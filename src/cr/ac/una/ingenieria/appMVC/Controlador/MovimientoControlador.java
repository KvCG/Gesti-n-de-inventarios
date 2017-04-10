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
import java.util.Objects;
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

        this.modMovView.txtCodigoMov.setEditable(false);
        this.modMovView.txtCodigoPersona.setVisible(false);
        this.modMovView.txtCodigoArticulo.setVisible(false);
        this.modMovView.txtCodigoArticulo1.setVisible(false);
        this.modMovView.txtCodigoProveedor.setVisible(false);
        this.modMovView.txtCodigoPersona.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!modMovView.txtCodigoPersona.getText().isEmpty()) {
                    cargaPersona();
                    try {
                        modMovView.txtCodigoMov.setText("MOV" + movimientoBLModelo.obtenerConsecutivo().toString());
                    } catch (SQLException ex) {
                        Logger.getLogger(MovimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        this.modMovView.txtCodigoArticulo.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!modMovView.txtCodigoArticulo.getText().isEmpty()) {
                    cargaArticulo();
                    try {
                        modMovView.txtCodigoMov.setText("MOV" + movimientoBLModelo.obtenerConsecutivo().toString());
                    } catch (SQLException ex) {
                        Logger.getLogger(MovimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        this.modMovView.txtCodigoProveedor.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!modMovView.txtCodigoProveedor.getText().isEmpty()) {
                    cargaProveedor();
                    try {
                        modMovView.txtCodigoMov.setText("MOV" + movimientoBLModelo.obtenerConsecutivo().toString());
                    } catch (SQLException ex) {
                        Logger.getLogger(MovimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
       this.modMovView.txtCodigoPersona.setText(ValidarAcceso.getPerCurrent().getCedula());

        this.readOnly(false);
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
    public void clear() {
        this.modMovView.txtArticulo.setText(null);
        this.modMovView.txtCantidad.setText(null);
        this.modMovView.txtCodigoMov.setText(null);
        this.modMovView.txtPersona.setText(null);
        this.modMovView.txtProveedor.setText(null);
        this.modMovView.txtStock.setText(null);
        this.modMovView.rdDevolucion.setSelected(false);
        this.modMovView.rdIngreso.setSelected(false);
        this.modMovView.rdEgreso.setSelected(false);
        this.Movimientos.clear();
        this.llenarTabla(modMovView.tbMovimiento);
    }

    public void llenarTabla(JTable tablaArticulo) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulo.setModel(modeloTabla);
        modeloTabla.addColumn("No.");
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Codigo Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        Persona per = new Persona();
        Proveedor pro = new Proveedor();
        Articulo ar = new Articulo();
        Integer num = 1;
        Object fila[] = new Object[5];
        for (Object oAux : this.Movimientos) {
            Movimiento s = (Movimiento) oAux;
            try {
                pro.setIdProvedor(s.getIdProveedor());
                pro = proveedorBLModelo.obtenerPorId(pro);
                ar.setIdarticulo(s.getIdArticulo());
                ar = articuloBLModelo.obtenerPorId2(ar);
                per.setIdpersona(s.getIdPersona());
                per = personaBLModelo.obtenerPorId2(per);
            } catch (SQLException ex) {
                Logger.getLogger(MovimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

            fila[0] = num++;
            fila[1] = s.getCodigo();
            fila[2] = ar.getCodigo();
            fila[3] = ar.getNombre();
            fila[4] = s.getCantidad().toString();

            modeloTabla.addRow(fila);
        }
    }

    private Integer isEmpty() {
        if (!this.modMovView.rdIngreso.isSelected() && !this.modMovView.rdEgreso.isSelected() && !this.modMovView.rdDevolucion.isSelected()) {
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
            return 1; //Ingreso 
        }
        if (this.modMovView.rdEgreso.isSelected()) {
            return 2;//Egreso
        }
        if (this.modMovView.rdDevolucion.isSelected()) {
            return 3;//Devolucion
        }
        return null;
    }

    public void alarma(int opc) {
        switch (opc) {
            case 1:
                JOptionPane.showMessageDialog(modMovView, "Debe seleccionar el tipo de movimiento", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(modMovView, "Debe seleccionar un articulo", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(modMovView, "Debe indicar la cantidad", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(modMovView, "Debe digitar un codigo para el movimiento", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                JOptionPane.showMessageDialog(modMovView, "Debe seleccionar un proveedor", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                break;
            case 6:
                JOptionPane.showMessageDialog(modMovView, "Debe indicar un responsable", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                break;
            case 7:
                JOptionPane.showMessageDialog(modMovView, "Debe indicar un responsable", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }
    }

    public void readOnly(boolean value) { //Al agregar un movimiemto deshabilita los campos de proveedor, codigo, perosna
        this.modMovView.txtProveedor.setEditable(value);
        this.modMovView.txtPersona.setEditable(value);
        this.modMovView.txtArticulo.setEditable(value);
        this.modMovView.txtStock.setEditable(value);
        //this.modMovView.txtCodigoMov.setEditable(value);
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
            modMovView.txtStock.setText(u.getCantidad().toString());
        } catch (SQLException ex) {
        }
    }

    public void cargaProveedor() {
        Proveedor u = new Proveedor();
        Integer id = Integer.parseInt(this.modMovView.txtCodigoProveedor.getText());
        u.setIdProvedor(id);
        try {
            u = proveedorBLModelo.obtenerPorId(u);
            modMovView.txtProveedor.setText(u.getNombre());
        } catch (SQLException ex) {
        }
    }

    public Integer contains(ArrayList<Movimiento> list, Movimiento mov) {
        Integer index = 0;
        for (Movimiento s : list) {
            if (Objects.equals(s.getIdArticulo(), mov.getIdArticulo())) {
                return index;
            }
            index++;
        }
        return -1;
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
                Integer index;
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
                    if (!this.modMovView.txtCodigoProveedor.getText().isEmpty()) {
                        pro.setIdProvedor(Integer.parseInt(this.modMovView.txtCodigoProveedor.getText()));
                        pro = proveedorBLModelo.obtenerPorId(pro);
                        mov.setIdProveedor(pro.getIdProvedor());
                    }
                    if (!this.modMovView.txtCodigoArticulo.getText().isEmpty()) {
                        ar.setCodigo(this.modMovView.txtCodigoArticulo.getText());
                        ar = articuloBLModelo.obtenerPorId(ar);
                        mov.setIdArticulo(ar.getIdarticulo());
                    }
                    if (!this.modMovView.txtCodigoPersona.getText().isEmpty()) {
                        per.setCedula(this.modMovView.txtCodigoPersona.getText());
                        per = personaBLModelo.obtenerPorId(per);
                        mov.setIdPersona(per.getIdpersona());
                    }
                    index = this.contains(Movimientos, mov);
                    if (modMovView.rdEgreso.isSelected()
                            && (Integer.parseInt(modMovView.txtCantidad.getText()) > Integer.parseInt(modMovView.txtStock.getText()))) {
                        JOptionPane.showMessageDialog(null, "Movimiento Invalido: " + "La cantidad de salida sobrepasa la cantidad en existencias", null, JOptionPane.ERROR_MESSAGE);
                        this.modMovView.txtCantidad.setText(null);
                    } else {
                        if (index != -1) {
                            Movimiento aux = this.Movimientos.get(index);
                            aux.setCantidad(mov.getCantidad() + aux.getCantidad());
                            this.Movimientos.set(index, aux);
                        } else {
                            this.Movimientos.add(mov);
                        }
                        this.modMovView.txtCodigoMov.setEditable(false);
                        this.modMovView.txtCantidad.setText(null);
                        this.modMovView.txtArticulo.setText(null);
                        this.modMovView.txtStock.setText(null);
                        this.llenarTabla(this.modMovView.tbMovimiento);
                        this.readOnly(false);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                this.alarma(this.isEmpty());
            }
        }

        if (e.getSource() == this.modMovView.btRealizar) {
            if (!this.Movimientos.isEmpty()) {
                if (JOptionPane.showConfirmDialog(modMovView, "Esta seguro que desea realizar el movimiento") == 0) {
                    try {
                        for (Object oAux : this.Movimientos) {
                            Movimiento mov = (Movimiento) oAux;
                            movimientoBLModelo.insertar(mov);
                        }
                        this.clear();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(modMovView, "No se han ingresado los movimientos", "Error al realizar operación", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == this.modMovView.btCancelar) {
            if (JOptionPane.showConfirmDialog(modMovView, "Si cancela perdera la información digitada") == 0) {
                this.clear();
            }
        }

        if (e.getSource() == this.modMovView.btQuitar) {
            int fila = this.modMovView.tbMovimiento.getSelectedRow();
            if (fila != -1) {
                Integer NumRem = Integer.parseInt(this.modMovView.tbMovimiento.getValueAt(fila, 0).toString());
                this.Movimientos.remove(NumRem - 1);
                this.llenarTabla(modMovView.tbMovimiento);
            } else {
                JOptionPane.showMessageDialog(modMovView, "No se ha seleccionado un movimeinto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

}
