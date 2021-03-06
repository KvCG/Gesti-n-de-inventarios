/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.MovimientoBL;
import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantProveedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Moviento;
import cr.ac.una.ingenieria.appMVC.Vista.PantallaPrincipal;
import cr.ac.una.ingenieria.appMVC.Vista.SolicitudUsuarioPassword;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Gustavo
 */
public class ValidarAcceso implements ActionListener, DocumentListener {

    MySQLConexion metodos = new MySQLConexion();
    public static PantallaPrincipal ManteAdmiView;
    private SolicitudUsuarioPassword solUsePa;
    public static Usuario current;
    public static Persona perCurrent;
    private PersonaBL perBl;
    private UsuarioBL usuBl;

    public static Persona getPerCurrent() {
        return perCurrent;
    }

    public static void setPerCurrent(Persona perCurrent) {
        ValidarAcceso.perCurrent = perCurrent;
    }

    public PantallaPrincipal getManteAdmiView() {
        return ManteAdmiView;
    }

    public static Usuario getCurrent() {
        return current;
    }

    public static void setCurrent(Usuario current) {
        ValidarAcceso.current = current;
    }

    public void setManteAdmiView(PantallaPrincipal ManteAdmiView) {
        this.ManteAdmiView = ManteAdmiView;
    }

    public MySQLConexion getMetodos() {
        return metodos;
    }

    /**
     *
     * @param metodos
     */
    public void setMetodos(MySQLConexion metodos) {
        this.metodos = metodos;
    }

    /**
     *
     * @return
     */
    public SolicitudUsuarioPassword getSolUsePa() {
        return solUsePa;
    }

    /**
     *
     * @param solUsePa
     */
    public void setSolUsePa(SolicitudUsuarioPassword solUsePa) {
        this.solUsePa = solUsePa;
    }

    /**
     *
     * @param ManteAdmiView
     * @param solUsePa
     */
    public ValidarAcceso(SolicitudUsuarioPassword solUsePa) {
        this.solUsePa = solUsePa;
        this.solUsePa.BtIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.solUsePa.BtIngresar) {
            if (validadIngreso() == 1) {
                this.solUsePa.dispose();
                this.ManteAdmiView = new PantallaPrincipal();
                ArticuloBL articuloBlModelo = new ArticuloBL();
                ProveedorBL proveedorBlModelo = new ProveedorBL();
                UsuarioBL usuarioBLModelo = new UsuarioBL();
                PersonaBL personaBLModelo = new PersonaBL();
                PantallaPrincipalControlador controlador = new PantallaPrincipalControlador(ManteAdmiView, usuarioBLModelo, proveedorBlModelo, articuloBlModelo, personaBLModelo);
                controlador.getPantPrinView().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Acceso Denegado"
                        + "por favor ingrese su usuario y contrasena correctos ", "Acceso Denegado",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        validadIngreso();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validadIngreso();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validadIngreso();
    }

    /**
     *
     * @return
     */
    public int validadIngreso() {
        current = new Usuario();
        String usuario = solUsePa.txtUsuario.getText();
        String password = String.valueOf(solUsePa.TxtPassword.getPassword());

        int resultado = 0;
        String SSQL = "SELECT * FROM usuario WHERE alias='" + usuario + "'AND password=('" + password + "')";

        Connection connect = null;
        try {
            ValidarAcceso.current = new Usuario();
            ValidarAcceso.perCurrent = new Persona();
            this.perBl = new PersonaBL();
            this.usuBl = new UsuarioBL();
            connect = metodos.getConexion();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            if (rs.next()) {
                ValidarAcceso.current.setAlias(rs.getString("alias"));
                ValidarAcceso.current = usuBl.obtenerPorId(current);
                ValidarAcceso.perCurrent.setIdpersona(current.getIdPersona());
                ValidarAcceso.perCurrent = perBl.obtenerPorId2(perCurrent);
                resultado = 1;
            }
            connect.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de Conexion ", JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }

}
