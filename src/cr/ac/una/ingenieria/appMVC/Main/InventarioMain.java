/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Main;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.BodegaBL;
import cr.ac.una.ingenieria.appMVC.BL.MovimientoBL;
import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Controlador.MovimientoControlador;
import cr.ac.una.ingenieria.appMVC.Controlador.PersonaControlador;
import cr.ac.una.ingenieria.appMVC.Controlador.ValidarAcceso;
import cr.ac.una.ingenieria.appMVC.Domain.Bodega;


import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantProveedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Moviento;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Persona;

import cr.ac.una.ingenieria.appMVC.Vista.PantallaPrincipal;
import cr.ac.una.ingenieria.appMVC.Vista.SolicitudUsuarioPassword;

/**
 *
 * @author Kev
 */
public class InventarioMain {
    public static void main(String[] args) {
//        
//        BodegaBL Bbl = new BodegaBL();
//        try {
//            for(Bodega b : Bbl.obtenerTodos()){
//                System.out.println(b.getNombre());
//            }
//        } catch (Exception e) {
//        }
       
        
        SolicitudUsuarioPassword solUsuarioPassword =new SolicitudUsuarioPassword();
   
        SolicitudUsuarioPassword solUsePa = new SolicitudUsuarioPassword();
        ValidarAcceso validar = new ValidarAcceso(solUsePa);
        validar.getSolUsePa().setVisible(true);

//        Modulo_Moviento vista = new Modulo_Moviento();
//        MantArticuloBuscar mantArticuloBView = new MantArticuloBuscar();
//        MantPersonaBuscar mantPersonaBView = new MantPersonaBuscar();
//        MantProveedorBuscar mantProveedorBView = new MantProveedorBuscar();
//        MovimientoBL movimientoBLModelo = new MovimientoBL();
//        ArticuloBL articuloBLModelo = new ArticuloBL();
//        PersonaBL personaBLModelo = new PersonaBL();
//        ProveedorBL proveedorBLModelo = new ProveedorBL();
//        MovimientoControlador con = new MovimientoControlador(movimientoBLModelo, vista, articuloBLModelo, personaBLModelo, proveedorBLModelo, mantArticuloBView, mantPersonaBView, mantProveedorBView);
//        con.getModMovView().show();
//        con.getModMovView().toFront();
 
    }
}
