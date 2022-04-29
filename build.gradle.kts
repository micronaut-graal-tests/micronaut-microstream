import java.net.URI

plugins {
    id("groovy") 
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.3.2"
}

version = "0.1"
group = "example.micronaut"

repositories {
    mavenCentral()
    maven { this.url = URI.create("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("example.micronaut.*")
    }
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut:micronaut-graal")

    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("io.micronaut.microstream:micronaut-microstream:1.0.0-SNAPSHOT")
    implementation("io.micronaut.microstream:micronaut-microstream-annotations:1.0.0-SNAPSHOT")
    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("ch.qos.logback:logback-classic")
}

application {
    mainClass.set("example.micronaut.Application")
}

java {
    sourceCompatibility = JavaVersion.toVersion("1.8")
    targetCompatibility = JavaVersion.toVersion("1.8")
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set("microstream")
        }
    }
}
