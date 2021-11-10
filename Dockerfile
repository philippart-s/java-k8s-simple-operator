FROM fabric8/java-alpine-openjdk11-jre

ENTRYPOINT ["java", "-jar", "/usr/share/operator/operator.jar", "fr.wilda.HelloWorldRunner"]

ARG JAR_FILE
ADD target/simple-java-k8s-operator-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/share/operator/operator.jar