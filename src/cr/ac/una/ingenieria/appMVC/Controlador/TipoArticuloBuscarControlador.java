
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.TipoArticuloBL;
import cr.ac.una.ingenieria.appMVC.Domain.TipoArticulo;
import cr.ac.una.ingenieria.appMVC.Vista.MantBusarTipoArticulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class TipoArticuloBuscarControlador implements ActionListener{
    private MantBusarTipoArticulo mantBusarTipoArticuloView;
    private TipoArticuloBL TipArtBL;
    private JTextField txt_IdTipoArticulo;
    private JTextField txt_Descripcion;
    private JComboBox jcb_estado;

    public TipoArticuloBuscarControlador(MantBusarTipoArticulo mantBusarTipoArticuloView, 
            TipoArticuloBL TipArtBL, JTextField txt_IdTipoArticulo, JTextField txt_Descripcion,
            JComboBox jcb_estado) {
        this.mantBusarTipoArticuloView = mantBusarTipoArticuloView;
        this.TipArtBL = TipArtBL;
        this.txt_IdTipoArticulo = txt_IdTipoArticulo;
        this.txt_Descripcion = txt_Descripcion;
        this.jcb_estado = jcb_estado;
        
        this.mantBusarTipoArticuloView.btn_Seleccionar.addActionListener(this);
        this.llenarTabla(this.mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo);
        
        this.mantBusarTipoArticuloView.jtf_BuscarTipoArticulo.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) {
                llenarTabla(mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo);
            }
        });
    }//fin constructor
//-------------------get's------------------------------
    public MantBusarTipoArticulo getMantBusarTipoArticuloView() {
        return mantBusarTipoArticuloView;
    }

    public TipoArticuloBL getTipArtBL() {
        return TipArtBL;
    }

    public JTextField getTxt_IdTipoArticulo() {
        return txt_IdTipoArticulo;
    }

    public JTextField getTxt_Descripcion() {
        return txt_Descripcion;
    }

    public JComboBox getJcb_estado() {
        return jcb_estado;
    }
    
    //-------------------Set's------------------------------

    public void setMantBusarTipoArticuloView(MantBusarTipoArticulo mantBusarTipoArticuloView) {
        this.mantBusarTipoArticuloView = mantBusarTipoArticuloView;
    }

    public void setTipArtBL(TipoArticuloBL TipArtBL) {
        this.TipArtBL = TipArtBL;
    }

    public void setTxt_IdTipoArticulo(JTextField txt_IdTipoArticulo) {
        this.txt_IdTipoArticulo = txt_IdTipoArticulo;
    }

    public void setTxt_Descripcion(JTextField txt_Descripcion) {
        this.txt_Descripcion = txt_Descripcion;
    }

    public void setJcb_estado(JComboBox jcb_estado) {
        this.jcb_estado = jcb_estado;
    }
    
    public  void llenarTabla(JTable tablaTipArt){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaTipArt.setModel(modeloTabla);
        
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("TIPO");
        modeloTabla.addColumn("ESTADO");
        Object fila [] = new Object[3];
        
        String Sql = "Where descripcion like '%" + this.mantBusarTipoArticuloView.jtf_BuscarTipoArticulo.getText() + "%'"
                + "or estado like'%" + this.mantBusarTipoArticuloView.jtf_BuscarTipoArticulo.getText() + "%'"
                + "or codigo like'%" + this.mantBusarTipoArticuloView.jtf_BuscarTipoArticulo.getText() + "%'";
        
        try {
            for(Object oAux : this.TipArtBL.obtenerConWhere(new TipoArticulo(), Sql)){
                TipoArticulo ta = (TipoArticulo)oAux;
                fila[0] = ta.getCodigo();
                fila[1] = ta.getDescripcion();
                if(ta.getEstado() == true)
                    fila[2] = "ACTIVO";
                else
                    fila[2] = "INACTIVO";
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO CARGAR LOS DATOS \n"
                    +e.getMessage() +" ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo.getRowCount() != 0 &&
           this.mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo.getSelectedRow() != -1){
            
            int fila = this.mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo.getSelectedRow();
            
            String id = this.mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo.getValueAt(fila, 0).toString();
            String des = this.mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo.getValueAt(fila, 1).toString();
            String est = this.mantBusarTipoArticuloView.jtabla_BuscarTipoArticulo.getValueAt(fila, 2).toString();
            
            this.txt_IdTipoArticulo.setText(id);
            this.txt_Descripcion.setText(des);
            this.jcb_estado.setSelectedItem(est);
            
            this.mantBusarTipoArticuloView.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"SELECCIONE UNA OPCION \n"
                        + "DE LA LISTA","ALERTA",JOptionPane.WARNING_MESSAGE);
        }
    }    
}
