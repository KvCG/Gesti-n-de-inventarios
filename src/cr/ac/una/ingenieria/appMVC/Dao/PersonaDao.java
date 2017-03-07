/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
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
public class PersonaDao implements IBaseDao<Persona> {
    
    private final MySQLConexion conexion;

    public PersonaDao() {
        conexion = new MySQLConexion();
    }

    
    
    

    @Override
    public void insertar(Persona obj) throws SQLException {
        Connection con = conexion.getConexion();  
        CallableStatement cs = con.prepareCall("insert into persona (cedula,nombre,apellidos,correo)"
                                             + " values (?,?,?,?)");
        
        cs.setString(1, obj.getCedula());
        cs.setString(2, obj.getNombre());
        cs.setString(3, obj.getApellidos());
        cs.setString(4, obj.getCorreo());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Persona obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("update persona set cedula =?,nombre = ?,apellidos = ?,correo = ?"
                                             + " where idpersona = ?");
        
        cs.setString(1, obj.getCedula());
        cs.setString(2, obj.getNombre());
        cs.setString(3, obj.getApellidos());
        cs.setString(4, obj.getCorreo());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(Persona obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from persona where idpersona = ?");
        cs.setInt(1, obj.getIdpersona());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public Persona obtenerPorId(Persona obj) throws SQLException {
        Persona p = null;
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("select * from persona where idpersona = ? " );
        cs.setInt(1, obj.getIdpersona());
        
         ResultSet result = cs.executeQuery();
        while(result.next()){
        p = new Persona();
        p.setIdpersona(result.getInt("idpersona"));
        p.setCedula(result.getString("cedula"));
        p.setNombre(result.getString("nombre"));
        p.setApellidos(result.getString("apellidos"));
        p.setCorreo(result.getString("correo"));
        }
        con.close();
        return p;
    }

    @Override
    public ArrayList<Persona> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Persona> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from persona ");
        ResultSet result = ps.executeQuery();
         while(result.next()){
        Persona p = new Persona();
        p.setIdpersona(result.getInt("idpersona"));
        p.setCedula(result.getString("cedula"));
        p.setNombre(result.getString("nombre"));
        p.setApellidos(result.getString("apellidos"));
        p.setCorreo(result.getString("correo"));
        l.add(p);
        }
        con.close();
        return l;
    }

    @Override
    public ArrayList<Persona> obtenerConWhere(String where) throws SQLException {
         Connection con = conexion.getConexion();
        ArrayList<Persona> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from persona "+where);
        ResultSet result = ps.executeQuery();
         while(result.next()){
        Persona p = new Persona();
        p.setIdpersona(result.getInt("idpersona"));
        p.setCedula(result.getString("cedula"));
        p.setNombre(result.getString("nombre"));
        p.setApellidos(result.getString("apellidos"));
        p.setCorreo(result.getString("correo"));
        l.add(p);
        }
        con.close();
        return l;
    }
    
}
