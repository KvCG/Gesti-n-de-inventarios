
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.TipoArticulo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class TipoArticuloBL implements IBaseBL<TipoArticulo>{
    private GenericDao sDAo;

    public TipoArticuloBL() {
        this.sDAo = new GenericDao();
    }
  @Override
    public void insertar(TipoArticulo obj) throws SQLException {
        this.sDAo.insertar(obj);
    }

    @Override
    public void modificar(TipoArticulo obj) throws SQLException {
        this.sDAo.modificar(obj);
    }

    @Override
    public void eliminar(TipoArticulo obj) throws SQLException {
        this.sDAo.eliminar(obj);
    }

    @Override
    public TipoArticulo obtenerPorId(TipoArticulo obj) throws SQLException {
        return (TipoArticulo)sDAo.obtenerPorId(obj);
    }

    @Override
    public TipoArticulo obtenerPorId2(TipoArticulo obj) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<TipoArticulo> obtenerTodos() throws SQLException {
        return this.sDAo.obtenerTodos(new TipoArticulo());
    }
    
    public ArrayList<TipoArticulo> obtenerConWhere(TipoArticulo obj,String where)throws SQLException{
        return this.sDAo.obtenerConWhere(obj, where);
    }    

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        return  null;
    }

    @Override
    public ArrayList<TipoArticulo> obtenerConWhere() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
