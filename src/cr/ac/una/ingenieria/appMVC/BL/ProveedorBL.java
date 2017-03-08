/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedores;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ProveedorBL implements IBaseBL<Proveedores> {
    
    private GenericDao pDao;
    
    /**
     *
     */
    public ProveedorBL(){
        this.pDao = new GenericDao();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Proveedores obj) throws SQLException {
        pDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Proveedores obj) throws SQLException {
        pDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Proveedores obj) throws SQLException {
        pDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Proveedores obtenerPorId(Proveedores obj) throws SQLException {
       return (Proveedores)this.pDao.obtenerPorId(obj);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Proveedores> obtenerTodos() throws SQLException {
       return this.pDao.obtenerTodos(new Proveedores());
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<Proveedores> obtenerConWhere(Proveedores obj, String where ) throws SQLException {
        return this.pDao.obtenerConWhere(obj, where);
    } 

    @Override
    public Proveedores obtenerPorId2(Proveedores obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


