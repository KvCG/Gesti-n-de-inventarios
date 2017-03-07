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
public class Modulo_Registo_Persona extends javax.swing.JInternalFrame {

    /**
     * Creates new form Modulo_Registo_Persona
     */
    public Modulo_Registo_Persona() {
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

        lb_idPersona = new javax.swing.JLabel();
        lb_Cedula = new javax.swing.JLabel();
        lb_Nombre = new javax.swing.JLabel();
        lb_Apellidos = new javax.swing.JLabel();
        lb_Correo = new javax.swing.JLabel();
        jtxtId = new javax.swing.JTextField();
        jtxtCedula = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jtxtCorreo = new javax.swing.JTextField();
        btGuardar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        txtCodigoBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MODULO REGISTRO - PERSONA");
        setMinimumSize(new java.awt.Dimension(730, 310));

        lb_idPersona.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_idPersona.setText("ID");

        lb_Cedula.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_Cedula.setText("CEDULA");

        lb_Nombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_Nombre.setText("NOMBRE");

        lb_Apellidos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_Apellidos.setText("APELLIDOS");

        lb_Correo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_Correo.setText("CORREO ELEC.");

        btGuardar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Guardar 00.png"))); // NOI18N
        btGuardar.setText("GUARDAR");

        btModificar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Editar 01.png"))); // NOI18N
        btModificar.setText("EDITAR");

        btBuscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Busar.png"))); // NOI18N
        btBuscar.setText("BUSCAR");

        btCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Cancelar.png"))); // NOI18N
        btCancelar.setText("CANCELAR");

        btEliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/ingenieria/appMVC/Vista/Imagen/Eliminar.png"))); // NOI18N
        btEliminar.setText("ELIMINAR");

        txtCodigoBuscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCodigoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Apellidos)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtApellido))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Nombre)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_idPersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtId)
                        .addGap(18, 18, 18)
                        .addComponent(lb_Cedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtCedula))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Correo)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtCorreo)))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Cedula)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idPersona))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Nombre)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Apellidos)
                    .addComponent(jtxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Correo)
                    .addComponent(jtxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btModificar)
                    .addComponent(btBuscar)
                    .addComponent(btCancelar)
                    .addComponent(btEliminar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btBuscar;
    public javax.swing.JButton btCancelar;
    public javax.swing.JButton btEliminar;
    public javax.swing.JButton btGuardar;
    public javax.swing.JButton btModificar;
    public javax.swing.JTextField jtxtApellido;
    public javax.swing.JTextField jtxtCedula;
    public javax.swing.JTextField jtxtCorreo;
    public javax.swing.JTextField jtxtId;
    public javax.swing.JTextField jtxtNombre;
    private javax.swing.JLabel lb_Apellidos;
    private javax.swing.JLabel lb_Cedula;
    private javax.swing.JLabel lb_Correo;
    private javax.swing.JLabel lb_Nombre;
    private javax.swing.JLabel lb_idPersona;
    public javax.swing.JTextField txtCodigoBuscar;
    // End of variables declaration//GEN-END:variables
}
