FROM java:8
EXPOSE 8081
ADD /target/MyNas-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","MyNas-0.0.1-SNAPSHOT.jar"]