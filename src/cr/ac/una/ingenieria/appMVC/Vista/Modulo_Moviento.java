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
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        lbTota = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MOVIMIENTO ARTICULO");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("RESPONSABLE:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("PROVEEDOR:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("CODIGO MOVIMIENTO:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("TIPO MOVIMIENTO:");

        rdIngreso.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdIngreso.setForeground(new java.awt.Color(0, 204, 0));
        rdIngreso.setText("INGRESO");

        rdEgreso.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdEgreso.setForeground(new java.awt.Color(255, 51, 51));
        rdEgreso.setText("EGRESO");

        rdDevolucion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdDevolucion.setForeground(new java.awt.Color(51, 51, 255));
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

        btBuscaProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btBuscaProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Buscar02.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("ARTICULO:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("CANTIDAD:");

        txtCantidad.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        txtArticulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btBuscaArticulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btBuscaArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Buscar02.png"))); // NOI18N
        btBuscaArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaArticuloActionPerformed(evt);
            }
        });

        btAgregar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagenes/002-signs.png"))); // NOI18N

        btQuitar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagenes/001-minus.png"))); // NOI18N
        btQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuitarActionPerformed(evt);
            }
        });

        tbMovimiento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        tbMovimiento.setAutoCreateRowSorter(true);
        tbMovimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Codigo", "Codigo Articulo", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMovimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbMovimiento.getTableHeader().setReorderingAllowed(false);
        spMovimiento.setViewportView(tbMovimiento);

        btRealizar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btRealizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Ingresar.png"))); // NOI18N
        btRealizar.setText("REALIZAR");

        btCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Cancelar.png"))); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("EN STOCK:");

        txtStock.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        lbTota.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbTota.setText("TOTAL:");

        lbTotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(255, 51, 51));
        lbTotal.setText("₡0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btRealizar)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lbTota)
                                .addGap(18, 18, 18)
                                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscaPersona)
                                .addGap(38, 38, 38)
                                .addComponent(txtCodigoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscaProveedor)
                                .addGap(38, 38, 38)
                                .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoMov, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(rdIngreso)
                                .addGap(18, 18, 18)
                                .addComponent(rdEgreso)
                                .addGap(18, 18, 18)
                                .addComponent(rdDevolucion))
                            .addComponent(spMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoArticulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(txtPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaPersona)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtCodigoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaProveedor)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(txtCodigoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(rdIngreso)
                    .addComponent(rdEgreso)
                    .addComponent(rdDevolucion))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCodigoArticulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAgregar)
                            .addComponent(btQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btBuscaArticulo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)))
                .addComponent(spMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTota)
                    .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRealizar)
                    .addComponent(btCancelar))
                .addContainerGap())
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

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();

        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyTyped

    private void btBuscaArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscaArticuloActionPerformed


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
    public javax.swing.JLabel jLabel7;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lbTota;
    public javax.swing.JLabel lbTotal;
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
    public javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
