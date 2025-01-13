# whosthatbird.com

A full stack Kotlin + React app with a Moondream 2 Flask micro service that identifies birds.

Inspiration ::
<blockquote class="twitter-tweet"><p lang="en" dir="ltr">In the JVM we trust ☕️ <a href="https://t.co/ji7razBtob">pic.twitter.com/ji7razBtob</a></p>&mdash; 81reap (@PrayagBhakar) <a href="https://twitter.com/PrayagBhakar/status/1878537317549285454?ref_src=twsrc%5Etfw">January 12, 2025</a></blockquote> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>

🚨 :: This project may change a lot and is currently partally documented/implemented. Cleanup will be needed.

🚨 :: This is not a starter, this is intended to be a wip monorepo

## What's the point?

Excluding the ML Python Microservice,

- [😎] Full stack type safty with Kotlin, React, HTML, and CSS
- [😎] Multiplatform target with Kotlin Multiplatofrm and React
- [😎] Easy integration with legacy Java and React `npm` Packages
- [😎] Shared build so dependeices are upgraded throughout the stack together
- [🚧] Universal unit testing with Kotlin Testing + MockK
- [🚧] One Jar to run them all
- [🤔💭][STRECH] Unified logging
- [🤔💭][STRECH] OAuth Integtraiton
- [🤔💭][STRECH] Per user SQlite
- [🤔💭][STRECH] Integtrate Moondream 2 API into backend Kotlin code
- [🤔💭][STRECH] Client service workers
- [🤔💭][STRECH] Compile client to WASM
- [🤔💭][STRECH] RPC calls/websockets
- [🤔💭][STRECH] VSCode Support
- [🤔💭][STRECH] SEO, Open Graph, `<meta>` tags, and other `<head>` fun
- [🤔💭][STRECH] Google Lighthouse Speedruns

## An enterprise ready, fullstack app, monorepo

```bash
whosthatbird/
├─ moondream2/ # Python Microservice
│  ├─ api/
│  ├─ train/
├─ app/ # Fullstack Kotlin + React App
│  ├─ src/
│  │  ├─ commonMain/ # Shared Kotlin code
│  │  ├─ jvmMain/ # Java Virtual Machine (JVM) Kotlin backend
│  │  ├─ jsMain/ # Kotlin + React frontend
│  ├─ build.gradle.kts
```

## How? What's the secret sauce?

1. Kotlin Wrappers

JetBrain offers Kotlin Wrappers for [React.js](https://github.com/facebook/react) and [Emotion.js](https://github.com/emotion-js/emotion) as well as a Bill of Material (`kotlin-wrappers-bom`) to keep versions in sync. 

Kotlin Wrappers can even be used for `npm` dependencies. 

```build.gradle.kts
val jsMain by getting {
	dependencies {
		// React, React DOM + Wrappers
		implementation(enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.430"))
		implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
		implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")

		// Kotlin React Emotion (CSS)
		implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")

		// npm dependencies
		implementation(npm("react-player", "2.12.0"))
	}
}
```
```ReactPlayer.kt
@file:JsModule("react-player")
@file:JsNonModule

package player

import react.ComponentClass
import react.Props

@JsName("default")
external val ReactPlayer: ComponentClass<ReactPlayerProps>

external interface ReactPlayerProps : Props {
	var url: String
	var controls: Boolean
}

/* Now you can use the dependency like this ::
ReactPlayer {
	url = "https://youtu.be/dQw4w9WgXcQ?si=jKjp4y79ecxB8ES8"
	controls = true
}
*/
```

🧱 WIP 🚧 :: finish spilling the beans 🫘

## To-Do

- [🚧] Sub README To-Do(s)
- [🚧] Clean up fullstack app + commit w/ `git` history
- [🚧] Clean up repo
- [🚧] CI/CD
- [🚧] Full monorepo top level build

# LICENCE

This work is published as All Rights Reserved until @81reap finishes Sub Licence double check work. This appiles to all subdiretries of code unless specified otherwise.