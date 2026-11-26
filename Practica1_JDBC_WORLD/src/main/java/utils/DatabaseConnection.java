package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexión a la base de datos. Se configura con las variables de entorno
 * DB_URL, DB_USER y DB_PASS; si no existen, usa una base local de ejemplo.
 */
public class DatabaseConnection {
    private static final String DEFAULT_URL = "jdbc:mysql://127.0.0.1:3306/world";

    public static Connection getConnection() {
        String url = valor("DB_URL", DEFAULT_URL);
        String user = valor("DB_USER", "user");
        String pass = valor("DB_PASS", "user");
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar a " + url, e);
        }
    }

    private static String valor(String nombre, String porDefecto) {
        String v = System.getenv(nombre);
        if (v == null) {
            v = System.getProperty(nombre);
        }
        return v != null ? v : porDefecto;
    }
}
