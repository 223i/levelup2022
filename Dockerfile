FROM openjdk:17-slim

COPY ./target/Home_work-1.0.0.jar /app/
WORKDIR /app

CMD ["java", "-jar", "Home_work-1.0.0.jar"]