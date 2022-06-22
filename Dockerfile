FROM scottyengineering/java11
VOLUME /tmp
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} test.jar
ENTRYPOINT ["java","-jar","/test.jar"]
