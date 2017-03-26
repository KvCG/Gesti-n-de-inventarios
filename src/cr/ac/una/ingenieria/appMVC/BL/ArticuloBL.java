/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ArticuloBL implements IBaseBL<Articulo> {
    
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
    public void insertar(Articulo obj) throws SQLException {
        this.aDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Articulo obj) throws SQLException {
        this.aDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Articulo obj) throws SQLException {
        this.aDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Articulo obtenerPorId(Articulo obj) throws SQLException {
        return (Articulo)this.aDao.obtenerPorId(obj);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Articulo> obtenerTodos() throws SQLException {
        return this.aDao.obtenerTodos(new Articulo());
    }

    
    public ArrayList<Proveedor> obtenerConWhere(Articulo obj, String where ) throws SQLException {
        return this.aDao.obtenerConWhere(obj, where);
    } 

 

    @Override
    public Articulo obtenerPorId2(Articulo obj) throws SQLException {
        return (Articulo)this.aDao.obtenerPorId2(obj);
    }

    
    
}
