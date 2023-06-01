FROM openjdk:18

COPY "./target/CRUD_CLIENTE_FACTURADOR-2-0.0.1-SNAPSHOT.jar" "app.jar"

ENTRYPOINT ["java","-jar","app.jar"]