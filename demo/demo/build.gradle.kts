plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("io.spring.dependency-management") version "1.1.6"
	id("org.springframework.boot") version "3.3.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

springBoot {
	mainClass.set("com.example.demo.DemoApplication")
}
