FROM openjdk:8-jdk-alpine
RUN addgroup -S k8s-group && adduser -S k8s-user -G k8s-group
USER k8s-user:k8s-group
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]