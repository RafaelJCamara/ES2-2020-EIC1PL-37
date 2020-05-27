FROM openjdk:7
COPY target/Grupo37ESII-*.jar /demo.jar
WORKDIR /usr/src/myapp
CMD ["java","-jar","/demo.jar"]
