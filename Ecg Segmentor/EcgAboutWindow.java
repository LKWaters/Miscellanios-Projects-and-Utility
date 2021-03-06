package bio.ecg;/*
 * aboutECG.java
 *
 * See EcgLicense.txt for License terms.
 */

import javax.swing.*;



public class EcgAboutWindow extends javax.swing.JDialog {
    
    /** Creates new form aboutECG */
    public EcgAboutWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(400,530);
        setHelpText();
    }
    

    private void initComponents() {//GEN-BEGIN:initComponents
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About ECG...");
        setModal(true);
        jLabel1.setFont(new java.awt.Font("MS Sans Serif", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Java ECG Generator");
        jLabel1.setBounds(80, 20, 230, 30);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        okButton.setBounds(140, 450, 73, 25);
        jDesktopPane1.add(okButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        txtEditor.setEditable(false);
        txtEditor.setContentType("text/html");
        jScrollPane1.setViewportView(txtEditor);

        jScrollPane1.setBounds(14, 84, 360, 350);
        jDesktopPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("MS Sans Serif", 3, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("version 1.0");
        jLabel2.setBounds(220, 50, 140, 30);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new EcgAboutWindow(new JFrame(), true).setVisible(true);
    }  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JEditorPane txtEditor;
    // End of variables declaration//GEN-END:variables
    private void setHelpText() {
        txtEditor.setText( "<html> <body>" +
                           " <table>" +
                           " <tr>" +
                           " <td width='300' align='left' valign='top'>" +
                           "       <p><strong>&copy;</strong> Java code Copyright by Mauricio Villarroel.</p>" +
                           "       <p>Java ECG Generator was developed for ECGSYN.</p>" +
                           "       <p><strong>&copy;</strong> ECGSYN Copyright by Patrick E. McSharry and Gari D. Clifford.</p>" +
                           "       For the Mathematical Model, see:</p>" +
                           "       <table width='100%' border='1' cellspacing='0' cellpadding='5'>" +
                           "         <tr> " +
                           "           <td align='left' valign='top'>" +
                "IEEE Transactions On Biomedical Engineering, " +
                           "             50(3), 289-294, March 2003</td>" +
                           "         </tr>" +
                           "       </table>" +
                           "       <p> Contact: </p>" +
                           "       <ul>" +
                           "         <li>Patrck McSharry (<a href='mailto:patrick@mcsharry.net'>patrick@mcsharry.net</a>)</li>" +
                           "         <li>Gari Clifford (<a href='mailto:gari@mit.edu'>gari@mit.edu</a>)</li>" +
                           "         <li>Mauricio Villarroel (<a href='mailto:m.villarroel@acm.org'>m.villarroel@acm.org</a>)</li>" +
                           "       </ul>" +
                           "       <p align='justify'>Java ECG Generator and all its components are free software. You can" +
                           "          redistribute them or modify it under the terms of the" +
                           "          GNU General Public License as published by the Free Software" +
                           "          Foundation; either version 2 of the License, or (at your option)" +
                           "          any later version.</p></td>" +
                           " </tr>" +
                           " </table>" +
                            "</body> </html>");
    }
}
