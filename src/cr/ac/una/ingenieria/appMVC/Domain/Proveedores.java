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
public class Proveedores extends BaseDomain {
    
    private Integer PK_IDProvedor;
    private String Nombre;
    private String Direccion;
    private String CorreoElectronico;
    private String Telefono;

    /**
     *
     */
    public Proveedores() {
    }

    /**
     *
     * @param PK_IDProvedor
     * @param Nombre
     * @param Direccion
     * @param CorreoElectronico
     * @param Telefono
     * @param ultUsuario
     * @param ultFecha
     */
    public Proveedores(Integer PK_IDProvedor, String Nombre, String Direccion, String CorreoElectronico, String Telefono, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IDProvedor = PK_IDProvedor;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.CorreoElectronico = CorreoElectronico;
        this.Telefono = Telefono;
    }

    /**
     *
     * @return
     */
    public Integer getPK_IDProvedor() {
        return PK_IDProvedor;
    }

    /**
     *
     * @param PK_IDProvedor
     */
    public void setPK_IDProvedor(Integer PK_IDProvedor) {
        this.PK_IDProvedor = PK_IDProvedor;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     *
     * @param Nombre
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     *
     * @param Direccion
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     *
     * @return
     */
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    /**
     *
     * @param CorreoElectronico
     */
    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     *
     * @param Telefono
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
  
    
}
