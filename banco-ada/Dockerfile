FROM openjdk:17
ADD target/*.jar /app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]