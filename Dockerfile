FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 5500

COPY target/moneytransfer-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

