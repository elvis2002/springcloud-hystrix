FROM java:8-jre
MAINTAINER elviszhang <zhangb2002@163.com>

ADD ./target/hystrix-monitoring.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/hystrix-monitoring.jar"]

EXPOSE 5000