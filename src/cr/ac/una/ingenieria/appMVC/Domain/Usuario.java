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
public class Usuario {
    
    private Integer idUsuario;
    private Integer idPersona;
    private String alias;
    private String password;
    private Integer rol;
    private boolean estado;

    /**
     *
     */
    public Usuario() {
    }

    public Usuario(Integer idUsuario, Integer idPersona, String alias, String password, Integer rol, boolean estado) {
        this.idUsuario = idUsuario;
        this.idPersona = idPersona;
        this.alias = alias;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

     public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

   
    
    
    
}
