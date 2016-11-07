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
public class Articulos extends BaseDomain {
    
    private Integer PK_IDArticulo;
    private Integer FK_idProveedor;
    private String Nombre;
    private String Descripcion;
    private Integer CantidadExistencia;
    private double PrecioUnitario;

    /**
     *
     */
    public Articulos() {
    }

    /**
     *
     * @param PK_IDArticulo
     * @param FK_idProveedor
     * @param Nombre
     * @param Descripcion
     * @param CantidadExistencia
     * @param PrecioUnitario
     * @param ultUsuario
     * @param ultFecha
     */
    public Articulos(Integer PK_IDArticulo, Integer FK_idProveedor, String Nombre, String Descripcion, Integer CantidadExistencia, double PrecioUnitario,String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IDArticulo = PK_IDArticulo;
        this.FK_idProveedor = FK_idProveedor;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.CantidadExistencia = CantidadExistencia;
        this.PrecioUnitario = PrecioUnitario;
       
    }

    /**
     *
     * @return
     */
    public Integer getPK_IDArticulo() {
        return PK_IDArticulo;
    }

    /**
     *
     * @param PK_IDArticulo
     */
    public void setPK_IDArticulo(Integer PK_IDArticulo) {
        this.PK_IDArticulo = PK_IDArticulo;
    }

    /**
     *
     * @return
     */
    public Integer getFK_idProveedor() {
        return FK_idProveedor;
    }

    /**
     *
     * @param FK_idProveedor
     */
    public void setFK_idProveedor(Integer FK_idProveedor) {
        this.FK_idProveedor = FK_idProveedor;
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
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     *
     * @param Descripcion
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     *
     * @return
     */
    public Integer getCantidadExistencia() {
        return CantidadExistencia;
    }

    /**
     *
     * @param CantidadExistencia
     */
    public void setCantidadExistencia(Integer CantidadExistencia) {
        this.CantidadExistencia = CantidadExistencia;
    }

    /**
     *
     * @return
     */
    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    /**
     *
     * @param PrecioUnitario
     */
    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }    
    
}

