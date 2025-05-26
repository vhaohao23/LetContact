
package application.ChatInterface.form;


import application.dao.RelationshipDAO;
import application.model.Relationship;
import application.model.User;
import application.raven.swing.Button;
import application.raven.swing.ImageAvatar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Item_Search extends javax.swing.JPanel {

    private User currentUser;
    private User targetUser;

    public Item_Search(User currentUser, User targetUser) {
        this.currentUser = currentUser;
        this.targetUser = targetUser;
        initComponents();
        lbuserName.setText(targetUser.getUserName());
        lbdob.setText(targetUser.getDob() != null ? targetUser.getDob().toString() : "N/A");
        lbgender.setText(targetUser.getGender() != null ? targetUser.getGender() : "N/A");
        setAvatarImage(targetUser.getAvatar());
    }

    private void setAvatarImage(byte[] avatar) {
        if (avatar != null && avatar.length > 0) {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(avatar);
                BufferedImage img = ImageIO.read(bais);
                Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageAvatar.setIcon(new ImageIcon(scaledImg));
            } catch (IOException e) {
                e.printStackTrace();
                imageAvatar.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png")));
            }
        } else {
            imageAvatar.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png")));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar = new ImageAvatar();
        lbuserName = new javax.swing.JLabel();
        lbdob = new javax.swing.JLabel();
        lbgender = new javax.swing.JLabel();
        button1 = new Button();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png"))); // NOI18N

        lbuserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbuserName.setText("USER NAME");

        lbdob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdob.setText("Dob");

        lbgender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbgender.setText("Gender");

        button1.setBackground(new java.awt.Color(163, 209, 255));
        button1.setForeground(new java.awt.Color(0, 51, 153));
        button1.setText("Add Friend");
        button1.setToolTipText("");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbgender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbuserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbdob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(lbuserName)
                .addGap(18, 18, 18)
                .addComponent(lbdob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbgender)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        RelationshipDAO relationshipDAO = new RelationshipDAO();
        // Bản ghi 1: currentUser là UserID1, targetUser là UserID2, trạng thái "accepted"
        Relationship relationship1 = new Relationship();
        relationship1.setUser1(currentUser);
        relationship1.setUser2(targetUser);
        relationship1.setrStatus("accepted");

        // Bản ghi 2: targetUser là UserID1, currentUser là UserID2, trạng thái "waiting"
        Relationship relationship2 = new Relationship();
        relationship2.setUser1(targetUser);
        relationship2.setUser2(currentUser);
        relationship2.setrStatus("waiting");

        // Lưu vào cơ sở dữ liệu
        boolean success1 = relationshipDAO.insert(relationship1);
        boolean success2 = relationshipDAO.insert(relationship2);

        if (success1 && success2) {
            JOptionPane.showMessageDialog(this, "Friend request sent successfully!");
            // Xóa Item_Search khỏi danh sách sau khi thêm
            SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).remove(this);
            SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).revalidate();
            SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to send friend request.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button button1;
    private ImageAvatar imageAvatar;
    private javax.swing.JLabel lbdob;
    private javax.swing.JLabel lbgender;
    private javax.swing.JLabel lbuserName;
    // End of variables declaration//GEN-END:variables
}
