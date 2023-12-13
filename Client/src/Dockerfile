FROM openjdk:8

EXPOSE 8089
ADD target/Client-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]