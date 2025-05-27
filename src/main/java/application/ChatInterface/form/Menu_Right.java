
package application.ChatInterface.form;

import application.ChatInterface.event.EventMenuRight;
import application.ChatInterface.event.PublicEvent;
import application.dao.RelationshipDAO;
import application.model.Conversation;
import application.model.Participant;
import application.model.Relationship;
import application.model.User;
import application.session_management.SessionManagement;

import javax.swing.*;

public class Menu_Right extends javax.swing.JPanel {

    private User selectedUser;
    private application.dao.RelationshipDAO relationshipDAO;

    public Menu_Right() {
        initComponents();
        init();
        setVisible(false);
        relationshipDAO = new RelationshipDAO();
    }

    private void init() {
        PublicEvent.getInstance().addEventMenuRight(new EventMenuRight() {
            @Override
            public void selectUser(User user) {
                selectedUser = user;
                jLabel4.setText(user.getUserName());
                if (user.getAvatar() != null && user.getAvatar().length > 0) {
                    imageAvatar1.setIcon(new ImageIcon(user.getAvatar()));
                } else {
                    imageAvatar1.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/avatar.png")));
                }
                revalidate();
                repaint();
                setVisible(true);
            }

            @Override
            public void selectConversation(Conversation conversation, Participant participant) {
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new application.raven.swing.ImageAvatar();
        jLabel4 = new javax.swing.JLabel();
        button3 = new application.raven.CustomButton.Button();
        button4 = new application.raven.swing.Button();
        button5 = new application.raven.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar1.setBackground(new java.awt.Color(255, 255, 255));
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/avt2.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Name");

        button3.setBackground(new java.awt.Color(0, 51, 153));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Báo Cáo");
        button3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(210, 235, 255));
        button4.setForeground(new java.awt.Color(0, 0, 102));
        button4.setText("Restricted");
        button4.setToolTipText("");
        button4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(255, 102, 102));
        button5.setForeground(new java.awt.Color(102, 0, 0));
        button5.setText("Block");
        button5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        if (selectedUser != null) {
            User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
            if (currentUser != null) {
                try {
                    Relationship relationship = new Relationship();
                    relationship.setUser1(currentUser);
                    relationship.setUser2(selectedUser);

                    boolean success = relationshipDAO.update(relationship, "restricted");

                    if (success) {
                        JOptionPane.showMessageDialog(this,
                                "Đã hạn chế người dùng " + selectedUser.getUserName(),
                                "Thành công",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Không thể hạn chế người dùng này",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,
                            "Đã xảy ra lỗi: " + e.getMessage(),
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Vui lòng đăng nhập để thực hiện chức năng này",
                        "Lỗi",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng chọn người dùng trước khi thực hiện hạn chế",
                    "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        if (selectedUser != null) {
            User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
            if (currentUser != null) {
                try {
                    Relationship relationship1 = new Relationship();
                    relationship1.setUser1(currentUser);
                    relationship1.setUser2(selectedUser);

                    boolean success1 = relationshipDAO.update(relationship1, "blocked");

                    Relationship relationship2 = new Relationship();
                    relationship2.setUser1(selectedUser);
                    relationship2.setUser2(currentUser);

                    boolean success2 = relationshipDAO.update(relationship2, "unaccepted");

                    if (success1 && success2) {
                        JOptionPane.showMessageDialog(this,
                                "Đã chặn người dùng " + selectedUser.getUserName(),
                                "Thành công",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Không thể chặn người dùng này",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,
                            "Đã xảy ra lỗi: " + e.getMessage(),
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Vui lòng đăng nhập để thực hiện chức năng này",
                        "Lỗi",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng chọn người dùng trước khi thực hiện chặn",
                    "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_button5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.raven.CustomButton.Button button3;
    private application.raven.swing.Button button4;
    private application.raven.swing.Button button5;
    private application.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
