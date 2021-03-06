
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
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
public class ProveedorDao implements IBaseDao<Proveedor> {

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
    public void insertar(Proveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into proveedor(nombre,email,telefono,"
                                             + "direccion,estado) values "
                                             + "(?,?,?,?,?)");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getEmail());
        cs.setString(3, obj.getTelefono());
        cs.setString(4, obj.getDireccion());
        cs.setBoolean(5, obj.getEstado());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Proveedor obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update proveedor set nombre=?,"
                                            + "email=?, telefono=?,"
                                            + "direccion=?,estado=? "
                                            + "where idproveedor=?");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getEmail());
        cs.setString(3, obj.getTelefono());
        cs.setString(4, obj.getDireccion());
        cs.setBoolean(5, obj.getEstado());
        cs.setInt(6, obj.getIdProvedor());
        
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Proveedor obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update proveedor set estado = false where idproveedor = ?");
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
    public Proveedor obtenerPorId(Proveedor obj) throws SQLException {
        Proveedor p = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from proveedor where idproveedor = ? " );
        cs.setInt(1, obj.getIdProvedor());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            p = new Proveedor();
            p.setIdProvedor(result.getInt("idproveedor"));
            p.setNombre(result.getString("nombre"));
            p.setEmail(result.getString("email"));
            p.setTelefono(result.getString("telefono"));
            p.setDireccion(result.getString("direccion"));
            p.setEstado(result.getBoolean("estado"));
        }
        con.close();
        return p;
    }
    
    
    
    @Override
    public Proveedor obtenerPorId2(Proveedor obj) throws SQLException {return null;
}

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Proveedor> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Proveedor> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from proveedor ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedor p = new Proveedor();
            p.setIdProvedor(result.getInt("idproveedor"));
            p.setNombre(result.getString("nombre"));
            p.setEmail(result.getString("email"));
            p.setTelefono(result.getString("telefono"));
            p.setDireccion(result.getString("direccion"));
            p.setEstado(result.getBoolean("estado"));
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
    public ArrayList<Proveedor> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Proveedor> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from proveedor "+where );
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedor p = new Proveedor();
            p.setIdProvedor(result.getInt("idproveedor"));
            p.setNombre(result.getString("nombre"));
            p.setEmail(result.getString("email"));
            p.setTelefono(result.getString("telefono"));
            p.setDireccion(result.getString("direccion"));
            p.setEstado(result.getBoolean("estado"));
            l.add(p);
        }
        con.close();
        return l;
    }

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

