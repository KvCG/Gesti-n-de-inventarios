/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.ArticuloProveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kev
 */
public class ArticuloProveedorDao implements IBaseDao<ArticuloProveedor> {

    private final MySQLConexion conexion;

    public ArticuloProveedorDao() {
        conexion = new MySQLConexion();
    }

    @Override
    public void insertar(ArticuloProveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into articulo_proveedor(articulo,proveedor,costo)"
                + "values (?,?,?)");

        cs.setInt(1, obj.getArticulo());
        cs.setInt(2, obj.getProveedor());
        cs.setFloat(3, obj.getCosto());

        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(ArticuloProveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("update articulo_proveedor set articulo = ?, proveedor = ?,"
                + "costo =? where articulo = ? and proveedor = ?");
        cs.setInt(1, obj.getArticulo());
        cs.setInt(2, obj.getProveedor());
        cs.setFloat(3, obj.getCosto());
        cs.setInt(4, obj.getArticulo());
        cs.setInt(5, obj.getProveedor());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(ArticuloProveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArticuloProveedor obtenerPorId(ArticuloProveedor obj) throws SQLException {
        ArticuloProveedor a = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from articulo_proveedor where articulo = ? and proveedor = ?");
        cs.setInt(1, obj.getArticulo());
        cs.setInt(2, obj.getProveedor());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            a = new ArticuloProveedor();
            a.setArticulo(result.getInt("articulo"));
            a.setProveedor(result.getInt("proveedor"));
            a.setCosto(result.getFloat("costo"));
        }
        con.close();
        return a;
    }

    @Override
    public ArticuloProveedor obtenerPorId2(ArticuloProveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ArticuloProveedor> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<ArticuloProveedor> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from articulo_proveedor");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            ArticuloProveedor a = new ArticuloProveedor();
            a.setArticulo(result.getInt("articulo"));
            a.setProveedor(result.getInt("proveedor"));
            a.setCosto(result.getFloat("costo"));
            l.add(a);
        }
        con.close();
        return l;
    }

    @Override
    public ArrayList<ArticuloProveedor> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<ArticuloProveedor> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from articulo_proveedor " + where);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            ArticuloProveedor a = new ArticuloProveedor();
            a.setArticulo(result.getInt("articulo"));
            a.setProveedor(result.getInt("proveedor"));
            a.setCosto(result.getFloat("costo"));

            l.add(a);
        }
        con.close();
        return l;
    }

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
