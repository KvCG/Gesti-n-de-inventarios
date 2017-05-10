package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.BodegaBL;
import cr.ac.una.ingenieria.appMVC.Domain.Bodega;
import cr.ac.una.ingenieria.appMVC.Vista.MantBodegaBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Bodega;
import cr.ac.una.ingenieria.appMVC.Vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class BodegaControlador implements ActionListener {

    private Modulo_Bodega ModBodegaView;
    private BodegaBL Bodbl;
    public PantallaPrincipal panPrincipal;

    public BodegaControlador(Modulo_Bodega ModBodegaView, BodegaBL Bodbl) {
        this.ModBodegaView = ModBodegaView;
        this.Bodbl = Bodbl;

        this.ModBodegaView.btn_Guardar.addActionListener(this);
        this.ModBodegaView.btn_Editar.addActionListener(this);
        this.ModBodegaView.btn_Buscar.addActionListener(this);
        this.ModBodegaView.btn_Cancelar.addActionListener(this);
        this.ModBodegaView.btn_Eliminar.addActionListener(this);
        iniciarPantalla();
    }

    public void iniciarPantalla() {
        this.ModBodegaView.btn_Editar.setEnabled(false);
        this.ModBodegaView.jtf_IDBodega.setEnabled(false);
    }

//--------------------get's--------------------
    public Modulo_Bodega getModBodegaView() {
        return ModBodegaView;
    }

    public BodegaBL getBodbl() {
        return Bodbl;
    }

//--------------------set's--------------------
    public void setModBodegaView(Modulo_Bodega ModBodegaView) {
        this.ModBodegaView = ModBodegaView;
    }

    public void setBodbl(BodegaBL Bodbl) {
        this.Bodbl = Bodbl;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.ModBodegaView.btn_Guardar) {
            if (!this.ModBodegaView.jtf_TipoBodega.getText().isEmpty()
                    && !this.ModBodegaView.jtf_Nombre.getText().isEmpty()) {
                try {
                    Bodega bo = new Bodega();
                    bo.setTipo(this.ModBodegaView.jtf_TipoBodega.getText());
                    bo.setNombre(this.ModBodegaView.jtf_Nombre.getText());
                    String estado = this.ModBodegaView.jcb_Estado.getSelectedItem().toString();

                    if (estado.equals("Activa")) {
                        bo.setEstado(true);
                    } else {
                        bo.setEstado(false);
                    }

                    this.Bodbl.insertar(bo);
                    JOptionPane.showMessageDialog(null, "SE AGREGO LA BODEGA CORRECTAMENTE", ""
                            + "AGREGANDO BODEGA", JOptionPane.INFORMATION_MESSAGE);

                    this.ModBodegaView.jtf_IDBodega.setText("");
                    this.ModBodegaView.jtf_TipoBodega.setText("");
                    this.ModBodegaView.jtf_Nombre.setText("");
                    this.ModBodegaView.jcb_Estado.setSelectedIndex(0);
                    this.cargarBodegaCombo(ArticuloControlador.mantArticuloView.jcbBodega);
                } catch (Exception e) {
                    Logger.getLogger(BodegaControlador.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "SE ENCUENTRAN ESPACIOS EN BLANCO",
                        "ESPACIOS EN BLANCO", JOptionPane.WARNING_MESSAGE);
            }
        }//Fin evento boton guardar

        if (ae.getSource() == this.ModBodegaView.btn_Editar) {
            if (!"".equals(this.ModBodegaView.jtf_TipoBodega.getText())
                    || !"".equals(this.ModBodegaView.jtf_Nombre.getText())) {
                Bodega bo = new Bodega();
                bo.setIdBodega(Integer.parseInt(this.ModBodegaView.jtf_IDBodega.getText()));
                try {
                    bo.setTipo(this.ModBodegaView.jtf_TipoBodega.getText());
                    bo.setNombre(this.ModBodegaView.jtf_Nombre.getText());
                    String estado = this.ModBodegaView.jcb_Estado.getSelectedItem().toString();

                    if (estado.equals("Activa")) {
                        bo.setEstado(true);
                    } else {
                        bo.setEstado(false);
                    }

                    this.Bodbl.modificar(bo);
                    JOptionPane.showMessageDialog(null, "SE AGREGO LA BODEGA CORRECTAMENTE", ""
                            + "AGREGANDO BODEGA", JOptionPane.INFORMATION_MESSAGE);
                    this.ModBodegaView.jtf_IDBodega.setText("");
                    this.ModBodegaView.jtf_TipoBodega.setText("");
                    this.ModBodegaView.jtf_Nombre.setText("");
                    this.ModBodegaView.jcb_Estado.setSelectedIndex(0);
                    this.ModBodegaView.btn_Editar.setEnabled(false);
                    this.ModBodegaView.btn_Guardar.setEnabled(true);
                    this.cargarBodegaCombo(ArticuloControlador.mantArticuloView.jcbBodega);
                } catch (Exception e) {
                    Logger.getLogger(BodegaControlador.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "DIGITE EL TIPO O NOMBRE DE BODEGA",
                        "ESPACIOS EN BLANCO", JOptionPane.WARNING_MESSAGE);
            }
        }//Fin evento boton editar

        if (ae.getSource() == this.ModBodegaView.btn_Buscar) {
            this.ModBodegaView.btn_Guardar.setEnabled(false);
            this.ModBodegaView.btn_Eliminar.setEnabled(true);
            this.ModBodegaView.btn_Editar.setEnabled(true);
            this.ModBodegaView.btn_Cancelar.setEnabled(true);
            this.ModBodegaView.btn_Buscar.setEnabled(true);

            MantBodegaBuscar Mant_BuscarBodega = new MantBodegaBuscar();

            BodegaBuscarControlador BuscarBodegaControl = new BodegaBuscarControlador(Mant_BuscarBodega, Bodbl,
                    this.ModBodegaView.jtf_IDBodega,
                    this.ModBodegaView.jtf_TipoBodega,
                    this.ModBodegaView.jtf_Nombre,
                    this.ModBodegaView.jcb_Estado);

            BuscarBodegaControl.getBuscarBodegaView().setVisible(true);
        }//Fin evento boton buscar

        if (ae.getSource() == this.ModBodegaView.btn_Cancelar) {
            this.ModBodegaView.jtf_IDBodega.setText("");
            this.ModBodegaView.jtf_TipoBodega.setText("");
            this.ModBodegaView.jtf_Nombre.setText("");
            this.ModBodegaView.jcb_Estado.setSelectedIndex(0);
            this.ModBodegaView.btn_Guardar.setEnabled(true);
            this.ModBodegaView.btn_Eliminar.setEnabled(true);
            this.ModBodegaView.btn_Editar.setEnabled(false);
            this.ModBodegaView.btn_Cancelar.setEnabled(true);
            this.ModBodegaView.btn_Buscar.setEnabled(true);
        }//Fin evento boton cancelar

        if (ae.getSource() == this.ModBodegaView.btn_Eliminar) {
            if (!"".equals(this.ModBodegaView.jtf_IDBodega.getText())) {
                try {
                    Bodega bo = new Bodega();
                    bo.setIdBodega(Integer.parseInt(this.ModBodegaView.jtf_IDBodega.getText()));

                    this.Bodbl.eliminar(bo);
                    JOptionPane.showMessageDialog(null, "SE ELIMIINO LA BODEGA CORRECTAMENTE", ""
                            + "ELIMINANDO BODEGA", JOptionPane.INFORMATION_MESSAGE);

                    this.ModBodegaView.jtf_IDBodega.setText("");
                    this.ModBodegaView.jtf_TipoBodega.setText("");
                    this.ModBodegaView.jtf_Nombre.setText("");
                    this.ModBodegaView.jcb_Estado.setSelectedIndex(0);
                    this.ModBodegaView.btn_Editar.setEnabled(false);
                    this.ModBodegaView.btn_Guardar.setEnabled(true);
                    this.cargarBodegaCombo(ArticuloControlador.mantArticuloView.jcbBodega);
                } catch (Exception e) {
                    Logger.getLogger(BodegaControlador.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA BODEGA",
                        "ELIMINANDO BODEGA", JOptionPane.WARNING_MESSAGE);
            }
        }//Fin evento boton eliminar
    }

    public void cargarBodegaCombo(JComboBox jcbBod) {
        ArticuloControlador.mantArticuloView.jcbBodega.removeAllItems();
        DefaultComboBoxModel ModeloJcb = new DefaultComboBoxModel();
        jcbBod.setModel(ModeloJcb);
        this.Bodbl = new BodegaBL();
        try {
            for (Bodega b : this.Bodbl.obtenerTodos()) {
                if (b.getEstado() == true) {
                    ModeloJcb.addElement(b.getTipo().toString());
                }
            }
        } catch (Exception e) {
        }

    }
}
