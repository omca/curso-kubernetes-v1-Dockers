1. comandos dockers



BASE DE DATOS

POSTGRES

- descargar postgres
  $ docker pull postgres:14-alpine

- instancias postgres
  $ docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
  $ docker run -p 5532:5432 --name serverPostgresDocker -e POSTGRES_PASSWORD=sasa -e POSTGRES_DB=msvc_cursos -d postgres:14-alpine
  $ docker run -p 5532:5432 --name serverPostgresDocker --network spring -e POSTGRES_PASSWORD=sasa -e POSTGRES_DB=msvc_cursos -d postgres:14-alpine


- entrar a la instancia de un postgres

$ docker exec -it serverPostgresDocker psql -U postgres
postgres=# CREATE DATABASE msvc_cursos;

$  docker exec -it 2c5408df7320 /bin/sh
# psql -U postgres
# postgres=# CREATE DATABASE msvc_cursos;


MYSQL

$ docker pull mysql:8
$ docker run -p 33060:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=sasa -e MYSQL_DATABASE=msvc_usuarios -d mysql:8
$ docker run -p 33060:3306 --name mysql-db --network spring -e MYSQL_ROOT_PASSWORD=sasa -e MYSQL_DATABASE=msvc_usuarios -d mysql:8


MICROSERVICIO USUARIOS Y CURSOS

- crear imagenes en base a dockerfile - usuarios
  $ docker build -t usuarios . -f ./msvc-usuarios/Dockerfile

- crear imagenes en base a dockerfile - cursos
  $ docker build -t cursos . -f ./msvc-cursos/Dockerfile

- ejecutar container de microservicio - usuarios
  $ docker run -p 8001:8001 -d --name msvc-usuarios usuarios
  $ docker run -p 8001:8001 --rm -d --network spring --name msvc-usuarios usuarios   (--name establece un nombre para el POD)

- ejecutar container de microservicio - cursos
  $ docker run -p 8002:8002 --rm -d --name msvc-cursos cursos




DOCKER COMPOSE

docker-compose . up

- DOCKER COMPOSE USUARIOS
  $ docker-compose -f docker-compose-usuarios.yml up

$ docker-compose -f docker-compose-usuarios.yml up -d

$ docker-compose -f docker-compose-usuarios.yml down


- DOCKER COMPOSE CURSOS
  $ docker-compose -f docker-compose-cursos.yml up

$ docker-compose -f docker-compose-cursos.yml up -d

$ docker-compose -f docker-compose-cursos.yml down








https://medium.com/devops-mojo/kubernetes-objects-resources-overview-introduction-understanding-kubernetes-objects-24d7b47bb018#:~:text=There%20are%20four%20types%20of,%2C%20NodePort%20%2C%20LoadBalancer%20and%20ExternalName%20.


################################################################
################# K U B E R N E T E S #########################
########################## K U B E R N E T E S ###################
############# K U B E R N E T E S ###############################
################################################################

1. ALIAS COMANDOS LINUX
   $ alias k="kubectl"

   minikube start

   minikube --version

   minikube status

2. Deploy Mysql
   $ k apply -f ./xdeploy/mysql/deployment-mysql.yaml
   $ k apply -f ./xdeploy/mysql/deployment-mysql.yaml  -f ./xdeploy/mysql/service-mysql.yaml

3. Deploy Postgres
   $ k apply -f ./xdeploy/postgres/deployment-postgres.yaml
   $ k apply -f ./xdeploy/postgres/deployment-postgres.yaml  -f ./xdeploy/postgres/service-postgres.yaml

4. Deploy user microservice

   $ docker build -t usuarios . -f ./msvc-usuarios/Dockerfile
   $ docker tag usuarios calderonomar48/usuarios-globant
   $ docker push calderonomar48/usuarios-globant

   $ k apply -f  ./xdeploy/users/deployment-users.yaml
   $ k apply -f ./xdeploy/users/deployment-users.yaml  -f ./xdeploy/users/service-users.yaml

5. Deploy course microservice
   $ docker build -t cursos . -f ./msvc-cursos/Dockerfile
   $ docker tag cursos calderonomar48/cursos-globant
   $ docker push calderonomar48/cursos-globant   
   $ k apply -f ./xdeploy/course/deployment-cursos.yaml  -f ./xdeploy/course/service-cursos.yaml

6. Delete deployment mysql
   $ k delete -f  ./xdeploy/users/deployment-users.yaml

7. External IP for deploy
   $ minikube service msvc-usuarios --url
   $ minikube service msvc-cursos --url

8. Push image in dockerHub - Users
   $ docker tag usuarios calderonomar48/usuarios-globant
   $ docker push calderonomar48/usuarios-globant

9. Push image in dockerHub - Cursos
   $ docker tag cursos calderonomar48/cursos-globant
   $ docker push calderonomar48/cursos-globant
































