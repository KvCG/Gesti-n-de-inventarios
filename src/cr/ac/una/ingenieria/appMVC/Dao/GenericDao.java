/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;





import cr.ac.una.ingenieria.appMVC.Domain.Persona;

import cr.ac.una.ingenieria.appMVC.Domain.Articulo;

import cr.ac.una.ingenieria.appMVC.Domain.Proveedores;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class GenericDao {

    private IBaseDao iBaseDato;

    /**
     *
     */
    public GenericDao() {
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    public void insertar(Object obj) throws SQLException {
        if (obj instanceof Persona) {
            iBaseDato = new PersonaDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
         if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
         }
          if (obj instanceof Articulo) {
            iBaseDato = new ArticuloDao();
        }
        
        iBaseDato.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    public void modificar(Object obj) throws SQLException {
         if (obj instanceof Persona) {
            iBaseDato = new PersonaDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
         if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
         }
          if (obj instanceof Articulo) {
            iBaseDato = new ArticuloDao();
        }
        iBaseDato.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    public void eliminar(Object obj) throws SQLException {
         if (obj instanceof Persona) {
            iBaseDato = new PersonaDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
         if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
         }
          if (obj instanceof Articulo) {
            iBaseDato = new ArticuloDao();
        }
        iBaseDato.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    public Object obtenerPorId(Object obj) throws SQLException {
         if (obj instanceof Persona) {
            iBaseDato = new PersonaDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
         if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
         }
          if (obj instanceof Articulo) {
            iBaseDato = new ArticuloDao();
        }
        return iBaseDato.obtenerPorId(obj);
    }
    
    public Object obtenerPorId2(Object obj) throws SQLException {
         if (obj instanceof Persona) {
            iBaseDato = new PersonaDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
         if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
         }
          if (obj instanceof Articulo) {
            iBaseDato = new ArticuloDao();
        }
        return iBaseDato.obtenerPorId2(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    public ArrayList obtenerTodos(Object obj) throws SQLException {
         if (obj instanceof Persona) {
            iBaseDato = new PersonaDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
         if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
         }
          if (obj instanceof Articulo) {
            iBaseDato = new ArticuloDao();
        }
        return iBaseDato.obtenerTodos();
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList obtenerConWhere(Object obj, String where) throws SQLException {
         if (obj instanceof Persona) {
            iBaseDato = new PersonaDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
         if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
         }
          if (obj instanceof Articulo) {
            iBaseDato = new ArticuloDao();
        }
        return iBaseDato.obtenerConWhere(where);
    }
}
