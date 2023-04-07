# aqui se hará una compilacion en varias etapas, y para eso usamos el builder
FROM openjdk:17-jdk-alpine as builder

# crea esas carpetas en el docker
WORKDIR /app/msvc-cursos

#copiando archivos: copy a -> b
COPY ./pom.xml /app
COPY ./msvc-cursos/.mvn ./.mvn
COPY ./msvc-cursos/mvnw .
COPY ./msvc-cursos/pom.xml .

RUN chmod +x mvnw

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-cursos/src ./src

RUN ./mvnw clean package -DskipTests




FROM openjdk:17-jdk-alpine
WORKDIR /app
RUN mkdir ./logs
# copiar el JAR de la construccion anterior 'builder'
COPY --from=builder /app/msvc-cursos/target/msvc-cursos-0.0.1-SNAPSHOT.jar .
ENV PORT 8002
EXPOSE $PORT
CMD sleep 30 && java -jar msvc-cursos-0.0.1-SNAPSHOT.jar
#CMD ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]