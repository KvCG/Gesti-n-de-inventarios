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
public class Articulo {
    
    private Integer idarticulo;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Integer tipo;
    private double precioVenta;
    private Integer cantidad;
    private Integer bodega;
    private Integer puntoPedido;
    private boolean estado;
    private String impuesto;

    public Articulo(Integer idarticulo, String codigo, String Nombre, String Descripcion, Integer cod_tipo_articulo, double PrecioVenta, Integer Cantidad, Integer Bodega, Integer Punto_de_Pedido, boolean estado, String impuesto) {
        this.idarticulo = idarticulo;
        this.codigo = codigo;
        this.nombre = Nombre;
        this.descripcion = Descripcion;
        this.tipo = cod_tipo_articulo;
        this.precioVenta = PrecioVenta;
        this.cantidad = Cantidad;
        this.bodega = Bodega;
        this.puntoPedido = Punto_de_Pedido;
        this.estado = estado;
        this.impuesto = impuesto;
    }
    
    public Articulo() {
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer cod_tipo_articulo) {
        this.tipo = cod_tipo_articulo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.precioVenta = PrecioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.cantidad = Cantidad;
    }

    public Integer getBodega() {
        return bodega;
    }

    public void setBodega(Integer Bodega) {
        this.bodega = Bodega;
    }

    public Integer getPuntoPedido() {
        return puntoPedido;
    }

    public void setPuntoPedido(Integer Punto_de_Pedido) {
        this.puntoPedido = Punto_de_Pedido;
    }
}