
package com.gatry.proveedores;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProveedorDAO proveedorDAO = new ProveedorDAO();

        try {
            /* Proveedor nuevoProveedor = new Proveedor(
                    "Proveedor de prueba Java",
                    "3001234567",
                    "prueba.java@gatry.com",
                    "Calle 123 # 20-50"
            );

            int id = proveedorDAO.insertar(nuevoProveedor);
            System.out.println("Proveedor insertado con ID: " + id); */


            Proveedor proveedorActualizado = new Proveedor(
                    2,
                    "Proveedor de prueba actualizado",
                    "3109876543",
                    "actualizado@gatry.com",
                    "Carrera 10 # 20-30"
            );

            boolean actualizado =
                    proveedorDAO.actualizar(proveedorActualizado);

            if (actualizado) {
                System.out.println("Proveedor actualizado correctamente.");
            } else {
                System.out.println("No se encontró el proveedor para actualizar.");
            }


            List<Proveedor> proveedores =
                    proveedorDAO.consultarTodos();

            System.out.println("\nListado de proveedores:");

            for (Proveedor proveedor : proveedores) {
                System.out.println(
                        proveedor.getIdProveedor() + " | "
                        + proveedor.getNombreProveedor() + " | "
                        + proveedor.getTelefono() + " | "
                        + proveedor.getCorreo() + " | "
                        + proveedor.getDireccion()
                );
            }


            boolean eliminado = proveedorDAO.eliminar(2);

            if (eliminado) {
                System.out.println("\nProveedor eliminado correctamente.");
            } else {
                System.out.println("\nNo se encontró el proveedor para eliminar.");
            }

            List<Proveedor> proveedoresRestantes =
                    proveedorDAO.consultarTodos();

            System.out.println("\nProveedores después de eliminar:");

            for (Proveedor proveedor : proveedoresRestantes) {
                System.out.println(
                        proveedor.getIdProveedor() + " | "
                        + proveedor.getNombreProveedor()
                );
            }
            
        } catch (SQLException e) {
            System.out.println("Error al operar con proveedores: "
                    + e.getMessage());
        }
    }
}
