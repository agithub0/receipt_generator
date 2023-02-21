FROM openjdk:latest
ADD target/*.jar receipt_generator.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/receipt_generator.jar"]