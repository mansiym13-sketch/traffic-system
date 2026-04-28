FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY . .

# 🔥 THIS LINE FIXES YOUR ERROR
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/traffic-system-0.0.1-SNAPSHOT.jar"]