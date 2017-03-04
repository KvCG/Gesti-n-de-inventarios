/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedores;
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
public class ProveedorDao implements IBaseDao<Proveedores> {

    private final MySQLConexion conexion;
     
    /**
     *
     */
    public ProveedorDao() {
        conexion = new MySQLConexion();
    }
      
    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Proveedores obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into proveedor(nombre,email,telefono,"
                                             + "direccion) values "
                                             + "(?,?,?,?)");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getEmail());
        cs.setString(3, obj.getTelefono());
        cs.setString(4, obj.getDireccion());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Proveedores obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update proveedores set nombre= ?,"
                                            + "email=?, telefono=?,"
                                            + "direccion=?,"
                                            + "where PK_IDProvedor=? ");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getEmail());
        cs.setString(3, obj.getTelefono());
        cs.setString(4, obj.getDireccion());;
        cs.setInt(5, obj.getIdProvedor());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Proveedores obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from proveedores where idproveedor = ?");
        cs.setInt(1, obj.getIdProvedor());
        
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
    public Proveedores obtenerPorId(Proveedores obj) throws SQLException {
        Proveedores p = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from proveedores where idproveedor = ? " );
        cs.setInt(1, obj.getIdProvedor());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            p = new Proveedores();
            p.setIdProvedor(result.getInt("idproveedor"));
            p.setNombre(result.getString("nombre"));
            p.setEmail(result.getString("email"));
            p.setTelefono(result.getString("telefono"));
            p.setDireccion(result.getString("direccion"));
        }
        con.close();
        return p;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Proveedores> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Proveedores> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from proveedor ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedores p = new Proveedores();
            p.setIdProvedor(result.getInt("idproveedor"));
            p.setNombre(result.getString("nombre"));
            p.setEmail(result.getString("email"));
            p.setTelefono(result.getString("telefono"));
            p.setDireccion(result.getString("direccion"));
            l.add(p);
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
    public ArrayList<Proveedores> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Proveedores> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from proveedor "+where );
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedores p = new Proveedores();
            p.setIdProvedor(result.getInt("idproveedor"));
            p.setNombre(result.getString("nombre"));
            p.setEmail(result.getString("email"));
            p.setTelefono(result.getString("telefono"));
            p.setDireccion(result.getString("direccion"));
            l.add(p);
        }
        con.close();
        return l;
    }
    
}

