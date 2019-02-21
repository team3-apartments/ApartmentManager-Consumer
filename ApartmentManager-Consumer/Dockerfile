FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
EXPOSE 8084
COPY --from=maven-build /build/target/ApartmentManager-Consumer-0.0.1-SNAPSHOT.jar consumer.jar
ENTRYPOINT ["java", "-jar", "consumer.jar"]
