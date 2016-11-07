/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
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
    MySQLConexion metodos= new MySQLConexion();
    private PantallaPrincipal ManteAdmiView;
    private SolicitudUsuarioPassword solUsePa;

    public PantallaPrincipal getManteAdmiView() {
        return ManteAdmiView;
    }

    public void setManteAdmiView(PantallaPrincipal ManteAdmiView) {
        this.ManteAdmiView = ManteAdmiView;
    }

    /**
     *
     * @return
     */
   

    /**
     *
     * @return
     */
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
    public ValidarAcceso(PantallaPrincipal ManteAdmiView, SolicitudUsuarioPassword solUsePa) {
        this.ManteAdmiView = ManteAdmiView;
        this.solUsePa = solUsePa;
        this.solUsePa.BtIngresar.addActionListener(this);
    }

    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.solUsePa.BtIngresar) {
            if(validadIngreso()==1){
                this.solUsePa.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido has ingresado"
                                                +"Satisfactoriamente SIGACI","Mensaje de Bienvenida", 
                                                JOptionPane.INFORMATION_MESSAGE);
                PantallaPrincipal ManteAdmiView = new PantallaPrincipal();
                ArticuloBL articuloBlModelo = new ArticuloBL();
                ProveedorBL proveedorBlModelo = new ProveedorBL();
                UsuarioBL usuarioBLModelo = new UsuarioBL();
                PantallaPrincipalControlador controlador = new PantallaPrincipalControlador(ManteAdmiView,usuarioBLModelo, proveedorBlModelo,articuloBlModelo);
                controlador.getPantPrinView().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Acceso Denegado"
                                                +"por favor ingrese su usuario y contrasena correctos ","Acceso Denegado", 
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
    public int validadIngreso(){
        
        String usuario= solUsePa.txtUsuario.getText();
        String password= String.valueOf(solUsePa.TxtPassword.getPassword());
        
        int resultado= 0;
        String SSQL="SELECT * FROM usuarios WHERE usuario='"+ usuario+"'AND Contraseña=('"+password+"')";
        Connection connect= null;
        try {
            connect= metodos.getConexion();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            if(rs.next()){
                resultado=1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de Conexion ", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                connect.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error de Desconexion ", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }
     
       

}
