/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Domain;

/**
 *
 * @author Kev
 */
public class Movimiento {
    private Integer idMovimiento;
    private Integer idPersona;
    private Integer idProveedor;
    private Integer idArticulo;
    private Integer cantidad;
    private Integer tipo;
    private String fecha;

    public Movimiento(Integer idMovimiento, Integer idPersona, Integer idProveedor, Integer idArticulo, Integer cantidad, Integer tipo, String fecha) {
        this.idMovimiento = idMovimiento;
        this.idPersona = idPersona;
        this.idProveedor = idProveedor;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Movimiento() {
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }   
}
