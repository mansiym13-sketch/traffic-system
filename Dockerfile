# Use Java 17
FROM eclipse-temurin:17-jdk-alpine

# Copy project files
WORKDIR /app
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/traffic-system-0.0.1-SNAPSHOT.jar"]