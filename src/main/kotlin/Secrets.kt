external interface Secrets {
    val SWEBSITE_MAPS_API_KEY: String
}
external fun require(module:String): dynamic
private val secrets: Secrets = require("secrets.json")
public val SWEBSITE_MAPS_API_KEY = secrets.SWEBSITE_MAPS_API_KEY

//external fun require(module:String): dynamic
//private val secrets = eval(require("secrets.js"))

//@JsModule("secrets.js")
//@JsNonModule
//
//external val SWEBSITE_MAPS_API_KEY:String