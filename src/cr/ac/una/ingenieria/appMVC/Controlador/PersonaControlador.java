
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michael
 */
public class PersonaControlador implements ActionListener{
    private Modulo_Registo_Persona Mod_Reg_PersonaView;
    private PersonaBL PersBL;

    public PersonaControlador(Modulo_Registo_Persona Mod_Reg_PersonaView, PersonaBL PersBL) {
        this.Mod_Reg_PersonaView = Mod_Reg_PersonaView;
        this.PersBL = PersBL;
        this.Mod_Reg_PersonaView.btGuardar.addActionListener(this);
        this.Mod_Reg_PersonaView.btModificar.addActionListener(this);
        this.Mod_Reg_PersonaView.btBuscar.addActionListener(this);
        this.Mod_Reg_PersonaView.btCancelar.addActionListener(this);
        this.Mod_Reg_PersonaView.btEliminar.addActionListener(this);
    }

    public Modulo_Registo_Persona getMod_Reg_PersonaView() {
        return Mod_Reg_PersonaView;
    }

    public PersonaBL getPersBL() {
        return PersBL;
    }

    public void setMod_Reg_PersonaView(Modulo_Registo_Persona Mod_Reg_PersonaView) {
        this.Mod_Reg_PersonaView = Mod_Reg_PersonaView;
    }

    public void setPersBL(PersonaBL PersBL) {
        this.PersBL = PersBL;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
}
