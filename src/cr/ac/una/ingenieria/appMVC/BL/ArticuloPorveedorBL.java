/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;


import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.ArticuloProveedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ArticuloPorveedorBL implements IBaseBL<ArticuloProveedor>{
    private GenericDao apDao;

    public ArticuloPorveedorBL(GenericDao apDao) {
        this.apDao = apDao;
    }

    @Override
    public void insertar(ArticuloProveedor obj) throws SQLException {
        this.apDao.insertar(obj);
    }

    @Override
    public void modificar(ArticuloProveedor obj) throws SQLException {
        this.apDao.modificar(obj);
    }

    @Override
    public void eliminar(ArticuloProveedor obj) throws SQLException {
        this.apDao.eliminar(obj);
    }

    @Override
    public ArticuloProveedor obtenerPorId(ArticuloProveedor obj) throws SQLException {
        return (ArticuloProveedor)this.apDao.obtenerPorId(obj);
    }

    @Override
    public ArticuloProveedor obtenerPorId2(ArticuloProveedor obj) throws SQLException {
       return (ArticuloProveedor)this.apDao.obtenerPorId2(obj);
    }

    @Override
    public ArrayList<ArticuloProveedor> obtenerTodos() throws SQLException {
        return this.apDao.obtenerTodos(new ArticuloProveedor());
    }
    
    public ArrayList<ArticuloProveedor> obtenerConWhere(ArticuloProveedor obj, String where ) throws SQLException {
        return this.apDao.obtenerConWhere(obj, where);
    } 

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ArticuloProveedor> obtenerConWhere() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
