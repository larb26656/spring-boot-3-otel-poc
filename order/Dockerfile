# Build stage
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon

# Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/order-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8011
ENTRYPOINT ["java", "-jar", "app.jar"]