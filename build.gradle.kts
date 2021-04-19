import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.spring") version "1.4.31"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11


repositories {
    mavenCentral()
}

dependencies {
    compile(group = "com.baomidou", name = "mybatis-plus-generator", version = "3.3.2")
    compile(group = "log4j", name = "log4j", version = "1.2.17")
    compile(group = "mysql", name = "mysql-connector-java")
    compile(group = "com.baomidou", name = "mybatis-plus-boot-starter", version = "3.4.2")
    compile(group="io.jsonwebtoken", name = "jjwt",version="0.7.0")
    implementation ("org.json:json:20171018")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("junit:junit:4.12")
    implementation("javax.xml.bind:jaxb-api:2.1")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

