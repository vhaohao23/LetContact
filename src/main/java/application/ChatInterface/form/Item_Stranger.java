
package application.ChatInterface.form;


import application.dao.ConversationDAO;
import application.dao.ParticipantDAO;
import application.dao.RelationshipDAO;
import application.model.Conversation;
import application.model.Participant;
import application.model.Relationship;
import application.model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

public class Item_Stranger extends javax.swing.JPanel {

    private User currentUser; // User đang đăng nhập
    private User targetUser;

    public Item_Stranger(User currentUser, User targetUser) {
        this.currentUser = currentUser;
        this.targetUser = targetUser;
        initComponents();
        setAvatarImage(targetUser.getAvatar());
        lbuserName.setText(targetUser.getUserName());
        lbdob.setText(targetUser.getDob() != null ? targetUser.getDob().toString() : "N/A");
        lbgender.setText(targetUser.getGender() != null ? targetUser.getGender() : "N/A");

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
            URL defaultImageUrl = getClass().getResource("/application/AdminImage/AccountIcon.png");
            if (defaultImageUrl != null) {
                imageAvatar.setIcon(new ImageIcon(defaultImageUrl));
            } else {
                System.err.println("Default avatar image not found at /application/AdminImage/AccountIcon.png");
                imageAvatar.setIcon(new ImageIcon()); // Icon trống nếu không tìm thấy
            }
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar = new application.raven.swing.ImageAvatar();
        lbuserName = new javax.swing.JLabel();
        lbdob = new javax.swing.JLabel();
        lbgender = new javax.swing.JLabel();
        button = new application.raven.swing.Button();
        button2 = new application.raven.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png"))); // NOI18N

        lbuserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbuserName.setText("USER NAME");

        lbdob.setText("Dob");

        lbgender.setText("Gender");

        button.setBackground(new java.awt.Color(111, 182, 255));
        button.setForeground(new java.awt.Color(0, 102, 204));
        button.setText("Cancel");
        button.setToolTipText("");
        button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(195, 225, 255));
        button2.setForeground(new java.awt.Color(0, 51, 153));
        button2.setText("Add Friend");
        button2.setToolTipText("");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbdob)
                    .addComponent(lbgender)
                    .addComponent(lbuserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbuserName)
                .addGap(12, 12, 12)
                .addComponent(lbdob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbgender)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(imageAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // TODO add your handling code here:
        RelationshipDAO relationshipDAO = new RelationshipDAO();
        Relationship relationship1 = new Relationship();
        relationship1.setUser1(currentUser);
        relationship1.setUser2(targetUser);

        Relationship relationship2 = new Relationship();
        relationship2.setUser1(targetUser);
        relationship2.setUser2(currentUser);

        boolean success1 = relationshipDAO.delete(relationship1);
        boolean success2 = relationshipDAO.delete(relationship2);

        if (success1 && success2) {
            JOptionPane.showMessageDialog(this, "Friend request canceled successfully!");
            SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).remove(this);
            SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).revalidate();
            SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to cancel friend request.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        RelationshipDAO relationshipDAO = new RelationshipDAO();
        ConversationDAO conversationDAO = new ConversationDAO();
        ParticipantDAO participantDAO = new ParticipantDAO();

        // Cập nhật R_Status thành "accepted"
        Relationship relationship1 = new Relationship();
        relationship1.setUser1(currentUser);
        relationship1.setUser2(targetUser);

        Relationship relationship2 = new Relationship();
        relationship2.setUser1(targetUser);
        relationship2.setUser2(currentUser);

        boolean success1 = relationshipDAO.update(relationship1, "accepted");
        boolean success2 = relationshipDAO.update(relationship2, "accepted");

        if (success1 && success2) {
            // Tạo bản ghi Conversation
            Conversation conversation = new Conversation();
            conversation.setType("solo");
            conversation.setNameGroup("x");
            conversation.setTheme("x");

            boolean conversationSuccess = conversationDAO.insert(conversation);

            if (conversationSuccess) {
                // Tạo hai bản ghi Participant
                Participant participant1 = new Participant();
                participant1.setUser(currentUser);
                participant1.setConversation(conversation);
                participant1.setRole("member");

                Participant participant2 = new Participant();
                participant2.setUser(targetUser);
                participant2.setConversation(conversation);
                participant2.setRole("member");

                boolean participantSuccess1 = participantDAO.insert(participant1);
                boolean participantSuccess2 = participantDAO.insert(participant2);

                if (participantSuccess1 && participantSuccess2) {
                    JOptionPane.showMessageDialog(this, "Friend request accepted successfully! Conversation created.");
                    SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).remove(this);
                    SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).revalidate();
                    SwingUtilities.getAncestorOfClass(JLayeredPane.class, this).repaint();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to create participants for the conversation.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to create conversation.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Failed to accept friend request.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.raven.swing.Button button;
    private application.raven.swing.Button button2;
    private application.raven.swing.ImageAvatar imageAvatar;
    private javax.swing.JLabel lbdob;
    private javax.swing.JLabel lbgender;
    private javax.swing.JLabel lbuserName;
    // End of variables declaration//GEN-END:variables
}
