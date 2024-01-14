FROM maven:3.9.6-amazoncorretto-17

RUN mkdir -p /app
WORKDIR /app

COPY pom.xml /app
COPY src /app/src

RUN mvn clean package

EXPOSE 8080

COPY target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
