package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
import cr.ac.una.ingenieria.appMVC.Vista.MantProveedorBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

public class ProveedorBuscarControlador implements ActionListener {

    private MantProveedorBuscar proovedorBuscarView;
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
    public ProveedorBuscarControlador(MantProveedorBuscar proovedorBuscarView, ProveedorBL proveedorBLModelo, JTextField txtRespuesta) {
        this.proovedorBuscarView = proovedorBuscarView;
        this.proveedorBLModelo = proveedorBLModelo;
        this.txtRespuesta = txtRespuesta;

        this.proovedorBuscarView.btSeleccionar.addActionListener(this);
        this.proovedorBuscarView.txtBuscar.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                llenarTabla(proovedorBuscarView.tbProveedor);
            }
        });

        this.proovedorBuscarView.btSeleccionar.addActionListener(this);
        this.proovedorBuscarView.jRadioButton_Activo.addActionListener(this);
        this.proovedorBuscarView.jRadioButton_Inactivo.addActionListener(this);
        iniciarPantalla();
        llenarTabla(this.proovedorBuscarView.tbProveedor);
    }

    /**
     *
     * @return
     */
    public MantProveedorBuscar getProovedorBuscarView() {
        return proovedorBuscarView;
    }

    /**
     *
     * @param proovedorBuscarView
     */
    public void setProovedorBuscarView(MantProveedorBuscar proovedorBuscarView) {
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
    
    public void iniciarPantalla() {
        this.proovedorBuscarView.buttonGroup_Estado.add(this.proovedorBuscarView.jRadioButton_Activo);
        this.proovedorBuscarView.buttonGroup_Estado.add(this.proovedorBuscarView.jRadioButton_Inactivo);

        this.proovedorBuscarView.jRadioButton_Activo.setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == this.proovedorBuscarView.btSeleccionar) {
            int fila = this.proovedorBuscarView.tbProveedor.getSelectedRow();
            if (fila != -1) {
                Integer idProveedor = Integer.parseInt(this.proovedorBuscarView.tbProveedor.getValueAt(fila, 0).toString());
                txtRespuesta.setText(String.valueOf(idProveedor));
                this.proovedorBuscarView.setVisible(false);
            }
        }
        if (e.getSource() == this.proovedorBuscarView.jRadioButton_Activo
                || e.getSource() == this.proovedorBuscarView.jRadioButton_Inactivo) {
            this.llenarTabla(this.proovedorBuscarView.tbProveedor);
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

        String Sql = "where nombre like '%" + this.proovedorBuscarView.txtBuscar.getText() + "%'";
        try {
            for (Object oAux : proveedorBLModelo.obtenerConWhere(new Proveedor(), Sql)) {
                Proveedor p = (Proveedor) oAux;
                if (this.proovedorBuscarView.jRadioButton_Activo.isSelected()) {
                    if (p.getEstado() == true) {
                        fila[0] = p.getIdProvedor();
                        fila[1] = p.getNombre();
                        fila[2] = p.getTelefono();
                        fila[3] = p.getEmail();
                        if (p.getEstado() == true) {
                            fila[4] = "activo";
                        }
                        modeloTabla.addRow(fila);
                    }
                }
                if (this.proovedorBuscarView.jRadioButton_Inactivo.isSelected()) {
                    if (p.getEstado() == false) {
                        fila[0] = p.getIdProvedor();
                        fila[1] = p.getNombre();
                        fila[2] = p.getTelefono();
                        fila[3] = p.getEmail();
                        if (p.getEstado() == false) {
                            fila[4] = "inactivo";
                        }
                        modeloTabla.addRow(fila);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
}
