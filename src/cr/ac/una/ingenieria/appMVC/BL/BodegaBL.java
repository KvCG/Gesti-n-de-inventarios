
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Bodega;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class BodegaBL implements IBaseBL<Bodega>{
    private GenericDao sDAo;

    public BodegaBL() {
        this.sDAo = new GenericDao();
    }

    @Override
    public void insertar(Bodega obj) throws SQLException {
        this.sDAo.insertar(obj);
    }

    @Override
    public void modificar(Bodega obj) throws SQLException {
        this.sDAo.modificar(obj);
    }

    @Override
    public void eliminar(Bodega obj) throws SQLException {
        this.sDAo.eliminar(obj);
    }

    @Override
    public Bodega obtenerPorId(Bodega obj) throws SQLException {
        return (Bodega)sDAo.obtenerPorId(obj);
    }

    @Override
    public Bodega obtenerPorId2(Bodega obj) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Bodega> obtenerTodos() throws SQLException {
        return this.sDAo.obtenerTodos(new Bodega());
    }
    
    public ArrayList<Bodega> obtenerConWhere(Bodega obj,String where)throws SQLException{
        return this.sDAo.obtenerConWhere(obj, where);
    }    

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        return null;
    }
}
