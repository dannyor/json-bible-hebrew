plugins {
    id("dbible.common-conventions")
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
//    kotlin("jvm") version "1.4.32"
    kotlin("plugin.serialization") version "1.4.32"
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

//repositories {
//    mavenCentral()
//}

dependencies {

    implementation("ch.qos.logback:logback-classic:1.2.3")


}
