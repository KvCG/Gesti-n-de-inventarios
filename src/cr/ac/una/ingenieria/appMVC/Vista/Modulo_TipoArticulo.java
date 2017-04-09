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
public class Modulo_TipoArticulo extends javax.swing.JInternalFrame {

    /**
     * Creates new form a
     */
    public Modulo_TipoArticulo() {
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

        btn_Guardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_Editar = new javax.swing.JButton();
        jtf_Descripcion = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();
        jcb_Estado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_Cancelar = new javax.swing.JButton();
        jtf_IdTipoArticulo = new javax.swing.JTextField();
        btn_Eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("AGREGAR TIPO ARTICULO");

        btn_Guardar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Guardar 00.png"))); // NOI18N
        btn_Guardar.setText("GUARDAR");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("ESTADO");

        btn_Editar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Editar 01.png"))); // NOI18N
        btn_Editar.setText("EDITAR");

        btn_Buscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Busar.png"))); // NOI18N
        btn_Buscar.setText("BUSCAR");

        jcb_Estado.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcb_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("ID TIPO ARTICULO");

        btn_Cancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Cancelar.png"))); // NOI18N
        btn_Cancelar.setText("CANCELAR");

        jtf_IdTipoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_IdTipoArticuloActionPerformed(evt);
            }
        });

        btn_Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Eliminar.png"))); // NOI18N
        btn_Eliminar.setText("ELIMINAR");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("DESCRIPCION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtf_IdTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtf_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jcb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_IdTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jcb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Guardar)
                    .addComponent(btn_Editar)
                    .addComponent(btn_Buscar)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Eliminar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_IdTipoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_IdTipoArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_IdTipoArticuloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Buscar;
    public javax.swing.JButton btn_Cancelar;
    public javax.swing.JButton btn_Editar;
    public javax.swing.JButton btn_Eliminar;
    public javax.swing.JButton btn_Guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JComboBox<String> jcb_Estado;
    public javax.swing.JTextField jtf_Descripcion;
    public javax.swing.JTextField jtf_IdTipoArticulo;
    // End of variables declaration//GEN-END:variables
}