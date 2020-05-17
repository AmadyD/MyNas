FROM openjdk:8
EXPOSE 8081
VOLUME /var/lib/docker/tmp/
ADD target/myNas-microservice.jar myNas-microservice.jar
ENTRYPOINT ["java", "-jar","myNas-microservice.jar"]