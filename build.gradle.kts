plugins {
    java
}

group = "com.melalex"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.slf4j", "slf4j-api", "1.7.30")

    testCompile("junit", "junit", "4.12")
}
