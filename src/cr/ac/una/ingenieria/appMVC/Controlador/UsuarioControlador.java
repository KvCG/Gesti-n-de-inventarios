/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.MantUsuario;
import cr.ac.una.ingenieria.appMVC.Vista.MantUsuarioBuscar;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class UsuarioControlador implements ActionListener, DocumentListener {
    
    private MantUsuario mantUsuarioview;
    private UsuarioBL usuarioBlModelo;

    /**
     *
     */
    public UsuarioControlador() {
    }

    /**
     *
     * @return
     */
    public MantUsuario getMantUsuarioview() {
        return mantUsuarioview;
    }

    /**
     *
     * @param mantUsuarioview
     */
    public void setMantUsuarioview(MantUsuario mantUsuarioview) {
        this.mantUsuarioview = mantUsuarioview;
    }

    /**
     *
     * @return
     */
    public UsuarioBL getUsuarioBlModelo() {
        return usuarioBlModelo;
    }

    /**
     *
     * @param usuarioBlModelo
     */
    public void setUsuarioBlModelo(UsuarioBL usuarioBlModelo) {
        this.usuarioBlModelo = usuarioBlModelo;
    }
    
    /**
     *
     * @param mantUsuarioview
     * @param usuarioBlModelo
     */
    public UsuarioControlador(MantUsuario mantUsuarioview, UsuarioBL usuarioBlModelo) {
        this.mantUsuarioview = mantUsuarioview;
        this.usuarioBlModelo = usuarioBlModelo;
        this.mantUsuarioview.btBuscar.addActionListener(this);
        this.mantUsuarioview.btInsertar.addActionListener(this);
        this.mantUsuarioview.btCancelar.addActionListener(this);
        this.mantUsuarioview.btEliminar.addActionListener(this);
        this.mantUsuarioview.btModificar.addActionListener(this);
        this.mantUsuarioview.btCargar.addActionListener(this);
        this.mantUsuarioview.txtidUsuario.getDocument().addDocumentListener(this);
        this.mantUsuarioview.btEliminar.setEnabled(false);
        this.mantUsuarioview.btModificar.setEnabled(false);
        inicializarPantalla();
    }
    
    private void inicializarPantalla() {
        this.mantUsuarioview.txtidUsuario.setEnabled(false);
        llenarTabla(this.mantUsuarioview.jTableusuarios);
    }
    
    /**
     *
     * @param tablaUsuarios
     */
    public void llenarTabla(JTable tablaUsuarios) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaUsuarios.setModel(modeloTabla);
        modeloTabla.addColumn("Id Usuario");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Usuario");
        
        

        Object fila[] = new Object[3];

        try {
            for (Object oAux : usuarioBlModelo.obtenerTodos()) {
                Usuario u = (Usuario) oAux;
                fila[0] = u.getPK_idUsuario();
                fila[1] = u.getNombre();
                fila[2] = u.getUsuario();
                
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantUsuarioview, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mantUsuarioview.btInsertar) {
            if(this.mantUsuarioview.txtNombre.getText().equals("")||this.mantUsuarioview.txtUsuario.getText().equals("")||this.mantUsuarioview.txtContraseña.getPassword().equals("")){
                JOptionPane.showMessageDialog(mantUsuarioview, "Error faltan espacios por rellenar:", "Error en ingresar el Usuario", JOptionPane.ERROR_MESSAGE);
            }else{
            Usuario u = new Usuario();
            u.setPK_idUsuario(1); 
            u.setNombre(this.mantUsuarioview.txtNombre.getText());
            u.setUsuario(this.mantUsuarioview.txtUsuario.getText());
            u.setContraseña(String.valueOf(this.mantUsuarioview.txtContraseña.getPassword()));
            
            try {
                //se agrega el socio a la base de datos
                this.usuarioBlModelo.insertar(u);
                llenarTabla(this.mantUsuarioview.jTableusuarios);
                JOptionPane.showMessageDialog(mantUsuarioview, "El Usuario ha sido ingresado correctamente", "Usuario Agreagado", JOptionPane.INFORMATION_MESSAGE);
                this.mantUsuarioview.txtContraseña.setText(null);
                this.mantUsuarioview.txtNombre.setText(null);
                this.mantUsuarioview.txtUsuario.setText(null);
                this.mantUsuarioview.txtidUsuario.setText(null);
                this.mantUsuarioview.btModificar.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al agregar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al eliminar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
            
        }if (e.getSource() == this.mantUsuarioview.btEliminar) {
            if(this.mantUsuarioview.jTableusuarios.getRowCount()!=0&&this.mantUsuarioview.jTableusuarios.getRowCount()!=-1){
            Usuario u = new Usuario();
            int fila = this.mantUsuarioview.jTableusuarios.getSelectedRow();
            int idUsuario = Integer.parseInt(this.mantUsuarioview.txtidUsuario.getText());
            u.setPK_idUsuario(idUsuario);
            try {
                int resp;
                resp=JOptionPane.showConfirmDialog(mantUsuarioview, "Esta seguro que desea eliminar el Usuario");
                if(resp==0){
                usuarioBlModelo.eliminar(u);
                llenarTabla(this.mantUsuarioview.jTableusuarios);
                JOptionPane.showMessageDialog(mantUsuarioview, "El Usuario ha sido eliminado correctamente",
                        "Usuario Eliminado", JOptionPane.INFORMATION_MESSAGE);
                this.mantUsuarioview.txtContraseña.setText(null);
                this.mantUsuarioview.txtNombre.setText(null);
                this.mantUsuarioview.txtUsuario.setText(null);
                this.mantUsuarioview.txtidUsuario.setText(null);
                this.mantUsuarioview.btEliminar.setEnabled(false);
                }
                if(resp==1){
                    JOptionPane.showMessageDialog(mantUsuarioview, "El Usuario no sera eliminado ",
                        "Usuario Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al eliminar el Usuario:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al eliminar el Usuario:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }if (e.getSource() == this.mantUsuarioview.btCargar) {
            
            if(this.mantUsuarioview.jTableusuarios.getRowCount()!=0&&
               this.mantUsuarioview.jTableusuarios.getSelectedRow()!=-1){
                 Usuario u = new Usuario();
                int fila = this.mantUsuarioview.jTableusuarios.getSelectedRow();
                              
                u.setPK_idUsuario(Integer.parseInt(this.mantUsuarioview.jTableusuarios.getValueAt(fila, 0).toString()));
                
                try {
                    u = usuarioBlModelo.obtenerPorId(u);
                    this.mantUsuarioview.txtidUsuario.setText(u.getPK_idUsuario().toString());
                    this.mantUsuarioview.txtNombre.setText(u.getNombre().toString());
                    this.mantUsuarioview.txtUsuario.setText(u.getUsuario().toString());
                    this.mantUsuarioview.txtContraseña.setText(u.getContraseña());
                    this.mantUsuarioview.btEliminar.setEnabled(true);
                    this.mantUsuarioview.btModificar.setEnabled(true);
                 
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
                
        }if(e.getSource()==this.mantUsuarioview.btModificar){
            if(this.mantUsuarioview.txtNombre.getText().equals("")||this.mantUsuarioview.txtUsuario.getText().equals("")||this.mantUsuarioview.txtContraseña.getText().equals("")){
                JOptionPane.showMessageDialog(mantUsuarioview, "Error primero debe seleccionar un Usuario:", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
             if(this.mantUsuarioview.jTableusuarios.getRowCount()!=0&&this.mantUsuarioview.jTableusuarios.getRowCount()!=-1){
             Usuario u = new Usuario();
            
             
             u.setPK_idUsuario(Integer.parseInt(this.mantUsuarioview.txtidUsuario.getText()));
                
            try {
                u = usuarioBlModelo.obtenerPorId(u);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                    u.setNombre(this.mantUsuarioview.txtNombre.getText());
                    u.setUsuario(this.mantUsuarioview.txtUsuario.getText());
                    u.setContraseña(this.mantUsuarioview.txtContraseña.getText());
                   try {
                
                        this.usuarioBlModelo.modificar(u);
                        llenarTabla(this.mantUsuarioview.jTableusuarios);
                        JOptionPane.showMessageDialog(mantUsuarioview, "El Usuario ha sido modificado correctamente", 
                                "Usuario Modificado", JOptionPane.INFORMATION_MESSAGE);
                        this.mantUsuarioview.txtidUsuario.setText(u.getPK_idUsuario().toString());
                        this.mantUsuarioview.txtNombre.setText(u.getNombre().toString());
                        this.mantUsuarioview.txtUsuario.setText(u.getUsuario().toString());
                        this.mantUsuarioview.txtContraseña.setText(u.getContraseña().toString());
                        this.mantUsuarioview.txtContraseña.setText(null);
                        this.mantUsuarioview.txtNombre.setText(null);
                        this.mantUsuarioview.txtUsuario.setText(null);
                        this.mantUsuarioview.txtidUsuario.setText(null);
                        this.mantUsuarioview.btEliminar.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al modificar  al Usuario:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al eliminar al Usuario:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
              }else{
                JOptionPane.showMessageDialog(mantUsuarioview, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }          
          } 
        }if (e.getSource() == this.mantUsuarioview.btCancelar){
            this.mantUsuarioview.txtNombre.setText(null);
            this.mantUsuarioview.txtUsuario.setText(null);
            this.mantUsuarioview.txtContraseña.setText(null);
            this.mantUsuarioview.txtidUsuario.setText(null);
            this.mantUsuarioview.btEliminar.setEnabled(false);
            
        }if (e.getSource() == this.mantUsuarioview.btBuscar) { 
            MantUsuarioBuscar mantUsuarioBuscarView = new MantUsuarioBuscar();
            UsuarioBuscarControlador usuarioBControlador ;
            usuarioBControlador = new UsuarioBuscarControlador(mantUsuarioBuscarView, 
                    usuarioBlModelo, 
                    this.mantUsuarioview.txtidUsuario);
            usuarioBControlador.getUsuarioBuscarView().setVisible(true);
            this.mantUsuarioview.btEliminar.setEnabled(true);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarusuario();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarusuario();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarusuario();
    }

     private void cargarusuario() {
        Usuario u = new Usuario();
        if (!this.mantUsuarioview.txtidUsuario.getText().isEmpty()) {
            u.setPK_idUsuario(Integer.parseInt(this.mantUsuarioview.txtidUsuario.getText()));
            try {
                u = usuarioBlModelo.obtenerPorId(u);
                this.mantUsuarioview.txtNombre.setText(u.getNombre());
                this.mantUsuarioview.txtUsuario.setText(u.getUsuario());
                this.mantUsuarioview.txtContraseña.setText(u.getContraseña());
                
                

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantUsuarioview, "Error no se pudo consultar el Usuario (" + ex.getMessage() + ")",
                        "Error al cargar el Usuario", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
}
