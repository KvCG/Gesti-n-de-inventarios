/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Main;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Controlador.PantallaPrincipalControlador;
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
//        PantallaPrincipal pantPrinView = new PantallaPrincipal();
//        UsuarioBL usuBL = new UsuarioBL();
//        ArticuloBL articuloBlModelo= new ArticuloBL();
//        ProveedorBL proveedorBlModelo= new ProveedorBL();
//        PantallaPrincipalControlador ppC = new PantallaPrincipalControlador(pantPrinView, usuBL,proveedorBlModelo,articuloBlModelo);
//        ppC.getPantPrinView().setVisible(true);
        
        SolicitudUsuarioPassword solUsuarioPassword =new SolicitudUsuarioPassword();
        PantallaPrincipal pantPrinView = new PantallaPrincipal();
        SolicitudUsuarioPassword solUsePa = new SolicitudUsuarioPassword();
        ValidarAcceso validar = new ValidarAcceso(pantPrinView, solUsePa);
        validar.getSolUsePa().setVisible(true);
        //pantPrinView.setVisible(true);
    }
    
}
