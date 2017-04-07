
package cr.ac.una.ingenieria.appMVC.Controlador;

import cr.ac.una.ingenieria.appMVC.BL.BodegaBL;
import cr.ac.una.ingenieria.appMVC.Domain.Bodega;
import cr.ac.una.ingenieria.appMVC.Vista.MantBodegaBuscar;
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
public class BodegaBuscarControlador implements ActionListener{
    
    private MantBodegaBuscar BuscarBodegaView;
    private BodegaBL bodBL;
    private JTextField txtIDBodega;
    private JTextField txtTipoBodega;
    private JTextField txtnombre;
    private JComboBox jcbEstadoBodega;

    public BodegaBuscarControlador(MantBodegaBuscar BuscarBodegaView,BodegaBL bodBL,
            JTextField txtIDBodega, JTextField txtTipoBodega,JTextField txtnombre,JComboBox jcbEstadoBodega) {
        this.BuscarBodegaView = BuscarBodegaView;
        this.bodBL = bodBL;
        this.txtIDBodega = txtIDBodega;
        this.txtTipoBodega = txtTipoBodega;
        this.txtnombre = txtnombre;
        this.jcbEstadoBodega = jcbEstadoBodega;
        
        this.BuscarBodegaView.btn_Seleccionar.addActionListener(this);
        this.llenarTabla(this.BuscarBodegaView.jtabla_BuscarBodega);
        
        this.BuscarBodegaView.jtf_BuscarBodega.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) {
                llenarTabla(BuscarBodegaView.jtabla_BuscarBodega);                
            }
        });
    }

//-------------------get's------------------------------
    public MantBodegaBuscar getBuscarBodegaView() {
        return BuscarBodegaView;
    }

    public BodegaBL getBodBL() {
        return bodBL;
    }

    public JTextField getTxtIDBodega() {
        return txtIDBodega;
    }

    public JTextField getTxtTipoBodega() {
        return txtTipoBodega;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }
    
    public JComboBox getJcbEstadoBodega() {
        return jcbEstadoBodega;
    }

//-------------------set's------------------------------
    public void setBuscarBodegaView(MantBodegaBuscar BuscarBodegaView) {
        this.BuscarBodegaView = BuscarBodegaView;
    }

    public void setBodBL(BodegaBL bodBL) {
        this.bodBL = bodBL;
    }

    public void setTxtIDBodega(JTextField txtIDBodega) {
        this.txtIDBodega = txtIDBodega;
    }

    public void setTxtTipoBodega(JTextField txtTipoBodega) {
        this.txtTipoBodega = txtTipoBodega;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }
    
    public void setJcbEstadoBodega(JComboBox jcbEstadoBodega) {
        this.jcbEstadoBodega = jcbEstadoBodega;
    }
    
    //////////////////////////////////////////////////////////////////
    
    public void llenarTabla(JTable tablaBodega){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaBodega.setModel(modeloTabla);
        
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("TIPO");
        modeloTabla.addColumn("NOMBRE");
        modeloTabla.addColumn("ESTADO");
        Object fila[] = new Object[4];
        
        String Sql = "Where tipo like '%" + this.BuscarBodegaView.jtf_BuscarBodega.getText() + "%'"
                + "or nombre like'%" + this.BuscarBodegaView.jtf_BuscarBodega.getText() + "%'"
                + "or estado like'%" + this.BuscarBodegaView.jtf_BuscarBodega.getText() + "%'"
                + "or idbodega like'%" + this.BuscarBodegaView.jtf_BuscarBodega.getText() + "%'";

        try {
            for(Object oAux : this.bodBL.obtenerConWhere(new Bodega(), Sql)){
                Bodega bo = (Bodega)oAux;
                fila[0] = bo.getIdBodega();
                fila[1] = bo.getTipo();
                fila[2] = bo.getNombre();
                if(bo.getEstado()==true)
                    fila[3] = "Activo";
                else
                    fila[3] = "Inactiva";
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"NO SE PUDO CARGAR LOS DATOS \n"
                    +e.getMessage() +" ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.BuscarBodegaView.jtabla_BuscarBodega.getRowCount() != 0 &&
           this.BuscarBodegaView.jtabla_BuscarBodega.getSelectedRow() != -1){
            
            int fila = this.BuscarBodegaView.jtabla_BuscarBodega.getSelectedRow();
            
            String idBod = this.BuscarBodegaView.jtabla_BuscarBodega.getValueAt(fila, 0).toString();
            String tipobod = this.BuscarBodegaView.jtabla_BuscarBodega.getValueAt(fila, 1).toString();
            String nombre = this.BuscarBodegaView.jtabla_BuscarBodega.getValueAt(fila, 2).toString();
            String estado = this.BuscarBodegaView.jtabla_BuscarBodega.getValueAt(fila, 3).toString();
            
            this.txtIDBodega.setText(idBod);
            this.txtTipoBodega.setText(tipobod);
            this.txtnombre.setText(nombre);
            this.jcbEstadoBodega.setSelectedItem(estado);
            
            this.BuscarBodegaView.dispose();
            
        }else{
            JOptionPane.showMessageDialog(BuscarBodegaView,"SELECCIONE UNA BODEGA \n"
                        + "DE LA LISTA","ALERTA",JOptionPane.WARNING_MESSAGE);
        }
    }
}
