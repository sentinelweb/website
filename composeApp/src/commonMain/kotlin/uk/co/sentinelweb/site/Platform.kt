package uk.co.sentinelweb.site

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform