from flask import Flask, request, jsonify
from flask_restx import Api, Resource, fields
from transformers import AutoModelForCausalLM
from PIL import Image
import io
import base64

model = AutoModelForCausalLM.from_pretrained(
	"vikhyatk/moondream2",
	revision="2024-07-23",
	trust_remote_code=True
)

def decode_image(image_base64):
	"""Decode base64 image to PIL Image."""
	image_data = base64.b64decode(image_base64)
	return Image.open(io.BytesIO(image_data))

app = Flask(__name__)
api = Api(app, title="moondream2 API", version="1.0", description="whatsthatbirb.com vLLM API")
image_input = api.model('ImageInput', {
  'image': fields.String(required=True, description='Base64-encoded image')
})

@api.route('/captioning')
class Caption(Resource):
	@api.expect(api.inherit('CaptionInput', image_input, {
			'length': fields.String(description='Caption length: short or normal', default='normal', enum=['short', 'normal'])
	}))

	def post(self):
		"""Generate a caption for an image"""
		try:
			data = request.json
			image = decode_image(data['image'])
			length = data.get('length', 'normal')
			if length == 'short':
				caption = model.caption(image, length='short')["caption"]
			else:
				caption = ''.join(model.caption(image, length='normal', stream=True)["caption"])
			return {"caption": caption}
		except Exception as e:
			return {"error": str(e)}, 400

@api.route('/visualQuery')
class Query(Resource):
	@api.expect(api.inherit('QueryInput', image_input, {
		'question': fields.String(required=True, description='Question about the image')
	}))

	def post(self):
		"""Ask a question about an image"""
		try:
			data = request.json
			image = decode_image(data['image'])
			question = data['question']
			answer = model.query(image, question)["answer"]
			return {"answer": answer}
		except Exception as e:
			return {"error": str(e)}, 400

@api.route('/detectObject')
class Detect(Resource):
	@api.expect(api.inherit('DetectInput', image_input, {
		'label': fields.String(required=True, description='Label to detect in the image')
	}))

	def post(self):
		"""Detect objects in an image"""
		try:
			data = request.json
			image = decode_image(data['image'])
			label = data['label']
			objects = model.detect(image, label)["objects"]
			return {"count": len(objects), "objects": objects}
		except Exception as e:
			return {"error": str(e)}, 400

@api.route('/pointing')
class Point(Resource):
	@api.expect(api.inherit('PointInput', image_input, {
		'label': fields.String(required=True, description='Label to find points for')
	}))
	def post(self):
		"""Identify points for a specific label in an image"""
		try:
			data = request.json
			image = decode_image(data['image'])
			label = data['label']
			points = model.point(image, label)["points"]
			return {"count": len(points), "points": points}
		except Exception as e:
			return {"error": str(e)}, 400

@api.route('/chat')
class Chat(Resource):
	@api.expect(api.model('ChatInput', {
		'image': fields.String(description='Base64-encoded image', required=False),
		'message': fields.String(required=True, description='Chat message for the model')
	}))
	def post(self):
		"""Chat with the model, optionally using an image"""
		try:
			data = request.json
			image = data.get('image')
			message = data['message']
			if image:
				image = decode_image(image)
				response = model.query(image, message)["answer"]
			else:
				response = model.chat(message)["response"]
			return {"response": response}
		except Exception as e:
			return {"error": str(e)}, 400

if __name__ == '__main__':
  app.run(host='0.0.0.0', port=5000)
