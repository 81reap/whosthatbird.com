# moondream2 Microservice API

## Quickstart

### 01 :: Setup 

```bash
$ python3 -m venv .venv
$ source .venv/bin/activate
$ pip install -r requirements.txt
```

### 02 :: Run

```bash
$ python3 -m api

# or

$ python3 __main__.py
```

Swagger UI :: http://localhost:5000/
Raw JSON Spec :: http://localhost:5000/swagger.json

## ToDo

- [🚀] moondream2 `/chat` endpoint
- [🚀] moondream2 `/captioning` endpoint
- [🚀] moondream2 `/visualQuery` endpoint
- [🚀] moondream2 `/detectObject` endpoint
- [🚀] moondream2 `/pointing` endpoint
- [🚀] Swagger UI w/ `flask-restx`
- [🚧] Finish processing finetune model
- [🤔💭][STRECH] Integrate this into Kotlin backend