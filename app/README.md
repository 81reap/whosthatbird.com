# Kotlin Fullstack Application

## Quickstart

### 01 :: [Install IntelliJ](https://www.jetbrains.com/idea/download/other.html)
If you have purchased an IntelliJ IDEA Licence, then install IntelliJ IDEA Ultimate. Otherwise install IntelliJ IDEA Community Edition.

### 02 :: Setup
```bash
$ ./gradlew dependencyUpdates
$ ./gradlew kotlinUpgradeYarnLock
$ ./gradlew clean build --refresh-dependencies
```

### 03 :: Run
```bash
## Backend
$ ./gradlew run

## Frontend
$ ./gradlew jsBrowserDevelopmentRun
# With Hot Reload
$ ./gradlew jsBrowserDevelopmentRun --continuous

## JAR [WIP]
$ ./gradlew installDist
$ ./gradlew installDist -PisProduction
$ jar build/install/PROJECT_NAME/bin/PROJECT_NAME
```

### 🐞Known Bug ::  MacOS :: `.DS_Store` will clog up gradle
```bash
# delete .DS_Store from current and all sub folders
$ find . -name '.DS_Store' -type f -delete
# and try again 
```

## To-Do

- add rest of code with proper git commits
- Unified Jar build
- [STRECH] WASM client
- [STRECH] VS Code