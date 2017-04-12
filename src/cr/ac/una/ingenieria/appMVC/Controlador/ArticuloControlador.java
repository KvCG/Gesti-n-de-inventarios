package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.BodegaBL;
import cr.ac.una.ingenieria.appMVC.BL.TipoArticuloBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Domain.Bodega;
import cr.ac.una.ingenieria.appMVC.Domain.TipoArticulo;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Gustavo
 */
public class ArticuloControlador implements ActionListener, DocumentListener {

    private Modulo_Inventario mantArticuloView;
    private ArticuloBL ArticuloBLModelo;
    private BodegaBL bodegaBL;
    private TipoArticuloBL tipArtBL;

    public ArticuloControlador() {
    }

    public ArticuloControlador(Modulo_Inventario mantArticuloView, ArticuloBL ArticuloBLModelo) {
        this.mantArticuloView = mantArticuloView;
        this.ArticuloBLModelo = ArticuloBLModelo;
        this.mantArticuloView.txtCodigoBuscar.getDocument().addDocumentListener(this);
        this.mantArticuloView.btInsertar.addActionListener(this);
        this.mantArticuloView.btBuscar.addActionListener(this);
        this.mantArticuloView.btCancelar.addActionListener(this);
        this.mantArticuloView.btEliminar.addActionListener(this);
        this.mantArticuloView.btModificar.addActionListener(this);
        this.mantArticuloView.jcb_Bodega.addActionListener(this);
        this.mantArticuloView.btModificar.setEnabled(false);
        this.mantArticuloView.btEliminar.setEnabled(false);
        this.mantArticuloView.txtCodigoBuscar.setVisible(false);
        inicializarPantalla();
        Cargar_jcbBodega(this.mantArticuloView.jcb_Bodega);
        Cargar_jcbTipoArticulo(this.mantArticuloView.jcb_Tipo);
    }

    public Modulo_Inventario getMantArticuloView() {
        return mantArticuloView;
    }

    public void setMantArticuloView(Modulo_Inventario mantArticuloView) {
        this.mantArticuloView = mantArticuloView;
    }

    public ArticuloBL getArticuloBLModelo() {
        return ArticuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL ArticuloBLModelo) {
        this.ArticuloBLModelo = ArticuloBLModelo;
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
                a.setPuntoPedido(Integer.parseInt(this.mantArticuloView.txtPuntoPedido.getText()));
                a.setCantidad(Integer.parseInt(this.mantArticuloView.TxtCantidad.getText()));

                String bodega = this.mantArticuloView.jcb_Bodega.getSelectedItem().toString();
                try {
                    for (Bodega b : this.bodegaBL.obtenerTodos()) {
                        if (b.getTipo().equals(bodega)) {
                            a.setBodega(b.getIdBodega());
                        }
                    }
                } catch (Exception eq) {
                }

                String tipArt = this.mantArticuloView.jcb_Tipo.getSelectedItem().toString();
                try {
                    for (TipoArticulo t : this.tipArtBL.obtenerTodos()) {
                        if (t.getDescripcion().equals(tipArt)) {
                            a.setTipo(t.getCodigo());
                        }
                    }
                } catch (Exception eq) {
                }

                try {
                    this.ArticuloBLModelo.insertar(a);
                    JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido ingresado correctamente", "Articulo Agregado", JOptionPane.INFORMATION_MESSAGE);
                    this.clean();
                    this.mantArticuloView.btEliminar.setEnabled(false);
                    this.mantArticuloView.btModificar.setEnabled(false);
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
                    this.mantArticuloView.btModificar.setEnabled(false);
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
                    a.setPuntoPedido(Integer.parseInt(this.mantArticuloView.txtPuntoPedido.getText()));
                    a.setCantidad(Integer.parseInt(this.mantArticuloView.TxtCantidad.getText()));

                    String bodega = this.mantArticuloView.jcb_Bodega.getSelectedItem().toString();
                    try {
                        for (Bodega b : this.bodegaBL.obtenerTodos()) {
                            if (b.getTipo().equals(bodega)) {
                                a.setBodega(b.getIdBodega());
                            }
                        }
                    } catch (Exception eq) {
                    }

                    String tipArt = this.mantArticuloView.jcb_Tipo.getSelectedItem().toString();
                    try {
                        for (TipoArticulo t : this.tipArtBL.obtenerTodos()) {
                            if (t.getDescripcion().equals(tipArt)) {
                                a.setTipo(t.getCodigo());
                            }
                        }
                    } catch (Exception eq) {
                    }
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
            this.mantArticuloView.btModificar.setEnabled(false);
            this.mantArticuloView.txtCodigo.setEnabled(true);
        }

        if (e.getSource() == this.mantArticuloView.btBuscar) {
            if (!mantArticuloView.txtCodigo.getText().isEmpty()) {
                
                MantArticuloBuscar mantArticuloBuscarView = new MantArticuloBuscar();
                ArticuloBuscarControlador articuloBControlador;
                articuloBControlador = new ArticuloBuscarControlador(mantArticuloBuscarView, 
                        ArticuloBLModelo, this.mantArticuloView.txtCodigoBuscar);
                articuloBControlador.getArticuloBuscarView().setVisible(true);
                this.mantArticuloView.btEliminar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(mantArticuloView, "Debes digitar un codigo primero", "Error", JOptionPane.ERROR_MESSAGE);
            }
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
        if (!this.mantArticuloView.txtCodigoBuscar.getText().isEmpty()) {
            a.setCodigo(this.mantArticuloView.txtCodigoBuscar.getText());
            try {
                a = ArticuloBLModelo.obtenerPorId(a);
                this.mantArticuloView.txtNombre.setText(a.getNombre());
                this.mantArticuloView.txtDescripcion.setText(a.getDescripcion());
                this.mantArticuloView.TxtCantidad.setText(String.valueOf(a.getCantidad().toString()));
                this.mantArticuloView.TxtPrecio.setText(String.valueOf(a.getPrecioVenta()));
                this.mantArticuloView.txtPuntoPedido.setText(String.valueOf(a.getPuntoPedido()));
                
                int bo = a.getBodega();
                int ti = a.getTipo();
                
                for(Bodega b:this.bodegaBL.obtenerTodos()){
                    if(b.getIdBodega() == bo){
                        this.mantArticuloView.jcb_Bodega.setSelectedItem(b.getNombre().toString());
                    }
                }
                
                for(TipoArticulo t:this.tipArtBL.obtenerTodos()){
                    if(t.getCodigo() == ti){
                        this.mantArticuloView.jcb_Tipo.setSelectedItem(t.getDescripcion().toString());                        
                    }
                }
                  
                
                this.mantArticuloView.btModificar.setEnabled(true);
                this.mantArticuloView.txtCodigo.setEnabled(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error no se pudo consultar el Articulo (" + ex.getMessage() + ")",
                        "Error al cargar el Articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Cargar_jcbBodega(JComboBox jcbBod) {
        this.mantArticuloView.jcb_Bodega.removeAllItems();
        DefaultComboBoxModel ModeloJcb = new DefaultComboBoxModel();
        jcbBod.setModel(ModeloJcb);
        this.bodegaBL = new BodegaBL();
        try {
            for (Bodega b : this.bodegaBL.obtenerTodos()) {
                if(b.getEstado() == true){
                    ModeloJcb.addElement(b.getTipo().toString());
                }
            }
        } catch (Exception e) {
        }

    }//fin del cargar bodega

    public void Cargar_jcbTipoArticulo(JComboBox jcbTipArt) {
        this.mantArticuloView.jcb_Tipo.removeAllItems();
        DefaultComboBoxModel Modelojcb = new DefaultComboBoxModel();
        jcbTipArt.setModel(Modelojcb);
        this.tipArtBL = new TipoArticuloBL();
        try {
            for (TipoArticulo t : this.tipArtBL.obtenerTodos()) {
                if(t.getEstado() == true){
                    Modelojcb.addElement(t.getDescripcion().toString());
                }
            }
        } catch (Exception e) {
        }
    }
}
