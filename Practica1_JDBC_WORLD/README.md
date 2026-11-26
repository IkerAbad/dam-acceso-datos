# Practica1_JDBC_WORLD

**Español** | [English](#english)

Primera práctica de JDBC del ciclo de DAM (octubre de 2022). Proyecto Maven en Java que accede por JDBC a la base de datos de ejemplo `world` de MySQL con el patrón DAO: una interfaz y una clase por cada tabla (`city`, `country` y `countrylanguage`) y las clases del modelo.

## Qué hace cada DAO

| DAO | Operaciones |
|---|---|
| `CityDaoImpl` | listar ciudades, comprobar si existe, consultar, país de una ciudad, ver si pertenece a un país, cambiar el nombre, añadir |
| `CountryDaoImpl` | listar países, comprobar si existe (por `code`), consultar, ciudades de un país por nombre, añadir (sin duplicar) |
| `CountryLanguageDaoImpl` | todos los idiomas, idiomas de un país |

Las consultas usan `PreparedStatement` y `try-with-resources`. Los listados devuelven colecciones vacías, no `null`.

## Pruebas

7 pruebas JUnit contra H2 en modo MySQL con el mismo esquema que `world` (tablas `country`, `city` y `countrylanguage`), sin necesidad de MySQL:

```
mvn test
```

Verificado con Java 21 y Maven: 7 pruebas, 0 fallos. No lo he ejecutado contra una instalación real de MySQL con los datos completos de `world`.

## Ejecutarlo contra MySQL

Carga la base `world` en MySQL y configura la conexión con variables de entorno (valores por defecto entre paréntesis):

```
DB_URL   (jdbc:mysql://127.0.0.1:3306/world)
DB_USER  (user)
DB_PASS  (user)
```

```
mvn compile exec:java -Dexec.mainClass=App
```

---

## English

First JDBC assignment of my DAM vocational course (October 2022). A Maven project in Java that accesses MySQL's sample `world` database through JDBC using the DAO pattern: an interface and a class for each table (`city`, `country` and `countrylanguage`) plus the model classes.

### What each DAO does

- `CityDaoImpl`: list, check existence, look up, get a city's country, check membership of a country, rename, add.
- `CountryDaoImpl`: list, check existence (by `code`), look up, list a country's cities by name, add (without duplicates).
- `CountryLanguageDaoImpl`: all languages, languages of one country.

Queries use `PreparedStatement` and `try-with-resources`; listings return empty collections instead of `null`.

### Tests

7 JUnit tests run against H2 in MySQL mode with the same schema as `world`, so MySQL is not needed: `mvn test`. Verified with Java 21 and Maven: 7 tests, 0 failures. I have not run it against a real MySQL install loaded with the full `world` data.

### Running against MySQL

Load `world` into MySQL and set `DB_URL`, `DB_USER` and `DB_PASS` (defaults: `jdbc:mysql://127.0.0.1:3306/world`, `user`, `user`), then `mvn compile exec:java -Dexec.mainClass=App`.
