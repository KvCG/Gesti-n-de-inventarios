/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Articulos;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedores;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ArticuloBL implements IBaseBL<Articulos> {
    
    private GenericDao aDao;
    
    /**
     *
     */
    public ArticuloBL(){
        this.aDao = new GenericDao();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Articulos obj) throws SQLException {
        this.aDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Articulos obj) throws SQLException {
        this.aDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Articulos obj) throws SQLException {
        this.aDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Articulos obtenerPorId(Articulos obj) throws SQLException {
        return (Articulos)this.aDao.obtenerPorId(obj);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Articulos> obtenerTodos() throws SQLException {
        return this.aDao.obtenerTodos(new Articulos());
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<Proveedores> obtenerConWhere(Articulos obj, String where ) throws SQLException {
        return this.aDao.obtenerConWhere(obj, where);
    } 

    /**
     *
     * @param idArticulo
     */
    public void obtenerPorId(int idArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
