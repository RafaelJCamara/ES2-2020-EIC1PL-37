FROM openjdk:7
COPY target/Grupo37ESII-*.jar /demo.jar
WORKDIR /usr/src/myapp
RUN javac Calculator.java
CMD ["java","-jar","/demo.jar"]