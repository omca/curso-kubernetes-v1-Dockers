
# 🐳 Docker & Kubernetes - Microservices Setup

Este documento contiene comandos esenciales para configurar y ejecutar microservicios utilizando Docker, Docker Compose y Kubernetes (Minikube).  
Incluye configuraciones para bases de datos (PostgreSQL y MySQL) y despliegue de microservicios `msvc-usuarios` y `msvc-cursos`.

---

## 📦 Docker - Bases de Datos

### 🔹 PostgreSQL

```bash
# Descargar imagen
docker pull postgres:14-alpine

# Ejecutar instancia PostgreSQL
docker run -p 5532:5432 --name serverPostgresDocker --network spring   -e POSTGRES_PASSWORD=sasa -e POSTGRES_DB=msvc_cursos -d postgres:14-alpine

# Ingresar a la base de datos
docker exec -it serverPostgresDocker psql -U postgres
postgres=# CREATE DATABASE msvc_cursos;
```

### 🔹 MySQL

```bash
# Descargar imagen
docker pull mysql:8

# Ejecutar instancia MySQL
docker run -p 33060:3306 --name mysql-db --network spring   -e MYSQL_ROOT_PASSWORD=sasa -e MYSQL_DATABASE=msvc_usuarios -d mysql:8
```

---

## 🧩 Docker - Microservicios

### 🛠️ Construcción de imágenes

```bash
# Usuarios
docker build -t usuarios . -f ./msvc-usuarios/Dockerfile

# Cursos
docker build -t cursos . -f ./msvc-cursos/Dockerfile
```

### 🚀 Ejecución de contenedores

```bash
# Usuarios
docker run -p 8001:8001 --rm -d --network spring --name msvc-usuarios usuarios

# Cursos
docker run -p 8002:8002 --rm -d --network spring --name msvc-cursos cursos
```

---

## 📋 Docker Compose

### 🧪 Usuarios

```bash
docker-compose -f docker-compose-usuarios.yml up -d
docker-compose -f docker-compose-usuarios.yml down
```

### 📘 Cursos

```bash
docker-compose -f docker-compose-cursos.yml up -d
docker-compose -f docker-compose-cursos.yml down
```

---

## ☸️ Kubernetes (Minikube)

> Alias útil:
```bash
alias k="kubectl"
```

### ▶️ Comandos básicos

```bash
minikube start
minikube status
```

### 🧱 Despliegue de recursos

#### 📁 MySQL

```bash
k apply -f ./xdeploy/mysql/deployment-mysql.yaml
k apply -f ./xdeploy/mysql/service-mysql.yaml
```

#### 📁 PostgreSQL

```bash
k apply -f ./xdeploy/postgres/deployment-postgres.yaml
k apply -f ./xdeploy/postgres/service-postgres.yaml
```

#### 👤 Microservicio Usuarios

```bash
# Build, tag y push
docker build -t usuarios . -f ./msvc-usuarios/Dockerfile
docker tag usuarios calderonomar48/usuarios-globant
docker push calderonomar48/usuarios-globant

# Deploy
k apply -f ./xdeploy/users/deployment-users.yaml
k apply -f ./xdeploy/users/service-users.yaml
```

#### 📚 Microservicio Cursos

```bash
# Build, tag y push
docker build -t cursos . -f ./msvc-cursos/Dockerfile
docker tag cursos calderonomar48/cursos-globant
docker push calderonomar48/cursos-globant

# Deploy
k apply -f ./xdeploy/course/deployment-cursos.yaml
k apply -f ./xdeploy/course/service-cursos.yaml
```

### ❌ Eliminar despliegues

```bash
k delete -f ./xdeploy/users/deployment-users.yaml
```

### 🌐 Obtener URL de servicios

```bash
minikube service msvc-usuarios --url
minikube service msvc-cursos --url
```

---

## 📚 Recursos útiles

- [Kubernetes Object Types (Medium)](https://medium.com/devops-mojo/kubernetes-objects-resources-overview-introduction-understanding-kubernetes-objects-24d7b47bb018#:~:text=There%20are%20four%20types%20of,%2C%20NodePort%20%2C%20LoadBalancer%20and%20ExternalName%20.)

---
