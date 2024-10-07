package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author camilosar
 */
public class VistaTienda extends javax.swing.JPanel {

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JButton getBotonAnterior() {
        return BotonAnterior;
    }

    public JButton getBotonSiguiente() {
        return BotonSiguiente;
    }

    public JButton getBotonVolver() {
        return BotonVolver;
    }

    public JPanel getContenedorImagen() {
        return ContenedorImagen;
    }

    public JTextField getLabelDescripcion() {
        return LabelDescripcion;
    }

    public JTextField getLabelNombre() {
        return LabelNombre;
    }

    public JLabel getRareza() {
        return Rareza;
    }



    /**
     * Creates new form VistaTienda
     */
    public VistaTienda() {
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
        ContenedorImagen = new javax.swing.JPanel();
        LabelDescripcion = new javax.swing.JTextField();
        LabelNombre = new javax.swing.JTextField();
        BotonAnterior = new javax.swing.JButton();
        BotonSiguiente = new javax.swing.JButton();
        BotonVolver = new javax.swing.JButton();
        Rareza = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(53, 68, 139));

        ContenedorImagen.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout ContenedorImagenLayout = new javax.swing.GroupLayout(ContenedorImagen);
        ContenedorImagen.setLayout(ContenedorImagenLayout);
        ContenedorImagenLayout.setHorizontalGroup(
            ContenedorImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        ContenedorImagenLayout.setVerticalGroup(
            ContenedorImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        LabelDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LabelDescripcion.setText("Descripción de la skin");
        LabelDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelDescripcionActionPerformed(evt);
            }
        });

        LabelNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LabelNombre.setText("Nombre Skin");
        LabelNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelNombreActionPerformed(evt);
            }
        });

        BotonAnterior.setBackground(new java.awt.Color(53, 68, 139));
        BotonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/izquierda.png"))); // NOI18N
        BotonAnterior.setBorder(null);
        BotonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnteriorActionPerformed(evt);
            }
        });

        BotonSiguiente.setBackground(new java.awt.Color(53, 68, 139));
        BotonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/derecha.png"))); // NOI18N
        BotonSiguiente.setBorder(null);
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });

        BotonVolver.setBackground(new java.awt.Color(53, 68, 139));
        BotonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/button_volver.png"))); // NOI18N
        BotonVolver.setBorder(null);

        Rareza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Epica.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(BotonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ContenedorImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(BotonVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(LabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(Rareza)))
                .addGap(0, 139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rareza, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(ContenedorImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(BotonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(BotonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(BotonVolver)
                        .addGap(31, 31, 31))))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("mainContainer");
    }// </editor-fold>//GEN-END:initComponents

    private void LabelDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelDescripcionActionPerformed

    private void LabelNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelNombreActionPerformed

    private void BotonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAnteriorActionPerformed

    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnterior;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JButton BotonVolver;
    private javax.swing.JPanel ContenedorImagen;
    private javax.swing.JTextField LabelDescripcion;
    private javax.swing.JTextField LabelNombre;
    private javax.swing.JLabel Rareza;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}