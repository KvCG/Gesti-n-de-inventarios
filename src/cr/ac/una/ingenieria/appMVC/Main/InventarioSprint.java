/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Main;

import cr.ac.una.ingenieria.appMVC.Controlador.ValidarAcceso;
import cr.ac.una.ingenieria.appMVC.Vista.PantallaPrincipal;
import cr.ac.una.ingenieria.appMVC.Vista.SolicitudUsuarioPassword;

/**
 *
 * @author Kev
 */
public class InventarioSprint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        SolicitudUsuarioPassword solUsuarioPassword =new SolicitudUsuarioPassword();
        PantallaPrincipal pantPrinView = new PantallaPrincipal();
        SolicitudUsuarioPassword solUsePa = new SolicitudUsuarioPassword();
        ValidarAcceso validar = new ValidarAcceso(pantPrinView, solUsePa);
        validar.getSolUsePa().setVisible(true);
        //pantPrinView.setVisible(true);
    }
    
}
