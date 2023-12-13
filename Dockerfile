
FROM openjdk:11
EXPOSE 8044
ADD target/docker-sts.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]