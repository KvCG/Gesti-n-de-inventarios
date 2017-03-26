/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ProveedorBL implements IBaseBL<Proveedor> {
    
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
    public void insertar(Proveedor obj) throws SQLException {
        pDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Proveedor obj) throws SQLException {
        pDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Proveedor obj) throws SQLException {
        pDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Proveedor obtenerPorId(Proveedor obj) throws SQLException {
       return (Proveedor)this.pDao.obtenerPorId(obj);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Proveedor> obtenerTodos() throws SQLException {
       return this.pDao.obtenerTodos(new Proveedor());
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<Proveedor> obtenerConWhere(Proveedor obj, String where ) throws SQLException {
        return this.pDao.obtenerConWhere(obj, where);
    } 

    @Override
    public Proveedor obtenerPorId2(Proveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


