package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Michael
 */
public class PersonaControlador implements ActionListener, DocumentListener{
    private Modulo_Registo_Persona Mod_Reg_PersonaView;
    private PersonaBL PersBL;

    public PersonaControlador() {
    }
    
    
    public PersonaControlador(Modulo_Registo_Persona Mod_Reg_PersonaView, PersonaBL PersBL) {
        this.Mod_Reg_PersonaView = Mod_Reg_PersonaView;
        this.PersBL = PersBL;
        this.Mod_Reg_PersonaView.txtCodigoBuscar.getDocument().addDocumentListener(this);
        this.Mod_Reg_PersonaView.btGuardar.addActionListener(this);
        this.Mod_Reg_PersonaView.btModificar.addActionListener(this);
        this.Mod_Reg_PersonaView.btBuscar.addActionListener(this);
        this.Mod_Reg_PersonaView.btCancelar.addActionListener(this);
        this.Mod_Reg_PersonaView.btEliminar.addActionListener(this);
        this.Mod_Reg_PersonaView.jtxtId.getDocument().addDocumentListener(this);
        this.Mod_Reg_PersonaView.btModificar.setEnabled(false);
        this.Mod_Reg_PersonaView.btEliminar.setEnabled(false);
        this.Mod_Reg_PersonaView.txtCodigoBuscar.setVisible(false);
        this.Mod_Reg_PersonaView.jtxtId.setVisible(false);
        inicializarPantalla();
        
    }

    public Modulo_Registo_Persona getMod_Reg_PersonaView() {
        return Mod_Reg_PersonaView;
    }

    public void setMod_Reg_PersonaView(Modulo_Registo_Persona Mod_Reg_PersonaView) {
        this.Mod_Reg_PersonaView = Mod_Reg_PersonaView;
    }

    public PersonaBL getPersBL() {
        return PersBL;
    }

    public void setPersBL(PersonaBL PersBL) {
        this.PersBL = PersBL;
    }

  
    
 
      private void inicializarPantalla() {
        
   }
       
    private boolean isEmpty() {
        if (this.Mod_Reg_PersonaView.jtxtCedula.getText().equals("")
                || this.Mod_Reg_PersonaView.jtxtNombre.getText().equals("")
                || this.Mod_Reg_PersonaView.jtxtApellido.getText().equals("")
                || this.Mod_Reg_PersonaView.jtxtCorreo.getText().equals("")) {
            return true;
        }
        return false;
    }

    private void clean() {
        this.Mod_Reg_PersonaView.jtxtCedula.setText(null);
        this.Mod_Reg_PersonaView.jtxtNombre.setText(null);
        this.Mod_Reg_PersonaView.jtxtApellido.setText(null);
        this.Mod_Reg_PersonaView.jtxtCorreo.setText(null);
        
        
    }
    

   
    
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Mod_Reg_PersonaView.btGuardar) {
            if (this.isEmpty()) {
                JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error faltan espacios por rellenar:", "Error al ingresar datos de la Persona", JOptionPane.ERROR_MESSAGE);

            } else {
                Persona p = new Persona();
                //p.setIdpersona(1);
                p.setCedula(this.Mod_Reg_PersonaView.jtxtCedula.getText());
                p.setNombre(this.Mod_Reg_PersonaView.jtxtNombre.getText());
                p.setApellidos(this.Mod_Reg_PersonaView.jtxtApellido.getText());
                p.setCorreo(this.Mod_Reg_PersonaView.jtxtCorreo.getText());
                try {
                    if (this.isEmail(this.Mod_Reg_PersonaView.jtxtCorreo.getText())) {
                        this.PersBL.insertar(p);
                        JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "La persona ha sido ingresada correctamente", "Persona Agreagada", JOptionPane.INFORMATION_MESSAGE);
                        this.clean();
                        this.Mod_Reg_PersonaView.btEliminar.setEnabled(false);
                        this.Mod_Reg_PersonaView.btModificar.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error ingrese el correo nuevamente:", "Error en ingresar correo", JOptionPane.ERROR_MESSAGE);
                        this.Mod_Reg_PersonaView.jtxtCorreo.setText(null);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error al agregar a la Persona:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error al agregar a la Persona:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == this.Mod_Reg_PersonaView.btEliminar) {
            Persona p = new Persona();
            String cedula = this.Mod_Reg_PersonaView.jtxtCedula.getText();
            p.setCedula(cedula);
            try {
                int resp;
                resp = JOptionPane.showConfirmDialog(Mod_Reg_PersonaView, "Esta seguro que desea eliminar a la Persona");
                if (resp == 0) {
                    PersBL.eliminar(p);
                    JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "La Persona ha sido eliminada correctamente", "Persona Eliminada", JOptionPane.INFORMATION_MESSAGE);
                    this.Mod_Reg_PersonaView.jtxtCedula.setText(null);
                    this.Mod_Reg_PersonaView.jtxtNombre.setText(null);
                    this.Mod_Reg_PersonaView.jtxtApellido.setText(null);
                    this.Mod_Reg_PersonaView.jtxtCorreo.setText(null);
                    this.Mod_Reg_PersonaView.btEliminar.setEnabled(false);
                }
                if (resp == 1) {
                    JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "La Persona no sera eliminada ",
                            "Persona Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error al eliminar a la Persona:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error al eliminar a la Persona:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == this.Mod_Reg_PersonaView.btModificar) {
            if (this.isEmpty()) {
                JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error primero debe seleccionar una Persona:", "Error en ingresar Persona", JOptionPane.ERROR_MESSAGE);
            } else {
                Persona p = new Persona();
                p.setCedula(this.Mod_Reg_PersonaView.jtxtCedula.getText());

                try {
                    if (this.isEmail(this.Mod_Reg_PersonaView.jtxtCorreo.getText())) {
                        p = PersBL.obtenerPorId(p);
                        p.setCedula(this.Mod_Reg_PersonaView.jtxtCedula.getText());
                        p.setNombre(this.Mod_Reg_PersonaView.jtxtNombre.getText());
                        p.setApellidos(this.Mod_Reg_PersonaView.jtxtApellido.getText());
                        p.setCorreo(this.Mod_Reg_PersonaView.jtxtCorreo.getText());
                        this.PersBL.modificar(p);
                        this.clean();
                        this.Mod_Reg_PersonaView.btEliminar.setEnabled(false);
                        this.Mod_Reg_PersonaView.jtxtCedula.setEnabled(true);
                        JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "La Persona ha sido modificada correctamente",
                                "Persona madificada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error ingrese el correo nuevamente:", "Error en ingresar correo", JOptionPane.ERROR_MESSAGE);
                        this.Mod_Reg_PersonaView.jtxtCorreo.setText(null);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error al modificar a la Persona:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error al modificar a la Persona:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        if (e.getSource() == this.Mod_Reg_PersonaView.btCancelar) {
            this.clean();
            this.Mod_Reg_PersonaView.btEliminar.setEnabled(false);
            this.Mod_Reg_PersonaView.jtxtCedula.setEnabled(true);
        }

        if (e.getSource() == this.Mod_Reg_PersonaView.btBuscar) {
            if (!Mod_Reg_PersonaView.jtxtCedula.getText().isEmpty()) {
                MantPersonaBuscar mantPersonaBuscarView = new MantPersonaBuscar();
                PersonaBuscarControlador personaBControlador;
                personaBControlador = new PersonaBuscarControlador(mantPersonaBuscarView, PersBL, this.Mod_Reg_PersonaView.txtCodigoBuscar);
                personaBControlador.getPersonaBuscarView().setVisible(true);
                this.Mod_Reg_PersonaView.btEliminar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Debes digitar una cedula primero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarPersona();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarPersona();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarPersona();
    }

    private void cargarPersona() {
        Persona p = new Persona();
        if (!this.Mod_Reg_PersonaView.txtCodigoBuscar.getText().isEmpty()) {
            p.setCedula(this.Mod_Reg_PersonaView.txtCodigoBuscar.getText());
            try {
                p = PersBL.obtenerPorId(p);
                this.Mod_Reg_PersonaView.jtxtCedula.setText(p.getCedula());
                this.Mod_Reg_PersonaView.jtxtNombre.setText(p.getNombre());
                this.Mod_Reg_PersonaView.jtxtApellido.setText(p.getApellidos());
                this.Mod_Reg_PersonaView.jtxtCorreo.setText(p.getCorreo());
                this.Mod_Reg_PersonaView.btModificar.setEnabled(true);
                this.Mod_Reg_PersonaView.jtxtCedula.setEnabled(false);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(Mod_Reg_PersonaView, "Error no se pudo consultar la Persona (" + ex.getMessage() + ")",
                        "Error al cargar a la Persona", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
