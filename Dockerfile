FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springboot-docker-demo.jar
ENTRYPOINT ["java","-jar","springboot-docker-demo.jar"]
