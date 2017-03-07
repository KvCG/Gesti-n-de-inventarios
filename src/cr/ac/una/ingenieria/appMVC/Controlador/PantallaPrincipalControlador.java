/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Inventario;
import cr.ac.una.ingenieria.appMVC.Vista.ManteProveedores;
import cr.ac.una.ingenieria.appMVC.Vista.PantallaPrincipal;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


/**
 *
 * @author Kev
 */
public class PantallaPrincipalControlador implements ActionListener{
    private PantallaPrincipal pantPrinView;
    private UsuarioBL usuarioBLModelo;
    private ProveedorBL proveedorBlModelo;
    private ArticuloBL articuloBlModelo;

    public PantallaPrincipalControlador(PantallaPrincipal pantPrinView, UsuarioBL usuarioBLModelo, ProveedorBL proveedorBlModelo,ArticuloBL articuloBlModelo) {
        this.pantPrinView = pantPrinView;
        this.usuarioBLModelo = usuarioBLModelo;
        this.proveedorBlModelo = proveedorBlModelo;
        this.articuloBlModelo = articuloBlModelo;
        this.pantPrinView.jMenuArticulo.addActionListener(this);
        this.pantPrinView.jMenuProveedores.addActionListener(this);
//        this.pantPrinView.jMenuUsuario.addActionListener(this);
        this.pantPrinView.ReporteProveedores.addActionListener(this);
//        this.pantPrinView.ReporteUsuarios.addActionListener(this);
        this.pantPrinView.ReporteArticulos.addActionListener(this);
        this.pantPrinView.Articulos5.addActionListener(this);
        inicializarPantalla();
    }

    

    
    
    
    public PantallaPrincipal getPantPrinView() {
        return pantPrinView;
    }

    public void setPantPrinView(PantallaPrincipal pantPrinView) {
        this.pantPrinView = pantPrinView;
    }

    public UsuarioBL getUsuarioBLModelo() {
        return usuarioBLModelo;
    }

    public void setUsuarioBLModelo(UsuarioBL usuarioBLModelo) {
        this.usuarioBLModelo = usuarioBLModelo;
    }

    public ProveedorBL getProveedorBlModelo() {
        return proveedorBlModelo;
    }

    public void setProveedorBlModelo(ProveedorBL proveedorBlModelo) {
        this.proveedorBlModelo = proveedorBlModelo;
    }

    public ArticuloBL getArticuloBlModelo() {
        return articuloBlModelo;
    }

    public void setArticuloBlModelo(ArticuloBL articuloBlModelo) {
        this.articuloBlModelo = articuloBlModelo;
    }

   

    

    
    private void inicializarPantalla() {
        this.pantPrinView.setEnabled(true);
    }
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == this.pantPrinView.jMenuUsuario) {
//            MantUsuario mantClienteView = new MantUsuario();
//            UsuarioControlador usuControlador;
//            usuControlador = new UsuarioControlador(mantClienteView, usuarioBLModelo);
//            usuControlador.getMantUsuarioview().setVisible(true);
//        }
        
        if (e.getSource() == this.pantPrinView.jMenuProveedores) {
            ManteProveedores mantProveedoresView = new ManteProveedores();
            mantProveedoresView.setVisible(true);
            ProveedorControlador provControlador;
            provControlador = new ProveedorControlador(mantProveedoresView, proveedorBlModelo);
            provControlador.getMantProveedorView().setVisible(true);
        }
        
        if (e.getSource() == this.pantPrinView.jMenuArticulo) {
            Modulo_Inventario mantArticuloView = new Modulo_Inventario();
            ManteProveedores mantProveedoresView = new ManteProveedores();
            mantArticuloView.setVisible(true);
            ArticuloControlador artControlador;
            artControlador = new ArticuloControlador(mantArticuloView, articuloBlModelo);
            artControlador.getMantArticuloView().setVisible(true);
        }
//        if (e.getSource() == this.pantPrinView.ReporteUsuarios) {
//            InputStream inputStream = null;
//            //JasperReport jr = null; 
//            try {
//                inputStream = new FileInputStream("C:\\Users\\Gustavo\\Desktop\\Inventario(Sprint 1)\\src\\cr\\ac\\una\\ingenieria\\appMVC\\Vista\\Reportes\\ReporteUsuarios.jrxml");
//                //URL in=this.getClass().getResource("\\Reportes\\ReporteProvedores.jrxml");
//                Map parameters = new HashMap();
//                JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//                //jr= (JasperReport) JRLoader.loadObject(in); 
//                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//                MySQLConexion Con = new MySQLConexion();
//                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, Con.getConexion());
//                JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Gustavo\\Desktop\\ReporteUsuarios.pdf");
//
//                File file = new File("C:\\Users\\Gustavo\\Desktop\\ReporteUsuarios.pdf");
//                if (file.toString().endsWith(".pdf")) {
//                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
//                } else {
//                    Desktop desktop = Desktop.getDesktop();
//                    desktop.open(file);
//                }
//
//            } catch (FileNotFoundException ex) {
//
//                System.err.println(ex.getMessage());
//            } catch (IOException ex) {
//                Logger.getLogger(PantallaPrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (JRException ex) {
//                Logger.getLogger(PantallaPrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SQLException ex) {
//                Logger.getLogger(PantallaPrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
        
    }
}
    

