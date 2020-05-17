FROM java:8
EXPOSE 8081
ADD /target/MyNas-0.0.1-SNAPSHOT  /MyNas
ENTRYPOINT ["java", "-jar","/MyNas"]