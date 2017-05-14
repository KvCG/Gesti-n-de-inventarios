package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.MantUsuarioBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UsuarioBuscarControlador implements ActionListener {

    private MantUsuarioBuscar usuarioBuscarView;
    private UsuarioBL UsuarioBLModelo;
    private JTextField txtRespuesta;

    /**
     *
     */
    public UsuarioBuscarControlador() {
    }

    /**
     *
     * @param usuarioBuscarView
     * @param UsuarioBLModelo
     * @param txtRespuesta
     */
    public UsuarioBuscarControlador(MantUsuarioBuscar usuarioBuscarView, UsuarioBL UsuarioBLModelo, JTextField txtRespuesta) {
        this.usuarioBuscarView = usuarioBuscarView;
        this.UsuarioBLModelo = UsuarioBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.usuarioBuscarView.btBuscar.addActionListener(this);
        this.usuarioBuscarView.btSeleccionar.addActionListener(this);
        this.usuarioBuscarView.jRadioButton_Activo.addActionListener(this);
        this.usuarioBuscarView.jRadioButton_Inactivo.addActionListener(this);
        this.iniciarRadioBoton();
        llenarTabla(this.usuarioBuscarView.jTableusuarios);
    }

    /**
     *
     * @return
     */
    public MantUsuarioBuscar getUsuarioBuscarView() {
        return usuarioBuscarView;
    }

    /**
     *
     * @param usuarioBuscarView
     */
    public void setUsuarioBuscarView(MantUsuarioBuscar usuarioBuscarView) {
        this.usuarioBuscarView = usuarioBuscarView;
    }

    /**
     *
     * @return
     */
    public UsuarioBL getUsuarioBLModelo() {
        return UsuarioBLModelo;
    }

    /**
     *
     * @param UsuarioBLModelo
     */
    public void setUsuarioBLModelo(UsuarioBL UsuarioBLModelo) {
        this.UsuarioBLModelo = UsuarioBLModelo;
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

    public void iniciarRadioBoton() {
        this.usuarioBuscarView.buttonGroup_Estado.add(this.usuarioBuscarView.jRadioButton_Activo);
        this.usuarioBuscarView.buttonGroup_Estado.add(this.usuarioBuscarView.jRadioButton_Inactivo);
        this.usuarioBuscarView.jRadioButton_Activo.setSelected(true);
    }

    /**
     *
     * @param tablaUsuarios
     */
    public void llenarTabla(JTable tablaUsuarios) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaUsuarios.setModel(modeloTabla);
        modeloTabla.addColumn("Usuario");
        modeloTabla.addColumn("Estado");
        Object fila[] = new Object[2];

        String Sql = "where alias like '%" + this.usuarioBuscarView.txtBuscar.getText() + "%'";
        try {
            for (Object oAux : UsuarioBLModelo.obtenerConWhere(new Usuario(), Sql)) {
                Usuario u = (Usuario) oAux;
                if (this.usuarioBuscarView.jRadioButton_Activo.isSelected()) {
                    if (u.getEstado() == true) {
                        fila[0] = u.getAlias();
                        if (u.getEstado() == true) {
                            fila[1] = "Activo";
                        }
                        modeloTabla.addRow(fila);
                    }
                }
                if (this.usuarioBuscarView.jRadioButton_Inactivo.isSelected()) {
                    if (u.getEstado() == false) {
                        fila[0] = u.getAlias();
                        if (u.getEstado() == false) {
                            fila[1] = "inactivo";
                        }
                        modeloTabla.addRow(fila);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.usuarioBuscarView.btBuscar) {
            llenarTabla(this.usuarioBuscarView.jTableusuarios);
        }

        if (e.getSource() == this.usuarioBuscarView.btSeleccionar) {
            int fila = this.usuarioBuscarView.jTableusuarios.getSelectedRow();
            if (fila != -1) {
                String alias = this.usuarioBuscarView.jTableusuarios.getValueAt(fila, 0).toString();
                txtRespuesta.setText(String.valueOf(alias));
                this.usuarioBuscarView.setVisible(false);
            }
        }
        
        if(e.getSource() == this.usuarioBuscarView.jRadioButton_Activo ||
           e.getSource() == this.usuarioBuscarView.jRadioButton_Inactivo){
            this.llenarTabla(this.usuarioBuscarView.jTableusuarios);
        }
    }
}