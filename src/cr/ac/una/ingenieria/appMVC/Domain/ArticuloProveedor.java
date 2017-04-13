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
public class ArticuloProveedor {
    private Integer articulo;
    private Integer proveedor;
    private Float costo;

    public ArticuloProveedor(Integer articulo, Integer proveedor, Float costo) {
        this.articulo = articulo;
        this.proveedor = proveedor;
        this.costo = costo;
    }

    public ArticuloProveedor() {
    }

    public Integer getArticulo() {
        return articulo;
    }

    public void setArticulo(Integer articulo) {
        this.articulo = articulo;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }
}
