plugins {
    id("java")
    id("application")
}

group = "com.Carlos.spaceinvaders"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("com.googlecode.lanterna:lanterna:3.1.1")
    testImplementation("junit:junit:4.13.1")
    testImplementation("org.mockito:mockito-core:3.12.4")
}

tasks.test {
    useJUnitPlatform()
}
application{
    mainClass.set("com.Carlos.spaceinvaders/Application")
}