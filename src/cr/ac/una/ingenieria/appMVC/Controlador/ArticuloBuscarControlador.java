/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
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
public class ArticuloBuscarControlador implements ActionListener {

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
        this.articuloBuscarView.txtBuscar.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                llenarTabla(articuloBuscarView.jTBuscarArticulo);
            }
        });
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
        if (e.getSource() == this.articuloBuscarView.btBuscar) {
            llenarTabla(this.articuloBuscarView.jTBuscarArticulo);
        }

        if (e.getSource() == this.articuloBuscarView.btSeleccionar) {
            int fila = this.articuloBuscarView.jTBuscarArticulo.getSelectedRow();
            if (fila != -1) {
                String codigo = this.articuloBuscarView.jTBuscarArticulo.getValueAt(fila, 0).toString();
                txtRespuesta.setText(codigo);
                this.articuloBuscarView.setVisible(false);
            } else {
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

        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Estado");

        Object fila[] = new Object[4];

        String Sql = "where nombredf like '%" + this.articuloBuscarView.txtBuscar.getText() + "%'"
                + " or codigo like '%" + this.articuloBuscarView.txtBuscar.getText() + "%'";

        try {
            for (Object oAux : ArticuloBLModelo.obtenerConWhere(new Articulo(), Sql)) {
                Articulo a = (Articulo) oAux;
                fila[0] = a.getCodigo();
                fila[1] = a.getNombre();
                fila[2] = a.getDescripcion();
                if(a.getEstado()==true){
                    fila[3] = "activo";
                }else{
                    fila[3] = "inactivo";
                }
                

                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

}
