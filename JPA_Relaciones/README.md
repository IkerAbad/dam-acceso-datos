# JPA_Relaciones

Práctica de JPA con Hibernate del ciclo de DAM (diciembre de 2022 y mayo de 2023). Proyecto Maven en Java que mapea las cuatro relaciones de JPA entre entidades de un club de ajedrez sobre una base MySQL llamada `JPA_Ajedrez`.

## Qué hay

- Entidades `Usuario`, `Equipo`, `Idioma` y `Ejercicios` con relaciones muchos a muchos (usuario y ejercicios), muchos a uno y uno a muchos (usuario y equipo) y uno a uno (usuario e idioma), con cascadas de borrado y de persistencia.
- Un DAO genérico (`Dao`) y uno por entidad, con sus interfaces. Las clases concretas solo implementan `find`; crear, actualizar y borrar los aporta el DAO genérico.
- `App.java` es un programa de prueba.
- Compila con Java 17 y Maven (subí Lombok a 1.18.30 para poder compilar con un JDK moderno). No lo he ejecutado contra una base de datos real.

## Cómo probarlo

Hace falta MySQL con una base `JPA_Ajedrez`. La conexión está en `src/main/resources/META-INF/persistence.xml` (una máquina virtual local en `192.168.56.101`, usuario `user`); cámbiala por la tuya. Hibernate crea o actualiza las tablas (`hbm2ddl.auto=update`).

```
./mvnw compile
./mvnw exec:java -Dexec.mainClass=App
```

## Licencia

MIT, ver [LICENSE](LICENSE).

---

# JPA_Relaciones (English)

JPA with Hibernate assignment from my DAM vocational course (December 2022 and May 2023). A Maven project in Java that maps the four JPA relationship types between the entities of a chess club over a MySQL database called `JPA_Ajedrez`.

## What's inside

- `Usuario`, `Equipo`, `Idioma` and `Ejercicios` entities with many-to-many (user and exercises), many-to-one and one-to-many (user and team) and one-to-one (user and language) relationships, with delete and persist cascades.
- A generic DAO (`Dao`) and one per entity, with their interfaces. The concrete classes only implement `find`; create, update and delete come from the generic DAO.
- `App.java` is a test program.
- It builds with Java 17 and Maven (I bumped Lombok to 1.18.30 so it compiles on a modern JDK). I have not run it against a real database.

## Trying it

You need MySQL with a `JPA_Ajedrez` database. The connection is in `src/main/resources/META-INF/persistence.xml` (a local virtual machine at `192.168.56.101`, user `user`); change it to yours. Hibernate creates or updates the tables (`hbm2ddl.auto=update`).

```
./mvnw compile
./mvnw exec:java -Dexec.mainClass=App
```

## License

MIT, see [LICENSE](LICENSE).
