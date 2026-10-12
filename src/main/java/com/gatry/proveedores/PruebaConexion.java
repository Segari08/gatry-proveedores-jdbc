

package com.gatry.proveedores;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {
        try (Connection conexion = Conexion.conectar()) {
            System.out.println("Conexión exitosa con MySQL.");
            System.out.println("Base de datos: " + conexion.getCatalog());
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

        System.out.println("Prueba de conexión finalizada.");
    }
}
