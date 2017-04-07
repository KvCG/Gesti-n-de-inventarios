/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.BL;

import cr.ac.una.ingenieria.appMVC.Dao.GenericDao;
import cr.ac.una.ingenieria.appMVC.Domain.Movimiento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kev
 */
public class MovimientoBL implements IBaseBL<Movimiento> {

    private GenericDao aDao;

    public MovimientoBL() {
        this.aDao = new GenericDao();
    }

    @Override
    public void insertar(Movimiento obj) throws SQLException {
        this.aDao.insertar(obj);
    }

    @Override
    public void modificar(Movimiento obj) throws SQLException {
        this.aDao.modificar(obj);
    }

    @Override
    public void eliminar(Movimiento obj) throws SQLException {
        this.aDao.eliminar(obj);
    }

    @Override
    public Movimiento obtenerPorId(Movimiento obj) throws SQLException {
        return (Movimiento) this.aDao.obtenerPorId(obj);
    }

    @Override
    public Movimiento obtenerPorId2(Movimiento obj) throws SQLException {
        return (Movimiento) this.aDao.obtenerPorId2(obj);
    }

    @Override
    public ArrayList<Movimiento> obtenerTodos() throws SQLException {
        return this.aDao.obtenerTodos(new Movimiento());
    }

    @Override
    public Integer obtenerConsecutivo() throws SQLException {
        return this.aDao.obtenerConsecutivo(this);
    }

}
