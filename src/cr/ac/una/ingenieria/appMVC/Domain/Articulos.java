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
public class Articulos {
    
    private Integer idarticulo;
    private String codigo;
    private String Nombre;
    private String Descripcion;
    private Integer cod_tipo_articulo;
    private double PrecioVenta;
    private Integer Cantidad;
    private Integer Bodega;
    private Integer Punto_de_Pedido;

    public Articulos(Integer idarticulo, String codigo, String Nombre, String Descripcion, Integer cod_tipo_articulo, double PrecioVenta, Integer Cantidad, Integer Bodega, Integer Punto_de_Pedido) {
        this.idarticulo = idarticulo;
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.cod_tipo_articulo = cod_tipo_articulo;
        this.PrecioVenta = PrecioVenta;
        this.Cantidad = Cantidad;
        this.Bodega = Bodega;
        this.Punto_de_Pedido = Punto_de_Pedido;
    }

    public Articulos() {
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
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getCod_tipo_articulo() {
        return cod_tipo_articulo;
    }

    public void setCod_tipo_articulo(Integer cod_tipo_articulo) {
        this.cod_tipo_articulo = cod_tipo_articulo;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Integer getBodega() {
        return Bodega;
    }

    public void setBodega(Integer Bodega) {
        this.Bodega = Bodega;
    }

    public Integer getPunto_de_Pedido() {
        return Punto_de_Pedido;
    }

    public void setPunto_de_Pedido(Integer Punto_de_Pedido) {
        this.Punto_de_Pedido = Punto_de_Pedido;
    }

 
}