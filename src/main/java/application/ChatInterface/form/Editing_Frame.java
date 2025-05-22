
package application.ChatInterface.form;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Editing_Frame extends javax.swing.JFrame {

    
    public Editing_Frame() {
        initComponents();
        init();
    }

    private void init(){
        setLocationRelativeTo(null);
        URL url_icon_signup = Editing_Frame.class.getResource("/application/AdminImage/iconChat.png");
	Image img = Toolkit.getDefaultToolkit().createImage(url_icon_signup);
	setIconImage(img);
        setTitle("KHchat - Setting");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imageAvatar1 = new com.raven.swing.ImageAvatar();
        lbnickname = new javax.swing.JLabel();
        lbfirstname = new javax.swing.JLabel();
        lblastname = new javax.swing.JLabel();
        lbdob = new javax.swing.JLabel();
        lbgender = new javax.swing.JLabel();
        lbphone = new javax.swing.JLabel();
        lbemail = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        buttonSave = new com.raven.swing.Button();
        jtfirstname = new javax.swing.JTextField();
        jtlastname = new javax.swing.JTextField();
        jtdob = new javax.swing.JTextField();
        jtgender = new javax.swing.JTextField();
        jtphone = new javax.swing.JTextField();
        jtemail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaddress = new javax.swing.JTextArea();
        jtnickname = new javax.swing.JTextField();
        buttonCamera = new com.raven.swing.Button();
        buttonBack = new com.raven.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/Black_cat.jpg"))); // NOI18N

        lbnickname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbnickname.setForeground(new java.awt.Color(0, 0, 102));
        lbnickname.setText("Nick Name:");

        lbfirstname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbfirstname.setForeground(new java.awt.Color(0, 0, 102));
        lbfirstname.setText("First Name:");

        lblastname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblastname.setForeground(new java.awt.Color(0, 0, 102));
        lblastname.setText("Last Name:");

        lbdob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbdob.setForeground(new java.awt.Color(0, 0, 102));
        lbdob.setText("Date of Birh:");

        lbgender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbgender.setForeground(new java.awt.Color(0, 0, 102));
        lbgender.setText("Gender:");

        lbphone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbphone.setForeground(new java.awt.Color(0, 0, 102));
        lbphone.setText("Phone:");

        lbemail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbemail.setForeground(new java.awt.Color(0, 0, 102));
        lbemail.setText("Email:");

        lbaddress.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbaddress.setForeground(new java.awt.Color(0, 0, 102));
        lbaddress.setText("Address:");

        buttonSave.setBackground(new java.awt.Color(222, 238, 255));
        buttonSave.setForeground(new java.awt.Color(0, 0, 102));
        buttonSave.setText("Save");
        buttonSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jtfirstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfirstnameActionPerformed(evt);
            }
        });

        jtlastname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtlastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtlastnameActionPerformed(evt);
            }
        });

        jtdob.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtdob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtdobActionPerformed(evt);
            }
        });

        jtgender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtgenderActionPerformed(evt);
            }
        });

        jtphone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtphoneActionPerformed(evt);
            }
        });

        jtemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtemailActionPerformed(evt);
            }
        });

        jtaddress.setColumns(20);
        jtaddress.setRows(5);
        jScrollPane1.setViewportView(jtaddress);

        jtnickname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        buttonCamera.setForeground(new java.awt.Color(0, 0, 102));
        buttonCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/camera.png"))); // NOI18N
        buttonCamera.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCameraActionPerformed(evt);
            }
        });

        buttonBack.setBackground(new java.awt.Color(204, 223, 242));
        buttonBack.setForeground(new java.awt.Color(0, 0, 102));
        buttonBack.setText("Back");
        buttonBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbnickname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbfirstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbdob, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbphone, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbemail, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfirstname)
                            .addComponent(jtlastname)
                            .addComponent(jtdob)
                            .addComponent(jtgender)
                            .addComponent(jtphone)
                            .addComponent(jtemail)
                            .addComponent(jScrollPane1)
                            .addComponent(jtnickname)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnickname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtnickname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbfirstname)
                    .addComponent(jtfirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtdob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbgender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbphone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbemail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbaddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfirstnameActionPerformed

    private void jtlastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtlastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtlastnameActionPerformed

    private void jtdobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtdobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtdobActionPerformed

    private void jtgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtgenderActionPerformed

    private void jtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtphoneActionPerformed

    private void jtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtemailActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new application.ChatInterface.form.Setting_Frame().setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCameraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCameraActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editing_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button buttonBack;
    private com.raven.swing.Button buttonCamera;
    private com.raven.swing.Button buttonSave;
    private com.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaddress;
    private javax.swing.JTextField jtdob;
    private javax.swing.JTextField jtemail;
    private javax.swing.JTextField jtfirstname;
    private javax.swing.JTextField jtgender;
    private javax.swing.JTextField jtlastname;
    private javax.swing.JTextField jtnickname;
    private javax.swing.JTextField jtphone;
    private javax.swing.JLabel lbaddress;
    private javax.swing.JLabel lbdob;
    private javax.swing.JLabel lbemail;
    private javax.swing.JLabel lbfirstname;
    private javax.swing.JLabel lbgender;
    private javax.swing.JLabel lblastname;
    private javax.swing.JLabel lbnickname;
    private javax.swing.JLabel lbphone;
    // End of variables declaration//GEN-END:variables
}
