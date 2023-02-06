FROM  maven:3.6.0-jdk-11-slim AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM adoptopenjdk/openjdk11:jre11u-alpine-nightly
WORKDIR /opt/app
ARG JAR_FILE=isis3-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/src/app/target/${JAR_FILE} .
ENTRYPOINT ["java","-jar","isis3-0.0.1-SNAPSHOT.jar"]
