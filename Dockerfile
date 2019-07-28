FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/ezopsDemo-0.0.1-SNAPSHOT.jar ezopsDemo-docker.jar
ENTRYPOINT ["java","-jar","ezopsDemo-docker.jar"]