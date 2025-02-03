// src/jsMain/kotlin/external/DomPurify.kt

@file:JsModule("dompurify")
@file:JsNonModule
package external

@JsName("sanitize")
external fun sanitizeHTML(dirty: String): String
