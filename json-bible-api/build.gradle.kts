plugins {
//    id("dbible.common-conventions")
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.serialization") version "1.4.32"
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.google.guava:guava:29.0-jre")
    implementation("org.apache.commons:commons-lang3:3.11")
    implementation("commons-io:commons-io:2.8.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
//    implementation("net.java.truevfs:truevfs-access:0.13.0")
//    implementation("net.java.truevfs:truevfs-kernel-impl:0.13.0")
//    implementation("net.java.truevfs:truevfs-driver-file:0.13.0")
//    implementation("net.java.truevfs:truevfs-driver-zip:0.13.0")
//    implementation("net.java.truevfs:truevfs-access:0.14.0")
    implementation("net.java.truevfs:truevfs-profile-full:0.14.0")
//    implementation("net.java.truevfs:truevfs-driver-file:0.14.0")
//    implementation("net.java.truevfs:truevfs-driver-zip:0.14.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
    // Use the Kotlin test library.
    testImplementation("junit:junit:4.12")


}
