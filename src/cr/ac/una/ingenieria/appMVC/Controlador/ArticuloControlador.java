/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
        this.mantArticuloView.btModificar.setEnabled(false);
        this.mantArticuloView.btEliminar.setEnabled(false);
        inicializarPantalla();
    }

    private void inicializarPantalla() {

    }

    private boolean isEmpty() {
        if (this.mantArticuloView.txtNombre.getText().equals("")
                || this.mantArticuloView.txtDescripcion.getText().equals("")
                || this.mantArticuloView.TxtPrecio.getText().equals("")
                || this.mantArticuloView.TxtCantidad.getText().equals("")
                || this.mantArticuloView.txtPuntoPedido.getText().equals("")
                || this.mantArticuloView.txtCodigo.getText().equals("")) {
            return true;
        }
        return false;
    }

    private void clean() {
        this.mantArticuloView.TxtCantidad.setText(null);
        this.mantArticuloView.TxtPrecio.setText(null);
        this.mantArticuloView.txtNombre.setText(null);
        this.mantArticuloView.txtDescripcion.setText(null);
        this.mantArticuloView.txtCodigo.setText(null);
        this.mantArticuloView.txtPuntoPedido.setText(null);
        
    }

    /**
     *
     * @param tablaArticulos
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mantArticuloView.btInsertar) {

            if (this.isEmpty()) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error faltan espacios por rellenar:", "Error en ingresar articulo", JOptionPane.ERROR_MESSAGE);
            } else {
                Articulo a = new Articulo();
                a.setCodigo(this.mantArticuloView.txtCodigo.getText());
                a.setNombre(this.mantArticuloView.txtNombre.getText());
                a.setDescripcion(this.mantArticuloView.txtDescripcion.getText());
                a.setPrecioVenta(Double.parseDouble(this.mantArticuloView.TxtPrecio.getText()));
                a.setTipo(this.mantArticuloView.cbTipo.getSelectedIndex());
                a.setPuntoPedido(Integer.parseInt(this.mantArticuloView.txtPuntoPedido.getText()));
                a.setCantidad(Integer.parseInt(this.mantArticuloView.TxtCantidad.getText()));
                a.setBodega(this.mantArticuloView.cbBodega.getSelectedIndex());

                try {
                    this.ArticuloBLModelo.insertar(a);
                    JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido ingresado correctamente", "Articulo Agregado", JOptionPane.INFORMATION_MESSAGE);
                    this.clean();
                    this.mantArticuloView.btModificar.setEnabled(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantArticuloView, "Error al agregar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantArticuloView, "Error al agregar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == this.mantArticuloView.btEliminar) {
            Articulo a = new Articulo();
            String codigo = this.mantArticuloView.txtCodigo.getText();
            a.setCodigo(codigo);
            try {
                int resp;
                resp = JOptionPane.showConfirmDialog(mantArticuloView, "Esta seguro que desea eliminar el Articulo");
                if (resp == 0) {
                    ArticuloBLModelo.eliminar(a);
                    JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido eliminado correctamente", "Articulo Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    this.clean();
                    this.mantArticuloView.btEliminar.setEnabled(false);
                }
                if (resp == 1) {
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
        }
        if (e.getSource() == this.mantArticuloView.btCargar) {
            if (!this.mantArticuloView.txtCodigo.getText().isEmpty()) {
                Articulo a = new Articulo();
                String codigo = this.mantArticuloView.txtCodigo.getText();
                a.setCodigo(codigo);
                try {
                    a = ArticuloBLModelo.obtenerPorId(a);
                    if (a != null) {
                        this.mantArticuloView.txtCodigo.setText(a.getCodigo());
                        this.mantArticuloView.txtNombre.setText(a.getNombre());
                        this.mantArticuloView.txtDescripcion.setText(a.getDescripcion());
                        this.mantArticuloView.TxtCantidad.setText(String.valueOf(a.getCantidad().toString()));
                        this.mantArticuloView.TxtPrecio.setText(String.valueOf(a.getPrecioVenta()));
                        this.mantArticuloView.txtPuntoPedido.setText(String.valueOf(a.getPuntoPedido()));
                        this.mantArticuloView.cbBodega.setSelectedIndex(a.getBodega());
                        this.mantArticuloView.cbTipo.setSelectedIndex(a.getTipo());
                        this.mantArticuloView.btEliminar.setEnabled(true);
                        this.mantArticuloView.btModificar.setEnabled(true);
                        this.mantArticuloView.txtCodigo.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(mantArticuloView, "No se encontro el articulo", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(mantArticuloView, "Debes introducir el codigo primero.", "Error al buscar", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == this.mantArticuloView.btModificar) {
            if (this.isEmpty()) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error primero debe seleccionar un Articulo:", "Error en ingresar articulo", JOptionPane.ERROR_MESSAGE);
            } else {
                Articulo a = new Articulo();
                a.setCodigo(this.mantArticuloView.txtCodigo.getText());

                try {
                    a = ArticuloBLModelo.obtenerPorId(a);
                    a.setNombre(this.mantArticuloView.txtNombre.getText());
                    a.setDescripcion(this.mantArticuloView.txtDescripcion.getText());
                    a.setPrecioVenta(Double.parseDouble(this.mantArticuloView.TxtPrecio.getText()));
                    a.setTipo(this.mantArticuloView.cbTipo.getSelectedIndex());
                    a.setPuntoPedido(Integer.parseInt(this.mantArticuloView.txtPuntoPedido.getText()));
                    a.setCantidad(Integer.parseInt(this.mantArticuloView.TxtCantidad.getText()));
                    a.setBodega(this.mantArticuloView.cbBodega.getSelectedIndex());
                    this.ArticuloBLModelo.modificar(a);
                    this.clean();
                    this.mantArticuloView.btEliminar.setEnabled(false);
                    this.mantArticuloView.txtCodigo.setEnabled(true);
                    JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido modificado correctamente",
                            "Articulo maodificado Modificado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantArticuloView, "Error al modificar  al Articulo:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar al articulo:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        if (e.getSource() == this.mantArticuloView.btCancelar) {
            this.clean();
            this.mantArticuloView.btEliminar.setEnabled(false);
            this.mantArticuloView.txtCodigo.setEnabled(true);
        }

        if (e.getSource() == this.mantArticuloView.btBuscar) {
            MantArticuloBuscar mantArticuloBuscarView = new MantArticuloBuscar();
            ArticuloBuscarControlador articuloBControlador;
            articuloBControlador = new ArticuloBuscarControlador(mantArticuloBuscarView, ArticuloBLModelo, this.mantArticuloView.txtCodigo);
            articuloBControlador.getArticuloBuscarView().setVisible(true);
            this.mantArticuloView.btEliminar.setEnabled(true);
        }

    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        cargarArticulo();

    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        cargarArticulo();

    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        cargarArticulo();

    }

    private void cargarArticulo() {
        Articulo a = new Articulo();
        if (!this.mantArticuloView.txtCodigo.getText().isEmpty()) {
            a.setCodigo(this.mantArticuloView.txtCodigo.getText());
            try {
                a = ArticuloBLModelo.obtenerPorId(a);
                this.mantArticuloView.txtCodigo.setText(a.getCodigo());
                this.mantArticuloView.txtNombre.setText(a.getNombre());
                this.mantArticuloView.txtDescripcion.setText(a.getDescripcion());
                this.mantArticuloView.TxtCantidad.setText(String.valueOf(a.getCantidad().toString()));
                this.mantArticuloView.TxtPrecio.setText(String.valueOf(a.getPrecioVenta()));
                this.mantArticuloView.txtPuntoPedido.setText(String.valueOf(a.getPuntoPedido()));
                this.mantArticuloView.cbBodega.setSelectedIndex(a.getBodega());
                this.mantArticuloView.cbTipo.setSelectedIndex(a.getTipo());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error no se pudo consultar el Articulo (" + ex.getMessage() + ")",
                        "Error al cargar el Articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
