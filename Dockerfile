FROM openjdk:11.0-jre-slim

ADD target/trade-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

#ENV TRADE_URI=mongodb://mymongodb:27017/tradedb

RUN sh -c 'echo spring.data.mongodb.uri=mongodb://mymongodb:27017/tradedb > application.properties'

ENTRYPOINT ["java", "-jar", "/app.jar"]
