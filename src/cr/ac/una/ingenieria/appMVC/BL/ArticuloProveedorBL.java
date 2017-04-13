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
 * @author Kev
 */
public class ArticuloProveedorBL implements IBaseBL<ArticuloProveedor> {
    
    private GenericDao apDao;
    
    public ArticuloProveedorBL() {
        this.apDao = new GenericDao();
    }
    
    @Override
    public void insertar(ArticuloProveedor obj) throws SQLException {
        apDao.insertar(obj);
    }
    
    @Override
    public void modificar(ArticuloProveedor obj) throws SQLException {
        apDao.modificar(obj);
    }
    
    @Override
    public void eliminar(ArticuloProveedor obj) throws SQLException {
        apDao.eliminar(obj);
    }
    
    @Override
    public ArticuloProveedor obtenerPorId(ArticuloProveedor obj) throws SQLException {
        return (ArticuloProveedor) apDao.obtenerPorId(obj);
    }
    
    @Override
    public ArticuloProveedor obtenerPorId2(ArticuloProveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<ArticuloProveedor> obtenerTodos() throws SQLException {
        return apDao.obtenerTodos(this);
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
