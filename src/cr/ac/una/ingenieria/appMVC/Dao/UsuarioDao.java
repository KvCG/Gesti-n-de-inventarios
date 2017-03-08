/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
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
public class UsuarioDao implements IBaseDao<Usuario> {

    private final MySQLConexion conexion;

    /**
     *
     */
    public UsuarioDao() {
        conexion = new MySQLConexion();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Usuario obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("insert into usuario (alias,"
                + "password,rol,persona) values "
                + "(?,?,?,?)");
        cs.setString(1, obj.getAlias());
        cs.setString(2, obj.getPassword());
        cs.setInt(3, 1);//obj.getRol());
        cs.setInt(4, obj.getIdPersona());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Usuario obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("update usuario "
                + "set alias = ?, password = ?,"
                + "rol = ?,"
                + "where where alias = ?");
        cs.setString(1, obj.getAlias());
        cs.setString(2, obj.getPassword());
        cs.setInt(3, obj.getRol());
        cs.setString(4, obj.getAlias());
        cs.executeUpdate();
        con.close();
    }


    @Override
    public void eliminar(Usuario obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("delete from usuario where alias = ?");
        cs.setString(1, obj.getAlias());

        cs.executeUpdate();
        con.close();
    }


    @Override
    public Usuario obtenerPorId(Usuario obj) throws SQLException {
        Usuario u = null;
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("select * from usuario where alias = ? ");
        cs.setString(1, obj.getAlias());
        ResultSet result = cs.executeQuery();
        while (result.next()) {
            u = new Usuario();
            u.setIdUsuario(result.getInt("idusuario"));
            u.setIdPersona(result.getInt("idpersona"));
            u.setAlias(result.getString("alias"));
            u.setPassword(result.getString("password"));
            u.setRol(result.getInt("rol"));
        }
        con.close();
        return u;
    }

    @Override
    public ArrayList<Usuario> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Usuario> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from usuario ");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Usuario u = new Usuario();
            u.setIdUsuario(result.getInt("idusuario"));
            u.setIdPersona(result.getInt("idpersona"));
            u.setAlias(result.getString("alias"));
            u.setPassword(result.getString("password"));
            u.setRol(result.getInt("rol"));
            l.add(u);
        }
        con.close();
        return l;
    }


    @Override
    public ArrayList<Usuario> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Usuario> l = new ArrayList();

        PreparedStatement ps = con.prepareStatement("select * from usuario " + where);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Usuario u = new Usuario();
            u.setIdUsuario(result.getInt("idusuario"));
            u.setIdPersona(result.getInt("idpersona"));
            u.setAlias(result.getString("alias"));
            u.setPassword(result.getString("password"));
            u.setRol(result.getInt("rol"));
            l.add(u);
        }
        con.close();
        return l;
    }

}
