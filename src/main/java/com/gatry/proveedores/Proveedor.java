
package com.gatry.proveedores;

public class Proveedor {

    private int idProveedor;
    private String nombreProveedor;
    private String telefono;
    private String correo;
    private String direccion;

    public Proveedor(int idProveedor, String nombreProveedor,
                     String telefono, String correo, String direccion) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Proveedor(String nombreProveedor, String telefono,
                     String correo, String direccion) {
        this(0, nombreProveedor, telefono, correo, direccion);
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}
