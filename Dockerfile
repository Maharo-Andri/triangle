FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/triangle.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
CMD ["3", "4", "5"]
