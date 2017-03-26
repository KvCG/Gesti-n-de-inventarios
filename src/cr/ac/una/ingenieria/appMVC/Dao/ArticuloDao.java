/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
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
public class ArticuloDao implements IBaseDao<Articulo> {

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
    public void insertar(Articulo obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into articulo(codigo,nombre,descripcion,cod_tipo_articulo,"
                + "precio_venta,cantidad,bodega,punto_de_pedido) values "
                + "(?,?,?,?,?,?,?,?)");

        cs.setString(1, obj.getCodigo());
        cs.setString(2, obj.getNombre());
        cs.setString(3, obj.getDescripcion());
        cs.setInt(4, obj.getTipo());
        cs.setDouble(5, obj.getPrecioVenta());
        cs.setInt(6, obj.getCantidad());
        cs.setInt(7, obj.getBodega());
        cs.setInt(8, obj.getPuntoPedido());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Articulo obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("update articulo set codigo = ?, nombre = ?,"
                + "descripcion=?,cod_tipo_articulo = ?,"
                + "precio_venta = ?, cantidad = ?,"
                + "bodega=?, punto_de_pedido = ? "
                + "where codigo = ?");
        cs.setString(1, obj.getCodigo());
        cs.setString(2, obj.getNombre());
        cs.setString(3, obj.getDescripcion());
        cs.setInt(4, obj.getTipo());
        cs.setDouble(5, obj.getPrecioVenta());
        cs.setInt(6, obj.getCantidad());
        cs.setInt(7, obj.getBodega());
        cs.setInt(8, obj.getPuntoPedido());
        cs.setString(9, obj.getCodigo());
        cs.executeUpdate();
        con.close();

    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Articulo obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("update articulo set estado = false where codigo = ?");
        cs.setString(1, obj.getCodigo());

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
    public Articulo obtenerPorId(Articulo obj) throws SQLException {
        Articulo a = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from articulo where codigo = ? ");
        cs.setString(1, obj.getCodigo());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            a = new Articulo();
            a.setIdarticulo(result.getInt("idarticulo"));
            a.setCodigo(result.getString("codigo"));
            a.setNombre(result.getString("nombre"));
            a.setDescripcion(result.getString("descripcion"));
            a.setTipo(result.getInt("cod_tipo_articulo"));
            a.setPrecioVenta(result.getDouble("precio_venta"));
            a.setCantidad(result.getInt("cantidad"));
            a.setBodega(result.getInt("bodega"));
            a.setPuntoPedido(result.getInt("punto_de_pedido"));
            a.setEstado(result.getBoolean("estado"));
        }
        con.close();
        return a;
    }
    
    
    @Override
    public Articulo obtenerPorId2(Articulo obj) throws SQLException {
        Articulo a = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from articulo where idarticulo = ? ");
        cs.setInt(1, obj.getIdarticulo());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            a = new Articulo();
            a.setIdarticulo(result.getInt("idarticulo"));
            a.setCodigo(result.getString("codigo"));
            a.setNombre(result.getString("nombre"));
            a.setDescripcion(result.getString("descripcion"));
            a.setTipo(result.getInt("cod_tipo_articulo"));
            a.setPrecioVenta(result.getDouble("precio_venta"));
            a.setCantidad(result.getInt("cantidad"));
            a.setBodega(result.getInt("bodega"));
            a.setPuntoPedido(result.getInt("punto_de_pedido"));
            a.setEstado(result.getBoolean("estado"));
        }
        con.close();
        return a;
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public ArrayList<Articulo> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Articulo> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from articulo ");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Articulo a = new Articulo();
            a.setIdarticulo(result.getInt("idarticulo"));
            a.setCodigo(result.getString("codigo"));
            a.setNombre(result.getString("nombre"));
            a.setDescripcion(result.getString("descripcion"));
            a.setTipo(result.getInt("cod_tipo_articulo"));
            a.setPrecioVenta(result.getDouble("precio_venta"));
            a.setCantidad(result.getInt("cantidad"));
            a.setBodega(result.getInt("bodega"));
            a.setPuntoPedido(result.getInt("punto_de_pedido"));
            a.setEstado(result.getBoolean("estado"));
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
    public ArrayList<Articulo> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Articulo> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from articulo " + where);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Articulo a = new Articulo();
            a.setIdarticulo(result.getInt("idarticulo"));
            a.setCodigo(result.getString("codigo"));
            a.setNombre(result.getString("nombre"));
            a.setDescripcion(result.getString("descripcion"));
            a.setTipo(result.getInt("cod_tipo_articulo"));
            a.setPrecioVenta(result.getDouble("precio_venta"));
            a.setCantidad(result.getInt("cantidad"));
            a.setBodega(result.getInt("bodega"));
            a.setPuntoPedido(result.getInt("punto_de_pedido"));
            a.setEstado(result.getBoolean("estado"));
            l.add(a);
        }
        con.close();
        return l;
    }
}
