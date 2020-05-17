FROM openjdk:8
EXPOSE 8081
MAINTAINER Amady <amady6.add@gmail.com>
COPY target/myNas-microservice.jar myNas-microservice.jar
ENTRYPOINT ["java", "-jar","/myNas-microservice.jar"]