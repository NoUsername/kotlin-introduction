plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.diffplug.spotless") version "6.25.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

// quick and dirty common conf (bad practice!)
subprojects {
	apply(plugin = "java")
	apply(plugin = "com.diffplug.spotless")
	apply(plugin = "io.spring.dependency-management")

	spotless {
		kotlin {
			ktfmt().dropboxStyle()
		}
		java {
			googleJavaFormat()
		}
	}

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(21)
		}
	}

	repositories {
		mavenCentral()
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:3.1.1")
		}
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}