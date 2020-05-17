FROM java:8
EXPOSE 8081
ADD /target/MyNas-0.0.1-SNAPSHOT.jar MyNas.jar
ENTRYPOINT ["java", "-jar","MyNas.jar"]