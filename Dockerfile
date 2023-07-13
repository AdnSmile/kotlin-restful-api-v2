FROM openjdk:17.0.1-jdk

COPY build/libs/kotlin-restful-api-v2-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]

# bikin image nya sekalian tag -> docker build --tag kotlin-restful-api:0.0.1 .