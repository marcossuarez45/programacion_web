FROM openjdk:18-jdk-alpine
COPY "./target/CRUD_CLIENTE_FACTURADOR-2-0.0.1-SNAPSHOT" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]