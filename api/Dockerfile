FROM openjdk:8-jre-alpine

ARG project_name=shopee-api
ARG application_name=$project_name.jar

RUN echo $project_name
RUN echo $application_name


#-------------------------------------------------------------
# Prepare file and application
#-------------------------------------------------------------
RUN mkdir -p /apps/shopee/$project_name/
RUN mkdir -p /apps/shopee/_temp/application-log

ADD target/deploy/$application_name /apps/shopee/$project_name/application.jar


#-------------------------------------------------------------
# Set default working dir
#-------------------------------------------------------------
WORKDIR	 /apps/shopee/$project_name
EXPOSE 8081

ENTRYPOINT exec java -Dspring.profiles.active=$CONTAINER_ENV -jar application.jar
