
package cr.ac.una.ingenieria.appMVC.Vista;
import cr.ac.una.ingenieria.appMVC.BL.ArticuloBL;
import cr.ac.una.ingenieria.appMVC.BL.PersonaBL;
import cr.ac.una.ingenieria.appMVC.BL.ProveedorBL;
import cr.ac.una.ingenieria.appMVC.BL.UsuarioBL;
import cr.ac.una.ingenieria.appMVC.Controlador.ArticuloControlador;
import cr.ac.una.ingenieria.appMVC.Controlador.PersonaControlador;
import cr.ac.una.ingenieria.appMVC.Controlador.ProveedorControlador;
import cr.ac.una.ingenieria.appMVC.Controlador.UsuarioControlador;



public class PantallaPrincipal extends javax.swing.JFrame {
    //control de pantalla
    boolean Mod_Inv = false;
    boolean Mod_Reg_Per = false;
    boolean Mod_Reg_Usu = false;
    boolean Mod_Pro = false;
    boolean Mod_Mov = false;
    
    //pantallas
    Modulo_Inventario Mante_ArticulosView;
    Modulo_Registo_Persona Mod_Reg_PerView;
    Modulo_Registo_Usuario Mod_Reg_UsuView;
    Modulo_Proveedores Mod_ProveView;
    MantPersonaBuscar mantPersonaBView;
    
           
    //constructor       
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
        
        //para la venta modulo inventario
        this.Mante_ArticulosView = new Modulo_Inventario();
        ArticuloBL ArtBL = new ArticuloBL();
        ArticuloControlador ArtControl = new ArticuloControlador(Mante_ArticulosView,ArtBL);
        ArtControl.getMantArticuloView();
        
        //para la venta modulo Modulo_Registo_Persona
        this.Mod_Reg_PerView = new Modulo_Registo_Persona();
        PersonaBL perBL = new PersonaBL();
        PersonaControlador perControl = new PersonaControlador(Mod_Reg_PerView, perBL);
        perControl.getMod_Reg_PersonaView(); 
        
        //para la venta modulo Modulo_Registo_Usuario
        this.Mod_Reg_UsuView = new Modulo_Registo_Usuario();
        UsuarioBL usuBL = new UsuarioBL();
        //this.Mod_Reg_PerView = new Modulo_Registo_Persona();
        this.mantPersonaBView = new MantPersonaBuscar();
//        PersonaBL perBL1 = new PersonaBL();
        UsuarioControlador UsuControl = new UsuarioControlador(Mod_Reg_UsuView,usuBL,perBL,Mod_Reg_PerView,mantPersonaBView);
        UsuControl.getMantUsuarioview();
        
        //para la venta modulo Modulo_Registo_Persona
        this.Mod_ProveView = new Modulo_Proveedores();
        ProveedorBL proveBL = new ProveedorBL();
        ProveedorControlador proveeControl = new ProveedorControlador(Mod_ProveView, proveBL);
        proveeControl.getMantProveedorView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jdpPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMantenimiento = new javax.swing.JMenu();
        jMenuArticulo = new javax.swing.JMenuItem();
        jMenuProveedores = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiPersona = new javax.swing.JMenuItem();
        jmiUsuario = new javax.swing.JMenuItem();
        jmMovimiento = new javax.swing.JMenu();
        jMenuEstadisticas = new javax.swing.JMenu();
        ReportesArticulos = new javax.swing.JMenu();
        ReporteArticulos = new javax.swing.JMenuItem();
        jmiArticulosMinimo = new javax.swing.JMenuItem();
        jmiArticuloGravado = new javax.swing.JMenuItem();
        jmiArticuloExento = new javax.swing.JMenuItem();
        ReporteProveedores = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jmInformacion = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGACI");

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setFocusable(false);

        jMenuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Modulo.png"))); // NOI18N
        jMenuMantenimiento.setText("Modulos");
        jMenuMantenimiento.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuArticulo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuArticulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Inventario 00.png"))); // NOI18N
        jMenuArticulo.setText("Inventario");
        jMenuArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArticuloActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuArticulo);

        jMenuProveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuProveedores.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Proveedor.png"))); // NOI18N
        jMenuProveedores.setText("Proveedores");
        jMenuProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProveedoresActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuProveedores);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Registro.png"))); // NOI18N
        jMenu2.setText("Registro");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jmiPersona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jmiPersona.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jmiPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Cliente01.png"))); // NOI18N
        jmiPersona.setText("Persona");
        jmiPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPersonaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiPersona);

        jmiUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jmiUsuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jmiUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Usuario01.png"))); // NOI18N
        jmiUsuario.setText("Usuario");
        jmiUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(jmiUsuario);

        jMenuMantenimiento.add(jMenu2);

        jMenuBar1.add(jMenuMantenimiento);

        jmMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Movimiento.png"))); // NOI18N
        jmMovimiento.setText("Movimientos");
        jmMovimiento.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuBar1.add(jmMovimiento);

        jMenuEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 02.png"))); // NOI18N
        jMenuEstadisticas.setText("Reportes");
        jMenuEstadisticas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        ReportesArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Articulo.png"))); // NOI18N
        ReportesArticulos.setText("Articulos");
        ReportesArticulos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        ReporteArticulos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ReporteArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        ReporteArticulos.setText("General");
        ReportesArticulos.add(ReporteArticulos);

        jmiArticulosMinimo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jmiArticulosMinimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        jmiArticulosMinimo.setText("Minimos");
        ReportesArticulos.add(jmiArticulosMinimo);

        jmiArticuloGravado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jmiArticuloGravado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        jmiArticuloGravado.setText("Gravado");
        ReportesArticulos.add(jmiArticuloGravado);

        jmiArticuloExento.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jmiArticuloExento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Reporte 01.png"))); // NOI18N
        jmiArticuloExento.setText("Exento");
        ReportesArticulos.add(jmiArticuloExento);

        jMenuEstadisticas.add(ReportesArticulos);

        ReporteProveedores.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ReporteProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Proveedor.png"))); // NOI18N
        ReporteProveedores.setText("Proveedores");
        jMenuEstadisticas.add(ReporteProveedores);

        jMenuItem6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Lista01.png"))); // NOI18N
        jMenuItem6.setText("Lista Precios");
        jMenuEstadisticas.add(jMenuItem6);

        jMenuBar1.add(jMenuEstadisticas);

        jmInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Info.png"))); // NOI18N
        jmInformacion.setText("Informacion");
        jmInformacion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuBar1.add(jmInformacion);

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
                .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArticuloActionPerformed
        try {
            if(this.Mod_Inv == false){
                int x = (this.jdpPrincipal.getWidth() / 2) - (this.Mante_ArticulosView.getWidth() / 2);
                int y = (this.jdpPrincipal.getHeight()/ 2) - (this.Mante_ArticulosView.getHeight() / 2);
                this.Mante_ArticulosView.setLocation(x, y);
                
                this.jdpPrincipal.add(this.Mante_ArticulosView);
                this.jdpPrincipal.updateUI();
                this.jdpPrincipal.repaint();
                this.Mante_ArticulosView.show();
                this.Mod_Inv = true;
            }
            else{
                this.Mante_ArticulosView.show();
                this.Mante_ArticulosView.toFront();
                this.Mod_Inv = false;
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jMenuArticuloActionPerformed

    private void jmiPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPersonaActionPerformed
        try {
            if(this.Mod_Reg_Per == false){
                int x = (this.jdpPrincipal.getWidth() / 2) - (this.Mod_Reg_PerView.getWidth() / 2);
                int y = (this.jdpPrincipal.getHeight()/ 2) - (this.Mod_Reg_PerView.getHeight() / 2);
                this.Mod_Reg_PerView.setLocation(x, y);
                
                this.jdpPrincipal.add(this.Mod_Reg_PerView);
                this.jdpPrincipal.updateUI();
                this.jdpPrincipal.repaint();
                this.Mod_Reg_PerView.show();
                this.Mod_Reg_Per = true;
            }
            else{
                this.Mod_Reg_PerView.show();
                this.Mod_Reg_PerView.toFront();
                this.Mod_Reg_Per = false;
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jmiPersonaActionPerformed

    private void jmiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuarioActionPerformed
       try {
            if(this.Mod_Reg_Usu == false){
                int x = (this.jdpPrincipal.getWidth() / 2) - (this.Mod_Reg_UsuView.getWidth() / 2);
                int y = (this.jdpPrincipal.getHeight()/ 2) - (this.Mod_Reg_UsuView.getHeight() / 2);
                this.Mod_Reg_UsuView.setLocation(x, y);
                
                this.jdpPrincipal.add(this.Mod_Reg_UsuView);
                this.jdpPrincipal.updateUI();
                this.jdpPrincipal.repaint();
                this.Mod_Reg_UsuView.show();
                this.Mod_Reg_Usu = true;
            }
            else{
                this.Mod_Reg_UsuView.show();
                this.Mod_Reg_UsuView.toFront();
                this.Mod_Reg_Usu = false;
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jmiUsuarioActionPerformed

    private void jMenuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProveedoresActionPerformed
        try {
            if(this.Mod_Pro == false){
                int x = (this.jdpPrincipal.getWidth() / 2) - (this.Mod_ProveView.getWidth() / 2);
                int y = (this.jdpPrincipal.getHeight()/ 2) - (this.Mod_ProveView.getHeight() / 2);
                this.Mod_ProveView.setLocation(x, y);
                
                this.jdpPrincipal.add(this.Mod_ProveView);
                this.jdpPrincipal.updateUI();
                this.jdpPrincipal.repaint();
                this.Mod_ProveView.show();
                this.Mod_Pro = true;
            }
            else{
                this.Mod_ProveView.show();
                this.Mod_ProveView.toFront();
                this.Mod_Pro = false;
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jMenuProveedoresActionPerformed

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
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem ReporteArticulos;
    public javax.swing.JMenuItem ReporteProveedores;
    private javax.swing.JMenu ReportesArticulos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    public javax.swing.JMenuItem jMenuArticulo;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jMenuEstadisticas;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu jMenuMantenimiento;
    public javax.swing.JMenuItem jMenuProveedores;
    private javax.swing.JDesktopPane jdpPrincipal;
    public javax.swing.JMenu jmInformacion;
    private javax.swing.JMenu jmMovimiento;
    public javax.swing.JMenuItem jmiArticuloExento;
    public javax.swing.JMenuItem jmiArticuloGravado;
    public javax.swing.JMenuItem jmiArticulosMinimo;
    public javax.swing.JMenuItem jmiPersona;
    private javax.swing.JMenuItem jmiUsuario;
    // End of variables declaration//GEN-END:variables
}
