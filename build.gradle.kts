plugins {
    signing
    `java-library`
    `maven-publish`
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "io.github.orz-api"
version = "0.0.2-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
    withJavadocJar()
    withSourcesJar()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-json")
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.apache.commons:commons-lang3")
    api("com.google.guava:guava:33.2.1-jre")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.javadoc {
    val options = (options as StandardJavadocDocletOptions)
    options.encoding("UTF-8")
    options.addStringOption("Xdoclint:none", "-quiet")
    if (JavaVersion.current().isJava9Compatible) {
        options.addBooleanOption("html5", true)
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                description = "orz-api base spring boot starter"
                url = "https://github.com/orz-api/orz-base-spring-boot-starter"
                licenses {
                    license {
                        name = "MIT License"
                        url = "https://opensource.org/license/mit/"
                    }
                }
                developers {
                    developer {
                        id = "reset7523"
                        name = "reset7523"
                        email = "reset7523@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com:orz-api/orz-base-spring-boot-starter.git"
                    developerConnection = "scm:git:git://github.com:orz-api/orz-base-spring-boot-starter.git"
                    url = "https://github.com/orz-api/orz-base-spring-boot-starter"
                }
            }
        }
    }
    repositories {
        maven {
            url = uri(
                    if (version.toString().endsWith("SNAPSHOT")) "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                    else "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            )
            credentials {
                val orzOssrhUsername: String by project
                val orzOssrhPassword: String by project
                username = orzOssrhUsername
                password = orzOssrhPassword
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}
