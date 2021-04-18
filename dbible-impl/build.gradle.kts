
plugins {
    id("dbible.common-conventions")
//    kotlin("jvm") version "1.4.32"
//    kotlin("plugin.serialization") version "1.4.32"
    // Apply the java-library plugin for API and implementation separation.
//    `java-library`
    `java-library`
}

//repositories {
//    // Use JCenter for resolving dependencies.
//    jcenter()
//}

dependencies {
    implementation(project(":json-bible-api"))
//    // Align versions of all Kotlin components
//    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
//
//    // Use the Kotlin JDK 8 standard library.
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
//
//    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
//    implementation("com.google.guava:guava:29.0-jre")
//    implementation("org.apache.commons:commons-lang3:3.11")
//    implementation("commons-io:commons-io:2.8.0")
//    implementation("ch.qos.logback:logback-classic:1.2.3")
////    implementation("net.java.truevfs:truevfs-access:0.14.0")
//    implementation("net.java.truevfs:truevfs-profile-full:0.14.0")
////    implementation("net.java.truevfs:truevfs-driver-file:0.14.0")
////    implementation("net.java.truevfs:truevfs-driver-zip:0.14.0")
//
//    // Use the Kotlin test library.
//    testImplementation("org.jetbrains.kotlin:kotlin-test")
//
//    // Use the Kotlin JUnit integration.
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

}
