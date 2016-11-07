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
        
        CallableStatement cs = con.prepareCall("insert into Usuarios (nombre,usuario,"
                                             + "contraseña,ultUsuario,"
                                             + "ultFecha) values "
                                             + "(?,?,?,?,curdate())");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getUsuario());
        cs.setString(3, obj.getContraseña());
        cs.setString(4, obj.getUltUsuario()); 
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Usuario obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update Usuarios set nombre = ?, "
                                            + "Usuario = ?, Contraseña = ?,"
                                            + "ultUsuario = ?,"
                                            + "ultFecha = curdate() "
                                            + "where PK_idUsuario = ?");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getUsuario());
        cs.setString(3, obj.getContraseña());
        cs.setString(4, obj.getUltUsuario()); 
        cs.setInt(5, obj.getPK_idUsuario());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Usuario obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from Usuarios where PK_idUsuario = ?");
        cs.setInt(1, obj.getPK_idUsuario());
        
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
    public Usuario obtenerPorId(Usuario obj) throws SQLException {
        Usuario u = null;
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("select * from Usuarios where PK_idUsuario = ? " );
        cs.setInt(1, obj.getPK_idUsuario());
        ResultSet result = cs.executeQuery();
        while(result.next()){
            u = new Usuario();
            u.setPK_idUsuario(result.getInt("PK_idUsuario"));
            u.setNombre(result.getString("nombre"));
            u.setUsuario(result.getString("Usuario"));
            u.setContraseña(result.getString("Contraseña"));
            u.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return u;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Usuario> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Usuario> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Usuarios ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Usuario u = new Usuario();
            u.setPK_idUsuario(result.getInt("PK_idUsuario"));
            u.setNombre(result.getString("nombre"));
            u.setUsuario(result.getString("Usuario"));
            u.setContraseña(result.getString("Contraseña"));
            u.setUltUsuario(result.getString("UltUsuario"));
            l.add(u);
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
    public ArrayList<Usuario> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Usuario> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Usuarios "+where);
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Usuario u = new Usuario();
            u.setPK_idUsuario(result.getInt("PK_idUsuario"));
            u.setNombre(result.getString("nombre"));
            u.setUsuario(result.getString("Usuario"));
            u.setContraseña(result.getString("Contraseña"));
            u.setUltUsuario(result.getString("UltUsuario"));
            l.add(u);
        }
        con.close();
        return l;
    }
    
}
