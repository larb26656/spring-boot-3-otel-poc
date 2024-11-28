plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	// Prerequisite for observability
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	// For Metrics
	// For OTLP
	implementation("io.micrometer:micrometer-registry-otlp")

	// For Tracing
	implementation("io.micrometer:micrometer-tracing-bridge-otel")

	// For Exporter
	implementation("io.opentelemetry:opentelemetry-exporter-otlp")

	// For Latency Visualization
	// For OTLP
//	implementation("io.zipkin.contrib.otel:encoder-brave:0.1.0")

	// For use create span annotation
	implementation("org.springframework.boot:spring-boot-starter-aop")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
