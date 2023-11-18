FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/c14-24-m-java--0.0.1-SNAPSHOT.jar nocountryc1424mjava.jar
EXPOSE 3306
ENTRYPOINT ["java", "-jar", "nocountryc1424mjava.jar"]