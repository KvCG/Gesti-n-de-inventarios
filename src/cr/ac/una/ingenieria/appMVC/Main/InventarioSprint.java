/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Main;

import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Controlador.ValidarAcceso;


import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Domain.Usuario;

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
//        Usuario u = new Usuario(1, 2, "guroja", "12344566", 1);
//        Proveedores p=new Proveedores(1, "Cinta Azul", "Alajuela", "grcantill@gmail.com", "22222222");
//        Articulos a = new Articulos(8, "cod0001", "Pate", "PATE EN PASTA", 2, 1000, 100, 1, 20);
//        a.setPrecioVenta(2000);
//
//        
//        //a2.setCantidad(30);
//       
//        try{
//             usuBL.insertar(u);
//             articuloBlModelo.insertar(a);
//           articuloBlModelo.insertar(a);
//             proveedorBlModelo.insertar(p);
//             articuloBlModelo.modificar(a);
//        }
//        catch(Exception e){
//            System.out.println("error");
//        }

//        PantallaPrincipal pantPrinView = new PantallaPrincipal();
//       UsuarioBL usuBL = new UsuarioBL();
//       ArticuloBL articuloBlModelo= new ArticuloBL();
//       ProveedorBL proveedorBlModelo= new ProveedorBL();
//        PantallaPrincipalControlador ppC = new PantallaPrincipalControlador(pantPrinView, usuBL,proveedorBlModelo,articuloBlModelo);
//        ppC.getPantPrinView().setVisible(true);
//        Usuario u = new Usuario(1, 2, "m", "m", 1);
//        Proveedores p=new Proveedores(1, "Cinta Azul", "Alajuela", "grcantill@gmail.com", "22222222");
//        Articulos a = new Articulos(8, "cod0001", "Pate", "PATE EN PASTA", 2, 1000, 100, 1, 20);
//        a.setPrecioVenta(2000);

//        
//        //a2.setCantidad(30);
//       
//        try{
//             usuBL.insertar(u);
//        }
//        catch(Exception e){
//            System.out.println("error");
//        }
//        

//            PersonaBL pbl = new PersonaBL();
//            //Persona p = new Persona(1,"112620870","Gustavo","Rojas","grcantill@gmail.com");
//            Persona p =new Persona(1,"5355","michael","Rojas","grcantill@gmail.com");
//            try{
//                pbl.insertar(p);
//            }catch(Exception e){
//                System.out.println("error al insertar a la persona");
//            }
            
//        SolicitudUsuarioPassword solUsuarioPassword =new SolicitudUsuarioPassword();
//        PantallaPrincipal pantPrinView = new PantallaPrincipal();
//        SolicitudUsuarioPassword solUsePa = new SolicitudUsuarioPassword();
//        ValidarAcceso validar = new ValidarAcceso(pantPrinView, solUsePa);
//        validar.getSolUsePa().setVisible(true);
//        pantPrinView.setVisible(true);


        SolicitudUsuarioPassword solUsuarioPassword =new SolicitudUsuarioPassword();
        PantallaPrincipal pantPrinView = new PantallaPrincipal();
        SolicitudUsuarioPassword solUsePa = new SolicitudUsuarioPassword();
        ValidarAcceso validar = new ValidarAcceso(pantPrinView, solUsePa);
        validar.getSolUsePa().setVisible(true);
        //pantPrinView.setVisible(true);

    }
    
}
