FROM gradle:8.8.0-jdk22-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src/producer
WORKDIR /home/gradle/src/producer
RUN gradle build --no-daemon --stacktrace -x test

FROM openjdk:22-bullseye
EXPOSE 8086
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/producer/build/libs/*.jar /home/app.jar
ENV SPRING_PROFILES_ACTIVE=default
ENV APP_NAME=movements-middleend
ENV PORT=8083
CMD java -server -Dserver.tomcat.threads.max=200 -Duser.country=EC -Duser.language=es -Duser.timezone=America/Guayaquil -jar /home/app.jar