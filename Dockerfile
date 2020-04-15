FROM ubuntu-jdk

MAINTAINER sahilmo "sahil_mohammad@outlook.com"

ENV version=docker
ENV jdbcurl
ENV dbuser

WORKDIR /usr/local/bin/

ADD target/pma-app.jar .

ENTRYPOINT ["java","-jar", "pma-app.jar"]