FROM openjdk:8

EXPOSE 8080

COPY build/distributions/uberJar/petclinic.jar /usr/src/cuba/petclinic.jar

CMD ["java", "-Dapp.home=/usr/src/cuba/home", "-jar", "/usr/src/cuba/petclinic.jar"]
