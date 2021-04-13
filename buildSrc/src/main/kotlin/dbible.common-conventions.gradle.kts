

plugins {
//    id("org.jetbrains.kotlin.jvm")
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.java.truevfs:truevfs-profile-full:0.14.0")
    constraints {
//        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
//        implementation("org.apache.commons:commons-text:1.9") // <3>
    }

//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
//
//    implementation("com.google.guava:guava:29.0-jre")
//    implementation("org.apache.commons:commons-lang3:3.11")
//    implementation("commons-io:commons-io:2.8.0")
}

tasks.test {
    useJUnitPlatform()
}
