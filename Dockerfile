FROM openjdk:latest
COPY ./Grupo37ESII-0.0.1-SNAPSHOT.jar /usr/src/myapp/movedjar.jar
COPY ./Calculator.java /usr/src/myapp/Calculator.java
WORKDIR /usr/src/myapp/
CMD ["java","-jar","/usr/src/myapp/movedjar.jar"]
