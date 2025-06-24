
package application.ChatInterface.form;

import application.ChatInterface.ChatSection_Form;
import application.ChatInterface.ListFriends_Form;
import application.ChatInterface.ReportAccount_Form;
import application.dao.ConversationDAO;
import application.dao.MessageDAO;
import application.dao.ParticipantDAO;
import application.dao.RelationshipDAO;
import application.model.Conversation;
import application.model.Message;
import application.model.Participant;
import application.model.Relationship;
import application.model.User;
import application.raven.swing.Button;
import application.raven.swing.ImageAvatar;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.imageio.ImageIO;

public class Item_Friend extends javax.swing.JPanel {

    private User friend;
    private User loggedInUser;
    private JFrame parentFrame;
    private RelationshipDAO relationshipDAO;
    private ConversationDAO conversationDAO;
    private ParticipantDAO participantDAO;
    private MessageDAO messageDAO;

    public Item_Friend(User friend, User loggedInUser, JFrame parentFrame) {
        this.friend = friend;
        this.loggedInUser = loggedInUser;
        this.parentFrame = parentFrame;
        initComponents();
        populateUserDetails();
        this.relationshipDAO = new RelationshipDAO();
        this.conversationDAO = new ConversationDAO();
        this.participantDAO = new ParticipantDAO();
        this.messageDAO = new MessageDAO();
    }

    private void populateUserDetails() {
        lbuserName.setText(friend.getUserName());
        lbdob.setText(friend.getDob() != null ? new SimpleDateFormat("dd/MM/yyyy").format(friend.getDob()) : "N/A");
        lbgender.setText(friend.getGender() != null ? friend.getGender() : "N/A");
        lbstatus.setText(friend.getStatus() != null ? friend.getStatus() : "N/A");

        // Set avatar
        if (friend.getAvatar() != null) {
            try {
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(friend.getAvatar()));
                ImageIcon icon = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                imageAvatar.setIcon(icon);
            } catch (Exception e) {
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
        button2 = new Button();
        lbstatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png")));

        lbuserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbuserName.setText("USER NAME");

        lbdob.setText("Dob");

        lbgender.setText("Gender");

        button1.setBackground(new java.awt.Color(163, 209, 255));
        button1.setForeground(new java.awt.Color(0, 51, 153));
        button1.setText("Chat Now");
        button1.setToolTipText("Chat now!");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(184, 212, 241));
        button2.setForeground(new java.awt.Color(0, 51, 153));
        button2.setText("Unfriend");
        button2.setToolTipText("");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        lbstatus.setText("Status");

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
                    .addComponent(lbuserName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbstatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbuserName)
                        .addGap(12, 12, 12)
                        .addComponent(lbdob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbgender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbstatus)))
                .addGap(0, 9, Short.MAX_VALUE))
            .addComponent(imageAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        try {
            // Xóa messages
            java.util.List<Message> messages = messageDAO.selectMessagesBetweenUsers(loggedInUser, friend);
            for (Message message : messages) {
                messageDAO.delete(message);
            }
            // Xóa participants và conversation
            Conversation conversation = participantDAO.getCommonConversation(loggedInUser, friend);
            if (conversation != null) {
                // Xóa participants
                Participant participant1 = participantDAO.selectParticipantOneByTwoUser(loggedInUser, friend);
                Participant participant2 = participantDAO.selectParticipantOneByTwoUser(friend, loggedInUser);

                if (participant1 != null) participantDAO.delete(participant1);
                if (participant2 != null) participantDAO.delete(participant2);

                // Xóa conversation
                conversationDAO.delete(conversation);
            }

            // Xóa relationships
            List<Relationship> relationships = relationshipDAO.selectRelationshipsByUsers(loggedInUser, friend);
            for (Relationship relationship : relationships) {
                relationshipDAO.delete(relationship);
            }

            JOptionPane.showMessageDialog(this,
                    "Đã xóa tất cả dữ liệu liên quan đến " + friend.getUserName(),
                    "Thành công",
                    JOptionPane.INFORMATION_MESSAGE);

            refreshParentForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Đã xảy ra lỗi: " + e.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button2ActionPerformed
    private void refreshParentForm() {
        Container parent = getParent();
        while (parent != null && !(parent instanceof ReportAccount_Form)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            ((ReportAccount_Form) parent).showPeople();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button button1;
    private Button button2;
    private ImageAvatar imageAvatar;
    private javax.swing.JLabel lbdob;
    private javax.swing.JLabel lbgender;
    private javax.swing.JLabel lbstatus;
    private javax.swing.JLabel lbuserName;
    // End of variables declaration//GEN-END:variables
}
