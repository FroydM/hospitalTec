
package vista;

/**
 *
 * @author SITARE
 */
public class SolicitarCitaDoctor extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearCita
     */
    public SolicitarCitaDoctor() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbEspecialida = new javax.swing.JComboBox<>();
        dtCalendario = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtSangre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        txtTel1 = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("CITA M??DICA");
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setMinimumSize(new java.awt.Dimension(75, 31));
        setPreferredSize(new java.awt.Dimension(828, 557));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Observaciones");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 10));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        cbEspecialida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbEspecialida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 250, 30));

        dtCalendario.setDateFormatString("dd/ MMM/yyyy HH:mm");
        dtCalendario.setMinSelectableDate(new java.util.Date(-62135747884000L));
        jPanel1.add(dtCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 290, 30));

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 250, -1));

        jLabel9.setText("Fecha");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(0, 204, 51));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 150, 40));

        jLabel10.setText("Especialidad");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("SOLICITUD DE CITA M??DICA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 40));

        jLabel12.setText("ID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setForeground(new java.awt.Color(204, 255, 255));
        jPanel2.setDoubleBuffered(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DATOS DEL PACIENTE");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 40));

        jLabel4.setText("Nacionalidad:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        jLabel5.setText("Nombre: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel6.setText("Sangre:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel13.setText("Apellido 1:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 20));
        jPanel2.add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 200, 20));
        jPanel2.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 200, 20));
        jPanel2.add(txtSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 200, 20));

        jLabel14.setText("Apellido 2: ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel15.setText("Identificaci??n:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel16.setText("Residencia");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        jLabel17.setText("Fecha de nacimiento:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 150, 30));

        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });
        jPanel2.add(txtProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 200, 20));

        txtNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacionalidadActionPerformed(evt);
            }
        });
        jPanel2.add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 200, 20));
        jPanel2.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 200, 20));

        jLabel18.setText("Email:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jLabel19.setText("Telefono");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        txtEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 200, 20));

        txtTel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTel1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 200, 20));

        btnBuscarPaciente.setText("Buscar");
        jPanel2.add(btnBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getAccessibleContext().setAccessibleName("SOLICITARCITA");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void txtNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacionalidadActionPerformed

    private void txtEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail1ActionPerformed

    private void txtTel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTel1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarPaciente;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cbEspecialida;
    public com.toedter.calendar.JDateChooser dtCalendario;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField txtApellido1;
    public javax.swing.JTextField txtApellido2;
    public javax.swing.JTextField txtEmail1;
    public javax.swing.JFormattedTextField txtFechaNacimiento;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtNacionalidad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextArea txtObservaciones;
    public javax.swing.JTextField txtProvincia;
    public javax.swing.JTextField txtSangre;
    public javax.swing.JTextField txtTel1;
    // End of variables declaration//GEN-END:variables
}
