/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 * @param <T>
 */
public interface IBaseDao<T> {

    /**
     *
     * @param obj
     * @throws SQLException
     */
    public void insertar(T obj) throws SQLException;

    /**
     *
     * @param obj
     * @throws SQLException
     */
    public void modificar(T obj) throws SQLException;

    /**
     *
     * @param obj
     * @throws SQLException
     */
    public void eliminar(T obj) throws SQLException;

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    public T obtenerPorId(T obj) throws SQLException;
            
            
    public T obtenerPorId2(T obj) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<T> obtenerTodos() throws SQLException;

    /**
     *
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<T> obtenerConWhere(String where) throws SQLException;
}
