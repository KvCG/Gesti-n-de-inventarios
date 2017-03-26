/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Dao;

import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Movimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kev
 */
public class MovimientoDao implements IBaseDao<Movimiento> {

    private final MySQLConexion conexion;

    public MovimientoDao() {
        conexion = new MySQLConexion();
    }

    @Override
    public void insertar(Movimiento obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into movimiento(persona,proveedor,articulo,tipo,cantidad,"
                + "fecha) values (?,?,?,?,?,curdate())");

        cs.setInt(1, obj.getIdPersona());
        cs.setInt(2, obj.getIdProveedor());
        cs.setInt(3, obj.getIdArticulo());
        cs.setInt(4, obj.getTipo());
        cs.setInt(5, obj.getCantidad());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Movimiento obj) throws SQLException {// Se muede modificar un movimiento?
//        Connection con = conexion.getConexion();
//        CallableStatement cs = con.prepareCall("update movimiento set persona = ?, proveedor = ?,"
//                + "articulo=?, tipo = ? where idMovimiento = ?");
//        
//        cs.setInt(1, obj.getIdPersona());
//        cs.setInt(2, obj.getIdProveedor());
//        cs.setInt(3, obj.getIdArticulo());
//        cs.setInt(4, obj.getTipo());
//        cs.executeUpdate();
//        con.close();
    }

    @Override
    public void eliminar(Movimiento obj) throws SQLException { //Se debe eliminar?

    }

    @Override
    public Movimiento obtenerPorId(Movimiento obj) throws SQLException {
        return null;
    }

    @Override
    public Movimiento obtenerPorId2(Movimiento obj) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Movimiento> obtenerTodos() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Movimiento> obtenerConWhere(String where) throws SQLException {
        return null; 
    }

}
