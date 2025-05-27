package application.ChatInterface.form;


import application.ChatInterface.RestrictedAccount_Form;
import application.raven.swing.Button;
import application.raven.swing.ImageAvatar;
import application.model.Relationship;
import application.model.User;
import application.dao.RelationshipDAO;
import application.dao.ConversationDAO;
import application.dao.ParticipantDAO;
import application.dao.MessageDAO;
import application.model.Conversation;
import application.model.Message;
import application.model.Participant;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Item_Restricted extends javax.swing.JPanel {
    private User restrictedUser;
    private User currentUser;
    private RelationshipDAO relationshipDAO;
    private ConversationDAO conversationDAO;
    private ParticipantDAO participantDAO;
    private MessageDAO messageDAO;

    public Item_Restricted(User currentUser, User restrictedUser) {
        initComponents();
        this.currentUser = currentUser;
        this.restrictedUser = restrictedUser;
        this.relationshipDAO = new RelationshipDAO();
        this.conversationDAO = new ConversationDAO();
        this.participantDAO = new ParticipantDAO();
        this.messageDAO = new MessageDAO();

        lbuserName.setText(restrictedUser.getUserName());
        lbdob.setText(restrictedUser.getDob() != null ? restrictedUser.getDob().toString() : "N/A");
        lbgender.setText(restrictedUser.getGender() != null ? restrictedUser.getGender() : "N/A");
        lbstatus.setText(restrictedUser.getStatus() != null ? restrictedUser.getStatus() : "N/A");

        setUserAvatar();
    }

    private void setUserAvatar() {
        if (restrictedUser.getAvatar() != null && restrictedUser.getAvatar().length > 0) {
            try {
                // Convert byte array to BufferedImage
                ByteArrayInputStream bais = new ByteArrayInputStream(restrictedUser.getAvatar());
                BufferedImage bufferedImage = ImageIO.read(bais);
                if (bufferedImage == null) {
                    throw new Exception("Invalid image data");
                }

                // Get target dimensions (use fixed size if component not yet sized)
                int width = imageAvatar.getWidth() > 0 ? imageAvatar.getWidth() : 100;
                int height = imageAvatar.getHeight() > 0 ? imageAvatar.getHeight() : 100;

                // Resize image
                Image resizedImage = bufferedImage.getScaledInstance(
                        width,
                        height,
                        Image.SCALE_SMOOTH
                );

                // Set ImageIcon to ImageAvatar
                imageAvatar.setIcon(new ImageIcon(resizedImage));
            } catch (Exception e) {
                System.err.println("Error loading avatar for user " + restrictedUser.getUserName() + ": " + e.getMessage());
                setDefaultAvatar();
            }
        } else {
            setDefaultAvatar();
        }
    }

    private void setDefaultAvatar() {
        try {
            imageAvatar.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png")));
        } catch (Exception e) {
            System.err.println("Error loading default avatar: " + e.getMessage());
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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Cập nhật R_Status thành "accepted"
            Relationship relationship = new Relationship();
            relationship.setUser1(currentUser);
            relationship.setUser2(restrictedUser);
            boolean success = relationshipDAO.updateSpecific(relationship, "accepted");

            if (success) {
                JOptionPane.showMessageDialog(this,
                    "Đã bỏ hạn chế người dùng " + restrictedUser.getUserName(),
                    "Thành công",
                    JOptionPane.INFORMATION_MESSAGE);

                // Refresh RestrictedAccount_Form
                Container parent = getParent();
                while (parent != null && !(parent instanceof RestrictedAccount_Form)) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    ((RestrictedAccount_Form) parent).showPeople();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi khi bỏ hạn chế: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Xóa messages
        List<Message> messages = messageDAO.selectMessagesBetweenUsers(currentUser, restrictedUser);
        for (Message message : messages) {
            messageDAO.delete(message);
        }

        // Xóa participants và conversation
        Conversation conversation = participantDAO.getCommonConversation(currentUser, restrictedUser);
        if (conversation != null) {
            // Xóa participants
            Participant participant1 = participantDAO.selectParticipantOneByTwoUser(currentUser, restrictedUser);
            Participant participant2 = participantDAO.selectParticipantOneByTwoUser(restrictedUser, currentUser);

            if (participant1 != null) participantDAO.delete(participant1);
            if (participant2 != null) participantDAO.delete(participant2);

            // Xóa conversation
            conversationDAO.delete(conversation);
        }

        // Xóa relationships
        List<Relationship> relationships = relationshipDAO.selectRelationshipsByUsers(currentUser, restrictedUser);
        for (Relationship relationship : relationships) {
            relationshipDAO.delete(relationship);
        }

        // Thông báo thành công
        JOptionPane.showMessageDialog(this,
            "Đã xóa tất cả dữ liệu liên quan đến " + restrictedUser.getUserName(),
            "Thành công",
            JOptionPane.INFORMATION_MESSAGE);

        // Refresh form
        Container parent = getParent();
        while (parent != null && !(parent instanceof RestrictedAccount_Form)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            ((RestrictedAccount_Form) parent).showPeople();
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
            "Đã xảy ra lỗi: " + e.getMessage(),
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
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