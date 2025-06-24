package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.form.Item_Search;
import application.dao.RelationshipDAO;
import application.dao.UserDAO;
import application.model.Relationship;
import application.model.User;
import application.raven.swing.Button;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;


public class SearchFriends_Form extends javax.swing.JLayeredPane {

    private User currentUser;

    public SearchFriends_Form(User currentUser) {
        this.currentUser = currentUser;
        initComponents();
        init();
    }
    
    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx, wrap 5", "[center]10[center]10[center]10[center]10[center]", "[]10[]"));
        showPeople();
    }
private void showPeople() {
    UserDAO userDAO = new UserDAO();
    RelationshipDAO relationshipDAO = new RelationshipDAO();
    List<User> allUsers = userDAO.getAll();
    List<Relationship> relationships = relationshipDAO.getAll();
    
    List<User> nonRelatedUsers = allUsers.stream()
            .filter(user -> !user.getUserID().equals(currentUser.getUserID())) // Loại bỏ currentUser
            .filter(user -> {
                // Kiểm tra xem có bất kỳ mối quan hệ nào giữa currentUser và user này không
                boolean hasRelationship = relationships.stream()
                        .anyMatch(r -> 
                            (r.getUser1().getUserID().equals(currentUser.getUserID()) && 
                             r.getUser2().getUserID().equals(user.getUserID())) ||
                            (r.getUser1().getUserID().equals(user.getUserID()) && 
                             r.getUser2().getUserID().equals(currentUser.getUserID()))
                        );
                return !hasRelationship; // Chỉ giữ lại những user không có mối quan hệ
            })
            .collect(Collectors.toList());

    menuList.removeAll();
    for (User user : nonRelatedUsers) {
        menuList.add(new Item_Search(currentUser, user));
    }
    menuList.revalidate();
    menuList.repaint();
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();
        button = new Button();
        jtsearch = new application.AdminPart.SearchText();

        sp.setBackground(new java.awt.Color(222, 242, 255));

        menuList.setBackground(new java.awt.Color(200, 227, 255));

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/search.png"))); // NOI18N
        button.setOpaque(true);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        jtsearch.setForeground(new java.awt.Color(153, 153, 153));
        jtsearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtsearchActionPerformed(evt);
            }
        });

        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(button, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(jtsearch, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addGroup(layout.createSequentialGroup()
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
    String searchText = jtsearch.getText().trim();

    if (searchText.isEmpty()) {
        showPeople();
    } else {
        UserDAO userDAO = new UserDAO();
        RelationshipDAO relationshipDAO = new RelationshipDAO();
        List<User> allUsers = userDAO.getAll();
        List<Relationship> relationships = relationshipDAO.getAll();

        List<User> filteredUsers = allUsers.stream()
                .filter(user -> !user.getUserID().equals(currentUser.getUserID())) // Loại bỏ currentUser
                .filter(user -> {
                    // Kiểm tra xem có bất kỳ mối quan hệ nào giữa currentUser và user này không
                    boolean hasRelationship = relationships.stream()
                            .anyMatch(r -> 
                                (r.getUser1().getUserID().equals(currentUser.getUserID()) && 
                                 r.getUser2().getUserID().equals(user.getUserID())) ||
                                (r.getUser1().getUserID().equals(user.getUserID()) && 
                                 r.getUser2().getUserID().equals(currentUser.getUserID()))
                            );
                    return !hasRelationship; // Chỉ giữ lại những user không có mối quan hệ
                })
                .filter(user -> user.getUserName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());

        menuList.removeAll();
        for (User user : filteredUsers) {
            menuList.add(new Item_Search(currentUser, user));
        }
        menuList.revalidate();
        menuList.repaint();
        if (filteredUsers.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Không tìm thấy người dùng nào có tên chứa: " + searchText, 
                "Kết quả tìm kiếm", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

    private void jtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtsearchActionPerformed
        // TODO add your handling code here:
        buttonActionPerformed(evt);
    }//GEN-LAST:event_jtsearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button button;
    private application.AdminPart.SearchText jtsearch;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}