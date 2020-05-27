FROM openjdk:latest
COPY C:\'Program Files (x86)'\Jenkins\workspace\'Package Job'\target\Grupo37ESII-0.0.1-SNAPSHOT.jar /usr/src/myapp/movedjar.jar
WORKDIR /usr/src/myapp
CMD ["java","-jar","movedjar.jar"]