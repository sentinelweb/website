//@file:JsModule("highlight.js")
//@file:JsNonModule

external interface HLJS {
    fun highlightAll()
}
//
//@JsName("hljs")
//external val hljs: HLJS
val hljs: HLJS = require("highlight.js");