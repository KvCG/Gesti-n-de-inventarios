/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedores;
import cr.ac.una.ingenieria.appMVC.Vista.MantProovedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Proveedores;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Gustavo
 */
public class ProveedorControlador implements ActionListener, DocumentListener{

    private Modulo_Proveedores mantProveedorView;
    private ProveedorBL ProveedorBLModelo;

    public ProveedorControlador(){
    
    }
    /**
     *
     * @return
     */
    public Modulo_Proveedores getMantProveedorView() {
        return mantProveedorView;
    }

    /**
     *
     * @param mantProveedorView
     */
    public void setMantProveedorView(Modulo_Proveedores mantProveedorView) {
        this.mantProveedorView = mantProveedorView;
    }

    /**
     *
     * @return
     */
    public ProveedorBL getProveedorBLModelo() {
        return ProveedorBLModelo;
    }

    /**
     *
     * @param ProveedorBLModelo
     */
    public void setProveedorBLModelo(ProveedorBL ProveedorBLModelo) {
        this.ProveedorBLModelo = ProveedorBLModelo;
    }

    /**
     *
     * @param mantProveedorView
     * @param ProveedorBLModelo
     */
    public ProveedorControlador(Modulo_Proveedores mantProveedorView, ProveedorBL ProveedorBLModelo) {
        this.mantProveedorView = mantProveedorView;
        this.ProveedorBLModelo = ProveedorBLModelo; 
        this.mantProveedorView.btInsertar.addActionListener(this);
        this.mantProveedorView.btEliminar.addActionListener(this);
        this.mantProveedorView.btModificar.addActionListener(this);
        this.mantProveedorView.btCancelar.addActionListener(this);
        this.mantProveedorView.btBuscar.addActionListener(this);
        this.mantProveedorView.txtIdProveedor.getDocument().addDocumentListener(this);
        this.mantProveedorView.btModificar.setEnabled(false);
        this.mantProveedorView.btEliminar.setEnabled(false);
        this.mantProveedorView.txtIdProveedor.setEnabled(false);
        //inicializarPantalla();
        
        
        
    }
    
    private void inicializarPantalla() {
       this.mantProveedorView.txtIdProveedor.setEnabled(false);
        //llenarTabla(this.mantProveedorView.jTableProveedor);
    }
     
    /**
     *
     * @param TablaProovedores
     */

    
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == this.mantProveedorView.btInsertar) { 
            if(this.mantProveedorView.txtIdProveedor.equals("")||this.mantProveedorView.txtTelefono.getText().equals("")||this.mantProveedorView.txtCorreo.getText().equals("")||this.mantProveedorView.txtNombre.getText().equals("")||this.mantProveedorView.txtDireccion.getText().equals(""))
            {
                JOptionPane.showMessageDialog(mantProveedorView, "Error faltan espacios por rellenar:", "Error en ingresar articulo", JOptionPane.ERROR_MESSAGE);
            }
            else{
            Proveedores p = new Proveedores();
            p.setIdProvedor(1); //como es auto generado no es relavante tomar el campo de texto id.
            p.setNombre(this.mantProveedorView.txtNombre.getText());
            p.setTelefono(this.mantProveedorView.txtTelefono.getText());
            p.setEmail(this.mantProveedorView.txtCorreo.getText());
            p.setDireccion(this.mantProveedorView.txtDireccion.getText());
            try {
                if(this.isEmail(this.mantProveedorView.txtCorreo.getText())){
                this.ProveedorBLModelo.insertar(p);
                //llenarTabla(this.mantProveedorView.jTableProveedor);
                JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido ingresado correctamente", "Proveedor Agreagado", JOptionPane.INFORMATION_MESSAGE);
                this.mantProveedorView.txtNombre.setText(null);
                this.mantProveedorView.txtTelefono.setText(null);
                this.mantProveedorView.txtIdProveedor.setText(null);
                this.mantProveedorView.txtTelefono.setText(null);
                this.mantProveedorView.txtCorreo.setText(null);
                this.mantProveedorView.txtDireccion.setText(null);
                this.mantProveedorView.btModificar.setEnabled(true);
                }else{
                JOptionPane.showMessageDialog(mantProveedorView, "Error ingrese el correo nuevamente:", "Error en ingresar correo", JOptionPane.ERROR_MESSAGE);
                this.mantProveedorView.txtCorreo.setText(null);
            }        
                        
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantProveedorView, "Error al agregar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        }
       if (e.getSource() == this.mantProveedorView.btEliminar){
//           if(this.mantProveedorView.jTableProveedor.getRowCount()!=0&&this.mantProveedorView.jTableProveedor.getRowCount()!=-1){
//            Proveedores p = new Proveedores();
//            
//            int fila = this.mantProveedorView.jTableProveedor.getSelectedRow();
//            
//            int idProveedor = Integer.parseInt(this.mantProveedorView.txtIdProveedor.getText());
//            p.setIdProvedor(idProveedor);
//                try {
//                    int resp;
//                    resp=JOptionPane.showConfirmDialog(mantProveedorView, "Esta seguro que desea eliminar el Proveedor");
//                    if(resp==0){
//                    ProveedorBLModelo.eliminar(p);
//                    //llenarTabla(this.mantProveedorView.jTableProveedor);
//                    JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido eliminado correctamente", "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
//                    this.mantProveedorView.txtTelefono.setText(null);
//                    this.mantProveedorView.txtIdProveedor.setText(null);
//                    this.mantProveedorView.txtTelefono.setText(null);
//                    this.mantProveedorView.txtCorreo.setText(null);
//                    this.mantProveedorView.txtDireccion.setText(null);
//                    this.mantProveedorView.btModificar.setEnabled(true);
//                    this.mantProveedorView.btEliminar.setEnabled(false);
//                    }
//                    if(resp==1){
//                        JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor no sera eliminado ",
//                        "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                } catch (Exception ex) {
//                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                }
//           else{
//                    JOptionPane.showMessageDialog(mantProveedorView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//           
}

        if (e.getSource() == this.mantProveedorView.btModificar) {
            if (this.mantProveedorView.txtTelefono.getText().equals("") || this.mantProveedorView.txtCorreo.getText().equals("") || this.mantProveedorView.txtNombre.getText().equals("") || this.mantProveedorView.txtDireccion.getText().equals("")) {
                JOptionPane.showMessageDialog(mantProveedorView, "Error al Modificar debe seleccionar antes un proveedor:", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Proveedores p = new Proveedores();
                p.setIdProvedor(Integer.parseInt(this.mantProveedorView.txtIdProveedor.getText()));
                try {
                    if (this.isEmail(this.mantProveedorView.txtCorreo.getText())) {
                    p = ProveedorBLModelo.obtenerPorId(p);
                    p.setNombre(this.mantProveedorView.txtNombre.getText());
                    p.setEmail(this.mantProveedorView.txtCorreo.getText());
                    p.setTelefono(String.valueOf(this.mantProveedorView.txtTelefono.getText()));
                    p.setDireccion(this.mantProveedorView.txtDireccion.getText());
                    this.ProveedorBLModelo.modificar(p);
                    this.mantProveedorView.btEliminar.setEnabled(false);
                    this.mantProveedorView.txtIdProveedor.setEnabled(true);
                    JOptionPane.showMessageDialog(mantProveedorView, "el Proveedor ha sido modificada correctamente",
                                "Proveedor madificado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                try {
                    
                    this.ProveedorBLModelo.modificar(p);
                    JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido modificado correctamente",
                            "Proveedor Modificado", JOptionPane.INFORMATION_MESSAGE);
                    this.mantProveedorView.txtNombre.setText(null);
                    this.mantProveedorView.txtTelefono.setText(null);
                    this.mantProveedorView.txtIdProveedor.setText(null);
                    this.mantProveedorView.txtTelefono.setText(null);
                    this.mantProveedorView.txtCorreo.setText(null);
                    this.mantProveedorView.txtDireccion.setText(null);
                    this.mantProveedorView.btEliminar.setEnabled(false);
                } catch (SQLException ex) {
                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al modificar  al proveedor:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar al proveedor:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
       if (e.getSource() == this.mantProveedorView.btCancelar){
            this.mantProveedorView.txtTelefono.setText(null);
            this.mantProveedorView.txtCorreo.setText(null);
            this.mantProveedorView.txtDireccion.setText(null);
            this.mantProveedorView.txtTelefono.setText(null);
            this.mantProveedorView.txtIdProveedor.setText(null);
            this.mantProveedorView.txtCorreo.setText(null);
            this.mantProveedorView.txtNombre.setText(null);
            this.mantProveedorView.btEliminar.setEnabled(false);
        }
       if (e.getSource() == this.mantProveedorView.btBuscar) { 
           MantProovedorBuscar mantBuscarView = new MantProovedorBuscar();
           ProveedorBuscarControlador pBControlador ;
           pBControlador = new ProveedorBuscarControlador(mantBuscarView,ProveedorBLModelo, this.mantProveedorView.txtIdProveedor);
           pBControlador.getProovedorBuscarView().setVisible(true);
           this.mantProveedorView.btEliminar.setEnabled(true);
           this.mantProveedorView.btModificar.setEnabled(true);
           this.mantProveedorView.btInsertar.setEnabled(false);
        }
       
    }

    /**
     *
     * @param correo
     * @return
     */
    public boolean isEmail(String correo) {
    Pattern pat = null;
    Matcher mat = null; 
    pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
    mat = pat.matcher(correo);
    if (mat.find()) {
    return true;
    }else{
    return false;
    } 
}
    
    
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        cargarProveedor();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        cargarProveedor();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        cargarProveedor();
    }
    private void cargarProveedor() {
        Proveedores p = new Proveedores();
        if (!this.mantProveedorView.txtIdProveedor.getText().isEmpty()) {
            p.setIdProvedor(Integer.parseInt(this.mantProveedorView.txtIdProveedor.getText()));
            try {
                p = ProveedorBLModelo.obtenerPorId(p);
                this.mantProveedorView.txtNombre.setText(p.getNombre());
                this.mantProveedorView.txtTelefono.setText(p.getTelefono());
                this.mantProveedorView.txtDireccion.setText(p.getDireccion());
                this.mantProveedorView.txtCorreo.setText(p.getEmail());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantProveedorView, "Error no se pudo consultar el Proveedor (" + ex.getMessage() + ")",
                        "Error al cargar el Proveedor", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}

