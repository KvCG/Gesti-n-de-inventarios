/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Vista;

/**
 *
 * @author Michael
 */
public class Modulo_Moviento extends javax.swing.JInternalFrame {

    /**
     * Creates new form Movimiento_Articulo
     */
    public Modulo_Moviento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdIngreso = new javax.swing.JRadioButton();
        rdEgreso = new javax.swing.JRadioButton();
        rdDevolucion = new javax.swing.JRadioButton();
        txtCodigoMov = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        txtPersona = new javax.swing.JTextField();
        btBuscaPersona = new javax.swing.JButton();
        btBuscaProveedor = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtArticulo = new javax.swing.JTextField();
        btBuscaArticulo = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btQuitar = new javax.swing.JButton();
        spMovimiento = new javax.swing.JScrollPane();
        tbMovimiento = new javax.swing.JTable();
        btRealizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txtCodigoPersona = new javax.swing.JTextField();
        txtCodigoArticulo = new javax.swing.JTextField();
        txtCodigoArticulo1 = new javax.swing.JTextField();
        txtCodigoProveedor = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MOVIMIENTO ARTICULO");
        setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("PERSONA:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("PROVEEDOR:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("CODIGO MOVIMIENTO:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("TIPO MOVIMIENTO");

        rdIngreso.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdIngreso.setText("INGRESO");

        rdEgreso.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdEgreso.setText("EGRESO");

        rdDevolucion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdDevolucion.setText("DEVOLUCION");

        txtCodigoMov.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtPersona.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonaActionPerformed(evt);
            }
        });

        btBuscaPersona.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btBuscaPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Buscar02.png"))); // NOI18N
        btBuscaPersona.setText("BUSCAR");

        btBuscaProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btBuscaProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Buscar02.png"))); // NOI18N
        btBuscaProveedor.setText("BUSCAR");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("ARTICULO:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("CANTIDAD:");

        txtCantidad.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtArticulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btBuscaArticulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btBuscaArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Buscar02.png"))); // NOI18N
        btBuscaArticulo.setText("BUSCAR");

        btAgregar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btAgregar.setText("AGREGAR");

        btQuitar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btQuitar.setText("QUITAR");
        btQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuitarActionPerformed(evt);
            }
        });

        tbMovimiento.setAutoCreateRowSorter(true);
        tbMovimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "COD. ART", "ARTICULO", "CANTIDAD", "CODIGO MOVIMIENTO"
            }
        ));
        tbMovimiento.getTableHeader().setReorderingAllowed(false);
        spMovimiento.setViewportView(tbMovimiento);

        btRealizar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btRealizar.setText("REALIZAR");

        btCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btCancelar.setText("CANCELAR");

        txtCodigoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPersonaActionPerformed(evt);
            }
        });

        txtCodigoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArticuloActionPerformed(evt);
            }
        });

        txtCodigoArticulo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArticulo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addComponent(spMovimiento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel1)))
                                            .addComponent(jLabel4))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdIngreso)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdEgreso)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdDevolucion))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtCodigoMov)
                                                    .addComponent(txtProveedor)
                                                    .addComponent(txtPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btBuscaProveedor)
                                                    .addComponent(btBuscaPersona)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(btRealizar)
                                .addGap(80, 80, 80)
                                .addComponent(btCancelar)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoArticulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtArticulo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btBuscaArticulo)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdIngreso)
                    .addComponent(rdEgreso)
                    .addComponent(rdDevolucion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPersona)
                    .addComponent(jLabel1)
                    .addComponent(btBuscaPersona)
                    .addComponent(txtCodigoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaProveedor)
                    .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaArticulo)
                    .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgregar)
                    .addComponent(btQuitar)
                    .addComponent(txtCodigoArticulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(spMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRealizar)
                    .addComponent(btCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btQuitarActionPerformed

    private void txtPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonaActionPerformed

    private void txtCodigoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPersonaActionPerformed

    private void txtCodigoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoArticuloActionPerformed

    private void txtCodigoArticulo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoArticulo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoArticulo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAgregar;
    public javax.swing.JButton btBuscaArticulo;
    public javax.swing.JButton btBuscaPersona;
    public javax.swing.JButton btBuscaProveedor;
    public javax.swing.JButton btCancelar;
    public javax.swing.JButton btQuitar;
    public javax.swing.JButton btRealizar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JRadioButton rdDevolucion;
    public javax.swing.JRadioButton rdEgreso;
    public javax.swing.JRadioButton rdIngreso;
    public javax.swing.JScrollPane spMovimiento;
    public javax.swing.JTable tbMovimiento;
    public javax.swing.JTextField txtArticulo;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCodigoArticulo;
    public javax.swing.JTextField txtCodigoArticulo1;
    public javax.swing.JTextField txtCodigoMov;
    public javax.swing.JTextField txtCodigoPersona;
    public javax.swing.JTextField txtCodigoProveedor;
    public javax.swing.JTextField txtPersona;
    public javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables
}
