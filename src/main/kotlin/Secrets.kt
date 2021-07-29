external interface Secrets {
    val SWEBSITE_MAPS_API_KEY: String
}

private val secrets: Secrets = require("secrets.json")
public val SWEBSITE_MAPS_API_KEY = secrets.SWEBSITE_MAPS_API_KEY

