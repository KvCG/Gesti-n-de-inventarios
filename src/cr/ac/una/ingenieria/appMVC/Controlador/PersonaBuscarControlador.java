package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;
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
public class PersonaBuscarControlador implements ActionListener {

    private MantPersonaBuscar personaBuscarView;
    private PersonaBL PersonaBLModelo;
    private JTextField txtRespuesta;

    public PersonaBuscarControlador(MantPersonaBuscar personaBuscarView, PersonaBL PersonaBLModelo, JTextField txtRespuesta) {
        this.personaBuscarView = personaBuscarView;
        this.PersonaBLModelo = PersonaBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.personaBuscarView.txtBuscar.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                llenarTabla(personaBuscarView.jTBuscarPersona);
            }
        });
        this.personaBuscarView.btSeleccionar.addActionListener(this);
        this.personaBuscarView.jRadioButton_Activo.addActionListener(this);
        this.personaBuscarView.jRadioButton_Inactivo.addActionListener(this);
        IniciarRadioBoton();
        llenarTabla(this.personaBuscarView.jTBuscarPersona);
    }

    public MantPersonaBuscar getPersonaBuscarView() {
        return personaBuscarView;
    }

    public void setPersonaBuscarView(MantPersonaBuscar personaBuscarView) {
        this.personaBuscarView = personaBuscarView;
    }

    public PersonaBL getPersonaBLModelo() {
        return PersonaBLModelo;
    }

    public void setPersonaBLModelo(PersonaBL PersonaBLModelo) {
        this.PersonaBLModelo = PersonaBLModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

    public void IniciarRadioBoton() {
        this.personaBuscarView.buttonGroup_Estado.add(this.personaBuscarView.jRadioButton_Activo);
        this.personaBuscarView.buttonGroup_Estado.add(this.personaBuscarView.jRadioButton_Inactivo);
        this.personaBuscarView.jRadioButton_Activo.setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.personaBuscarView.btBuscar) {
            llenarTabla(this.personaBuscarView.jTBuscarPersona);
        }

        if (e.getSource() == this.personaBuscarView.btSeleccionar) {
            int fila = this.personaBuscarView.jTBuscarPersona.getSelectedRow();
            if (fila != -1) {
                String cedula = this.personaBuscarView.jTBuscarPersona.getValueAt(fila, 0).toString();
                txtRespuesta.setText(cedula);
                this.personaBuscarView.setVisible(false);
            }
        }

        if (e.getSource() == this.personaBuscarView.jRadioButton_Activo
                || e.getSource() == this.personaBuscarView.jRadioButton_Inactivo) {
            this.llenarTabla(this.personaBuscarView.jTBuscarPersona);
        }
    }

    public void llenarTabla(JTable tablaPersona) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaPersona.setModel(modeloTabla);

        modeloTabla.addColumn("Cedula");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Estado");
        Object fila[] = new Object[4];

        String Sql = "where nombre like '%" + this.personaBuscarView.txtBuscar.getText() + "%'"
                + " or cedula like '%" + this.personaBuscarView.txtBuscar.getText() + "%'";

        try {
            for (Object oAux : PersonaBLModelo.obtenerConWhere(new Persona(), Sql)) {
                Persona p = (Persona) oAux;
                if (this.personaBuscarView.jRadioButton_Activo.isSelected()) {
                    if (p.getEstado() == true) {
                        fila[0] = p.getCedula();
                        fila[1] = p.getNombre();
                        fila[2] = p.getApellidos();
                        if (p.getEstado() == true) {
                            fila[3] = "Activo";
                        }
                        modeloTabla.addRow(fila);
                    }
                }
                if (this.personaBuscarView.jRadioButton_Inactivo.isSelected()) {
                    if (p.getEstado() == false) {
                        fila[0] = p.getCedula();
                        fila[1] = p.getNombre();
                        fila[2] = p.getApellidos();
                        if (p.getEstado() == false) {
                            fila[3] = "Inactivo";
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
