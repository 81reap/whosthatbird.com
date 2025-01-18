# Kotlin Fullstack Application

## Quickstart

### 01 :: [Install IntelliJ](https://www.jetbrains.com/idea/download/other.html)
If you have purchased an IntelliJ IDEA Licence, then install IntelliJ IDEA Ultimate. Otherwise install IntelliJ IDEA Community Edition.

### 02 :: Setup
```bash
# Check for any dependencies to update
$ ./gradlew dependencyUpdates

# install java + kotlin
//todo

# uhhhh.... idk?? //todo
$ ./gradlew clean build --refresh-dependencies
```

### 03 :: Run
```bash
## Run the Backend
$ ./gradlew run

## Run the Frontend
$ ./gradlew jsBrowserDevelopmentRun
# or w/ Hot Reload
$ ./gradlew jsBrowserDevelopmentRun --continuous

## JAR [WIP]
$ ./gradlew jvmJar
$ ./gradlew installDist
$ ./gradlew installDist -PisProduction
$ jar build/install/PROJECT_NAME/bin/PROJECT_NAME
```

### 🐞Known Bugs

#### 1 :: [ MacOS] `.DS_Store` will clog up gradle
```bash
# delete .DS_Store from current and all sub folders
$ find . -name '.DS_Store' -type f -delete
# and try again 
```

#### 2 :: Yarn Lockfile Issues
```bash
$ ./gradlew kotlinUpgradeYarnLock
```

## To-Do

- add rest of code with proper git commits
- Unified Jar build
- [STRECH] WASM client
- [STRECH] VS Code