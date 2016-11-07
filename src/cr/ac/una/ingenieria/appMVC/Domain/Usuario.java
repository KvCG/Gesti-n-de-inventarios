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
public class Usuario extends BaseDomain {
    
    private Integer PK_idUsuario;
    private String nombre;
    private String usuario;
    private String contraseña;

    /**
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param PK_idUsuario
     * @param nombre
     * @param usuario
     * @param contraseña
     * @param ultUsuario
     * @param ultFecha
     */
    public Usuario(Integer PK_idUsuario, String nombre, String usuario, String contraseña, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_idUsuario = PK_idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     *
     * @return
     */
    public Integer getPK_idUsuario() {
        return PK_idUsuario;
    }

    /**
     *
     * @param PK_idUsuario
     */
    public void setPK_idUsuario(Integer PK_idUsuario) {
        this.PK_idUsuario = PK_idUsuario;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     *
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
