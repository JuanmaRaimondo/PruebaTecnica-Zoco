# Eventracker - Backend API

Este microservicio es el núcleo de persistencia y lógica de negocio del sistema Eventracker. Está desarrollado como una API RESTful que actúa como puente entre el motor de extracción (Scraper IA) y la base de datos, gestionando el almacenamiento y la consulta de los eventos culturales.

## 🛠️ Tecnologías Utilizadas
* **Java 21**
* **Spring Boot 3.x:** Framework principal para la creación de la API.
* **Spring Data MongoDB:** Para la persistencia NoSQL de los documentos.
* **Docker:** Contenerización del servicio y la base de datos.

## ⚙️ Arquitectura y Configuración
El backend está diseñado para ejecutarse en un entorno dockerizado, comunicándose con los demás servicios a través de la red interna de Docker. 


## 📍 Endpoints Principales
* `POST /api/evento/crear`: Endpoint de ingesta. Recibe el JSON estructurado desde el Scraper IA y lo persiste en la base de datos.
* `GET /api/evento/listar`: Endpoint de consumo. Devuelve la lista de eventos activos para ser consumida por el Dashboard o cualquier otro cliente frontend.
