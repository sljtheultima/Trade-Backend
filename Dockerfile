FROM openjdk:11.0

ADD target/trade-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV TRADE_URI=mongodb://mymongodb:27017/tradedb

ENTRYPOINT ["java", "-jar", "/app.jar"]
