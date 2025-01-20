# 🌐 **ForoHub API** 🚀

## 📖 **Descripción del Proyecto**
**ForoHub** es una API REST diseñada para replicar el funcionamiento de un foro. Este proyecto permite a los usuarios gestionar tópicos (crear, leer, actualizar y eliminar) utilizando las mejores prácticas de desarrollo, junto con autenticación y persistencia de datos.

---

## 🛠️ **Tecnologías Utilizadas**
- ☕ **Java** (JDK 17+)
- 🌱 **Spring Boot** (3+)
- 📦 **Maven** (4+)
- 🐬 **MySQL** (8+)
- 📜 **Hibernate / JPA**
- 🦋 **Flyway** (Migraciones)
- 🔐 **Spring Security**

---

## ✨ **Funcionalidades**
✅ CRUD completo para tópicos:  
  - **Crear** un nuevo tópico.  
  - **Listar** todos los tópicos.  
  - **Consultar** un tópico por ID.  
  - **Actualizar** un tópico existente.  
  - **Eliminar** un tópico.

✅ Validaciones de negocio para garantizar la integridad de los datos.  
✅ Persistencia de información en base de datos MySQL.  
✅ Autenticación básica con **Spring Security**.  

---

## 📂 **Estructura del Proyecto**
```plaintext
src/main/java/com/aluracursos/desafio/forohub/
├── ForohubApplication.java      // Clase principal para iniciar la aplicación
├── controllers/
│   └── TopicoController.java    // Controlador REST para las operaciones de tópicos
├── dtos/
│   ├── TopicoDTO.java           // Formato de salida para los tópicos
│   ├── TopicoRequest.java       // DTO de entrada para crear/actualizar tópicos
│   └── TemaRequest.java         // DTO de entrada para crear/actualizar temas
├── entities/
│   ├── Topico.java              // Entidad que representa un tópico
│   └── Tema.java                // Entidad que representa un tema
├── repositories/
│   ├── TemaRepository.java      // Repositorio para manejar temas
│   └── TopicoRepository.java    // Repositorio para manejar tópicos
├── services/
│   └── TopicoService.java       // Lógica de negocio para tópicos
```



---


##  📦 **Instalación**
## Clona este repositorio:


git clone <URL_DEL_REPOSITORIO>
Configura la base de datos en el archivo application.properties:

## **Propiedades**

spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
Ejecuta las migraciones con Flyway:

mvn flyway:migrate
Inicia la aplicación:

mvn spring-boot:run


## 🔗 **Endpoints de la API**


## Método	Endpoint	Descripción
POST	/api/topicos	📝 Crear un nuevo tópico
GET	/api/topicos	📋 Listar todos los tópicos
GET	/api/topicos/{id}	🔍 Obtener un tópico por ID
PUT	/api/topicos/{id}	✏️ Actualizar un tópico
DELETE	/api/topicos/{id}	🗑️ Eliminar un tópico



🤝 Contribuciones
¡Las contribuciones son bienvenidas! Abre un issue o envía un pull request con tus mejoras o sugerencias.

📝 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.


### Características Especiales
- Se utilizan emojis para hacer que el contenido sea más visual.
- Los títulos están en **negrita** para destacar secciones clave.
- La estructura del proyecto y pasos de instalación están claramente delimitados.

¡Espero que esta versión te sea útil y atractiva! Si quieres ajustar algo más, avísame. 😊
