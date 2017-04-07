
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Bodega;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BodegaDao implements IBaseDao<Bodega>{
    private final MySQLConexion conexion;

    public BodegaDao() {
        this.conexion = new MySQLConexion();
    }

    @Override
    public void insertar(Bodega obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("insert into bodega"
                + "(idbodega,tipo,nombre,estado) values(?,?,?,?)");
        cs.setInt(1,obj.getIdBodega());
        cs.setString(2,obj.getTipo());
        cs.setString(3, obj.getNombre());
        cs.setBoolean(4, obj.getEstado());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Bodega obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update bodega set tipo = ?,"
                + "nombre = ?,"
                + "estado = ?" 
                + " where idbodega=?");
        
        cs.setString(1, obj.getTipo());
        cs.setString(2, obj.getNombre());
        cs.setBoolean(3, obj.getEstado());
        cs.setInt(4, obj.getIdBodega());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(Bodega obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("update bodega set estado = false where idbodega = ?");
        
        cs.setInt(1, obj.getIdBodega());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public Bodega obtenerPorId(Bodega obj) throws SQLException {
        Bodega bodega = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("Select * from bodega where idbodega = ?");
        cs.setInt(1, obj.getIdBodega());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            bodega = new  Bodega();
            bodega.setIdBodega(result.getInt("idbodega"));
            bodega.setTipo(result.getString("tipo"));
            bodega.setNombre(result.getString("nombre"));
            bodega.setEstado(result.getBoolean("estado"));            
        }
        con.close();
        return bodega;
    }

    @Override
    public Bodega obtenerPorId2(Bodega obj) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Bodega> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Bodega> listaBodega = new ArrayList();
        
        PreparedStatement ps = con.prepareCall("select * from bodega");
        ResultSet result = ps.executeQuery();
        
        while(result.next()){
            Bodega bod = new Bodega();
            bod.setIdBodega(result.getInt("idbodega"));
            bod.setTipo(result.getString("tipo"));
            bod.setNombre(result.getString("nombre"));
            bod.setEstado(result.getBoolean("estado"));
            listaBodega.add(bod);
        }
        con.close();
        return listaBodega;
    }

    @Override
    public ArrayList<Bodega> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Bodega> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from bodega " + where);
        ResultSet result = ps.executeQuery();
        
        while(result.next()){
            Bodega bodega = new Bodega();
            bodega.setIdBodega(result.getInt("idbodega"));
            bodega.setTipo(result.getString("tipo"));
            bodega.setNombre(result.getString("nombre"));
            bodega.setEstado(result.getBoolean("estado"));
            l.add(bodega);
        }
        con.close();
        return l;
    }

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        return  null;
    }
    
}
