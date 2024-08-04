FROM openjdk:17-jdk-slim
COPY target/admin-service-0.0.1-SNAPSHOT.jar /app/admin-service-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "admin-service-0.0.1-SNAPSHOT.jar"]
