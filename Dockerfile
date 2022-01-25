FROM adoptopenjdk/openjdk11
EXPOSE 8080
COPY target/AuthorizationService-0.0.1-SNAPSHOT.jar AuthorizationService.jar
CMD ["java", "-jar", "/AuthorizationService.jar"]