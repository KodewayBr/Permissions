plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "br.com.kodeway.permissions"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://libraries.minecraft.net/")
    maven("https://jitpack.io/")

}

tasks {
    java {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    compileJava { options.encoding = "UTF-8"}

    java {
        shadowJar { archiveFileName.set("permissions-1.0-SNAPSHOT.jar") }
    }
}

dependencies {
    compileOnly(fileTree("libs"))

    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
}