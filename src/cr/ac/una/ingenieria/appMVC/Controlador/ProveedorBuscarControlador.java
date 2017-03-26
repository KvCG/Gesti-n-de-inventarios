/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedores;
import cr.ac.una.ingenieria.appMVC.Vista.MantProovedorBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class ProveedorBuscarControlador implements  ActionListener {
    
    private MantProovedorBuscar proovedorBuscarView;
    private ProveedorBL proveedorBLModelo;
    private JTextField txtRespuesta;

    /**
     *
     */
    public ProveedorBuscarControlador() {
    }

    /**
     *
     * @param proovedorBuscarView
     * @param proveedorBLModelo
     * @param txtRespuesta
     */
    public ProveedorBuscarControlador(MantProovedorBuscar proovedorBuscarView, ProveedorBL proveedorBLModelo, JTextField txtRespuesta) {
        this.proovedorBuscarView = proovedorBuscarView;
        this.proveedorBLModelo = proveedorBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.proovedorBuscarView.btBuscar.addActionListener(this);
        this.proovedorBuscarView.btSeleccionar.addActionListener(this);
       this.proovedorBuscarView.txtBuscar.addCaretListener(new CaretListener(){
           @Override
            public void caretUpdate(CaretEvent e) {
                llenarTabla(proovedorBuscarView.jTableProovedor);
            }
        });
       
        this.proovedorBuscarView.btSeleccionar.addActionListener(this);
        llenarTabla(this.proovedorBuscarView.jTableProovedor);
    }

    /**
     *
     * @return
     */
    public MantProovedorBuscar getProovedorBuscarView() {
        return proovedorBuscarView;
    }

    /**
     *
     * @param proovedorBuscarView
     */
    public void setProovedorBuscarView(MantProovedorBuscar proovedorBuscarView) {
        this.proovedorBuscarView = proovedorBuscarView;
    }

    /**
     *
     * @return
     */
    public ProveedorBL getProveedorBLModelo() {
        return proveedorBLModelo;
    }

    /**
     *
     * @param proveedorBLModelo
     */
    public void setProveedorBLModelo(ProveedorBL proveedorBLModelo) {
        this.proveedorBLModelo = proveedorBLModelo;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    /**
     *
     * @param txtRespuesta
     */
    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == this.proovedorBuscarView.btBuscar){
            llenarTabla(this.proovedorBuscarView.jTableProovedor);
        }
        
        if(e.getSource() == this.proovedorBuscarView.btSeleccionar){
            int fila = this.proovedorBuscarView.jTableProovedor.getSelectedRow();
            if (fila != -1) {
            Integer idProveedor = Integer.parseInt(this.proovedorBuscarView.jTableProovedor.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idProveedor));
            this.proovedorBuscarView.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(proovedorBuscarView, "Error debe seleccionar un proveedor:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     *
     * @param tablaProoveedor
     */
    public void llenarTabla(JTable tablaProoveedor) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProoveedor.setModel(modeloTabla);

        modeloTabla.addColumn("Id Proovedor");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo Elec.");
        modeloTabla.addColumn("Estado");
        

        Object fila[] = new Object[5];
        
        String Sql = "where nombre like '%"+ this.proovedorBuscarView.txtBuscar.getText() +"%'";

        try {
            for (Object oAux : proveedorBLModelo.obtenerConWhere(new Proveedores(), Sql)) {
                Proveedores p = (Proveedores) oAux;
                fila[0] = p.getIdProvedor();
                fila[1] = p.getNombre();
                fila[2] = p.getTelefono();
                fila[3] = p.getEmail();
                fila[4] = p.getEstado();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
}

