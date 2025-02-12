FROM openjdk:17

COPY ./target/general-service-0.0.1-SNAPSHOT.jar /app/general_service-0.0.1-SNAPSHOT.jar

WORKDIR /app/

EXPOSE 8081
EXPOSE 5005

CMD [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "/app/general_service-0.0.1-SNAPSHOT.jar" ]