FROM openjdk:8-jdk-alpine
EXPOSE 8001

COPY src/main/resources/docker-application.properties application.properties
COPY target/ui-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]