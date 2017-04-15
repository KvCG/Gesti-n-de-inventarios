/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Domain;

/**
 *
<<<<<<< HEAD
 * @author Gustavo
=======
 * @author Kev
>>>>>>> origin/master
 */
public class ArticuloProveedor {
    private Integer articulo;
    private Integer proveedor;
<<<<<<< HEAD
    private double porcentaje_descuento;
    private double precio_estandar;
    private String fecha_primera_compra;
    private String fecha_ultima_compra;
    private Integer cantidad_pedido;
    private Integer total_pedido;

    public ArticuloProveedor() {
    }

    
    public ArticuloProveedor(Integer articulo, Integer proveedor, double porcentaje_descuento, double precio_estandar, String fecha_primera_compra, String fecha_ultima_compra, Integer cantidad_pedido, Integer total_pedido) {
        this.articulo = articulo;
        this.proveedor = proveedor;
        this.porcentaje_descuento = porcentaje_descuento;
        this.precio_estandar = precio_estandar;
        this.fecha_primera_compra = fecha_primera_compra;
        this.fecha_ultima_compra = fecha_ultima_compra;
        this.cantidad_pedido = cantidad_pedido;
        this.total_pedido = total_pedido;
=======
    private Float costo;

    public ArticuloProveedor(Integer articulo, Integer proveedor, Float costo) {
        this.articulo = articulo;
        this.proveedor = proveedor;
        this.costo = costo;
    }

    public ArticuloProveedor() {
>>>>>>> origin/master
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

<<<<<<< HEAD
    public double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public double getPrecio_estandar() {
        return precio_estandar;
    }

    public void setPrecio_estandar(double precio_estandar) {
        this.precio_estandar = precio_estandar;
    }

    public String getFecha_primera_compra() {
        return fecha_primera_compra;
    }

    public void setFecha_primera_compra(String fecha_primera_compra) {
        this.fecha_primera_compra = fecha_primera_compra;
    }

    public String getFecha_ultima_compra() {
        return fecha_ultima_compra;
    }

    public void setFecha_ultima_compra(String fecha_ultima_compra) {
        this.fecha_ultima_compra = fecha_ultima_compra;
    }

    public Integer getCantidad_pedido() {
        return cantidad_pedido;
    }

    public void setCantidad_pedido(Integer cantidad_pedido) {
        this.cantidad_pedido = cantidad_pedido;
    }

    public Integer getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(Integer total_pedido) {
        this.total_pedido = total_pedido;
    }
    
    
    
=======
    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }
>>>>>>> origin/master
}
