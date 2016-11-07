/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulos;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedores;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantProovedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.ManteArticulos;
import cr.ac.una.ingenieria.appMVC.Vista.ManteProveedores;
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
public class ArticuloControlador implements ActionListener, DocumentListener {
    private ManteArticulos mantArticuloView;
    private ArticuloBL ArticuloBLModelo;
    private ProveedorBL ProveedorBLModelo;
    private ManteProveedores mantProveedoresView;

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
     * @return
     */
    public ManteProveedores getMantProveedoresView() {
        return mantProveedoresView;
    }

    /**
     *
     * @param mantProveedoresView
     */
    public void setMantProveedoresView(ManteProveedores mantProveedoresView) {
        this.mantProveedoresView = mantProveedoresView;
    }
    
    /**
     *
     * @return
     */
    public ManteArticulos getMantArticuloView() {
        return mantArticuloView;
    }

    /**
     *
     * @param mantArticuloView
     */
    public void setMantArticuloView(ManteArticulos mantArticuloView) {
        this.mantArticuloView = mantArticuloView;
    }

    /**
     *
     * @return
     */
    public ArticuloBL getArticuloBLModelo() {
        return ArticuloBLModelo;
    }

    /**
     *
     * @param ArticuloBLModelo
     */
    public void setArticuloBLModelo(ArticuloBL ArticuloBLModelo) {
        this.ArticuloBLModelo = ArticuloBLModelo;
    }

    /**
     *
     * @param mantArticuloView
     * @param ArticuloBLModelo
     * @param ProveedorBLModelo
     * @param mantProveedoresView
     */
    public ArticuloControlador(ManteArticulos mantArticuloView, ArticuloBL ArticuloBLModelo, ProveedorBL ProveedorBLModelo, ManteProveedores mantProveedoresView) {
        this.mantArticuloView = mantArticuloView;
        this.ArticuloBLModelo = ArticuloBLModelo;
        this.ProveedorBLModelo = ProveedorBLModelo;
        this.mantProveedoresView = mantProveedoresView;
        this.mantArticuloView.btInsertar.addActionListener(this);
        this.mantArticuloView.btBuscar.addActionListener(this);
        this.mantArticuloView.btCancelar.addActionListener(this);
        this.mantArticuloView.btCargar.addActionListener(this);
        this.mantArticuloView.btEliminar.addActionListener(this);
        this.mantArticuloView.btModificar.addActionListener(this);
        this.mantArticuloView.txtIdArticulo.getDocument().addDocumentListener(this);
        this.mantArticuloView.btAgregarProveedor.addActionListener(this);
        this.mantArticuloView.btModificar.setEnabled(false);
        this.mantArticuloView.btEliminar.setEnabled(false);
        this.mantArticuloView.txtIdProveedor.setEnabled(false);
        this.mantArticuloView.txtIdProveedor.setText("Seleccione un proveedor");
        inicializarPantalla();
    }

    

   

    
    private void inicializarPantalla() {
       this.mantArticuloView.txtIdArticulo.setEnabled(false);
       this.mantArticuloView.txtIdProveedor.setEnabled(false);
        llenarTabla(this.mantArticuloView.jTableArticulos);
    }
    
    /**
     *
     * @param tablaArticulos
     */
    public void llenarTabla(JTable tablaArticulos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulos.setModel(modeloTabla);
        modeloTabla.addColumn("Id Proveedor");
        modeloTabla.addColumn("Id Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio");

        Object fila[] = new Object[6];

        try {
            for (Object oAux : ArticuloBLModelo.obtenerTodos()) {
                Articulos a = (Articulos) oAux;
                fila[0] = a.getFK_idProveedor();
                fila[1] = a.getPK_IDArticulo();
                fila[2] = a.getNombre();
                fila[3] = a.getDescripcion();
                fila[4] = a.getCantidadExistencia();
                fila[5] = a.getPrecioUnitario();
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantArticuloView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mantArticuloView.btInsertar) {
            
            if(this.mantArticuloView.txtNombre.getText().equals("")||this.mantArticuloView.txtDescripcion.getText().equals("")||this.mantArticuloView.TxtPrecio.getText().equals("")||this.mantArticuloView.TxtCantidad.getText().equals("")||this.mantArticuloView.txtIdProveedor.getText().equals(""))
            {
                JOptionPane.showMessageDialog(mantArticuloView, "Error faltan espacios por rellenar:", "Error en ingresar articulo", JOptionPane.ERROR_MESSAGE);
            }
            else{
            Articulos a = new Articulos();
            a.setPK_IDArticulo(1); //como es auto generado no es relavante tomar el campo de texto id.
            a.setNombre(this.mantArticuloView.txtNombre.getText());
            a.setDescripcion(this.mantArticuloView.txtDescripcion.getText());
            a.setCantidadExistencia(Integer.parseInt(this.mantArticuloView.TxtCantidad.getText()));
            a.setPrecioUnitario(Integer.parseInt(this.mantArticuloView.TxtPrecio.getText()));
            a.setFK_idProveedor(Integer.parseInt(this.mantArticuloView.txtIdProveedor.getText()));
            try {
               
                this.ArticuloBLModelo.insertar(a);
                llenarTabla(this.mantArticuloView.jTableArticulos);
                JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido ingresado correctamente", "Articulo Agregado", JOptionPane.INFORMATION_MESSAGE);
                this.mantArticuloView.TxtCantidad.setText(null);
                this.mantArticuloView.TxtPrecio.setText(null);
                this.mantArticuloView.txtDescripcion.setText(null);
                this.mantArticuloView.txtIdArticulo.setText(null);
                this.mantArticuloView.txtIdProveedor.setText(null);
                this.mantArticuloView.txtNombre.setText(null);
                this.mantArticuloView.btModificar.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantArticuloView, "Error al agregar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        }
        if (e.getSource() == this.mantArticuloView.btEliminar){
           if(this.mantArticuloView.jTableArticulos.getRowCount()!=0&&this.mantArticuloView.jTableArticulos.getRowCount()!=-1){
            Articulos a = new Articulos();
            int fila = this.mantArticuloView.jTableArticulos.getSelectedRow();
            int idArticulo = Integer.parseInt(this.mantArticuloView.txtIdArticulo.getText());
            a.setPK_IDArticulo(idArticulo);
               System.out.println("ojo "+a.getPK_IDArticulo());
            try {
                int resp;
                resp=JOptionPane.showConfirmDialog(mantArticuloView, "Esta seguro que desea eliminar el Articulo");
                if(resp==0){
                ArticuloBLModelo.eliminar(a);
                llenarTabla(this.mantArticuloView.jTableArticulos);
                JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido eliminado correctamente", "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                this.mantArticuloView.TxtCantidad.setText(null);
                this.mantArticuloView.TxtPrecio.setText(null);
                this.mantArticuloView.txtDescripcion.setText(null);
                this.mantArticuloView.txtIdArticulo.setText(null);
                this.mantArticuloView.txtIdProveedor.setText(null);
                this.mantArticuloView.txtNombre.setText(null);
                this.mantArticuloView.btEliminar.setEnabled(false);
                }
                if(resp==1){
                    JOptionPane.showMessageDialog(mantArticuloView, "El Articulo no sera eliminado ",
                        "Articulo Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(mantArticuloView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
       }
        if (e.getSource() == this.mantArticuloView.btCargar) {               
            if(this.mantArticuloView.jTableArticulos.getRowCount()!=0&&this.mantArticuloView.jTableArticulos.getRowCount()!=-1){
                Articulos a = new Articulos();
                int fila = this.mantArticuloView.jTableArticulos.getSelectedRow();
                a.setPK_IDArticulo(Integer.parseInt(this.mantArticuloView.jTableArticulos.getValueAt(fila, 1).toString()));
                
                try {                    
                    a = ArticuloBLModelo.obtenerPorId(a);
                    this.mantArticuloView.txtIdArticulo.setText(String.valueOf(a.getPK_IDArticulo().toString()));
                    this.mantArticuloView.txtNombre.setText(a.getNombre().toString());
                    this.mantArticuloView.txtDescripcion.setText(a.getDescripcion().toString());
                    this.mantArticuloView.TxtCantidad.setText(String.valueOf(a.getCantidadExistencia().toString()));
                    this.mantArticuloView.TxtPrecio.setText(String.valueOf(a.getPrecioUnitario()));
                    this.mantArticuloView.txtIdProveedor.setText(String.valueOf(a.getFK_idProveedor().toString()));
                    this.mantArticuloView.btEliminar.setEnabled(true);
                                
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(mantArticuloView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
              
              
       }
        if(e.getSource()==this.mantArticuloView.btModificar){
              if(this.mantArticuloView.txtNombre.getText().equals("")||this.mantArticuloView.txtDescripcion.getText().equals("")||this.mantArticuloView.TxtPrecio.getText().equals("")||this.mantArticuloView.TxtCantidad.getText().equals("")||this.mantArticuloView.txtIdProveedor.getText().equals(""))
            {
                JOptionPane.showMessageDialog(mantArticuloView, "Error primero debe seleccionar un Articulo:", "Error en ingresar articulo", JOptionPane.ERROR_MESSAGE);
            }
            else{
             if(this.mantArticuloView.jTableArticulos.getRowCount()!=0&&this.mantArticuloView.jTableArticulos.getRowCount()!=-1){
             Articulos a = new Articulos();
            
            
             a.setPK_IDArticulo(Integer.parseInt(this.mantArticuloView.txtIdArticulo.getText()));
                
            try {
                a = ArticuloBLModelo.obtenerPorId(a);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                    a.setNombre(this.mantArticuloView.txtNombre.getText());
                    a.setDescripcion(this.mantArticuloView.txtDescripcion.getText());
                    a.setCantidadExistencia(Integer.parseInt(this.mantArticuloView.TxtCantidad.getText()));
                    a.setPrecioUnitario(Double.parseDouble(this.mantArticuloView.TxtPrecio.getText()));
                    a.setFK_idProveedor(Integer.parseInt(this.mantArticuloView.txtIdProveedor.getText()));
                    
                   try {
                
                        this.ArticuloBLModelo.modificar(a);
                        llenarTabla(this.mantArticuloView.jTableArticulos);
                        JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido modificado correctamente", 
                                "Articulo maodificado Modificado", JOptionPane.INFORMATION_MESSAGE);
                        this.mantArticuloView.TxtCantidad.setText(null);
                        this.mantArticuloView.TxtPrecio.setText(null);
                        this.mantArticuloView.txtDescripcion.setText(null);
                        this.mantArticuloView.txtIdArticulo.setText(null);
                        this.mantArticuloView.txtIdProveedor.setText(null);
                        this.mantArticuloView.txtNombre.setText(null);
                        this.mantArticuloView.btEliminar.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantArticuloView, "Error al modificar  al Articulo:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar al articulo:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
              }else{
                JOptionPane.showMessageDialog(mantArticuloView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
              }
              
        }
        if (e.getSource() == this.mantArticuloView.btCancelar)
        {
            this.mantArticuloView.txtNombre.setText(null);
            this.mantArticuloView.TxtCantidad.setText(null);
            this.mantArticuloView.TxtPrecio.setText(null);
            this.mantArticuloView.txtIdArticulo.setText(null);
            this.mantArticuloView.txtDescripcion.setText(null);
            this.mantArticuloView.txtIdProveedor.setText(null);
            this.mantArticuloView.btEliminar.setEnabled(false);
        }
            if (e.getSource() == this.mantArticuloView.btBuscar) { 
            MantArticuloBuscar mantArticuloBuscarView = new MantArticuloBuscar();
            ArticuloBuscarControlador articuloBControlador ;
            articuloBControlador = new ArticuloBuscarControlador(mantArticuloBuscarView, 
                    ArticuloBLModelo, 
                    this.mantArticuloView.txtIdArticulo);
            articuloBControlador.getArticuloBuscarView().setVisible(true);
            this.mantArticuloView.btEliminar.setEnabled(true);
             
        }
            if(e.getSource() == this.mantArticuloView.btAgregarProveedor){
               MantProovedorBuscar mantBuscarView = new MantProovedorBuscar();
               ProveedorBuscarControlador pBControlador ;
               pBControlador = new ProveedorBuscarControlador(mantBuscarView, ProveedorBLModelo, 
                    this.mantArticuloView.txtIdProveedor);
            pBControlador.getProovedorBuscarView().setVisible(true);
            
            }
  }

    @Override
    public void insertUpdate(DocumentEvent de) {
        cargarArticulo();
        cargarIdProveedor();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        cargarArticulo();
        cargarIdProveedor();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        cargarArticulo();
        cargarIdProveedor();
    }
    private void cargarArticulo() {
        Articulos a = new Articulos();
        if (!this.mantArticuloView.txtIdArticulo.getText().isEmpty()) {
            a.setPK_IDArticulo(Integer.parseInt(this.mantArticuloView.txtIdArticulo.getText()));
            try {
                a = ArticuloBLModelo.obtenerPorId(a);
                this.mantArticuloView.txtNombre.setText(a.getNombre().toString());
                this.mantArticuloView.txtDescripcion.setText(a.getDescripcion().toString());
                this.mantArticuloView.TxtCantidad.setText(String.valueOf(a.getCantidadExistencia().toString()));
                this.mantArticuloView.TxtPrecio.setText(String.valueOf(a.getPrecioUnitario()));
                this.mantArticuloView.txtIdProveedor.setText(String.valueOf(a.getFK_idProveedor().toString()));                                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error no se pudo consultar el Articulo (" + ex.getMessage() + ")",
                        "Error al cargar el Articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cargarIdProveedor(){
        Proveedores p= new Proveedores();
        if (!this.mantArticuloView.txtIdArticulo.getText().isEmpty()) {
            p.setPK_IDProvedor(Integer.parseInt(this.mantArticuloView.txtIdProveedor.getText()));
            try {
                p = ProveedorBLModelo.obtenerPorId(p);
                    

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error no se pudo consultar el Proveedor (" + ex.getMessage() + ")",
                        "Error al cargar el proveedor", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
}
}
