FROM openjdk:17
COPY target/spring-jpa-app.jar .
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/spring-jpa-app.jar"]