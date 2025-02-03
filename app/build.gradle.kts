val kotlinVersion          = "2.1.10"
val coroutinesVersion      = "1.10.1"
val serializationVersion   = "1.8.0"
val ktorVersion            = "3.0.3"
val logbackVersion         = "1.5.16"
val kotlinWrappersVersion  = "2025.1.3"
val kotlinxHtmlVersion     = "0.12.0"

plugins {
    kotlin("multiplatform") version "2.1.10"
    application
    kotlin("plugin.serialization") version "2.1.10"
    id("com.github.ben-manes.versions") version "0.52.0"
}

group = "org.bhakar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
}

kotlin {
    jvm() {
        withJava()
    }

    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
                devServer = devServer?.copy(
                    port = 8081
                )
                headers {

                }
                println(devServer)
            }
        }
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-html:$kotlinxHtmlVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
            }
        }

        val jvmMain by getting {
            dependencies {
                // Ktor server
                implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
                implementation("io.ktor:ktor-server-netty:$ktorVersion")
                implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                // (Optional) CORS, compression, logging, etc.
                implementation("io.ktor:ktor-server-cors:$ktorVersion")
                implementation("io.ktor:ktor-server-core:$ktorVersion")
                implementation("io.ktor:ktor-server-compression:$ktorVersion")

                // Logging
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
            }
        }

        val jsMain by getting {
            dependencies {
                // React + wrappers BOM
                implementation(project.dependencies.enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:$kotlinWrappersVersion"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")

                // NPM Dependencies
                implementation(devNpm("html-webpack-plugin", "5.6.3"))
                implementation(npm("@huggingface/transformers", "3.3.2"))
                //implementation(npm("@xenova/transformers", "2.17.2"))

                implementation(npm("dompurify", "3.1.2"))
                implementation(npm("marked", "4.0.2"))

                // Ktor client for fetching data
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            }
        }

        // (Optional) Test source sets omitted for brevity
    }
}

application {
    mainClass.set("ServerKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

/* SUPER JAR
 * This task it to take the front end and cram it into the backend to make one SUPER JAR
 */
tasks.getByName<Jar>("jvmJar") {
    // We want the *production* JS if we do `./gradlew installDist` or a production build
    val isProduction = project.hasProperty("isProduction")
            || project.gradle.startParameter.taskNames.any { it.contains("installDist") }

    val webpackTaskName = if (isProduction) {
        "jsBrowserProductionWebpack"
    } else {
        "jsBrowserDevelopmentWebpack"
    }
    val webpackTask = tasks.getByName<org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack>(webpackTaskName)

    dependsOn(webpackTask)

    // Put the JS bundles inside the JAR's resources, e.g. at /web
    from(File(webpackTask.destinationDirectory, webpackTask.outputFileName)) {
        into("static")
    }
}

//------------------------------------------------------
// Make sure the JAR is on the classpath when we run
//------------------------------------------------------
tasks.getByName<JavaExec>("run") {
    // Force the `run` task to run from the jar that includes the JS
    classpath(tasks.getByName<Jar>("jvmJar"))
}

//------------------------------------------------------
// (Optional) For a typical "stage" or "installDist" approach
//------------------------------------------------------
distributions {
    main {
        contents {
            // Put the JAR into /lib
            from(layout.buildDirectory.dir("libs")) {
                rename("${rootProject.name}-jvm", rootProject.name)
                into("lib")
            }
        }
    }
}

// Update Plugin
// https://github.com/ben-manes/gradle-versions-plugin
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}
tasks.named<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputFormatter = "html"
    outputDir = "build/reports/dependency"
    reportfileName = "report"
}
