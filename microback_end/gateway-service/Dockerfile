# Usar una imagen base con OpenJDK 17
FROM openjdk:17-jdk-alpine

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/admin-service-0.0.1-SNAPSHOT.jar /app/admin-service.jar

# Configurar el puerto que la aplicación usará
EXPOSE 8086

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/admin-service.jar"]
