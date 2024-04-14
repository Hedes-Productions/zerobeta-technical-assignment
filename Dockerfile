FROM openjdk:23-slim
WORKDIR /app
COPY target/*.jar technical-assignment.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","technical-assignment.jar"]