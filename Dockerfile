FROM openjdk:8-jdk-alpine
EXPOSE  8080
ADD target/jumiaTask.jar jumiaTask.jar
ENTRYPOINT ["java","-jar","/jumiaTask.jar"]