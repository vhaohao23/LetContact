package application.ChatInterface.form;

import application.ChatInterface.event.EventMenuRight;
import application.ChatInterface.event.PublicEvent;
import application.dao.RelationshipDAO;
import application.model.Conversation;
import application.model.Participant;
import application.model.User;
import java.awt.Image;
import javax.swing.ImageIcon;
import application.model.Relationship;
import application.session_management.SessionManagement;

import javax.swing.JOptionPane;

public class Menu_Right extends javax.swing.JPanel {

    private User selectedUser; // Lưu user được chọn
    private application.dao.RelationshipDAO relationshipDAO; // Để tương tác với CSDL

    public Menu_Right() {
        initComponents();
        init();
        setVisible(false);
        relationshipDAO = new RelationshipDAO(); // Khởi tạo RelationshipDAO
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
        button1 = new application.raven.CustomButton.Button();
        button2 = new application.raven.CustomButton.Button();
        button3 = new application.raven.CustomButton.Button();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        button4 = new application.raven.swing.Button();
        button5 = new application.raven.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar1.setBackground(new java.awt.Color(255, 255, 255));
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/avt2.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Name");

        button1.setBackground(new java.awt.Color(22, 83, 206));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Hình ảnh, video");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(22, 83, 206));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("File");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(0, 51, 153));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Báo Cáo");
        button3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(97, 175, 255));
        jRadioButton1.setText("Normal");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 183, 165));
        jRadioButton2.setText("Family");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(213, 159, 241));
        jRadioButton3.setText("BFF");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 102, 102));
        jRadioButton4.setText("Love");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Relationship");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {
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
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.raven.CustomButton.Button button1;
    private application.raven.CustomButton.Button button2;
    private application.raven.CustomButton.Button button3;
    private application.raven.swing.Button button4;
    private application.raven.swing.Button button5;
    private application.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}