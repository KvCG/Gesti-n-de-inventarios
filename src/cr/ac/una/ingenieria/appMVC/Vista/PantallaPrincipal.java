package cr.ac.una.ingenieria.appMVC.Vista;

public class PantallaPrincipal extends javax.swing.JFrame {    
    public PantallaPrincipal() {
        setTitle("SIGACI");
        this.setLocationRelativeTo(null);
        this.setExtendedState(PantallaPrincipal.MAXIMIZED_BOTH);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jdpPrincipal = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTArticulo = new javax.swing.JTable();
        LbTituloCuadro = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Mantenimiento = new javax.swing.JMenu();
        jMenuItem_Articulo = new javax.swing.JMenuItem();
        jMenuItem_Proveedores = new javax.swing.JMenuItem();
        jMenu_Registro = new javax.swing.JMenu();
        jMenuItem_Registro_Persona = new javax.swing.JMenuItem();
        jMenuItem_Registro_Usuario = new javax.swing.JMenuItem();
        jMenu_Movimiento = new javax.swing.JMenu();
        jMenuItem_Movimientos = new javax.swing.JMenuItem();
        jMenu_Herramientas = new javax.swing.JMenu();
        jMenuItem_Bodega = new javax.swing.JMenuItem();
        jMenuItem_TipoArticulo = new javax.swing.JMenuItem();
        jMenu_Reportes = new javax.swing.JMenu();
        jMenu_ReportesArticulos = new javax.swing.JMenu();
        jMenuItem_ReporteArticulos_General = new javax.swing.JMenuItem();
        jMenuItem_ReporteArticulos_Minimo = new javax.swing.JMenuItem();
        jMenuItem_ReporteArticulos_Gravado = new javax.swing.JMenuItem();
        jMenuItem_ReporteArticulos_Exentos = new javax.swing.JMenuItem();
        jMenuItem_Reporte_Proveedores = new javax.swing.JMenuItem();
        jMenuItem_Reporte_ListaPrecio = new javax.swing.JMenuItem();
        jMenu_Informacion = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGACI");

        jTArticulo.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Minimo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTArticulo.setFocusable(false);
        jScrollPane1.setViewportView(jTArticulo);
        if (jTArticulo.getColumnModel().getColumnCount() > 0) {
            jTArticulo.getColumnModel().getColumn(0).setResizable(false);
        }

        jdpPrincipal.add(jScrollPane1);

        jScrollPane1.setBounds(0, 40, 600, 420);

        jScrollPane1.setBounds(0, 40, 452, 100);


        LbTituloCuadro.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        LbTituloCuadro.setForeground(new java.awt.Color(255, 255, 255));
        LbTituloCuadro.setText(" Punto de Pedido");
        jdpPrincipal.add(LbTituloCuadro);
        LbTituloCuadro.setBounds(190, 10, 220, 20);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setFocusable(false);

        jMenu_Mantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Modulo.png"))); // NOI18N
        jMenu_Mantenimiento.setText("Modulos");
        jMenu_Mantenimiento.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem_Articulo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem_Articulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Articulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Inventario 00.png"))); // NOI18N
        jMenuItem_Articulo.setText("Inventario");
        jMenuItem_Articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ArticuloActionPerformed(evt);
            }
        });
        jMenu_Mantenimiento.add(jMenuItem_Articulo);

        jMenuItem_Proveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem_Proveedores.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Proveedor.png"))); // NOI18N
        jMenuItem_Proveedores.setText("Proveedores");
        jMenuItem_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ProveedoresActionPerformed(evt);
            }
        });
        jMenu_Mantenimiento.add(jMenuItem_Proveedores);

        jMenu_Registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Registro.png"))); // NOI18N
        jMenu_Registro.setText("Registro");
        jMenu_Registro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem_Registro_Persona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem_Registro_Persona.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Registro_Persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Cliente01.png"))); // NOI18N
        jMenuItem_Registro_Persona.setText("Persona");
        jMenuItem_Registro_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Registro_PersonaActionPerformed(evt);
            }
        });
        jMenu_Registro.add(jMenuItem_Registro_Persona);

        jMenuItem_Registro_Usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem_Registro_Usuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Registro_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Usuario01.png"))); // NOI18N
        jMenuItem_Registro_Usuario.setText("Usuario");
        jMenuItem_Registro_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Registro_UsuarioActionPerformed(evt);
            }
        });
        jMenu_Registro.add(jMenuItem_Registro_Usuario);

        jMenu_Mantenimiento.add(jMenu_Registro);

        jMenuBar1.add(jMenu_Mantenimiento);

        jMenu_Movimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Movimiento.png"))); // NOI18N
        jMenu_Movimiento.setText("Movimientos");
        jMenu_Movimiento.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem_Movimientos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem_Movimientos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Movimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Movimiento.png"))); // NOI18N
        jMenuItem_Movimientos.setText("Movimientos");
        jMenuItem_Movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_MovimientosActionPerformed(evt);
            }
        });
        jMenu_Movimiento.add(jMenuItem_Movimientos);

        jMenuBar1.add(jMenu_Movimiento);

        jMenu_Herramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Herramientas.png"))); // NOI18N
        jMenu_Herramientas.setText("Mantenimiento");
        jMenu_Herramientas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem_Bodega.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem_Bodega.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Bodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Bodega01.png"))); // NOI18N
        jMenuItem_Bodega.setText("Bodega");
        jMenuItem_Bodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_BodegaActionPerformed(evt);
            }
        });
        jMenu_Herramientas.add(jMenuItem_Bodega);

        jMenuItem_TipoArticulo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem_TipoArticulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_TipoArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Lista01.png"))); // NOI18N
        jMenuItem_TipoArticulo.setText("Tipo Articulo");
        jMenuItem_TipoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_TipoArticuloActionPerformed(evt);
            }
        });
        jMenu_Herramientas.add(jMenuItem_TipoArticulo);

        jMenuBar1.add(jMenu_Herramientas);

        jMenu_Reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 02.png"))); // NOI18N
        jMenu_Reportes.setText("Reportes");
        jMenu_Reportes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenu_ReportesArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Articulo.png"))); // NOI18N
        jMenu_ReportesArticulos.setText("Articulos");
        jMenu_ReportesArticulos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem_ReporteArticulos_General.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_ReporteArticulos_General.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        jMenuItem_ReporteArticulos_General.setText("General");
        jMenu_ReportesArticulos.add(jMenuItem_ReporteArticulos_General);

        jMenuItem_ReporteArticulos_Minimo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_ReporteArticulos_Minimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        jMenuItem_ReporteArticulos_Minimo.setText("Minimos");
        jMenu_ReportesArticulos.add(jMenuItem_ReporteArticulos_Minimo);

        jMenuItem_ReporteArticulos_Gravado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_ReporteArticulos_Gravado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        jMenuItem_ReporteArticulos_Gravado.setText("Gravado");
        jMenu_ReportesArticulos.add(jMenuItem_ReporteArticulos_Gravado);

        jMenuItem_ReporteArticulos_Exentos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_ReporteArticulos_Exentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        jMenuItem_ReporteArticulos_Exentos.setText("Exento");
        jMenu_ReportesArticulos.add(jMenuItem_ReporteArticulos_Exentos);

        jMenu_Reportes.add(jMenu_ReportesArticulos);

        jMenuItem_Reporte_Proveedores.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Reporte_Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Proveedor.png"))); // NOI18N
        jMenuItem_Reporte_Proveedores.setText("Proveedores");
        jMenu_Reportes.add(jMenuItem_Reporte_Proveedores);

        jMenuItem_Reporte_ListaPrecio.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem_Reporte_ListaPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Lista01.png"))); // NOI18N
        jMenuItem_Reporte_ListaPrecio.setText("Lista Precios");
        jMenu_Reportes.add(jMenuItem_Reporte_ListaPrecio);

        jMenuBar1.add(jMenu_Reportes);

        jMenu_Informacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Info.png"))); // NOI18N
        jMenu_Informacion.setText("Informacion");
        jMenu_Informacion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu_Informacion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_ArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ArticuloActionPerformed
    }//GEN-LAST:event_jMenuItem_ArticuloActionPerformed

    private void jMenuItem_Registro_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Registro_PersonaActionPerformed

    }//GEN-LAST:event_jMenuItem_Registro_PersonaActionPerformed

    private void jMenuItem_Registro_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Registro_UsuarioActionPerformed
//      
    }//GEN-LAST:event_jMenuItem_Registro_UsuarioActionPerformed

    private void jMenuItem_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ProveedoresActionPerformed

    }//GEN-LAST:event_jMenuItem_ProveedoresActionPerformed

    private void jMenuItem_MovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_MovimientosActionPerformed

    }//GEN-LAST:event_jMenuItem_MovimientosActionPerformed

    private void jMenuItem_BodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_BodegaActionPerformed

    }//GEN-LAST:event_jMenuItem_BodegaActionPerformed

    private void jMenuItem_TipoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_TipoArticuloActionPerformed

    }//GEN-LAST:event_jMenuItem_TipoArticuloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LbTituloCuadro;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem_Articulo;
    public javax.swing.JMenuItem jMenuItem_Bodega;
    public javax.swing.JMenuItem jMenuItem_Movimientos;
    public javax.swing.JMenuItem jMenuItem_Proveedores;
    public javax.swing.JMenuItem jMenuItem_Registro_Persona;
    public javax.swing.JMenuItem jMenuItem_Registro_Usuario;
    public javax.swing.JMenuItem jMenuItem_ReporteArticulos_Exentos;
    public javax.swing.JMenuItem jMenuItem_ReporteArticulos_General;
    public javax.swing.JMenuItem jMenuItem_ReporteArticulos_Gravado;
    public javax.swing.JMenuItem jMenuItem_ReporteArticulos_Minimo;
    public javax.swing.JMenuItem jMenuItem_Reporte_ListaPrecio;
    public javax.swing.JMenuItem jMenuItem_Reporte_Proveedores;
    public javax.swing.JMenuItem jMenuItem_TipoArticulo;
    public javax.swing.JMenu jMenu_Herramientas;
    public javax.swing.JMenu jMenu_Informacion;
    public javax.swing.JMenu jMenu_Mantenimiento;
    public javax.swing.JMenu jMenu_Movimiento;
    public javax.swing.JMenu jMenu_Registro;
    public javax.swing.JMenu jMenu_Reportes;
    private javax.swing.JMenu jMenu_ReportesArticulos;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTArticulo;
    public javax.swing.JDesktopPane jdpPrincipal;
    // End of variables declaration//GEN-END:variables
}
