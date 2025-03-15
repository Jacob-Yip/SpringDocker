FROM maven:3.9.6-eclipse-temurin-21 AS build

LABEL version="0.0.1"
LABEL description="A Demo Project of Spring with Docker"
LABEL maintainer="Toothless7788 <noreply.auto.27@gmail.com"

# Set the working directory in the container
COPY src /home/app/src

COPY pom.xml /home/app

# Set the active profile to "default" for production
ENV SPRING_PROFILES_ACTIVE=default

RUN mvn -f /home/app/pom.xml clean package

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

RUN ls -al /home/app/target

# Command to run the Spring Boot application
ENTRYPOINT ["java","-jar","/home/app/target/SpringDocker-0.0.1-SNAPSHOT.jar"]