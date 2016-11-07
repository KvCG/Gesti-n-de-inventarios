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
        CallableStatement cs = con.prepareCall("insert into Articulos(FK_idProveedor,nombre,Descripcion,CantidadExistencia,"
                                             + "PrecioUnitario,ultUsuario,ultFecha) values "
                                             + "(?,?,?,?,?,?,curdate())");
        
        cs.setInt(1, obj.getFK_idProveedor());
        cs.setString(2, obj.getNombre());
        cs.setString(3, obj.getDescripcion());
        cs.setInt(4, obj.getCantidadExistencia());
        cs.setDouble(5, obj.getPrecioUnitario());
        cs.setString(6, obj.getUltUsuario());     
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
         CallableStatement cs = con.prepareCall("update Articulos set Nombre= ?,"
                                                +"Descripcion=?,CantidadExistencia=?,"
                                                +"PrecioUnitario=?,"  
                                                +"FK_idProveedor=?,"
                                                +"ultUsuario=?,"
                                                +"ultFecha = curdate()"
                                                +"where PK_IDArticulo=? ");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getDescripcion());
        cs.setInt(3, obj.getCantidadExistencia());
        cs.setDouble(4, obj.getPrecioUnitario());
        cs.setInt(5, obj.getFK_idProveedor());
        cs.setString(6, obj.getUltUsuario());  
        cs.setInt(7,obj.getPK_IDArticulo());
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
        
        CallableStatement cs = con.prepareCall("delete from Articulos where PK_IDArticulo = ?");
        cs.setInt(1, obj.getPK_IDArticulo());
        
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
        
        CallableStatement cs = con.prepareCall("select * from Articulos where PK_IDArticulo = ? " );
        cs.setInt(1, obj.getPK_IDArticulo());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            a = new Articulos();
            a.setPK_IDArticulo(result.getInt("PK_IDArticulo"));
            a.setFK_idProveedor(result.getInt("FK_idProveedor"));
            a.setNombre(result.getString("Nombre"));
            a.setDescripcion(result.getString("Descripcion"));
            a.setCantidadExistencia(result.getInt("CantidadExistencia"));
            a.setPrecioUnitario(result.getDouble("PrecioUnitario"));
            a.setUltUsuario(result.getString("UltUsuario"));
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
        
        PreparedStatement ps = con.prepareStatement("select * from Articulos ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Articulos a = new Articulos();
            a.setPK_IDArticulo(result.getInt("PK_IDArticulo"));
            a.setFK_idProveedor(result.getInt("FK_idProveedor"));
            a.setNombre(result.getString("Nombre"));
            a.setDescripcion(result.getString("Descripcion"));
            a.setCantidadExistencia(result.getInt("CantidadExistencia"));
            a.setPrecioUnitario(result.getDouble("PrecioUnitario"));
            a.setUltUsuario(result.getString("UltUsuario"));
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
        
        PreparedStatement ps = con.prepareStatement("select * from Articulos "+where );
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Articulos a = new Articulos();
             a.setPK_IDArticulo(result.getInt("PK_IDArticulo"));
            a.setFK_idProveedor(result.getInt("FK_idProveedor"));
            a.setNombre(result.getString("Nombre"));
            a.setDescripcion(result.getString("Descripcion"));
            a.setCantidadExistencia(result.getInt("CantidadExistencia"));
            a.setPrecioUnitario(result.getDouble("PrecioUnitario"));
            a.setUltUsuario(result.getString("UltUsuario"));
            l.add(a);
        }
        con.close();
        return l;
        
     
    }

    
    
}
