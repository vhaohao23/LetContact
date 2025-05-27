package application.ChatInterface.form;

import application.ChatInterface.ReportAccount_Form;
import application.dao.ConversationDAO;
import application.dao.MessageDAO;
import application.dao.ParticipantDAO;
import application.dao.RelationshipDAO;
import application.model.*;
import application.raven.swing.Button;
import application.raven.swing.ImageAvatar;
import java.awt.Container;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Item_Report extends javax.swing.JPanel {
    private User reportedUser;
    private User currentUser;
    private RelationshipDAO relationshipDAO;
    private ConversationDAO conversationDAO;
    private ParticipantDAO participantDAO;
    private MessageDAO messageDAO;

    public Item_Report(User currentUser, User reportedUser) {
        initComponents();
        this.currentUser = currentUser;
        this.reportedUser = reportedUser;
        this.relationshipDAO = new RelationshipDAO();
        this.conversationDAO = new ConversationDAO();
        this.participantDAO = new ParticipantDAO();
        this.messageDAO = new MessageDAO();
        
        // Hiển thị thông tin user
        lbuserName.setText(reportedUser.getUserName());
        lbdob.setText(reportedUser.getDob() != null ? reportedUser.getDob().toString() : "");
        lbgender.setText(reportedUser.getGender());
        lbstatus.setText(reportedUser.getStatus());
        
        // Hiển thị avatar
        displayAvatar();
    }

    private void displayAvatar() {
        byte[] avatarBytes = reportedUser.getAvatar();
        if (avatarBytes != null && avatarBytes.length > 0) {
            try {
                ImageIcon originalIcon = new ImageIcon(avatarBytes);
                Image originalImage = originalIcon.getImage();
                
                int width = imageAvatar.getWidth();
                int height = imageAvatar.getHeight();
                
                if (width <= 0) width = 100;
                if (height <= 0) height = 100;

                Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                imageAvatar.setIcon(new ImageIcon(scaledImage));
                
            } catch (Exception e) {
                setDefaultAvatar();
            }
        } else {
            setDefaultAvatar();
        }
    }

    private void setDefaultAvatar() {
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png"));
        imageAvatar.setIcon(defaultIcon);
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

        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png"))); // NOI18N

        lbuserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbuserName.setForeground(new java.awt.Color(153, 0, 0));
        lbuserName.setText("USER NAME");

        lbdob.setText("Dob");

        lbgender.setText("Gender");

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 204, 204));
        button1.setText("Unblock");
        button1.setToolTipText("");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbdob)
                            .addComponent(lbuserName))
                        .addGap(18, 155, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbgender)
                            .addComponent(lbstatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Cập nhật R_Status thành "accepted" cho cả hai chiều
            Relationship relationship = new Relationship();
            relationship.setUser1(currentUser);
            relationship.setUser2(reportedUser);
            relationshipDAO.update(relationship, "accepted");

            JOptionPane.showMessageDialog(this,
                "Đã bỏ chặn người dùng " + reportedUser.getUserName(),
                "Thành công",
                JOptionPane.INFORMATION_MESSAGE);
            
            // Refresh form
            refreshParentForm();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi khi bỏ chặn: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Xóa messages
            List<Message> messages = messageDAO.selectMessagesBetweenUsers(currentUser, reportedUser);
            for (Message message : messages) {
                messageDAO.delete(message);
            }

            // Xóa participants và conversation
            Conversation conversation = participantDAO.getCommonConversation(currentUser, reportedUser);
            if (conversation != null) {
                // Xóa participants
                Participant participant1 = participantDAO.selectParticipantOneByTwoUser(currentUser, reportedUser);
                Participant participant2 = participantDAO.selectParticipantOneByTwoUser(reportedUser, currentUser);
                
                if (participant1 != null) participantDAO.delete(participant1);
                if (participant2 != null) participantDAO.delete(participant2);

                // Xóa conversation
                conversationDAO.delete(conversation);
            }

            // Xóa relationships
            List<Relationship> relationships = relationshipDAO.selectRelationshipsByUsers(currentUser, reportedUser);
            for (Relationship relationship : relationships) {
                relationshipDAO.delete(relationship);
            }

            JOptionPane.showMessageDialog(this,
                "Đã xóa tất cả dữ liệu liên quan đến " + reportedUser.getUserName(),
                "Thành công",
                JOptionPane.INFORMATION_MESSAGE);

            refreshParentForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Đã xảy ra lỗi: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
        }
    }

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