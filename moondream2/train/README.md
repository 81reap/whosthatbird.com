# moondream2 Fine Tuning

## Quickstart

### 01 :: Setup 

🧱 WIP 🚧 :: setting up the dataset

```bash
$ python -m venv .venv
$ source .venv/bin/activate
$ pip install -r requirements.txt
```

### 02 :: Run

```bash
$ jupyter notebook
```

## Hardware Requirements

🧱 WIP 🚧 :: so far 12gb vRAM, 50gb storage

## Dataset

The NABirds V1 dataset comes from The Cornell Lab of Ornithology. [[LINK](https://dl.allaboutbirds.org/nabirds)]

> NABirds V1 is a collection of 48,000 annotated photographs of the 400 species of birds that are commonly observed in North America. More than 100 photographs are available for each species, including separate annotations for males, females and juveniles that comprise 700 visual categories. This dataset is to be used for fine-grained visual categorization experiments.

There is a ToS you will need to agree to access the dataset. The raw dataset will not be hosted here, but trained model outputs will be. 

🧱 WIP 🚧 :: @81reap Sub Licence review work

## To-Do

- [x] Add starter notebook
- [ ] Stabalize training code. This one may be due to timeouts running on google colab. AWS Sagemaker prices need to be figured out. 
- [ ] Transfer training code with proper git history
- [ ] Is .ipynb the best format for this??? Look into AWS Sagemaker traning runs & costs. OR fix Apollo & Jager + Containerize Pipeline.
- [ ] Fix deps to get [moondream2 rev2025-01-09](https://huggingface.co/vikhyatk/moondream2) working