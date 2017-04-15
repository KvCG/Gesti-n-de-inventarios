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
<<<<<<< HEAD
=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> origin/master
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
<<<<<<< HEAD
 * @author Gustavo
=======
 * @author Kev
>>>>>>> origin/master
 */
public class ArticuloProveedorDao implements IBaseDao<ArticuloProveedor> {

    private final MySQLConexion conexion;

    public ArticuloProveedorDao() {
        conexion = new MySQLConexion();
    }
<<<<<<< HEAD
    
    
    @Override
    public void insertar(ArticuloProveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into articulo_proveedor(articulo,proveedor,porcentaje_descuento"
                + "precio_estandar,fecha_primera_compra,fecha_ultima_compra,cantidad_pedido,total_pedido) values "
                + "(?,?,?,?,?,?,?,?)");
        
        cs.setInt(1, obj.getArticulo());
        cs.setInt(2, obj.getProveedor());
        cs.setDouble(3, obj.getPorcentaje_descuento());
        cs.setDouble(4, obj.getPrecio_estandar());
        cs.setString(5, obj.getFecha_primera_compra());
        cs.setString(6, obj.getFecha_ultima_compra());
        cs.setInt(7, obj.getCantidad_pedido());
        cs.setInt(8, obj.getTotal_pedido());
        cs.executeUpdate();
        con.close();
        
=======

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
>>>>>>> origin/master
    }

    @Override
    public void modificar(ArticuloProveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
<<<<<<< HEAD
        CallableStatement cs = con.prepareCall("update articulo_proveedor set articulo = ?,proveedor = ? , porcentaje_descuento = ?"
                + "precio_estandar = ?,fecha_primera_compra = ?,fecha_ultima_compra = ?,cantidad_pedido = ?,total_pedido = ?"
                + "where codigo = ?");
=======
        CallableStatement cs = con.prepareCall("articulo_proveedor set articulo = ?, proveedor = ?,"
                + "costo =? where articulo = ? and proveedor = ?");
        cs.setInt(1, obj.getArticulo());
        cs.setInt(2, obj.getProveedor());
        cs.setFloat(3, obj.getCosto());
        cs.setInt(4, obj.getArticulo());
        cs.setInt(5, obj.getProveedor());
        cs.executeUpdate();
        con.close();
>>>>>>> origin/master
    }

    @Override
    public void eliminar(ArticuloProveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArticuloProveedor obtenerPorId(ArticuloProveedor obj) throws SQLException {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
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
>>>>>>> origin/master
    }

    @Override
    public ArticuloProveedor obtenerPorId2(ArticuloProveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ArticuloProveedor> obtenerTodos() throws SQLException {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
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
        return l;    }
>>>>>>> origin/master

    @Override
    public ArrayList<ArticuloProveedor> obtenerConWhere(String where) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
<<<<<<< HEAD
    
=======

>>>>>>> origin/master
}
