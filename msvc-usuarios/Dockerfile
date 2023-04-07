# FORMA 1: Copia el .jar ejecutado localmente y lo ejecuta con el docker run
FROM openjdk:17-alpine
WORKDIR /app
COPY /msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar /app
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]





















# FORMA 2: Copia el pom.xml padre y todo el contenido del microservicio usuarios e internamennte ejecuta hace el empaquetado y luego lo ejecuta
# FROM openjdk:17-alpine
# WORKDIR /app/msvc-usuarios
# COPY ./pom.xml /app
# COPY ./msvc-usuarios .
#
# RUN chmod +x mvnw
# # #RUN es un comando que se ejecuta cuando se construye la imagen
# # aqui esta ejecutando un empaquetado .jar
# RUN ./mvnw clean package -DskipTests
# EXPOSE 8001
# # # se va a ejecutar en algun punto de entrada y se ejecuta cuando se construye la imagen (docker run)
# ENTRYPOINT ["java", "-jar", "./target/msvc-usuarios-0.0.1-SNAPSHOT.jar"]









# FORMA 3: Primero descarga las dependencias y quedan guardadas en CACHE para proximos cambios
# FROM openjdk:17-alpine
# WORKDIR /app/msvc-usuarios
# COPY ./pom.xml /app
# COPY ./msvc-usuarios/.mvn ./.mvn
# COPY ./msvc-usuarios/mvnw .
# COPY ./msvc-usuarios/pom.xml .
#
# RUN chmod +x mvnw
# # empaqueta el proyecto sin pruebas unitarias y sin codigo fuente, por eso tenemos que poner tb el repackage.skip (porque no existe una clase main)
# # rm -r elimina todo el folder /target
# RUN ./mvnw clean package -Dskip.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
# # RUN ./mvnw clean dependency:tree
#
# COPY ./msvc-usuarios/src ./src
# RUN ./mvnw clean package -DskipTests
# EXPOSE 8001
# ENTRYPOINT ["java", "-jar", "./target/msvc-usuarios-0.0.1-SNAPSHOT.jar"]








# # # forma 4: Multi-stage, son compilaciones en varias etapas, usa el patron Builder
# # # optimizar la imagen, bajo en peso
# FROM openjdk:17-alpine as builder
# WORKDIR /app/msvc-usuarios
# COPY ./pom.xml /app
# COPY ./msvc-usuarios/.mvn ./.mvn
# COPY ./msvc-usuarios/mvnw .
# COPY ./msvc-usuarios/pom.xml .
#
# RUN chmod +x mvnw
# RUN ./mvnw clean package -Dskip.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#
# COPY ./msvc-usuarios/src ./src
# RUN ./mvnw clean package -DskipTests
#
# #empieza el nuevo empaquetado del JAR
# FROM openjdk:17
# WORKDIR /app
# COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
# # EXPOSE 8001
#
# # CMD sleep 20 && java -jar msvc-usuarios-0.0.1-SNAPSHOT.jar
# #CMD ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
#
# EXPOSE 8001
# ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]



