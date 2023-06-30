
FROM openjdk:17

WORKDIR /app

COPY ./target/prm-plant-store-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "prm-plant-store-0.0.1-SNAPSHOT.jar"]
