plugins {
    id("java")
    id("application")
    id("info.solidsoft.pitest") version "1.9.0"
}

group = "com.Carlos.spaceinvaders"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

pitest {
    junit5PluginVersion = "1.0.0"
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation("com.googlecode.lanterna:lanterna:3.1.1")
    testImplementation("org.mockito:mockito-core:3.12.4")
}

tasks.test {
    useJUnitPlatform()
}
application{
    mainClass.set("com.Carlos.spaceinvaders/Application")
}