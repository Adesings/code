/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;
import Controladores.*; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author miguelhernandez
 */
public class Busqueda extends javax.swing.JFrame {

    /**
     * Creates new form Busqueda
     */
    public Busqueda() {
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color (224,255,255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Busqueda = new javax.swing.JLabel();
        lbl_NombreBusqueda = new javax.swing.JLabel();
        lbl_ApellidoPaternoBusqueda = new javax.swing.JLabel();
        txt_NombreBusqueda = new javax.swing.JTextField();
        txt_ApellidoPaternoBusqueda = new javax.swing.JTextField();
        btn_CancelarBusqueda = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        img_Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Busqueda.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbl_Busqueda.setText("Búsqueda:");
        getContentPane().add(lbl_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        lbl_NombreBusqueda.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_NombreBusqueda.setText("Nombre(s) del Propietario:");
        getContentPane().add(lbl_NombreBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 290, 40));

        lbl_ApellidoPaternoBusqueda.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_ApellidoPaternoBusqueda.setText("Apellido paterno:");
        getContentPane().add(lbl_ApellidoPaternoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 190, -1));

        txt_NombreBusqueda.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(txt_NombreBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 420, 40));

        txt_ApellidoPaternoBusqueda.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(txt_ApellidoPaternoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 420, 40));

        btn_CancelarBusqueda.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btn_CancelarBusqueda.setText("Cancelar Búsqueda");
        btn_CancelarBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CancelarBusquedaMouseClicked(evt);
            }
        });
        getContentPane().add(btn_CancelarBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, 50));

        btn_Buscar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btn_Buscar.setText("Buscar");
        btn_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BuscarMouseClicked(evt);
            }
        });
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 160, 50));

        img_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        getContentPane().add(img_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CancelarBusquedaMouseClicked
        EligeOpcion EO = new EligeOpcion();
        EO.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_CancelarBusquedaMouseClicked

    private void btn_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BuscarMouseClicked
        
        String nombrePropietario = txt_NombreBusqueda.getText() ;
        String apellidoPaterno = txt_ApellidoPaternoBusqueda.getText();
        
            Ctrl_Busqueda busqueda = new Ctrl_Busqueda();
            try {
            busqueda.buscar(nombrePropietario,apellidoPaterno);
            } catch (SQLException ex) {
            
            }
            
            dispose();
            
    }//GEN-LAST:event_btn_BuscarMouseClicked

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        
    }//GEN-LAST:event_btn_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_CancelarBusqueda;
    private javax.swing.JLabel img_Logo;
    private javax.swing.JLabel lbl_ApellidoPaternoBusqueda;
    private javax.swing.JLabel lbl_Busqueda;
    private javax.swing.JLabel lbl_NombreBusqueda;
    private javax.swing.JTextField txt_ApellidoPaternoBusqueda;
    private javax.swing.JTextField txt_NombreBusqueda;
    // End of variables declaration//GEN-END:variables

    }
