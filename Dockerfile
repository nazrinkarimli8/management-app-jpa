FROM openjdk:22
COPY target/ReservationApp-1.0-SNAPSHOT.jar management-app-jpa.jar
ENTRYPOINT ["java", "-jar", "management-app-jpa.jar"]