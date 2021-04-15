# FROM anapsix/alpine-java
# MAINTAINER Ramanuj
# COPY covid-info-app.jar /home/covid-info-app.jar
# EXPOSE 8500
# CMD ["java", "-jar", "covid-info-app.jar"] 

FROM anapsix/alpine-java
WORKDIR /
ADD covid-info-app.jar covid-info-app.jar
EXPOSE 8500
CMD java -jar covid-info-app.jar