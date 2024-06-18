FROM openjdk:17

LABEL authors="MURALI"

WORKDIR /usr/src/app

COPY target/Backend-0.0.1-SNAPSHOT.jar /usr/src/app/target/Backend-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/usr/src/app/target/Backend-0.0.1-SNAPSHOT.jar"]
