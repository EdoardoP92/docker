FROM maven as BUILD
RUN mkdir -p /project/src
COPY ./pom.xml /project
COPY ./src /project/src
RUN cd /project && mvn clean package -Dmaven.test.skip=true
FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY --from=build /project/target/*.jar /docker.jar
ENTRYPOINT ["java","-jar","/docker.jar"]