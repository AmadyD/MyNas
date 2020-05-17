FROM java:8
EXPOSE 8081
ADD target/myNas-microservice.jar myNas-microservice.jar
ENTRYPOINT ["java", "-jar","myNas-microservice.jar"]