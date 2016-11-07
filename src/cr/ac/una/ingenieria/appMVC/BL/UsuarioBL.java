/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;


import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class UsuarioBL implements IBaseBL<Usuario> {
    
    private GenericDao uDao;

    /**
     *
     */
    public UsuarioBL() {
        this.uDao = new GenericDao();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Usuario obj) throws SQLException {
        this.uDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Usuario obj) throws SQLException {
        this.uDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Usuario obj) throws SQLException {
        this.uDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Usuario obtenerPorId(Usuario obj) throws SQLException {
       return (Usuario)this.uDao.obtenerPorId(obj);    
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Usuario> obtenerTodos() throws SQLException {
        return this.uDao.obtenerTodos(new Usuario());
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<Usuario> obtenerConWhere(Usuario obj, String where ) throws SQLException {
        return this.uDao.obtenerConWhere(obj, where);
    } 
    
}
