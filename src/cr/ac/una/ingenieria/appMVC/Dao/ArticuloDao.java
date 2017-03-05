/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Articulos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ArticuloDao implements IBaseDao<Articulos> {
    
    private final MySQLConexion conexion;
     
    /**
     *
     */
    public ArticuloDao() {
        conexion = new MySQLConexion();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Articulos obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into articulo(codigo,nombre,descripcion,cod_tipo_articulo,"
                                             + "precio_venta,cantidad,bodega,punto_de_pedido) values "
                                             + "(?,?,?,?,?,?,?,?)");
        
        cs.setString(1, obj.getCodigo());
        cs.setString(2, obj.getNombre());
        cs.setString(3, obj.getDescripcion());
        cs.setInt(4, obj.getCod_tipo_articulo());
        cs.setDouble(5, obj.getPrecioVenta());
        cs.setInt(6, obj.getCantidad());
        cs.setInt(7, obj.getBodega());
        cs.setInt(8, obj.getPunto_de_Pedido());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Articulos obj) throws SQLException {
        Connection con = conexion.getConexion();
         CallableStatement cs = con.prepareCall("update articulo set codigo= ?,set nombre= ?,"
                                                +"descripcion=?,cod_tipo_articulo=?,"
                                                +"precio_venta=?,"  
                                                +"cantidad=?,"
                                                +"bodega=?,"
                                                +"punto_de_pedido = ?"
                                                +"where idarticulo=? ");
        cs.setString(1, obj.getCodigo()); 
        cs.setString(2, obj.getNombre());
        cs.setString(3, obj.getDescripcion());
        cs.setInt(4, obj.getCod_tipo_articulo());
        cs.setDouble(5, obj.getPrecioVenta());
        cs.setInt(6, obj.getCantidad());
        cs.setInt(7, obj.getBodega());
        cs.setInt(8, obj.getPunto_de_Pedido());
        cs.setInt(9, obj.getIdarticulo());
        cs.executeUpdate();
        con.close();
       
         
         
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Articulos obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from articulo where idarticulo = ?");
        cs.setInt(1, obj.getIdarticulo());
        
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Articulos obtenerPorId(Articulos obj) throws SQLException {
       Articulos a = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from articulo where idarticulo = ? " );
        cs.setInt(1, obj.getIdarticulo());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            a = new Articulos();
            a.setIdarticulo(result.getInt("idarticulo"));
            a.setCodigo(result.getString("codigo"));
            a.setNombre(result.getString("nombre"));
            a.setDescripcion(result.getString("descripcion"));
            a.setCod_tipo_articulo(result.getInt("cod_tipo_articulo"));
            a.setPrecioVenta(result.getDouble("precio_venta"));
            a.setCantidad(result.getInt("cantidad"));
            a.setBodega(result.getInt("bodega"));
            a.setPunto_de_Pedido(result.getInt("punto_de_pedido"));
            
        }
        con.close();
        return a;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Articulos> obtenerTodos() throws SQLException {
       Connection con = conexion.getConexion();
        ArrayList<Articulos> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from articulo ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Articulos a = new Articulos();
            a.setIdarticulo(result.getInt("idarticulo"));
            a.setCodigo(result.getString("codigo"));
            a.setNombre(result.getString("nombre"));
            a.setDescripcion(result.getString("descripcion"));
            a.setCod_tipo_articulo(result.getInt("cod_tipo_articulo"));
            a.setPrecioVenta(result.getDouble("precio_venta"));
            a.setCantidad(result.getInt("cantidad"));
            a.setBodega(result.getInt("bodega"));
            a.setPunto_de_Pedido(result.getInt("punto_de_pedido"));
            l.add(a);
        }
        con.close();
        return l;
    }

    /**
     *
     * @param where
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Articulos> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Articulos> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from articulo "+where );
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Articulos a = new Articulos();
            a.setIdarticulo(result.getInt("idarticulo"));
            a.setCodigo(result.getString("codigo"));
            a.setNombre(result.getString("nombre"));
            a.setDescripcion(result.getString("descripcion"));
            a.setCod_tipo_articulo(result.getInt("cod_tipo_articulo"));
            a.setPrecioVenta(result.getDouble("precio_venta"));
            a.setCantidad(result.getInt("cantidad"));
            a.setBodega(result.getInt("bodega"));
            a.setPunto_de_Pedido(result.getInt("punto_de_pedido"));
            l.add(a);
        }
        con.close();
        return l;
    }
}
