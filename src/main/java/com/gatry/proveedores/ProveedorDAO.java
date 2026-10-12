
package com.gatry.proveedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    public int insertar(Proveedor proveedor) throws SQLException {
        String sql = """
                INSERT INTO Proveedor
                    (nombre_proveedor, telefono, correo, direccion)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            sentencia.setString(1, proveedor.getNombreProveedor());
            sentencia.setString(2, proveedor.getTelefono());
            sentencia.setString(3, proveedor.getCorreo());
            sentencia.setString(4, proveedor.getDireccion());

            sentencia.executeUpdate();

            try (ResultSet claves = sentencia.getGeneratedKeys()) {
                if (claves.next()) {
                    int id = claves.getInt(1);
                    proveedor.setIdProveedor(id);
                    return id;
                }
            }
        }

        throw new SQLException("No se pudo obtener el ID del proveedor.");
    }

    public List<Proveedor> consultarTodos() throws SQLException {
        String sql = """
                SELECT id_proveedor, nombre_proveedor,
                       telefono, correo, direccion
                FROM Proveedor
                ORDER BY id_proveedor
                """;

        List<Proveedor> proveedores = new ArrayList<>();

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                Proveedor proveedor = new Proveedor(
                        resultado.getInt("id_proveedor"),
                        resultado.getString("nombre_proveedor"),
                        resultado.getString("telefono"),
                        resultado.getString("correo"),
                        resultado.getString("direccion")
                );

                proveedores.add(proveedor);
            }
        }

        return proveedores;
    }


    public boolean actualizar(Proveedor proveedor) throws SQLException {
        String sql = """
                UPDATE Proveedor
                SET nombre_proveedor = ?,
                    telefono = ?,
                    correo = ?,
                    direccion = ?
                WHERE id_proveedor = ?
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, proveedor.getNombreProveedor());
            sentencia.setString(2, proveedor.getTelefono());
            sentencia.setString(3, proveedor.getCorreo());
            sentencia.setString(4, proveedor.getDireccion());
            sentencia.setInt(5, proveedor.getIdProveedor());

            return sentencia.executeUpdate() > 0;
        }
    }


    public boolean eliminar(int idProveedor) throws SQLException {
        String sql = "DELETE FROM Proveedor WHERE id_proveedor = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idProveedor);

            return sentencia.executeUpdate() > 0;
        }
    }

}
