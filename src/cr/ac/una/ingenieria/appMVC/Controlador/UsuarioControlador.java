package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.MantUsuarioBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Persona;
import java.awt.event.ActionEvent;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UsuarioControlador implements ActionListener, DocumentListener {

    private Modulo_Registo_Usuario mantUsuarioView;
    private UsuarioBL usuarioBlModelo;
    private PersonaBL personaBLModelo;
    private MantPersonaBuscar mantPersonaBView;
    private Modulo_Registo_Persona mantPersonaView;

    public UsuarioControlador(Modulo_Registo_Usuario mantUsuarioview, UsuarioBL usuarioBlModelo, PersonaBL personaBLModelo, Modulo_Registo_Persona mantPersonaView, MantPersonaBuscar mantPersonaBView) {
        this.mantUsuarioView = mantUsuarioview;
        this.usuarioBlModelo = usuarioBlModelo;
        this.mantPersonaView = mantPersonaView;
        this.personaBLModelo = personaBLModelo;
        this.mantPersonaBView = mantPersonaBView;
        this.mantUsuarioView.btBuscar.addActionListener(this);
        this.mantUsuarioView.btInsertar.addActionListener(this);
        this.mantUsuarioView.btCancelar.addActionListener(this);
        this.mantUsuarioView.btEliminar.addActionListener(this);
        this.mantUsuarioView.btModificar.addActionListener(this);
        this.mantUsuarioView.btEliminar.setEnabled(false);
        this.mantUsuarioView.btModificar.setEnabled(false);
        this.mantUsuarioView.btBuscarPersona.addActionListener(this);
        this.mantUsuarioView.txtUsuarioBuscar.getDocument().addDocumentListener(this);
        this.mantUsuarioView.txtPersonaId.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                if (!mantUsuarioView.txtPersonaId.getText().isEmpty()) {
                    cargaPersona();
                }
            }
        });

        this.mantUsuarioView.btEliminar.setEnabled(false);
        this.mantUsuarioView.txtUsuarioBuscar.setVisible(false);
        this.mantUsuarioView.txtCedula.setEnabled(false);
        this.mantUsuarioView.txtPersonaId.setVisible(false);
        
    }

    public UsuarioControlador() {
    }

    public PersonaBL getPersonaBLModelo() {
        return personaBLModelo;
    }

    public void setPersonaBLModelo(PersonaBL personaBLModelo) {
        this.personaBLModelo = personaBLModelo;
    }

    public Modulo_Registo_Persona getMantPersonaView() {
        return mantPersonaView;
    }

    /**
     *
     * @return
     */
    public void setMantPersonaView(Modulo_Registo_Persona mantPersonaView) {
        this.mantPersonaView = mantPersonaView;
    }

    public Modulo_Registo_Usuario getMantUsuarioview() {
        return mantUsuarioView;
    }

    /**
     *
     * @param mantUsuarioview
     */
    public void setMantUsuarioview(Modulo_Registo_Usuario mantUsuarioview) {
        this.mantUsuarioView = mantUsuarioview;
    }

    /**
     *
     * @return
     */
    public UsuarioBL getUsuarioBlModelo() {
        return usuarioBlModelo;
    }

    /**
     *
     * @param usuarioBlModelo
     */
    public void setUsuarioBlModelo(UsuarioBL usuarioBlModelo) {
        this.usuarioBlModelo = usuarioBlModelo;
    }

    private boolean isEmpty() {
        if (this.mantUsuarioView.txtUsuario.getText().equals("")
                || this.mantUsuarioView.txtContraseña.getPassword().equals("")) {
            return true;
        }
        return false;
    }

    private void clean() {
        this.mantUsuarioView.txtContraseña.setText(null);
        this.mantUsuarioView.txtUsuario.setText(null);
        this.mantUsuarioView.txtCedula.setText(null);
        //this.mantUsuarioView.txtPersonaId.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mantUsuarioView.btInsertar) {
            if (this.isEmpty()) {
                JOptionPane.showMessageDialog(mantUsuarioView, "Error faltan espacios por rellenar", "Error en ingresar el Usuario", JOptionPane.ERROR_MESSAGE);
            } else {
                Usuario u = new Usuario();
                u.setAlias(this.mantUsuarioView.txtUsuario.getText());
                u.setPassword(String.valueOf(this.mantUsuarioView.txtContraseña.getPassword()));
                
                u.setRol(this.mantUsuarioView.cbRol.getSelectedIndex());
                Persona p = new Persona();
                p.setCedula(this.mantUsuarioView.txtPersonaId.getText());
                try {
                    p = personaBLModelo.obtenerPorId(p);
                    u.setIdPersona(p.getIdpersona());
                    if (this.isPassword(String.valueOf(this.mantUsuarioView.txtContraseña.getPassword()))) {
                        this.usuarioBlModelo.insertar(u);
                        JOptionPane.showMessageDialog(mantUsuarioView, "El Usuario ha sido ingresado correctamente", "Usuario Agreagado", JOptionPane.INFORMATION_MESSAGE);
                        this.clean();
                        this.mantUsuarioView.btEliminar.setEnabled(false);
                        this.mantUsuarioView.btModificar.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(mantUsuarioView, "La contraseña debe poseer mayusculas, minusculas, numeros y poseer de 8 a 15 caracteres",
                                " Error al ingresar la contraseña:", JOptionPane.ERROR_MESSAGE);
                        this.mantUsuarioView.txtContraseña.setText(null);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantUsuarioView, "Error al agregar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantUsuarioView, "Error al agregar el Usuario:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        if (e.getSource() == this.mantUsuarioView.btEliminar) {
            Usuario u = new Usuario();
            String alias = this.mantUsuarioView.txtUsuario.getText();
            u.setAlias(alias);
            try {
                int resp;
                resp = JOptionPane.showConfirmDialog(mantUsuarioView, "Esta seguro que desea eliminar el Usuario");
                if (resp == 0) {
                    usuarioBlModelo.eliminar(u);
                    JOptionPane.showMessageDialog(mantUsuarioView, "El Usuario ha sido eliminado correctamente",
                            "Usuario Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    this.mantUsuarioView.txtContraseña.setText(null);
                    this.mantUsuarioView.txtCedula.setText(null);
                    this.mantUsuarioView.txtPersonaId.setText(null);
                    this.mantUsuarioView.txtUsuario.setText(null);
                    this.mantUsuarioView.btEliminar.setEnabled(false);

                }
                if (resp == 1) {
                    JOptionPane.showMessageDialog(mantUsuarioView, "El Usuario no sera eliminado ",
                            "Usuario Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioView, "Error al eliminar el Usuario:" + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantUsuarioView, "Error al eliminar el Usuario:" + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == this.mantUsuarioView.btModificar) {
            
            if (this.isEmpty()) {
                JOptionPane.showMessageDialog(mantUsuarioView, "Error primero debe seleccionar un Usuario:", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Usuario u = new Usuario();
                u.setAlias(this.mantUsuarioView.txtUsuario.getText());

                try {
                    if (this.isPassword(String.valueOf(this.mantUsuarioView.txtContraseña.getPassword()))) {
                        u = usuarioBlModelo.obtenerPorId(u);
                        u.setAlias(this.mantUsuarioView.txtUsuario.getText());
                        u.setPassword(String.valueOf(this.mantUsuarioView.txtContraseña.getPassword()));
                        u.setRol(this.mantUsuarioView.cbRol.getSelectedIndex());
                        this.usuarioBlModelo.modificar(u);
                        this.clean();
                        this.mantUsuarioView.btEliminar.setEnabled(false);
                        this.mantUsuarioView.txtUsuario.setEnabled(true);

                        JOptionPane.showMessageDialog(mantUsuarioView, "El usuario ha sido modificado correctamente",
                                "Usuario madificado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(mantUsuarioView, "La contraseña debe poseer mayusculas, minusculas, numeros y poseer de 8 a 15 caracteres",
                                " Error al ingresar la contraseña:", JOptionPane.ERROR_MESSAGE);
                        this.mantUsuarioView.txtContraseña.setText(null);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantUsuarioView, "Error al modificar al usuario:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantUsuarioView, "Error al modificar usuario:" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        if (e.getSource() == this.mantUsuarioView.btCancelar) {
            this.clean();
            this.mantUsuarioView.btEliminar.setEnabled(false);

        }
        if (e.getSource() == this.mantUsuarioView.btBuscar) {
            if (!mantUsuarioView.txtUsuario.getText().isEmpty()) {
                MantUsuarioBuscar mantUsuarioBuscarView = new MantUsuarioBuscar();
                UsuarioBuscarControlador usuarioBControlador;
                usuarioBControlador = new UsuarioBuscarControlador(mantUsuarioBuscarView, usuarioBlModelo, mantUsuarioView.txtUsuarioBuscar);
                usuarioBControlador.getUsuarioBuscarView().setVisible(true);
                this.mantUsuarioView.btEliminar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(mantUsuarioView, "Debes digitar el nombre del usuario primero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == this.mantUsuarioView.btBuscarPersona) {
            MantPersonaBuscar mantPersonaBView = new MantPersonaBuscar();
            PersonaBuscarControlador personaBcontrolador;
            personaBcontrolador = new PersonaBuscarControlador(mantPersonaBView, personaBLModelo, mantUsuarioView.txtPersonaId);
            personaBcontrolador.getPersonaBuscarView().setVisible(true);
            this.mantUsuarioView.btEliminar.setEnabled(true);
            this.mantUsuarioView.btModificar.setEnabled(true);
        }
    }

    public boolean isPassword(String password) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$");
        mat = pat.matcher(password);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarusuario();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarusuario();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarusuario();
    }

    private void cargaPersona() {
        Persona u = new Persona();
        if (!this.mantUsuarioView.txtPersonaId.getText().isEmpty()) {
            u.setCedula(this.mantUsuarioView.txtPersonaId.getText());
            try {
                this.mantUsuarioView.txtUsuario.setEnabled(true);
                this.mantUsuarioView.btInsertar.setEnabled(true);
                u = personaBLModelo.obtenerPorId(u);
                mantUsuarioView.txtCedula.setText(u.getCedula() + " - " + u.getNombre() + " " + u.getApellidos());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantUsuarioView, "Error no se pudo consultar el Usuario (" + ex.getMessage() + ")",
                        "Error al cargar el Usuario", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cargarusuario() {
        
        Usuario u = new Usuario();
        if (!this.mantUsuarioView.txtUsuarioBuscar.getText().isEmpty()) {
            try {
                Persona p = new Persona();

                u.setAlias(this.mantUsuarioView.txtUsuarioBuscar.getText());
                u = usuarioBlModelo.obtenerPorId(u);
                p.setIdpersona(u.getIdPersona());
                p = personaBLModelo.obtenerPorId2(p);

                this.mantUsuarioView.txtPersonaId.setText(p.getCedula());
                this.mantUsuarioView.txtUsuario.setEnabled(false);
                this.mantUsuarioView.btInsertar.setEnabled(false);
                this.mantUsuarioView.txtUsuario.setText(u.getAlias());
                this.mantUsuarioView.txtContraseña.setText(u.getPassword());
                this.mantUsuarioView.cbRol.setSelectedIndex(u.getRol());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantUsuarioView, "Error no se pudo consultar el Usuario (" + ex.getMessage() + ")",
                        "Error al cargar el Usuario", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
