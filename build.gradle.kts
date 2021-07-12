val ver_kotlin: String by project
val ver_kotlin_react: String by project
val ver_kotlin_styled: String by project

plugins {
    id("org.jetbrains.kotlin.js") version "1.5.10"
//    java
}

group = "uk.co.sentinelweb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val outputJsLibName = "sentinel_website.js"

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$ver_kotlin_react")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$ver_kotlin_react")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$ver_kotlin_styled")

//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

kotlin {
    js {
        browser {
            binaries.executable()
            commonWebpackConfig {
                cssSupport.enabled = true
                outputFileName = outputJsLibName
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
            runTask {
                devServer = devServer?.copy(port = 3030)
            }
        }

    }
}

kotlin {
    js {
        nodejs {
        }
        binaries.executable()
    }
}
//
//tasks.getByName<Test>("test") {
//    useJUnitPlatform()
//}