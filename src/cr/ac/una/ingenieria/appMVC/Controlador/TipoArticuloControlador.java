package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.TipoArticuloBL;
import cr.ac.una.ingenieria.appMVC.Domain.TipoArticulo;
import cr.ac.una.ingenieria.appMVC.Vista.MantBusarTipoArticulo;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_TipoArticulo;
import cr.ac.una.ingenieria.appMVC.Vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class TipoArticuloControlador implements ActionListener {

    private Modulo_TipoArticulo Mod_TipoArtView;
    private TipoArticuloBL TipArtBL;
    public PantallaPrincipal panPrincipal;

    public TipoArticuloControlador(Modulo_TipoArticulo Mod_TipoArtView, TipoArticuloBL TipArtBL) {
        this.Mod_TipoArtView = Mod_TipoArtView;
        this.TipArtBL = TipArtBL;

        this.Mod_TipoArtView.btn_Guardar.addActionListener(this);
        this.Mod_TipoArtView.btn_Editar.addActionListener(this);
        this.Mod_TipoArtView.btn_Buscar.addActionListener(this);
        this.Mod_TipoArtView.btn_Cancelar.addActionListener(this);
        this.Mod_TipoArtView.btn_Eliminar.addActionListener(this);
        this.Mod_TipoArtView.jtf_IdTipoArticulo.setVisible(false);
        iniciarPantalla();
    }

//--------------------get's--------------------
    public Modulo_TipoArticulo getMod_TipoArtView() {
        return Mod_TipoArtView;
    }

    public TipoArticuloBL getTipArtBL() {
        return TipArtBL;
    }
//--------------------Set's--------------------

    public void setMod_TipoArtView(Modulo_TipoArticulo Mod_TipoArtView) {
        this.Mod_TipoArtView = Mod_TipoArtView;
    }

    public void setTipArtBL(TipoArticuloBL TipArtBL) {
        this.TipArtBL = TipArtBL;
    }

    public void iniciarPantalla() {
        this.Mod_TipoArtView.btn_Editar.setEnabled(false);
        this.Mod_TipoArtView.jtf_IdTipoArticulo.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.Mod_TipoArtView.btn_Guardar) {
            if (!"".equals(this.Mod_TipoArtView.jtf_Descripcion.getText())) {
                try {
                    TipoArticulo tipArt = new TipoArticulo();
                    tipArt.setDescripcion(this.Mod_TipoArtView.jtf_Descripcion.getText());
                    String estado = this.Mod_TipoArtView.jcb_Estado.getSelectedItem().toString();

                    if (estado.equals("ACTIVO")) {
                        tipArt.setEstado(true);
                    } else {
                        tipArt.setEstado(false);
                    }

                    this.TipArtBL.insertar(tipArt);

                    JOptionPane.showMessageDialog(null, "SE AGREGO EL TIPO DE ARTICULO CORRECTAMENTE", ""
                            + "AGREGANDO TIPO DE ARTICULO", JOptionPane.INFORMATION_MESSAGE);

                    this.Mod_TipoArtView.jtf_IdTipoArticulo.setText("");
                    this.Mod_TipoArtView.jtf_Descripcion.setText("");
                    this.Mod_TipoArtView.jcb_Estado.setSelectedIndex(0);
                    this.cargarTipoArtCombo(ArticuloControlador.mantArticuloView.jcbTipo);
                } catch (Exception e) {
                    Logger.getLogger(TipoArticuloControlador.class.getName()).log(Level.SEVERE, null, e);
                    System.out.println(e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "POR FAVOR DIGITE EL TIPO DE ARTICULO"
                        + "\n EN EL CAMPO DESCRIPCION", "ESPAIO VACIO", JOptionPane.WARNING_MESSAGE);
            }
        }//fin agregar

        if (ae.getSource() == this.Mod_TipoArtView.btn_Editar) {
            if (!"".equals(this.Mod_TipoArtView.jtf_Descripcion.getText())) {
                TipoArticulo tipAr = new TipoArticulo();
                tipAr.setCodigo(Integer.parseInt(this.Mod_TipoArtView.jtf_IdTipoArticulo.getText()));
                try {
                    tipAr.setDescripcion(this.Mod_TipoArtView.jtf_Descripcion.getText());
                    String estado = this.Mod_TipoArtView.jcb_Estado.getSelectedItem().toString();

                    if (estado.equals("Activo")) {
                        tipAr.setEstado(true);
                    } else {
                        tipAr.setEstado(false);
                    }

                    this.TipArtBL.modificar(tipAr);
                    JOptionPane.showMessageDialog(null, "Se actulaizo conrectamente", ""
                            + "Tipo Articulo", JOptionPane.YES_OPTION);
                    this.Mod_TipoArtView.jtf_IdTipoArticulo.setText("");
                    this.Mod_TipoArtView.jtf_Descripcion.setText("");
                    this.Mod_TipoArtView.jcb_Estado.setSelectedIndex(0);
                    this.Mod_TipoArtView.btn_Editar.setEnabled(false);
                    this.Mod_TipoArtView.btn_Guardar.setEnabled(true);
                    this.cargarTipoArtCombo(ArticuloControlador.mantArticuloView.jcbTipo);
                } catch (Exception e) {
                    Logger.getLogger(TipoArticuloControlador.class.getName()).log(Level.SEVERE, null, e);
                }

            } else {
                JOptionPane.showMessageDialog(null, "DIGITE EL TIPO DEL ARTICULO",
                        "ESPACIOS EN BLANCO", JOptionPane.WARNING_MESSAGE);
            }
        }//fin editar
        
        if(ae.getSource() == this.Mod_TipoArtView.btn_Buscar){
            this.Mod_TipoArtView.btn_Guardar.setEnabled(false);
            this.Mod_TipoArtView.btn_Eliminar.setEnabled(true);
            this.Mod_TipoArtView.btn_Editar.setEnabled(true);
            this.Mod_TipoArtView.btn_Cancelar.setEnabled(true);
            this.Mod_TipoArtView.btn_Buscar.setEnabled(true);
            
            MantBusarTipoArticulo mantTipoArtBusar = new MantBusarTipoArticulo();
            TipoArticuloBuscarControlador tipoArtBuscraControl = new TipoArticuloBuscarControlador(mantTipoArtBusar,
                    TipArtBL, this.Mod_TipoArtView.jtf_IdTipoArticulo,
                    this.Mod_TipoArtView.jtf_Descripcion,this.Mod_TipoArtView.jcb_Estado);
            tipoArtBuscraControl.getMantBusarTipoArticuloView().setVisible(true);
        }//fin buscar
        
        if(ae.getSource() == this.Mod_TipoArtView.btn_Cancelar){
            this.Mod_TipoArtView.jtf_IdTipoArticulo.setText("");
            this.Mod_TipoArtView.jtf_Descripcion.setText("");
            this.Mod_TipoArtView.jcb_Estado.setSelectedIndex(0);
            this.Mod_TipoArtView.btn_Guardar.setEnabled(true);
            this.Mod_TipoArtView.btn_Editar.setEnabled(false);
            this.Mod_TipoArtView.btn_Buscar.setEnabled(true);
            this.Mod_TipoArtView.btn_Cancelar.setEnabled(true);
            this.Mod_TipoArtView.btn_Eliminar.setEnabled(true);
        }//fin cancelar
        
        if(ae.getSource() == this.Mod_TipoArtView.btn_Eliminar){
            if(!"".equals(this.Mod_TipoArtView.jtf_IdTipoArticulo.getText())){
                try {
                    TipoArticulo tipArt = new TipoArticulo();
                    tipArt.setCodigo(Integer.parseInt(this.Mod_TipoArtView.jtf_IdTipoArticulo.getText()));
                    this.TipArtBL.eliminar(tipArt);
                    JOptionPane.showMessageDialog(null,"SE ELIMIINO CORRECTAMENTE",""
                            + "ELIMINANDO ",JOptionPane.INFORMATION_MESSAGE);
                    this.Mod_TipoArtView.jtf_IdTipoArticulo.setText("");
                    this.Mod_TipoArtView.jtf_Descripcion.setText("");
                    this.Mod_TipoArtView.jcb_Estado.setSelectedIndex(0);
                    this.Mod_TipoArtView.btn_Guardar.setEnabled(true);
                    this.Mod_TipoArtView.btn_Editar.setEnabled(false);
                    this.cargarTipoArtCombo(ArticuloControlador.mantArticuloView.jcbTipo);
                } catch (Exception e) {
                    Logger.getLogger(TipoArticuloControlador.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }//fin eliminar
    }
    
    
    public void cargarTipoArtCombo(JComboBox jcbTipArt) {
        ArticuloControlador.mantArticuloView.jcbTipo.removeAllItems();
        DefaultComboBoxModel Modelojcb = new DefaultComboBoxModel();
        jcbTipArt.setModel(Modelojcb);
        this.TipArtBL = new TipoArticuloBL();
        try {
            for (TipoArticulo t : this.TipArtBL.obtenerTodos()) {
                if (t.getEstado() == true) {
                    Modelojcb.addElement(t.getDescripcion().toString());
                }
            }
        } catch (Exception e) {
        }
    }
}
