// src/jsMain/kotlin/external/Markdown.kt

@file:JsModule("marked")
@file:JsNonModule
package external

external fun marked(input: String): String
