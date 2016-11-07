/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulos;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class ArticuloBuscarControlador implements  ActionListener {
    private MantArticuloBuscar articuloBuscarView;
    private ArticuloBL ArticuloBLModelo;
    private JTextField txtRespuesta;
    
    /**
     *
     * @param articuloBuscarView
     * @param ArticuloBLModelo
     * @param txtRespuesta
     */
    public ArticuloBuscarControlador(MantArticuloBuscar articuloBuscarView, ArticuloBL ArticuloBLModelo, JTextField txtRespuesta) {
        this.articuloBuscarView = articuloBuscarView;
        this.ArticuloBLModelo = ArticuloBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.articuloBuscarView.btBuscar.addActionListener(this);
        this.articuloBuscarView.btSeleccionar.addActionListener(this);
        llenarTabla(this.articuloBuscarView.jTBuscarArticulo);
    }

    /**
     *
     * @return
     */
    public MantArticuloBuscar getArticuloBuscarView() {
        return articuloBuscarView;
    }

    /**
     *
     * @param articuloBuscarView
     */
    public void setArticuloBuscarView(MantArticuloBuscar articuloBuscarView) {
        this.articuloBuscarView = articuloBuscarView;
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
       if(e.getSource() == this.articuloBuscarView.btBuscar){
           llenarTabla(this.articuloBuscarView.jTBuscarArticulo);
        }
        
        if(e.getSource() == this.articuloBuscarView.btSeleccionar){
            int fila = this.articuloBuscarView.jTBuscarArticulo.getSelectedRow();
            if (fila != -1) {
            Integer idArticulo = Integer.parseInt(this.articuloBuscarView.jTBuscarArticulo.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idArticulo));
            
            this.articuloBuscarView.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(articuloBuscarView, "Error debe seleccionar un Articulo:", "Error", JOptionPane.ERROR_MESSAGE);
            }
                
        }
    }

    /**
     *
     * @param tablaArticulo
     */
    public void llenarTabla(JTable tablaArticulo) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulo.setModel(modeloTabla);

        modeloTabla.addColumn("Id Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");
        
        

        Object fila[] = new Object[3];
        
        String Sql = "where Nombre like '%"+ this.articuloBuscarView.txtBuscar.getText() +"%'";

        try {
            for (Object oAux : ArticuloBLModelo.obtenerConWhere(new Articulos(), Sql)) {
                Articulos a = (Articulos) oAux;
                fila[0] = a.getPK_IDArticulo();
                fila[1] = a.getNombre();
                fila[2] = a.getDescripcion();
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
