
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.TipoArticulo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class TipoArticuloDao implements IBaseDao<TipoArticulo>{
    private final MySQLConexion conexion;

    public TipoArticuloDao() {
        this.conexion = new MySQLConexion();
    }
    

    @Override
    public void insertar(TipoArticulo obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("insert into tipo_articulo"
                + "(descripcion,estado) values(?,?)");
        
        cs.setString(1,obj.getDescripcion());
        cs.setBoolean(2, obj.getEstado());
        
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(TipoArticulo obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update tipo_articulo set descripcion = ?,"
                + "estado = ?" + " where codigo=?");
        
        cs.setString(1, obj.getDescripcion());
        cs.setBoolean(2, obj.getEstado());
        cs.setInt(3, obj.getCodigo());
        
        cs.executeUpdate();
        con.close();
    
    }

    @Override
    public void eliminar(TipoArticulo obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("update tipo_articulo set estado = false where codigo = ?");
        
        cs.setInt(1, obj.getCodigo());        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public TipoArticulo obtenerPorId(TipoArticulo obj) throws SQLException {
        TipoArticulo tipoArticulo = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("Select * from tipo_articulo where codigo = ?");
        cs.setInt(1, obj.getCodigo());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            tipoArticulo = new  TipoArticulo();
            tipoArticulo.setCodigo(result.getInt("codigo"));
            tipoArticulo.setDescripcion(result.getString("desripcion"));
            tipoArticulo.setEstado(result.getBoolean("estado"));            
        }
        con.close();
        return tipoArticulo;
    }

    @Override
    public TipoArticulo obtenerPorId2(TipoArticulo obj) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<TipoArticulo> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<TipoArticulo> listaTipoArticulo = new ArrayList();
        
        PreparedStatement ps = con.prepareCall("select * from tipo_articulo");
        ResultSet result = ps.executeQuery();
        
        while(result.next()){
            TipoArticulo tipArt = new TipoArticulo();
            tipArt.setCodigo(result.getInt("codigo"));
            tipArt.setDescripcion(result.getString("descripcion"));
            tipArt.setEstado(result.getBoolean("estado"));
            listaTipoArticulo.add(tipArt);
        }
        con.close();
        return listaTipoArticulo;
    }

    @Override
    public ArrayList<TipoArticulo> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<TipoArticulo> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from tipo_articulo " + where);
        ResultSet result = ps.executeQuery();
        
        while(result.next()){
            TipoArticulo tipArt = new TipoArticulo();
            tipArt.setCodigo(result.getInt("codigo"));
            tipArt.setDescripcion(result.getString("descripcion"));
            tipArt.setEstado(result.getBoolean("estado"));
            l.add(tipArt);
        }
        con.close();
        return l;
    }

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
