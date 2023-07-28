FROM gradle:8.2-jdk17 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN ls -la /home/gradle/src
RUN gradle bootJar
RUN ls -la /home/gradle/src/build
RUN ls -la /home/gradle/src/build/libs


FROM amazoncorretto:17
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/cookbook.jar /app/app.jar
# CMD ["java", "-jar", "app/app.jar"]
ENTRYPOINT ["java", "-jar", "app/app.jar"]