/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.ArticuloProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Domain.ArticuloProveedor;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
import cr.ac.una.ingenieria.appMVC.Vista.MantArtProvBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

public class ArtProvBuscarControlador implements ActionListener {

    private MantArtProvBuscar artProvBuscarView;
    private ArticuloProveedorBL artProvrBLModelo;
    private JTextField txtArt;
    private JTextField txtProv;
    private String busqueda;

    public ArtProvBuscarControlador() {
    }

    public ArtProvBuscarControlador(MantArtProvBuscar artProvBuscarView, ArticuloProveedorBL artProvrBLModelo, JTextField txtArt, JTextField txtProv, String busqueda) {
        this.artProvBuscarView = artProvBuscarView;
        this.artProvrBLModelo = artProvrBLModelo;
        this.busqueda = busqueda;
        this.txtArt = txtArt;
        this.txtProv = txtProv;
        this.artProvBuscarView.btBuscar.addActionListener(this);
        this.artProvBuscarView.btSeleccionar.addActionListener(this);
        this.artProvBuscarView.txtBuscar.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                llenarTabla(artProvBuscarView.tbArtProv);
            }
        });

        this.artProvBuscarView.btSeleccionar.addActionListener(this);
        llenarTabla(this.artProvBuscarView.tbArtProv);
    }

    public JTextField getTxtRespuesta() {
        return txtArt;
    }

    public MantArtProvBuscar getArtProvBuscarView() {
        return artProvBuscarView;
    }

    public void setArtProvBuscarView(MantArtProvBuscar artProvBuscarView) {
        this.artProvBuscarView = artProvBuscarView;
    }

    public ArticuloProveedorBL getArtProvrBLModelo() {
        return artProvrBLModelo;
    }

    public void setArtProvrBLModelo(ArticuloProveedorBL artProvrBLModelo) {
        this.artProvrBLModelo = artProvrBLModelo;
    }

    public JTextField getTxtArt() {
        return txtArt;
    }

    public void setTxtArt(JTextField txtArt) {
        this.txtArt = txtArt;
    }

    public JTextField getTxtProv() {
        return txtProv;
    }

    public void setTxtProv(JTextField txtProv) {
        this.txtProv = txtProv;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    /**
     *
     * @param txtRespuesta
     */
    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtArt = txtRespuesta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.artProvBuscarView.btBuscar) {
            llenarTabla(this.artProvBuscarView.tbArtProv);
        }

        if (e.getSource() == this.artProvBuscarView.btSeleccionar) {
            int fila = this.artProvBuscarView.tbArtProv.getSelectedRow();
            if (this.busqueda.equals("Proveedor")) {
                if (fila != -1) {
                    Integer idProveedor = Integer.parseInt(this.artProvBuscarView.tbArtProv.getValueAt(fila, 0).toString());
                    txtProv.setText(String.valueOf(idProveedor));
                    this.artProvBuscarView.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(artProvBuscarView, "Error debe seleccionar un proveedor:", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (fila != -1) {
                    String codArticulo = this.artProvBuscarView.tbArtProv.getValueAt(fila, 0).toString();
                    txtArt.setText(String.valueOf(codArticulo));
                    this.artProvBuscarView.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(artProvBuscarView, "Error debe seleccionar un Articulo:", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     *
     * @param tbArtProv
     */
    public void llenarTabla(JTable tbArtProv) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbArtProv.setModel(modeloTabla);
        try {
            ArticuloBL artBL = new ArticuloBL();
            ProveedorBL provBL = new ProveedorBL();
            ArrayList<Articulo> listaA = new ArrayList();
            ArrayList<Proveedor> listaP = new ArrayList();

            Object fila[];
            String Sql;
            if (this.busqueda.equals("Proveedor")) {
                modeloTabla.addColumn("ID");
                modeloTabla.addColumn("Nombre");
                modeloTabla.addColumn("Telefono");
                modeloTabla.addColumn("Email");
                fila = new Object[5]; 
                Articulo a = new Articulo();
                a.setCodigo(this.txtArt.getText());
                a = artBL.obtenerPorId(a);
                Sql = "where articulo =" + a.getIdarticulo().toString();
                for (Object oAux : artProvrBLModelo.obtenerConWhere(new ArticuloProveedor(), Sql)) {
                    ArticuloProveedor ap = (ArticuloProveedor) oAux;
                    Proveedor p = new Proveedor();
                    p.setIdProvedor(ap.getProveedor());
                    p = provBL.obtenerPorId(p);
                    listaP.add(p);
                }
            } else {
                modeloTabla.addColumn("Codigo");
                modeloTabla.addColumn("Nombre");
                modeloTabla.addColumn("Stock");
                fila = new Object[3];
                Sql = "where proveedor =" + this.txtProv.getText();
                for (Object oAux : artProvrBLModelo.obtenerConWhere(new ArticuloProveedor(), Sql)) {
                    ArticuloProveedor ap = (ArticuloProveedor) oAux;
                    Articulo a = new Articulo();
                    a.setIdarticulo(ap.getArticulo());
                    a = artBL.obtenerPorId2(a);
                    listaA.add(a);
                }
            }

            if (this.busqueda.equals("Proveedor")) {
                for (Object oAux : listaP) {
                    Proveedor ap = (Proveedor) oAux;
                    fila[0] = ap.getIdProvedor();
                    fila[1] = ap.getNombre();
                    fila[2] = ap.getTelefono();
                    fila[3] = ap.getEmail();
                    modeloTabla.addRow(fila);
                }
            } else {
                for (Object oAux : listaA) {
                    Articulo ap = (Articulo) oAux;
                    fila[0] = ap.getCodigo();
                    fila[1] = ap.getNombre();
                    fila[2] = ap.getCantidad();
                    modeloTabla.addRow(fila);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
}
