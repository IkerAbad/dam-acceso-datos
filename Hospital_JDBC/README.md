# Hospital_JDBC

Práctica de JDBC del ciclo de DAM (octubre de 2022). Es un proyecto Maven en Java que gestiona doctores y pacientes de un hospital contra una base de datos MySQL llamada `AD_Hospital`, usando el patrón DAO: una interfaz y una implementación por entidad y las clases del modelo (`Doctor` y `Patient`).

## Qué hay

- `DoctorDaoImpl` y `PatientDaoImpl` con las operaciones de alta, baja, consulta de uno o de todos, y actualización.
- `App.java` es un programa de prueba que llama a esas operaciones.
- Compila con Java 17 y Maven. Solo he comprobado que compila: no la he ejecutado contra una base de datos real.

## Cómo probarlo

Hace falta una base de datos `AD_Hospital` en MySQL con las tablas de doctores y pacientes. La conexión está escrita a mano en `src/main/java/org/jesuitasrioja/utils/DatabaseConnection.java` (una máquina virtual local en `192.168.56.101`, usuario `user`); cámbiala por la tuya.

```
mvn compile
mvn exec:java -Dexec.mainClass=org.jesuitasrioja.App
```

---

# Hospital_JDBC (English)

JDBC assignment from my DAM vocational course (October 2022). A Maven project in Java that manages a hospital's doctors and patients against a MySQL database called `AD_Hospital`, using the DAO pattern: one interface and one implementation per entity, plus the model classes (`Doctor` and `Patient`).

## What's inside

- `DoctorDaoImpl` and `PatientDaoImpl` with create, delete, fetch one or all, and update operations.
- `App.java` is a test program that calls those operations.
- It builds with Java 17 and Maven. I have only checked that it compiles; I have not run it against a real database.

## Trying it

You need an `AD_Hospital` database in MySQL with the doctors and patients tables. The connection is hardcoded in `src/main/java/org/jesuitasrioja/utils/DatabaseConnection.java` (a local virtual machine at `192.168.56.101`, user `user`); change it to yours.

```
mvn compile
mvn exec:java -Dexec.mainClass=org.jesuitasrioja.App
```
