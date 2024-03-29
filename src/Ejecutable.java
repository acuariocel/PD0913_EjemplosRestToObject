import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author INTERNET2
 */
public class Ejecutable extends javax.swing.JFrame {

    private final FuncionesAuto fa;
    private final Funciones f;

    /**
     * Creates new form Ejecutable
     */
    public Ejecutable() {
        initComponents();
        fa = new FuncionesAuto();
        f = new Funciones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ljblPlaca = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtPlaca = new javax.swing.JTextField();
        jtxtColor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ljblPlaca.setText("Placa:");

        jLabel2.setText("Color: ");

        jtxtPlaca.setText("LBA1234");
        jtxtPlaca.setToolTipText("Presione enter para buscar");
        jtxtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtPlacaKeyReleased(evt);
            }
        });

        jtxtColor.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtColor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ljblPlaca)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ljblPlaca)
                    .addComponent(jtxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(218, 123));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPlacaKeyReleased

        if (evt.getKeyCode() == 10) {
            if (!jtxtPlaca.getText().isEmpty()) {
                Autos auto = fa.jsonToObject(f.obtienePorGet("http://localhost:8080/PD0913_EjemploRest/webresources/modelo.autos/findForPlaca/placa=" + jtxtPlaca.getText()));
                if (auto != null) {
                    jtxtColor.setText(auto.getColor());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Datos no encontrados");
                    jtxtPlaca.setText(null);
                    jtxtColor.setText(null);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ingrese una placa");
            }

        }
    }//GEN-LAST:event_jtxtPlacaKeyReleased

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
            java.util.logging.Logger.getLogger(Ejecutable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejecutable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejecutable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejecutable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejecutable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtxtColor;
    private javax.swing.JTextField jtxtPlaca;
    private javax.swing.JLabel ljblPlaca;
    // End of variables declaration//GEN-END:variables
}
