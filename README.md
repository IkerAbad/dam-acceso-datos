# dam-acceso-datos

**Español** | [English](#english)

Acceso a datos en Java durante el ciclo de DAM: JDBC con el patrón DAO, JPA con relaciones entre entidades y una API REST con Spring Boot.

| Carpeta | Qué es | Periodo |
|---|---|---|
| [`Practica1_JDBC_WORLD`](Practica1_JDBC_WORLD/) | Primera práctica de JDBC del ciclo de DAM (octubre de 2022). Proyecto Maven en Java que accede por JDBC a la base de datos de ejemplo `world` de MySQL con el patrón DAO: una interfaz y una clase por cada tabla (`city`, `country` y `countrylanguage`) y las clases del modelo. | 2022-10 |
| [`Practica2_JDBC_EMPLEADOS`](Practica2_JDBC_EMPLEADOS/) | Segunda práctica de JDBC del ciclo de DAM (abril de 2023). Proyecto Maven en Java que consulta y modifica la base de datos de ejemplo `employees` de MySQL con el patrón DAO: un DAO por entidad (`DepartmentDao`, `EmployeeDao`, `SalaryDao`), las clases del modelo y una utilidad de conexión. | 2023-04 |
| [`Hospital_JDBC`](Hospital_JDBC/) | Práctica de JDBC del ciclo de DAM (octubre de 2022). Es un proyecto Maven en Java que gestiona doctores y pacientes de un hospital contra una base de datos MySQL llamada `AD_Hospital`, usando el patrón DAO: una interfaz y una implementación por entidad y las clases del modelo (`Doctor` y `Patient`). | 2022-10 |
| [`JPA_Relaciones`](JPA_Relaciones/) | Práctica de JPA con Hibernate del ciclo de DAM (diciembre de 2022 y mayo de 2023). Proyecto Maven en Java que mapea las cuatro relaciones de JPA entre entidades de un club de ajedrez sobre una base MySQL llamada `JPA_Ajedrez`. | 2022-12 / 2023-05 |
| [`todoapp_spring_boot`](todoapp_spring_boot/) | API REST de tareas pendientes hecha con Spring Boot 2.5 (abril de 2023, ciclo de DAM). Guarda las tareas en una base H2 en memoria, así que los datos se pierden al parar la aplicación. | 2023-04 |

Cada carpeta conserva su propio README, licencia y `.gitignore`. El historial de commits de cada proyecto original está incluido en este repositorio.

---

## English

Data access in Java from my DAM course: JDBC with the DAO pattern, JPA entity relationships and a Spring Boot REST API.

| Folder | What it is | Period |
|---|---|---|
| [`Practica1_JDBC_WORLD`](Practica1_JDBC_WORLD/) | First JDBC assignment of my DAM vocational course (October 2022). A Maven project in Java that accesses MySQL's sample `world` database through JDBC using the DAO pattern: an interface and a class for each table (`city`, `country` and `countrylanguage`) plus the model classes. | 2022-10 |
| [`Practica2_JDBC_EMPLEADOS`](Practica2_JDBC_EMPLEADOS/) | Second JDBC assignment from my DAM vocational course (April 2023). A Maven project in Java that queries and updates the MySQL sample database `employees` using the DAO pattern: one DAO per entity (`DepartmentDao`, `EmployeeDao`, `SalaryDao`), the model classes and a connection helper. | 2023-04 |
| [`Hospital_JDBC`](Hospital_JDBC/) | JDBC assignment from my DAM vocational course (October 2022). A Maven project in Java that manages a hospital's doctors and patients against a MySQL database called `AD_Hospital`, using the DAO pattern: one interface and one implementation per entity, plus the model classes (`Doctor` and `Patient`). | 2022-10 |
| [`JPA_Relaciones`](JPA_Relaciones/) | JPA with Hibernate assignment from my DAM vocational course (December 2022 and May 2023). A Maven project in Java that maps the four JPA relationship types between the entities of a chess club over a MySQL database called `JPA_Ajedrez`. | 2022-12 / 2023-05 |
| [`todoapp_spring_boot`](todoapp_spring_boot/) | A to-do REST API built with Spring Boot 2.5 (April 2023, DAM vocational course). It stores tasks in an in-memory H2 database, so data is lost when the app stops. | 2023-04 |

Each folder keeps its own README, license and `.gitignore`. The commit history of every original project is included in this repository.
