package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.BodegaBL;
import cr.ac.una.ingenieria.appMVC.BL.MovimientoBL;
import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.TipoArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Conexion.MySQLConexion;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Domain.Movimiento;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantProveedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Bodega;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Inventario;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Moviento;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Proveedores;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Persona;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Registo_Usuario;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_TipoArticulo;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kev
 */
public class PantallaPrincipalControlador implements ActionListener {

    private PantallaPrincipal pantPrinView;
    private UsuarioBL usuarioBLModelo;
    private ProveedorBL proveedorBlModelo;
    private ArticuloBL articuloBlModelo;
    private PersonaBL personaBlModelo;

    //control de pantalla
    boolean Mod_Inv = false;
    boolean Mod_Pro = false;
    boolean Mod_Reg_Per = false;
    boolean Mod_Reg_Usu = false;
    boolean Mod_Mov = false;
    boolean Mod_Bod = false;
    boolean Mod_Tip_Art = false;

    //pantallas
    Modulo_Inventario Mante_ArticulosView;
    Modulo_Proveedores Mod_ProveView;
    Modulo_Registo_Persona Mod_Reg_PerView;
    Modulo_Registo_Usuario Mod_Reg_UsuView;
    Modulo_Moviento vista;
    Modulo_Bodega Mod_BodegaView;
    Modulo_TipoArticulo Mod_TipoArticuloView;
    MantPersonaBuscar mantPersonaBView;

    public PantallaPrincipalControlador(PantallaPrincipal pantPrinView, UsuarioBL usuarioBLModelo, ProveedorBL proveedorBlModelo, ArticuloBL articuloBlModelo, PersonaBL personaBlModelo) {
        this.pantPrinView = pantPrinView;
        this.usuarioBLModelo = usuarioBLModelo;
        this.proveedorBlModelo = proveedorBlModelo;
        this.articuloBlModelo = articuloBlModelo;
        this.personaBlModelo = personaBlModelo;

        this.pantPrinView.jMenuItem_Articulo.addActionListener(this);//listo
        this.pantPrinView.jMenuItem_Proveedores.addActionListener(this);//listo
        this.pantPrinView.jMenuItem_Registro_Persona.addActionListener(this);//listo
        this.pantPrinView.jMenuItem_Registro_Usuario.addActionListener(this);//listo
        this.pantPrinView.jMenuItem_Movimientos.addActionListener(this);//listo
        this.pantPrinView.jMenuItem_Bodega.addActionListener(this);//listo
        this.pantPrinView.jMenuItem_TipoArticulo.addActionListener(this);//listo

        this.pantPrinView.jMenuItem_ReporteArticulos_General.addActionListener(this);
        this.pantPrinView.jMenuItem_ReporteArticulos_Minimo.addActionListener(this);
        this.pantPrinView.jMenuItem_ReporteArticulos_Gravado.addActionListener(this);
        this.pantPrinView.jMenuItem_ReporteArticulos_Exentos.addActionListener(this);
        this.pantPrinView.jMenuItem_Reporte_Proveedores.addActionListener(this);
        this.pantPrinView.jMenuItem_Reporte_ListaPrecio.addActionListener(this);

//        this.pantPrinView.ReporteUsuarios.addActionListener(this);
        inicializarPantalla();

        llenarTabla(this.pantPrinView.jTArticulo);
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

    public PersonaBL getPersonaBlModelo() {
        return personaBlModelo;
    }

    public void setPersonaBlModelo(PersonaBL personaBlModelo) {
        this.personaBlModelo = personaBlModelo;
    }

    private void inicializarPantalla() {
        this.pantPrinView.setEnabled(true);

        //para la venta modulo inventario
        this.Mante_ArticulosView = new Modulo_Inventario();
        ArticuloBL ArtBL = new ArticuloBL();
        ArticuloControlador ArtControl = new ArticuloControlador(Mante_ArticulosView, ArtBL);
        ArtControl.getMantArticuloView();

        //para la venta modulo Modulo_proveedor
        this.Mod_ProveView = new Modulo_Proveedores();
        ProveedorBL proveBL = new ProveedorBL();
        ProveedorControlador proveeControl = new ProveedorControlador(Mod_ProveView, proveBL);
        proveeControl.getMantProveedorView();

        //para la venta modulo Modulo_Registo_Persona
        this.Mod_Reg_PerView = new Modulo_Registo_Persona();
        PersonaBL perBL = new PersonaBL();
        PersonaControlador perControl = new PersonaControlador(Mod_Reg_PerView, perBL);
        perControl.getMod_Reg_PersonaView();

        //para la venta modulo Modulo_Registo_Usuario
        this.Mod_Reg_UsuView = new Modulo_Registo_Usuario();
        UsuarioBL usuBL = new UsuarioBL();
        this.mantPersonaBView = new MantPersonaBuscar();
        UsuarioControlador UsuControl = new UsuarioControlador(Mod_Reg_UsuView, usuBL, perBL, Mod_Reg_PerView, mantPersonaBView);
        UsuControl.getMantUsuarioview();

        //para la ventana de Movimiento
        vista = new Modulo_Moviento();
        MantArticuloBuscar mantArticuloBView = new MantArticuloBuscar();
        MantPersonaBuscar mantPersonaBView = new MantPersonaBuscar();
        MantProveedorBuscar mantProveedorBView = new MantProveedorBuscar();
        MovimientoBL movimientoBLModelo = new MovimientoBL();
        MovimientoControlador con = new MovimientoControlador(movimientoBLModelo, vista, ArtBL, perBL, proveBL, mantArticuloBView, mantPersonaBView, mantProveedorBView);
        con.getModMovView();

        //para la ventana de bodega
        this.Mod_BodegaView = new Modulo_Bodega();
        BodegaBL BodBL = new BodegaBL();
        BodegaControlador bodegaControl = new BodegaControlador(Mod_BodegaView, BodBL);
        bodegaControl.getModBodegaView();

        //para la ventana de tipo articulo
        this.Mod_TipoArticuloView = new Modulo_TipoArticulo();
        TipoArticuloBL tipoArtBL = new TipoArticuloBL();
        TipoArticuloControlador tipoArticuloControl = new TipoArticuloControlador(Mod_TipoArticuloView, tipoArtBL);
        tipoArticuloControl.getMod_TipoArtView();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.pantPrinView.jMenuItem_Articulo) {
            if (this.Mod_Inv == false) {
                int x = (this.pantPrinView.jdpPrincipal.getWidth() / 2) - (this.Mante_ArticulosView.getWidth() / 2);
                int y = (this.pantPrinView.jdpPrincipal.getHeight() / 2) - (this.Mante_ArticulosView.getHeight() / 2);
                this.Mante_ArticulosView.setLocation(x, y);

                this.pantPrinView.jdpPrincipal.add(this.Mante_ArticulosView);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.Mante_ArticulosView.show();
                this.Mod_Inv = true;
            } else {
                this.Mante_ArticulosView.show();
                this.Mante_ArticulosView.toFront();
                this.Mod_Inv = false;
            }
        }

        if (e.getSource() == this.pantPrinView.jMenuItem_Proveedores) {
            if (this.Mod_Pro == false) {
                int x = (this.pantPrinView.jdpPrincipal.getWidth() / 2) - (this.Mod_ProveView.getWidth() / 2);
                int y = (this.pantPrinView.jdpPrincipal.getHeight() / 2) - (this.Mod_ProveView.getHeight() / 2);
                this.Mod_ProveView.setLocation(x, y);

                this.pantPrinView.jdpPrincipal.add(this.Mod_ProveView);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.Mod_ProveView.show();
                this.Mod_Pro = true;
            } else {
                this.Mod_ProveView.show();
                this.Mod_ProveView.toFront();
                this.Mod_Pro = false;
            }
        }

        if (e.getSource() == this.pantPrinView.jMenuItem_Registro_Persona) {
            if (this.Mod_Reg_Per == false) {
                int x = (this.pantPrinView.jdpPrincipal.getWidth() / 2) - (this.Mod_Reg_PerView.getWidth() / 2);
                int y = (this.pantPrinView.jdpPrincipal.getHeight() / 2) - (this.Mod_Reg_PerView.getHeight() / 2);
                this.Mod_Reg_PerView.setLocation(x, y);

                this.pantPrinView.jdpPrincipal.add(this.Mod_Reg_PerView);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.Mod_Reg_PerView.show();
                this.Mod_Reg_Per = true;
            } else {
                this.Mod_Reg_PerView.show();
                this.Mod_Reg_PerView.toFront();
                this.Mod_Reg_Per = false;
            }
        }

        if (e.getSource() == this.pantPrinView.jMenuItem_Registro_Usuario) {
            if (this.Mod_Reg_Usu == false) {
                int x = (this.pantPrinView.jdpPrincipal.getWidth() / 2) - (this.Mod_Reg_UsuView.getWidth() / 2);
                int y = (this.pantPrinView.jdpPrincipal.getHeight() / 2) - (this.Mod_Reg_UsuView.getHeight() / 2);
                this.Mod_Reg_UsuView.setLocation(x, y);

                this.pantPrinView.jdpPrincipal.add(this.Mod_Reg_UsuView);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.Mod_Reg_UsuView.show();
                this.Mod_Reg_Usu = true;
            } else {
                this.Mod_Reg_UsuView.show();
                this.Mod_Reg_UsuView.toFront();
                this.Mod_Reg_Usu = false;
            }
        }

        if (e.getSource() == this.pantPrinView.jMenuItem_Movimientos) {
            if (this.Mod_Mov == false) {
                int x = (this.pantPrinView.jdpPrincipal.getWidth() / 2) - (this.vista.getWidth() / 2);
                int y = (this.pantPrinView.jdpPrincipal.getHeight() / 2) - (this.vista.getHeight() / 2);
                this.vista.setLocation(x, y);

                this.pantPrinView.jdpPrincipal.add(this.vista);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.vista.show();
                this.Mod_Mov = true;
            } else {
                this.vista.show();
                this.vista.toFront();
                this.Mod_Mov = false;
            }
        }

        if (e.getSource() == this.pantPrinView.jMenuItem_Bodega) {
            if (this.Mod_Bod == false) {
                int x = (this.pantPrinView.jdpPrincipal.getWidth() / 2) - (this.Mod_BodegaView.getWidth() / 2);
                int y = (this.pantPrinView.jdpPrincipal.getHeight() / 2) - (this.Mod_BodegaView.getHeight() / 2);
                this.Mod_BodegaView.setLocation(x, y);
                this.pantPrinView.jdpPrincipal.add(this.Mod_BodegaView);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.Mod_BodegaView.show();
                this.Mod_Bod = true;
            } else {
                this.Mod_BodegaView.show();
                this.Mod_BodegaView.toFront();
                this.Mod_Bod = false;
            }
        }

        if (e.getSource() == this.pantPrinView.jMenuItem_TipoArticulo) {
            if (this.Mod_Tip_Art == false) {
                int x = (this.pantPrinView.jdpPrincipal.getWidth() / 2) - (this.Mod_TipoArticuloView.getWidth() / 2);
                int y = (this.pantPrinView.jdpPrincipal.getHeight() / 2) - (this.Mod_TipoArticuloView.getHeight() / 2);
                this.Mod_TipoArticuloView.setLocation(x, y);
                this.pantPrinView.jdpPrincipal.add(this.Mod_TipoArticuloView);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.Mod_TipoArticuloView.show();
                this.Mod_Tip_Art = true;
            } else {
                this.pantPrinView.jdpPrincipal.add(this.Mod_TipoArticuloView);
                this.pantPrinView.jdpPrincipal.updateUI();
                this.pantPrinView.jdpPrincipal.repaint();
                this.Mod_TipoArticuloView.show();
                this.Mod_TipoArticuloView.toFront();
                Mod_Tip_Art = true;
            }
        }
        /////////////////////////Reportes/////////////////////////////////////////////

        if (e.getSource() == this.pantPrinView.jMenuItem_ReporteArticulos_General) {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream("C:\\Users\\Michael\\Desktop\\Gesti-n-de-inventarios\\src\\cr\\ac\\una\\ingenieria\\appMVC\\Vista\\Reportes\\General1.jrxml");
                Map parameters = new HashMap();
                JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                MySQLConexion con = new MySQLConexion();
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con.getConexion());
                JasperViewer visor = new JasperViewer(jasperPrint, false);
                visor.setVisible(true);
//                JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Michael\\Desktop\\Gesti-n-de-inventarios\\src\\cr\\ac\\una\\ingenieria\\appMVC\\Vista\\Reportes\\General.pdf");
//                JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Michael\\Desktop\\reportes\\General1.pdf");
                File file = new File("C:\\Users\\Michael\\Desktop\\Gesti-n-de-inventarios\\src\\cr\\ac\\una\\ingenieria\\appMVC\\Vista\\Reportes\\General1.pdf");
                if (file.toString().endsWith(".pdf")) {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                } else {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(file);
                }
            } catch (FileNotFoundException ex) {
                System.err.println(ex.getMessage());
            } catch (JRException | SQLException | IOException ex) {
                Logger.getLogger(PantallaPrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//fin reporte general
    }

    public void llenarTabla(JTable tablaArticulo) {

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulo.setModel(modeloTabla);

        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Minimo");

        Object fila[] = new Object[3];

        String Sql = "where cantidad < punto_de_pedido + 10 ";

        try {
            ArrayList<Articulo> listaminimos = articuloBlModelo.obtenerConWhere(new Articulo(), Sql);
            if (listaminimos.isEmpty()) {
                this.pantPrinView.jTArticulo.setVisible(false);
            } else {
                for (Object oAux : articuloBlModelo.obtenerConWhere(new Articulo(), Sql)) {

                    Articulo a = (Articulo) oAux;
                    fila[0] = a.getNombre();
                    fila[1] = a.getCantidad();
                    fila[2] = a.getPuntoPedido();

                    modeloTabla.addRow(fila);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
}
