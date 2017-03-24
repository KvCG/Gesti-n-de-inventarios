/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.MovimientoBL;
import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.Domain.Articulo;
import cr.ac.una.ingenieria.appMVC.Domain.Movimiento;
import cr.ac.una.ingenieria.appMVC.Domain.Persona;
import cr.ac.una.ingenieria.appMVC.Domain.Proveedor;
import cr.ac.una.ingenieria.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantPersonaBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.MantProveedorBuscar;
import cr.ac.una.ingenieria.appMVC.Vista.Modulo_Moviento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Kev
 */
public class MovimientoControlador implements ActionListener, DocumentListener{ 
    private MovimientoBL movimientoBLModelo;
    private Modulo_Moviento modMovView;
    private ArticuloBL articuloBLModelo;
    private PersonaBL personaBLModelo;
    private ProveedorBL proveedorBLModelo;
    private MantArticuloBuscar mantArticuloBView;
    private MantPersonaBuscar mantPersonaBView;
    private MantProveedorBuscar mantProveedorBView;

    public MovimientoControlador(MovimientoBL movimientoBLModelo, Modulo_Moviento modMovView, ArticuloBL articuloBLModelo, PersonaBL personaBLModelo, ProveedorBL proveedorBLModelo, MantArticuloBuscar mantArticuloBView, MantPersonaBuscar mantPersonaBView, MantProveedorBuscar mantProveedorBView) {
        this.movimientoBLModelo = movimientoBLModelo;
        this.modMovView = modMovView;
        
        this.articuloBLModelo = articuloBLModelo;
        this.personaBLModelo = personaBLModelo;
        this.proveedorBLModelo = proveedorBLModelo;
        this.mantArticuloBView = mantArticuloBView;
        this.mantPersonaBView = mantPersonaBView;
        this.mantProveedorBView = mantProveedorBView;
        
        this.modMovView.btAgregar.addActionListener(this);
        this.modMovView.btBuscaArticulo.addActionListener(this);
        this.modMovView.btBuscaPersona.addActionListener(this);
        this.modMovView.btBuscaProveedor.addActionListener(this);
        this.modMovView.btCancelar.addActionListener(this);
        this.modMovView.btQuitar.addActionListener(this);
        this.modMovView.btRealizar.addActionListener(this);
        
        this.modMovView.txtCodigoPersona.setVisible(false);
        this.modMovView.txtCodigoArticulo.setVisible(false);
        this.modMovView.txtCodigoArticulo1.setVisible(false);
        this.modMovView.txtCodigoProveedor.setVisible(false);
        
        this.modMovView.txtCodigoPersona.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                cargaPersona();
            }
        });
        
        this.modMovView.txtCodigoArticulo.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                cargaArticulo();
            }
        });    
        
        this.modMovView.txtCodigoProveedor.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                cargaProveedor();
            }
        });
    }

    public MovimientoBL getMovimientoBLModelo() {
        return movimientoBLModelo;
    }

    public void setMovimientoBLModelo(MovimientoBL movimientoBLModelo) {
        this.movimientoBLModelo = movimientoBLModelo;
    }

    public Modulo_Moviento getModMovView() {
        return modMovView;
    }

    public void setModMovView(Modulo_Moviento modMovView) {
        this.modMovView = modMovView;
    }

    public ArticuloBL getArticuloBLModelo() {
        return articuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL articuloBLModelo) {
        this.articuloBLModelo = articuloBLModelo;
    }

    public PersonaBL getPersonaBLModelo() {
        return personaBLModelo;
    }

    public void setPersonaBLModelo(PersonaBL personaBLModelo) {
        this.personaBLModelo = personaBLModelo;
    }

    public ProveedorBL getProveedorBLModelo() {
        return proveedorBLModelo;
    }

    public void setProveedorBLModelo(ProveedorBL proveedorBLModelo) {
        this.proveedorBLModelo = proveedorBLModelo;
    }

    public MantArticuloBuscar getMantArticuloBView() {
        return mantArticuloBView;
    }

    public void setMantArticuloBView(MantArticuloBuscar mantArticuloBView) {
        this.mantArticuloBView = mantArticuloBView;
    }

    public MantPersonaBuscar getMantPersonaBView() {
        return mantPersonaBView;
    }

    public void setMantPersonaBView(MantPersonaBuscar mantPersonaBView) {
        this.mantPersonaBView = mantPersonaBView;
    }

    public MantProveedorBuscar getMantProveedorBView() {
        return mantProveedorBView;
    }

    public void setMantProveedorBView(MantProveedorBuscar mantProveedorBView) {
        this.mantProveedorBView = mantProveedorBView;
    }
    
      
    
    
    //-----------------------------------------------------Utils
    public void cargaPersona(){
        Persona u = new Persona();
        u.setCedula(this.modMovView.txtCodigoPersona.getText());
        try {
            u = personaBLModelo.obtenerPorId(u);
            modMovView.txtPersona.setText(u.getNombre() + " " + u.getApellidos());
        } catch (SQLException ex) {
        }
    }
    public void cargaArticulo(){
        Articulo u = new Articulo();
        u.setIdarticulo(Integer.parseInt(this.modMovView.txtCodigoArticulo.getText()));
        try {
            u = articuloBLModelo.obtenerPorId(u);
            modMovView.txtArticulo.setText(u.getCodigo()+ " " + u.getNombre());
            modMovView.txtCodigoArticulo1.setText(u.getIdarticulo().toString());
        } catch (SQLException ex) {
        }
    }
    public void cargaProveedor(){
        Proveedor u = new Proveedor();
        u.setIdProvedor(Integer.parseInt(this.modMovView.txtCodigoProveedor.getText()));
        try {
            u = proveedorBLModelo.obtenerPorId(u);
            modMovView.txtProveedor.setText(u.getNombre());
        } catch (SQLException ex) {
        }
    }
    
    
    //-----------------------------------------------------
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.modMovView.btBuscaPersona) {
            mantPersonaBView = new MantPersonaBuscar();
            PersonaBuscarControlador personaBcontrolador;
            personaBcontrolador = new PersonaBuscarControlador(mantPersonaBView, personaBLModelo, modMovView.txtCodigoPersona);
            personaBcontrolador.getPersonaBuscarView().setVisible(true);   
        }
        
        if (e.getSource() == this.modMovView.btBuscaProveedor) {
            mantProveedorBView = new MantProveedorBuscar();
            ProveedorBuscarControlador proveedorBcontrolador;
            proveedorBcontrolador = new ProveedorBuscarControlador(mantProveedorBView, proveedorBLModelo, modMovView.txtCodigoProveedor);
            proveedorBcontrolador.getProovedorBuscarView().setVisible(true);   
        }
        
        if (e.getSource() == this.modMovView.btBuscaArticulo) {
            mantArticuloBView = new MantArticuloBuscar();
            ArticuloBuscarControlador articuloBcontrolador;
            articuloBcontrolador = new ArticuloBuscarControlador(mantArticuloBView, articuloBLModelo, modMovView.txtCodigoArticulo);
            articuloBcontrolador.getArticuloBuscarView().setVisible(true);   
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
