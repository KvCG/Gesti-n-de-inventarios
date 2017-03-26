/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.MovimientoBL;
import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Domain.Movimiento;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantProveedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Moviento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kev
 */
public class MovimientoControlador implements ActionListener, DocumentListener {

    private MovimientoBL movimientoBLModelo;
    private Modulo_Moviento modMovView;
    private ArticuloBL articuloBLModelo;
    private PersonaBL personaBLModelo;
    private ProveedorBL proveedorBLModelo;
    private MantArticuloBuscar mantArticuloBView;
    private MantPersonaBuscar mantPersonaBView;
    private MantProveedorBuscar mantProveedorBView;
    private final ArrayList<Movimiento> Movimientos;

    public MovimientoControlador(MovimientoBL movimientoBLModelo, Modulo_Moviento modMovView, ArticuloBL articuloBLModelo, PersonaBL personaBLModelo, ProveedorBL proveedorBLModelo, MantArticuloBuscar mantArticuloBView, MantPersonaBuscar mantPersonaBView, MantProveedorBuscar mantProveedorBView) {
        this.movimientoBLModelo = movimientoBLModelo;
        this.modMovView = modMovView;
        this.Movimientos = new ArrayList();

        this.articuloBLModelo = articuloBLModelo;
        this.personaBLModelo = personaBLModelo;
        this.proveedorBLModelo = proveedorBLModelo;
        this.mantArticuloBView = mantArticuloBView;
        this.mantPersonaBView = mantPersonaBView;
        this.mantProveedorBView = mantProveedorBView;

        this.modMovView.btAgregar.addActionListener(this);
        this.modMovView.btBuscaArticulo.addActionListener(this);
        this.modMovView.btBuscaPersona.addActionListener(this);
        this.modMovView.btBuscaProveedor.addActionListener(this);
        this.modMovView.btCancelar.addActionListener(this);
        this.modMovView.btQuitar.addActionListener(this);
        this.modMovView.btRealizar.addActionListener(this);

        this.modMovView.rdDevolucion.addActionListener(this);
        this.modMovView.rdIngreso.addActionListener(this);
        this.modMovView.rdEgreso.addActionListener(this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.modMovView.rdDevolucion);
        buttonGroup.add(this.modMovView.rdIngreso);
        buttonGroup.add(this.modMovView.rdEgreso);

//        this.modMovView.txtCodigoPersona.setVisible(false);
//        this.modMovView.txtCodigoArticulo.setVisible(false);
//        this.modMovView.txtCodigoArticulo1.setVisible(false);
//        this.modMovView.txtCodigoProveedor.setVisible(false);
        this.modMovView.txtCodigoPersona.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                cargaPersona();
            }
        });

        this.modMovView.txtCodigoProveedor.getDocument().addDocumentListener(this);
        this.modMovView.txtCodigoArticulo.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                cargaArticulo();
            }
        });

//        this.modMovView.txtCodigoProveedor.addCaretListener(new CaretListener() {
//            @Override
//            public void caretUpdate(CaretEvent e) {
//                cargaProveedor();
//            }
//        });
    }

    public MovimientoBL getMovimientoBLModelo() {
        return movimientoBLModelo;
    }

    public void setMovimientoBLModelo(MovimientoBL movimientoBLModelo) {
        this.movimientoBLModelo = movimientoBLModelo;
    }

    public Modulo_Moviento getModMovView() {
        return modMovView;
    }

    public void setModMovView(Modulo_Moviento modMovView) {
        this.modMovView = modMovView;
    }

    public ArticuloBL getArticuloBLModelo() {
        return articuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL articuloBLModelo) {
        this.articuloBLModelo = articuloBLModelo;
    }

    public PersonaBL getPersonaBLModelo() {
        return personaBLModelo;
    }

    public void setPersonaBLModelo(PersonaBL personaBLModelo) {
        this.personaBLModelo = personaBLModelo;
    }

    public ProveedorBL getProveedorBLModelo() {
        return proveedorBLModelo;
    }

    public void setProveedorBLModelo(ProveedorBL proveedorBLModelo) {
        this.proveedorBLModelo = proveedorBLModelo;
    }

    public MantArticuloBuscar getMantArticuloBView() {
        return mantArticuloBView;
    }

    public void setMantArticuloBView(MantArticuloBuscar mantArticuloBView) {
        this.mantArticuloBView = mantArticuloBView;
    }

    public MantPersonaBuscar getMantPersonaBView() {
        return mantPersonaBView;
    }

    public void setMantPersonaBView(MantPersonaBuscar mantPersonaBView) {
        this.mantPersonaBView = mantPersonaBView;
    }

    public MantProveedorBuscar getMantProveedorBView() {
        return mantProveedorBView;
    }

    public void setMantProveedorBView(MantProveedorBuscar mantProveedorBView) {
        this.mantProveedorBView = mantProveedorBView;
    }

    //-----------------------------------------------------Utils
    public void llenarTabla(JTable tablaArticulo) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulo.setModel(modeloTabla);

        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Codigo Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        Persona per = new Persona();
        Proveedor pro = new Proveedor();
        Articulo ar = new Articulo();

        Object fila[] = new Object[4];
        for (Object oAux : this.Movimientos) {
            Movimiento s = (Movimiento) oAux;
            try {
                pro.setIdProvedor(s.getIdProveedor());
                pro = proveedorBLModelo.obtenerPorId(pro);
                ar.setIdarticulo(s.getIdArticulo());
                ar = articuloBLModelo.obtenerPorId(ar);
                per.setIdpersona(s.getIdPersona());
                per = personaBLModelo.obtenerPorId(per);
            } catch (SQLException ex) {
                Logger.getLogger(MovimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

            fila[0] = s.getCodigo();
            fila[1] = ar.getCodigo();
            fila[2] = ar.getNombre();
            fila[3] = s.getCantidad().toString();

            modeloTabla.addRow(fila);
        }
    }

    private Integer isEmpty() {
        if (!this.modMovView.rdIngreso.isSelected() && !this.modMovView.rdIngreso.isSelected() && !this.modMovView.rdDevolucion.isSelected()) {
            return 1;
        }
        if (this.modMovView.txtArticulo.getText().isEmpty()) {
            return 2;
        }
        if (this.modMovView.txtCantidad.getText().isEmpty()) {
            return 3;
        }
        if (this.modMovView.txtCodigoMov.getText().isEmpty()) {
            return 4;
        }
        if (this.modMovView.rdIngreso.isSelected() && this.modMovView.txtProveedor.getText().isEmpty()) {
            return 5;
        }

        if (this.modMovView.rdEgreso.isSelected() && this.modMovView.txtPersona.getText().isEmpty()) {
            return 6;
        }

        if (this.modMovView.rdDevolucion.isSelected() && this.modMovView.txtPersona.getText().isEmpty()) {
            return 7;
        }
        return 0;
    }

    public Integer radioValor() {
        if (this.modMovView.rdIngreso.isSelected()) {
            return 1;
        }
        if (this.modMovView.rdEgreso.isSelected()) {
            return 2;
        }
        if (this.modMovView.rdDevolucion.isSelected()) {
            return 3;
        }
        return null;
    }

    public void cargaPersona() {
        Persona u = new Persona();
        u.setCedula(this.modMovView.txtCodigoPersona.getText());
        try {
            u = personaBLModelo.obtenerPorId(u);
            modMovView.txtPersona.setText(u.getNombre() + " " + u.getApellidos());
        } catch (SQLException ex) {
        }
    }

    public void cargaArticulo() {
        Articulo u = new Articulo();
        u.setCodigo(this.modMovView.txtCodigoArticulo.getText());
        try {
            u = articuloBLModelo.obtenerPorId(u);
            modMovView.txtArticulo.setText(u.getCodigo() + " " + u.getNombre());
            modMovView.txtCodigoArticulo1.setText(u.getIdarticulo().toString());
        } catch (SQLException ex) {
        }
    }

    public void cargaProveedor() {
        Proveedor u = new Proveedor();
        String id = this.modMovView.txtCodigoProveedor.getText();
        u.setIdProvedor(Integer.parseInt(id));
        try {
            u = proveedorBLModelo.obtenerPorId(u);
            modMovView.txtProveedor.setText(u.getNombre());
        } catch (SQLException ex) {
        }
    }

    //-----------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.modMovView.btBuscaPersona) {
            mantPersonaBView = new MantPersonaBuscar();
            PersonaBuscarControlador personaBcontrolador;
            personaBcontrolador = new PersonaBuscarControlador(mantPersonaBView, personaBLModelo, modMovView.txtCodigoPersona);
            personaBcontrolador.getPersonaBuscarView().setVisible(true);
        }

        if (e.getSource() == this.modMovView.btBuscaProveedor) {
            mantProveedorBView = new MantProveedorBuscar();
            ProveedorBuscarControlador proveedorBcontrolador;
            proveedorBcontrolador = new ProveedorBuscarControlador(mantProveedorBView, proveedorBLModelo, modMovView.txtCodigoProveedor);
            proveedorBcontrolador.getProovedorBuscarView().setVisible(true);
        }

        if (e.getSource() == this.modMovView.btBuscaArticulo) {
            mantArticuloBView = new MantArticuloBuscar();
            ArticuloBuscarControlador articuloBcontrolador;
            articuloBcontrolador = new ArticuloBuscarControlador(mantArticuloBView, articuloBLModelo, modMovView.txtCodigoArticulo);
            articuloBcontrolador.getArticuloBuscarView().setVisible(true);
        }

        if (e.getSource() == this.modMovView.btAgregar) {
            if (isEmpty() == 0) {
                Movimiento mov = new Movimiento();
                Persona per = new Persona();
                Proveedor pro = new Proveedor();
                Articulo ar = new Articulo();

                mov.setIdArticulo(0);
                mov.setIdPersona(0);
                mov.setIdProveedor(0);
                mov.setTipo(this.radioValor());
                mov.setCantidad(Integer.parseInt(modMovView.txtCantidad.getText()));
                mov.setCodigo(modMovView.txtCodigoMov.getText());

                try {
                    if (this.isEmpty() != 5) {
                        pro.setIdProvedor(Integer.parseInt(this.modMovView.txtCodigoProveedor.getText()));
                        pro = proveedorBLModelo.obtenerPorId(pro);
                        mov.setIdProveedor(pro.getIdProvedor());
                    }
                    if (this.isEmpty() != 2) {
                        ar.setCodigo(this.modMovView.txtCodigoArticulo.getText());
                        ar = articuloBLModelo.obtenerPorId(ar);
                        mov.setIdArticulo(ar.getIdarticulo());
                    }
                    if (this.isEmpty() != 6 && this.isEmpty() != 7) {
                        per.setIdpersona(Integer.parseInt(this.modMovView.txtCodigoPersona.getText()));
                        per = personaBLModelo.obtenerPorId(per);
                        mov.setIdPersona(per.getIdpersona());
                    }

                    this.Movimientos.add(mov);
                    this.llenarTabla(this.modMovView.tbMovimiento);
                } catch (SQLException ex) {
                    Logger.getLogger(MovimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(modMovView, "Faltan campos por rellenar", "Error al agregar", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.cargaProveedor();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.cargaProveedor();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.cargaProveedor();
    }

}
