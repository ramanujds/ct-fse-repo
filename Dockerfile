
FROM anapsix/alpine-java
WORKDIR /
ADD spring-boot-simple-app-0.0.1-SNAPSHOT.jar spring-boot-simple-app-0.0.1-SNAPSHOT.jar
EXPOSE 5000
CMD java -jar spring-boot-simple-app-0.0.1-SNAPSHOT.jar