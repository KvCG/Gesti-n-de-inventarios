/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Domain;

/**
 *
 * @author Gustavo
 */
public class Proveedor {
    
    private Integer IdProvedor;
    private String Nombre;
    private String direccion;
    private String email;
    private String Telefono;
    private boolean estado;

    public Proveedor() {
    }

    public Proveedor(Integer IdProvedor, String Nombre, String direccion, String email, String Telefono, boolean estado) {
        this.IdProvedor = IdProvedor;
        this.Nombre = Nombre;
        this.direccion = direccion;
        this.email = email;
        this.Telefono = Telefono;
        this.estado = estado;
    }

     public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    public Integer getIdProvedor() {
        return IdProvedor;
    }

    public void setIdProvedor(Integer IdProvedor) {
        this.IdProvedor = IdProvedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     *
     */
    
   
}
