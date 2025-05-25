
package application.ChatInterface.form;

import application.dao.UserDAO;
import application.model.User;
import application.raven.swing.Button;
import application.raven.swing.ImageAvatar;
import application.session_management.SessionManagement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Editing_Frame extends javax.swing.JFrame {

    private final User user;
    private byte[] newAvatarBytes; // Store selected avatar image data

    public Editing_Frame(User user) {
        this.user = user;
        this.newAvatarBytes = null; // Initialize as null
        initComponents();
        init();
    }

    private void init() {
        setLocationRelativeTo(null);
        URL url_icon_signup = Editing_Frame.class.getResource("/application/AdminImage/iconChat.png");
        if (url_icon_signup == null) {
            System.err.println("Icon image not found at: /application/AdminImage/iconChat.png");
        } else {
            Image img = Toolkit.getDefaultToolkit().createImage(url_icon_signup);
            setIconImage(img);
        }
        setTitle("KHchat - Editing Profile");

        // Populate user information
        if (user != null) {
            jtnickname.setText(user.getUserName() != null ? user.getUserName() : "");
            jtfirstname.setText(user.getFirstName() != null ? user.getFirstName() : "");
            jtlastname.setText(user.getLastName() != null ? user.getLastName() : "");

            // Format DOB from Date to dd-MM-yyyy
            Date dob = user.getDob();
            if (dob != null) {
                try {
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    jtdob.setText(outputFormat.format(dob));
                } catch (Exception e) {
                    jtdob.setText("");
                    System.err.println("Error formatting DOB: " + e.getMessage());
                }
            } else {
                jtdob.setText("");
            }

            jtgender.setText(user.getGender() != null ? user.getGender() : "");
            jtphone.setText(user.getPhone() != null ? user.getPhone() : "");
            jtemail.setText(user.getEmail() != null ? user.getEmail() : "");
            jtaddress.setText(user.getAddress() != null ? user.getAddress() : "");

            // Set avatar image
            byte[] avatarBytes = user.getAvatar();
            if (avatarBytes != null && avatarBytes.length > 0) {
                try {
                    ImageIcon avatarIcon = new ImageIcon(avatarBytes);
                    imageAvatar1.setIcon(avatarIcon);
                    imageAvatar1.repaint();
                } catch (Exception e) {
                    System.err.println("Error loading avatar from byte array: " + e.getMessage());
                    setDefaultAvatar();
                }
            } else {
                setDefaultAvatar();
            }
        } else {
            // Fallback if no user is provided
            jtnickname.setText("");
            jtfirstname.setText("");
            jtlastname.setText("");
            jtdob.setText("");
            jtgender.setText("");
            jtphone.setText("");
            jtemail.setText("");
            jtaddress.setText("");
            setDefaultAvatar();
        }
    }

    private void setDefaultAvatar() {
        URL defaultUrl = getClass().getResource("/application/AdminImage/avatar.png");
        if (defaultUrl != null) {
            ImageIcon defaultIcon = new ImageIcon(defaultUrl);
            imageAvatar1.setIcon(defaultIcon);
            imageAvatar1.repaint();
        } else {
            System.err.println("Default avatar image not found at: /application/AdminImage/avatar.png");
        }
    }

    private byte[] fileToBytes(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                System.err.println("Failed to read image: " + file.getAbsolutePath());
                return null;
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String fileName = file.getName().toLowerCase();
            String format = fileName.endsWith(".png") ? "png" : "jpeg"; // Default to JPEG if not PNG
            ImageIO.write(image, format, baos);
            byte[] result = baos.toByteArray();
            System.out.println("Successfully converted file to bytes: " + file.getAbsolutePath() + ", size: " + result.length);
            return result;
        } catch (Exception e) {
            System.err.println("Error converting file to bytes: " + e.getMessage());
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imageAvatar1 = new ImageAvatar();
        lbnickname = new javax.swing.JLabel();
        lbfirstname = new javax.swing.JLabel();
        lblastname = new javax.swing.JLabel();
        lbdob = new javax.swing.JLabel();
        lbgender = new javax.swing.JLabel();
        lbphone = new javax.swing.JLabel();
        lbemail = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        buttonSave = new Button();
        jtfirstname = new javax.swing.JTextField();
        jtlastname = new javax.swing.JTextField();
        jtdob = new javax.swing.JTextField();
        jtgender = new javax.swing.JTextField();
        jtphone = new javax.swing.JTextField();
        jtemail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaddress = new javax.swing.JTextArea();
        jtnickname = new javax.swing.JTextField();
        buttonCamera = new Button();
        buttonBack = new Button();

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
//                buttonBackActionPerformed(evt);
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
        new Setting_Frame(user).setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // TODO add your handling code here:
        if (user == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Update user object with new values
            user.setUserName(jtnickname.getText().trim().isEmpty() ? null : jtnickname.getText().trim());
            user.setFirstName(jtfirstname.getText().trim().isEmpty() ? null : jtfirstname.getText().trim());
            user.setLastName(jtlastname.getText().trim().isEmpty() ? null : jtlastname.getText().trim());

            // Parse DOB from dd-MM-yyyy to LocalDate and convert to java.sql.Date for database
            String dobText = jtdob.getText().trim();
            if (!dobText.isEmpty()) {
                try {
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate localDate = LocalDate.parse(dobText, inputFormatter);

                    // Validate the date is not in the future
                    LocalDate today = LocalDate.now(); // Current date (6:56 PM +07, May 25, 2025)
                    if (localDate.isAfter(today)) {
                        JOptionPane.showMessageDialog(this, "Date of birth cannot be in the future.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Convert LocalDate to java.sql.Date (yyyy-MM-dd format for SQL)
                    java.sql.Date dob = java.sql.Date.valueOf(localDate);
                    user.setDob(dob);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, "Invalid date format. Please use dd-MM-yyyy (e.g., 25-05-2025).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                user.setDob(null);
            }

            user.setGender(jtgender.getText().trim().isEmpty() ? null : jtgender.getText().trim());
            user.setPhone(jtphone.getText().trim().isEmpty() ? null : jtphone.getText().trim());
            user.setEmail(jtemail.getText().trim().isEmpty() ? null : jtemail.getText().trim());
            user.setAddress(jtaddress.getText().trim().isEmpty() ? null : jtaddress.getText().trim());

            // Update avatar if a new one was selected
            if (newAvatarBytes != null) {
                user.setAvatar(newAvatarBytes);
            }

            // Save to database
            UserDAO userDAO = new UserDAO();
            try {
                userDAO.update(user);
            } catch (Exception e) {
                System.err.println("Database update failed: " + e.getMessage());
                throw new RuntimeException("Failed to update user in database: " + e.getMessage());
            }

            // Update session
            SessionManagement.getInstance().getLoginSession().setUser(user);

            JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Return to Setting_Frame
            setVisible(false);
            new Setting_Frame(user).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving profile: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error in save operation: " + e.getMessage());
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCameraActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) return true;
                String name = f.getName().toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "Image Files (*.jpg, *.jpeg, *.png)";
            }
        });

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            newAvatarBytes = fileToBytes(selectedFile);
            if (newAvatarBytes != null && newAvatarBytes.length > 0) {
                try {
                    ImageIcon previewIcon = new ImageIcon(newAvatarBytes);
                    imageAvatar1.setIcon(previewIcon);
                    imageAvatar1.repaint();
                    System.out.println("Avatar preview updated successfully.");
                } catch (Exception e) {
                    System.err.println("Error previewing image: " + e.getMessage());
                    JOptionPane.showMessageDialog(this, "Invalid image file.", "Error", JOptionPane.ERROR_MESSAGE);
                    newAvatarBytes = null;
                    setDefaultAvatar();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to load image. Please select a valid image file.", "Error", JOptionPane.ERROR_MESSAGE);
                newAvatarBytes = null;
                setDefaultAvatar();
            }
        } else {
            System.out.println("File selection canceled.");
        }
    }//GEN-LAST:event_buttonCameraActionPerformed

    
//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Editing_Frame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button buttonBack;
    private Button buttonCamera;
    private Button buttonSave;
    private ImageAvatar imageAvatar1;
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
