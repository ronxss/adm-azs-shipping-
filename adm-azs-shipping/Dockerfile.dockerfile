FROM openjdk:21-ea-15-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/devmvn /./urandom", "-jar", "/app.jar"]