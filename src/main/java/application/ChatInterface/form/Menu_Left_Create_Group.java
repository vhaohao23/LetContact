
package application.ChatInterface.form;

import application.AdminPart.ScrollBar;
import application.ChatInterface.InputText;
import application.dao.ConversationDAO;
import application.dao.ParticipantDAO;
import application.dao.RelationshipDAO;
import application.dao.UserDAO;
import application.model.Conversation;
import application.model.Participant;
import application.model.Relationship;
import application.model.User;
import application.session_management.SessionManagement;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class Menu_Left_Create_Group extends javax.swing.JPanel {

    private HomeChat homeChat;
    private ConversationDAO conversationDAO = new ConversationDAO();
    private ParticipantDAO participantDAO = new ParticipantDAO();
    private UserDAO userDAO = new UserDAO();

    public Menu_Left_Create_Group(HomeChat homeChat) {
        this.homeChat = homeChat;
        initComponents();
        init();
    }

    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx","0[]0", "0[]2"));
        menuList1.setLayout(new MigLayout("fillx","0[]0", "0[]2"));
        showPeople();
        addItemClickListener();
    }
    private void showPeople(){
        menuList1.removeAll();
        User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
        if (currentUser != null) {
            List<User> friends = userDAO.selectFriend(currentUser);
            for (User user : friends) {
                if (!user.getUserID().equals(currentUser.getUserID())) { // Loại bỏ chính currentUser
                    menuList1.add(new Item_People(user), "wrap");
                }
            }
        }
        refreshMenuList();
    }

    private void addItemClickListener() {
        for (int i = 0; i < menuList1.getComponentCount(); i++) {
            Component comp = menuList1.getComponent(i);
            if (comp instanceof Item_People) {
                Item_People item = (Item_People) comp;
                item.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean alreadyExists = false;
                        for (Component existingComp : menuList.getComponents()) {
                            if (existingComp instanceof Item_People) {
                                Item_People existingItem = (Item_People) existingComp;
                                if (existingItem.getUser().getUserID().equals(item.getUser().getUserID())) {
                                    alreadyExists = true;
                                    break;
                                }
                            }
                        }
                        if (!alreadyExists) {
                            menuList.add(new Item_People(item.getUser()), "wrap");
                            refreshMenuList();
                        }
                    }
                });
            }
        }
    }
    
    private void refreshMenuList(){
        menuList.repaint();
        menuList.revalidate();
        menuList1.repaint();
        menuList1.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();
        buttonSearch = new application.raven.swing.Button();
        searchText = new application.AdminPart.SearchText();
        sp1 = new javax.swing.JScrollPane();
        menuList1 = new javax.swing.JLayeredPane();
        buttonMenuLeft = new application.raven.swing.Button();
        buttonCreate1 = new application.raven.swing.Button();
        inputText1 = new application.ChatInterface.InputText();
        button1 = new application.raven.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(227, 237, 250));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        buttonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/search.png"))); // NOI18N
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        sp1.setBorder(null);
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList1.setBackground(new java.awt.Color(211, 221, 235));
        menuList1.setOpaque(true);

        javax.swing.GroupLayout menuList1Layout = new javax.swing.GroupLayout(menuList1);
        menuList1.setLayout(menuList1Layout);
        menuList1Layout.setHorizontalGroup(
            menuList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuList1Layout.setVerticalGroup(
            menuList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );

        sp1.setViewportView(menuList1);

        buttonMenuLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/menu.png"))); // NOI18N
        buttonMenuLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuLeftActionPerformed(evt);
            }
        });

        buttonCreate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/create.png"))); // NOI18N
        buttonCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreate1ActionPerformed(evt);
            }
        });

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/edit.png"))); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addComponent(sp1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(inputText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonMenuLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMenuLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCreate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputText1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // TODO add your handling code here:
        String searchQuery = searchText.getText().trim();
        if (searchQuery.isEmpty()) {
            showPeople(); // Nếu không có từ khóa, hiển thị danh sách bạn bè mặc định
            return;
        }

        // Tìm kiếm user dựa trên username
        List<User> users = userDAO.selectByUsernameLike(searchQuery);
        User currentUser = SessionManagement.getInstance().getLoginSession().getUser();

        // Xóa menuList1 và hiển thị kết quả tìm kiếm
        menuList1.removeAll();
        if (currentUser != null) {
            for (User user : users) {
                if (!user.getUserID().equals(currentUser.getUserID())) {
                    menuList1.add(new Item_People(user), "wrap");
                }
            }
        }

        // Cập nhật lại menuList1
        refreshMenuList();
        addItemClickListener();
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonMenuLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenuLeftActionPerformed
        // TODO add your handling code here:
        homeChat.showMenu(new Menu_Left(homeChat));
    }//GEN-LAST:event_buttonMenuLeftActionPerformed

    private void buttonCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreate1ActionPerformed
        // TODO add your handling code here:
        menuList.removeAll();
        refreshMenuList();
    }//GEN-LAST:event_buttonCreate1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        String groupName = inputText1.getText().trim();
        if (groupName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a group name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy danh sách users từ menuList
        List<User> selectedUsers = new ArrayList<>();
        for (Component comp : menuList.getComponents()) {
            if (comp instanceof Item_People) {
                Item_People item = (Item_People) comp;
                selectedUsers.add(item.getUser());
            }
        }

        // Thêm currentUser vào danh sách
        User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
        if (currentUser != null) {
            selectedUsers.add(currentUser);
        }

        // Kiểm tra số lượng users (bao gồm currentUser)
        if (selectedUsers.size() < 3) { // Cần ít nhất 3 người (currentUser + 2 người khác)
            JOptionPane.showMessageDialog(this, "Please select at least 2 users to create a group (including yourself).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tạo bản ghi trong bảng conversation
        Conversation conversation = new Conversation();
        conversation.setType("group");
        conversation.setNameGroup(groupName);
        conversation.setTheme("default"); // Giả định theme mặc định

        boolean conversationSuccess = conversationDAO.insert(conversation);
        if (conversationSuccess) {
            // Tạo các bản ghi trong bảng participant
            boolean allParticipantsSuccess = true;
            for (User user : selectedUsers) {
                Participant participant = new Participant();
                participant.setUser(user);
                participant.setConversation(conversation);
                participant.setRole(user.getUserID().equals(currentUser.getUserID()) ? "admin" : "member");
                if (!participantDAO.insert(participant)) {
                    allParticipantsSuccess = false;
                    break;
                }
            }

            if (allParticipantsSuccess) {
                JOptionPane.showMessageDialog(this, "Group created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Quay lại Menu_Left sau khi tạo nhóm thành công
                homeChat.showMenu(new Menu_Left(homeChat));
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add participants to the group.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create group.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.raven.swing.Button button1;
    private application.raven.swing.Button buttonCreate1;
    private application.raven.swing.Button buttonMenuLeft;
    private application.raven.swing.Button buttonSearch;
    private InputText inputText1;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JLayeredPane menuList1;
    private application.AdminPart.SearchText searchText;
    private javax.swing.JScrollPane sp;
    private javax.swing.JScrollPane sp1;
    // End of variables declaration//GEN-END:variables
}
