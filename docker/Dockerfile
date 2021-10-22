FROM openjdk
MAINTAINER sangang
COPY filebeat.tar.gz /opt/filebeat.tar.gz
COPY filebeat.yml /filebeat.yml
RUN set -x && \
   cd /opt && \
   tar xzvf filebeat.tar.gz && \
   cd filebeat-* && \
   cp filebeat /bin && \
   cd /opt && \
   rm -rf filebeat*
ADD ./mq-0.0.1-SNAPSHOT.jar service.jar
ENTRYPOINT ["java", "-jar", "/service.jar","--server.port=8080"]
CMD [ "filebeat", "-e" ]
EXPOSE 2222