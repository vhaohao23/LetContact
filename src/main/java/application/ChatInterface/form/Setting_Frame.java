
package application.ChatInterface.form;

import application.model.User;
import application.raven.swing.Button;
import application.raven.swing.ImageAvatar;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Setting_Frame extends javax.swing.JFrame {
    private final User user;

    public Setting_Frame(User user) {
        this.user = user;
        initComponents();
        init();
    }

    private void init() {
        setLocationRelativeTo(null);
        URL url_icon_signup = Setting_Frame.class.getResource("/application/AdminImage/iconChat.png");
        Image img = Toolkit.getDefaultToolkit().createImage(url_icon_signup);
        setIconImage(img);
        setTitle("KHchat - Setting");

        // Populate user information
        if (user != null) {
            lbnickname.setText(user.getUserName() != null ? user.getUserName() : "N/A");
            lbuserfirstname.setText(user.getFirstName() != null ? user.getFirstName() : "N/A");
            lbuserlastname.setText(user.getLastName() != null ? user.getLastName() : "N/A");

            // Format DOB from Date to dd-MM-yyyy
            java.util.Date dob = user.getDob();
            if (dob != null) {
                try {
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    lbuserdob.setText(outputFormat.format(dob));
                } catch (Exception e) {
                    lbuserdob.setText("N/A");
                    e.printStackTrace();
                }
            } else {
                lbuserdob.setText("N/A");
            }

            lbusergender.setText(user.getGender() != null ? user.getGender() : "N/A");
            lbuserphone.setText(user.getPhone() != null ? user.getPhone() : "N/A");
            lbuseremail.setText(user.getEmail() != null ? user.getEmail() : "N/A");
            lbuseraddress.setText(user.getAddress() != null ? user.getAddress() : "N/A");
            lbuserstatus.setText(user.getStatus() != null ? user.getStatus() : "N/A");

            // Set avatar image
            byte[] avatarBytes = user.getAvatar();
            if (avatarBytes != null && avatarBytes.length > 0) {
                try {
                    ImageIcon avatarIcon = new ImageIcon(avatarBytes);
                    imageAvatar1.setIcon(avatarIcon);
                } catch (Exception e) {
                    System.err.println("Error loading avatar from byte array: " + e.getMessage());
                    // Set default avatar
                    URL defaultUrl = getClass().getResource("/application/AdminImage/avatar.png");
                    if (defaultUrl != null) {
                        imageAvatar1.setIcon(new ImageIcon(defaultUrl));
                    } else {
                        System.err.println("Default avatar image not found at: /application/AdminImage/avatar.png");
                    }
                }
            } else {
                // Set default avatar
                URL defaultUrl = getClass().getResource("/application/AdminImage/avatar.png");
                if (defaultUrl != null) {
                    imageAvatar1.setIcon(new ImageIcon(defaultUrl));
                } else {
                    System.err.println("Default avatar image not found at: /application/AdminImage/avatar.png");
                }
            }
        } else {
            // Fallback if no user is provided
            lbnickname.setText("N/A");
            lbuserfirstname.setText("N/A");
            lbuserlastname.setText("N/A");
            lbuserdob.setText("N/A");
            lbusergender.setText("N/A");
            lbuserphone.setText("N/A");
            lbuseremail.setText("N/A");
            lbuseraddress.setText("N/A");
            lbuserstatus.setText("N/A");
            URL defaultUrl = getClass().getResource("/application/AdminImage/avatar.png");
            if (defaultUrl != null) {
                imageAvatar1.setIcon(new ImageIcon(defaultUrl));
            } else {
                System.err.println("Default avatar image not found at: /application/AdminImage/avatar.png");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imageAvatar1 = new ImageAvatar();
        lbnickname = new javax.swing.JLabel();
        lbuserfirstname = new javax.swing.JLabel();
        lbuserlastname = new javax.swing.JLabel();
        lbfirstname = new javax.swing.JLabel();
        lblastname = new javax.swing.JLabel();
        lbdob = new javax.swing.JLabel();
        lbgender = new javax.swing.JLabel();
        lbphone = new javax.swing.JLabel();
        lbemail = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        lbstatus = new javax.swing.JLabel();
        lbuserdob = new javax.swing.JLabel();
        lbusergender = new javax.swing.JLabel();
        lbuserphone = new javax.swing.JLabel();
        lbuseremail = new javax.swing.JLabel();
        lbuseraddress = new javax.swing.JLabel();
        lbuserstatus = new javax.swing.JLabel();
        buttonSetting = new Button();
        buttonOut = new Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/Black_cat.jpg"))); // NOI18N

        lbnickname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbnickname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnickname.setText("USER NAME");

        lbuserfirstname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbuserfirstname.setForeground(new java.awt.Color(51, 51, 51));
        lbuserfirstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbuserfirstname.setText("First Name");

        lbuserlastname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbuserlastname.setForeground(new java.awt.Color(51, 51, 51));
        lbuserlastname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbuserlastname.setText("Last Name");

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

        lbstatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbstatus.setForeground(new java.awt.Color(0, 0, 102));
        lbstatus.setText("Status:");

        lbuserdob.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbuserdob.setForeground(new java.awt.Color(51, 51, 51));
        lbuserdob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbuserdob.setText("dd/mm/yyyy");

        lbusergender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbusergender.setForeground(new java.awt.Color(51, 51, 51));
        lbusergender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbusergender.setText("Gender");

        lbuserphone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbuserphone.setForeground(new java.awt.Color(51, 51, 51));
        lbuserphone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbuserphone.setText("090xxxxxxx");

        lbuseremail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbuseremail.setForeground(new java.awt.Color(51, 51, 51));
        lbuseremail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbuseremail.setText("email@gmail.com");

        lbuseraddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbuseraddress.setForeground(new java.awt.Color(51, 51, 51));
        lbuseraddress.setText("Address");

        lbuserstatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbuserstatus.setForeground(new java.awt.Color(51, 51, 51));
        lbuserstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbuserstatus.setText("STATUS");

        buttonSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/settings.png"))); // NOI18N
        buttonSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSettingActionPerformed(evt);
            }
        });

        buttonOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/logout.png"))); // NOI18N
        buttonOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbnickname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbdob, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbphone, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbemail, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(buttonSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbfirstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbuserstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbuserfirstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbuseraddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbuseremail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(lbuserphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbusergender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbuserdob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbuserlastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lbnickname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbuserfirstname)
                    .addComponent(lbfirstname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblastname)
                    .addComponent(lbuserlastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbdob)
                    .addComponent(lbuserdob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbusergender)
                    .addComponent(lbgender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbuserphone)
                    .addComponent(lbphone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbuseremail)
                    .addComponent(lbemail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbaddress)
                    .addComponent(lbuseraddress, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbuserstatus)
                    .addComponent(lbstatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSetting, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void buttonSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSettingActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Editing_Frame(user).setVisible(true);
    }//GEN-LAST:event_buttonSettingActionPerformed

    private void buttonOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_buttonOutActionPerformed

    
//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Setting_Frame(null).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button buttonOut;
    private Button buttonSetting;
    private ImageAvatar imageAvatar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbaddress;
    private javax.swing.JLabel lbdob;
    private javax.swing.JLabel lbemail;
    private javax.swing.JLabel lbfirstname;
    private javax.swing.JLabel lbgender;
    private javax.swing.JLabel lblastname;
    private javax.swing.JLabel lbnickname;
    private javax.swing.JLabel lbphone;
    private javax.swing.JLabel lbstatus;
    private javax.swing.JLabel lbuseraddress;
    private javax.swing.JLabel lbuserdob;
    private javax.swing.JLabel lbuseremail;
    private javax.swing.JLabel lbuserfirstname;
    private javax.swing.JLabel lbusergender;
    private javax.swing.JLabel lbuserlastname;
    private javax.swing.JLabel lbuserphone;
    private javax.swing.JLabel lbuserstatus;
    // End of variables declaration//GEN-END:variables
}
