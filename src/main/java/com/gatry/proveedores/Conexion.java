
package com.gatry.proveedores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/gatry_db";

    public static Connection conectar() throws SQLException {
        String usuario = System.getenv("GATRY_DB_USER");
        String contrasena = System.getenv("GATRY_DB_PASSWORD");

        if (usuario == null || contrasena == null) {
            throw new SQLException(
                    "Faltan las variables de entorno de conexión."
            );
        }

        return DriverManager.getConnection(URL, usuario, contrasena);
    }
}
