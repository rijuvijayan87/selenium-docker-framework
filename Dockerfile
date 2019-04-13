FROM openjdk:8u201-jre-alpine3.9

RUN apk add curl jq

#Workspace
WORKDIR /usr/share/selenium-docker

#Copying main, test jar files
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar

#Copying libs files on to the container
ADD target/libs                         libs

#Copying testng xmls
ADD book-flight-module.xml              book-flight-module.xml
ADD search-module.xml                   search-module.xml

ADD healthcheck.sh                      healthcheck.sh

#execution
ENTRYPOINT sh healthcheck.sh


