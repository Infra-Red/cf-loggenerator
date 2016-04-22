FROM java:latest

ADD ./LogGenerator.jar /LogGenerator.jar

CMD ["java", "-jar", "/LogGenerator.jar"]
