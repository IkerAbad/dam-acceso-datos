# todoapp_spring_boot

API REST de tareas pendientes hecha con Spring Boot 2.5 (abril de 2023, ciclo de DAM). Guarda las tareas en una base H2 en memoria, así que los datos se pierden al parar la aplicación.

## Qué hay

Endpoints bajo `/tasks`:

- `POST /tasks`: crea una tarea.
- `GET /tasks`: lista todas.
- `GET /tasks/status/{status}`: lista las tareas con un estado concreto.
- `PATCH /tasks/mask_as_finished/{id}`: marca una tarea como terminada (la ruta se llama así tal cual en el código).
- `DELETE /tasks/{id}`: borra una tarea. Si no existe devuelve 404.

Usa Spring Data JPA, un mapper de DTO a entidad, un manejador de excepciones propio y Swagger (Springfox) para la documentación. Con la aplicación en marcha, la consola de H2 está en `/h2-console`.

Compila con Maven. No he arrancado la aplicación ni probado los endpoints desde aquí, solo he comprobado que compila. Para compilar con un JDK reciente subí la versión de Lombok en el `pom.xml`.

## Cómo probarlo

```
./mvnw spring-boot:run
```

Con Swagger UI en `http://localhost:8080/swagger-ui/` si Springfox lo publica en esa ruta (no lo he comprobado).

## Licencia

MIT, ver [LICENSE](LICENSE).

---

# todoapp_spring_boot (English)

A to-do REST API built with Spring Boot 2.5 (April 2023, DAM vocational course). It stores tasks in an in-memory H2 database, so data is lost when the app stops.

## What's inside

Endpoints under `/tasks`:

- `POST /tasks`: create a task.
- `GET /tasks`: list all of them.
- `GET /tasks/status/{status}`: list tasks with a given status.
- `PATCH /tasks/mask_as_finished/{id}`: mark a task as finished (the route is spelled exactly like that in the code).
- `DELETE /tasks/{id}`: delete a task. Returns 404 if it does not exist.

It uses Spring Data JPA, a DTO-to-entity mapper, a custom exception handler and Swagger (Springfox) for documentation. With the app running, the H2 console is at `/h2-console`.

It builds with Maven. I have not started the application or tested the endpoints from here, I only checked that it compiles. To build with a recent JDK I bumped Lombok's version in `pom.xml`.

## Trying it

```
./mvnw spring-boot:run
```

With Swagger UI at `http://localhost:8080/swagger-ui/` if Springfox serves it there (I have not checked).

## License

MIT, see [LICENSE](LICENSE).
