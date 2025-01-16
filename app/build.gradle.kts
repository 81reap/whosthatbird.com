import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    kotlin("multiplatform") version "2.1.0"
    // application
    kotlin("plugin.serialization") version "2.1.0"
    id("com.github.ben-manes.versions") version "0.51.0"
}

group = "org.bhakar"
version = "1.0-SNAPSHOT"

val kotlinWrappersVersion = "2025.1.3"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
    }
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
            }
        }
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }

        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
            }
        }
//        val jvmTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }

        val jsMain by getting {
            dependencies {
                //React, React DOM, Css + Wrappers
                implementation(project.dependencies.enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:$kotlinWrappersVersion"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
                //implementation("org.jetbrains.kotlin-wrappers:kotlin-react-query")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom")
                //implementation("org.jetbrains.kotlin-wrappers:kotlin-tanstack-react-table")

                //Video Player
                //implementation(npm("react-player", "2.16.0"))

                //Coroutines & serialization
                implementation("org.jetbrains.kotlin:kotlinx-atomicfu-runtime:1.8.20-RC")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
            }
        }
//        val jsTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }
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
tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}
tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputFormatter = "html"
    outputDir = "build/reports/dependency"
    reportfileName = "report"
}