package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.ArticuloProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.BodegaBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.TipoArticuloBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Domain.ArticuloProveedor;
import cr.ac.una.ingenieria.appMVC.Domain.Bodega;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
import cr.ac.una.ingenieria.appMVC.Domain.TipoArticulo;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantProveedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
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
    private ArticuloProveedor artPro;
    private ProveedorBL proBl;
    private ArticuloProveedorBL artProvBl;

    public ArticuloControlador() {
    }

    public ArticuloControlador(Modulo_Inventario mantArticuloView, ArticuloBL ArticuloBLModelo) {
        this.mantArticuloView = mantArticuloView;
        this.ArticuloBLModelo = ArticuloBLModelo;
        this.artPro = new ArticuloProveedor();
        this.proBl = new ProveedorBL();
        this.artProvBl = new ArticuloProveedorBL();
        this.mantArticuloView = mantArticuloView;
        this.ArticuloBLModelo = ArticuloBLModelo;
        this.mantArticuloView.txtCodigoBuscar.getDocument().addDocumentListener(this);
        this.mantArticuloView.btInsertar.addActionListener(this);
        this.mantArticuloView.btBuscar.addActionListener(this);
        this.mantArticuloView.btCancelar.addActionListener(this);
        this.mantArticuloView.btEliminar.addActionListener(this);
        this.mantArticuloView.btModificar.addActionListener(this);
        this.mantArticuloView.jcbBodega.addActionListener(this);
        this.mantArticuloView.btBuscaProveedor.addActionListener(this);
        this.mantArticuloView.txtCodigoProv.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!mantArticuloView.txtCodigoProv.getText().isEmpty()) {
                    cargaProveedor();
                }

            }
        });
        this.mantArticuloView.btModificar.setEnabled(false);
        this.mantArticuloView.btEliminar.setEnabled(false);
        this.mantArticuloView.txtCodigoBuscar.setVisible(false);
        this.mantArticuloView.txtCodigoProv.setVisible(false);
        
        inicializarPantalla();
        cargarBodegaCombo(this.mantArticuloView.jcbBodega);
        cargarTipoArtCombo(this.mantArticuloView.jcbTipo);
    }

    public ArticuloProveedor getArtPro() {
        return artPro;
    }

    public void setArtPro(ArticuloProveedor artPro) {
        this.artPro = artPro;
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
        if (this.mantArticuloView.txtNombre.getText().isEmpty()
                || this.mantArticuloView.txtDescripcion.getText().isEmpty()
                || this.mantArticuloView.txtPrecio.getText().isEmpty()
                || this.mantArticuloView.txtCantidad.getText().isEmpty()
                || this.mantArticuloView.txtPuntoPedido.getText().isEmpty()
                || this.mantArticuloView.txtCodigo.getText().isEmpty()
                || this.mantArticuloView.txtNombreProv.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    private void clean() {
        this.mantArticuloView.txtCantidad.setText(null);
        this.mantArticuloView.txtPrecio.setText(null);
        this.mantArticuloView.txtNombre.setText(null);
        this.mantArticuloView.txtDescripcion.setText(null);
        this.mantArticuloView.txtCodigo.setText(null);
        this.mantArticuloView.txtPuntoPedido.setText(null);
        this.mantArticuloView.txtCosto.setText(null);
        this.mantArticuloView.chbImpuestos.setSelected(false);
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
                a.setPrecioVenta(Double.parseDouble(this.mantArticuloView.txtPrecio.getText()));
                a.setPuntoPedido(Integer.parseInt(this.mantArticuloView.txtPuntoPedido.getText()));
                a.setCantidad(Integer.parseInt(this.mantArticuloView.txtCantidad.getText()));
                if(this.mantArticuloView.chbImpuestos.isSelected()){
                    a.setImpuesto("Gravado");
                }else{
                     a.setImpuesto("Exento");
                }

                String bodega = this.mantArticuloView.jcbBodega.getSelectedItem().toString();
                try {
                    for (Bodega b : this.bodegaBL.obtenerTodos()) {
                        if (b.getTipo().equals(bodega)) {
                            a.setBodega(b.getIdBodega());
                        }
                    }
                    String tipArt = this.mantArticuloView.jcbTipo.getSelectedItem().toString();
                    for (TipoArticulo t : this.tipArtBL.obtenerTodos()) {
                        if (t.getDescripcion().equals(tipArt)) {
                            a.setTipo(t.getCodigo());
                        }
                    }
                    
                    this.ArticuloBLModelo.insertar(a);
                    a = ArticuloBLModelo.obtenerPorId(a);
                    artPro.setProveedor(Integer.parseInt(this.mantArticuloView.txtCodigoProv.getText()));
                    artPro.setArticulo(a.getIdarticulo());
                    artPro.setCosto(Float.parseFloat(this.mantArticuloView.txtCosto.getText()));
                    this.artProvBl.insertar(artPro);
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
                    a.setPrecioVenta(Double.parseDouble(this.mantArticuloView.txtPrecio.getText()));
                    a.setPuntoPedido(Integer.parseInt(this.mantArticuloView.txtPuntoPedido.getText()));
                    a.setCantidad(Integer.parseInt(this.mantArticuloView.txtCantidad.getText()));

                    String bodega = this.mantArticuloView.jcbBodega.getSelectedItem().toString();
                    try {
                        for (Bodega b : this.bodegaBL.obtenerTodos()) {
                            if (b.getTipo().equals(bodega)) {
                                a.setBodega(b.getIdBodega());
                            }
                        }
                    } catch (Exception eq) {
                    }

                    String tipArt = this.mantArticuloView.jcbTipo.getSelectedItem().toString();
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
        if (e.getSource() == this.mantArticuloView.btBuscaProveedor) {
            MantProveedorBuscar mantBuscarView = new MantProveedorBuscar();
            ProveedorBuscarControlador pBControlador;
            pBControlador = new ProveedorBuscarControlador(mantBuscarView, this.proBl, this.mantArticuloView.txtCodigoProv);
            pBControlador.getProovedorBuscarView().setVisible(true);
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
                this.mantArticuloView.txtCantidad.setText(String.valueOf(a.getCantidad().toString()));
                this.mantArticuloView.txtPrecio.setText(String.valueOf(a.getPrecioVenta()));
                this.mantArticuloView.txtPuntoPedido.setText(String.valueOf(a.getPuntoPedido()));
                if(a.getImpuesto().equals("Gravado")){
                    this.mantArticuloView.chbImpuestos.setSelected(true);
                }else{
                     this.mantArticuloView.chbImpuestos.setSelected(false);
                }
                
                int bo = a.getBodega();
                int ti = a.getTipo();

                for (Bodega b : this.bodegaBL.obtenerTodos()) {
                    if (b.getIdBodega() == bo) {
                        this.mantArticuloView.jcbBodega.setSelectedItem(b.getNombre().toString());
                    }
                }

                for (TipoArticulo t : this.tipArtBL.obtenerTodos()) {
                    if (t.getCodigo() == ti) {
                        this.mantArticuloView.jcbTipo.setSelectedItem(t.getDescripcion().toString());
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

    private void cargaProveedor() {
        Proveedor prov = new Proveedor();
        if (!this.mantArticuloView.txtCodigoProv.getText().isEmpty()) {
            prov.setIdProvedor(Integer.parseInt(this.mantArticuloView.txtCodigoProv.getText()));
            try {
                prov = proBl.obtenerPorId(prov);
                this.mantArticuloView.txtNombreProv.setText(prov.getNombre());
                this.mantArticuloView.txtTelefonoProv.setText(prov.getTelefono());
                this.mantArticuloView.txtCorreoProv.setText(prov.getEmail());
            } catch (SQLException ex) {
            }
        }
    }

    public void cargarBodegaCombo(JComboBox jcbBod) {
        this.mantArticuloView.jcbBodega.removeAllItems();
        DefaultComboBoxModel ModeloJcb = new DefaultComboBoxModel();
        jcbBod.setModel(ModeloJcb);
        this.bodegaBL = new BodegaBL();
        try {
            for (Bodega b : this.bodegaBL.obtenerTodos()) {
                if (b.getEstado() == true) {
                    ModeloJcb.addElement(b.getTipo().toString());
                }
            }
        } catch (Exception e) {
        }

    }//fin del cargar bodega

    public void cargarTipoArtCombo(JComboBox jcbTipArt) {
        this.mantArticuloView.jcbTipo.removeAllItems();
        DefaultComboBoxModel Modelojcb = new DefaultComboBoxModel();
        jcbTipArt.setModel(Modelojcb);
        this.tipArtBL = new TipoArticuloBL();
        try {
            for (TipoArticulo t : this.tipArtBL.obtenerTodos()) {
                if (t.getEstado() == true) {
                    Modelojcb.addElement(t.getDescripcion().toString());
                }
            }
        } catch (Exception e) {
        }
    }
}
