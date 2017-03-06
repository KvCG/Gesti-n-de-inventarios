/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class PersonaBL implements IBaseBL<Persona>{
    
    private GenericDao peDao;

    public PersonaBL() {
        this.peDao = new GenericDao();
    }
            
    

    @Override
    public void insertar(Persona obj) throws SQLException {
        this.peDao.insertar(obj);
    }

    @Override
    public void modificar(Persona obj) throws SQLException {
        this.peDao.modificar(obj);
    }

    @Override
    public void eliminar(Persona obj) throws SQLException {
        this.peDao.eliminar(obj);
    }

    @Override
    public Persona obtenerPorId(Persona obj) throws SQLException {
        return (Persona)this.peDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<Persona> obtenerTodos() throws SQLException {
        return this.peDao.obtenerTodos(new Persona());
    }
    public ArrayList<Persona> obtenerConWhere(Persona obj, String where ) throws SQLException {
        return this.peDao.obtenerConWhere(obj, where);
    } 
}
