package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.form.Item_Friend;
import application.ChatInterface.form.Item_Report;
import application.dao.RelationshipDAO;
import application.dao.UserDAO;
import application.model.Relationship;
import application.model.User;
import application.raven.swing.Button;
import application.session_management.SessionManagement;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ListFriends_Form extends javax.swing.JLayeredPane {
    private User loggedInUser;
    private UserDAO userDAO;
    private RelationshipDAO relationshipDAO;

    public ListFriends_Form() {
        initComponents();
        this.loggedInUser = SessionManagement.getInstance().getLoginSession().getUser();
        this.userDAO = new UserDAO();
        this.relationshipDAO = new RelationshipDAO();
        init();
    }
    
    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[fill]0", "0[]0"));
        showPeople();
    }
    
    public void showPeople() {
        menuList.removeAll();
        
        // Lấy danh sách user là UserID2 có R_Status với UserID1 là "accepted" hoặc "restricted"
        List<Relationship> relationships = relationshipDAO.getAll().stream()
            .filter(r -> r.getUser1().getUserID().equals(loggedInUser.getUserID())
                && (r.getrStatus().equals("accepted") || r.getrStatus().equals("restricted")))
            .collect(Collectors.toList());
            
        for (Relationship relationship : relationships) {
            User friend = relationship.getUser2();
            menuList.add(new Item_Friend(friend, loggedInUser, null), "wrap");
        }
        
        menuList.revalidate();
        menuList.repaint();
    }
    
    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String searchName = jtsearch.getText().trim();
        
        if (searchName.isEmpty()) {
            showPeople();
            return;
        }

        menuList.removeAll();
        
        // Lọc danh sách bạn bè theo tên nhập vào
        List<Relationship> relationships = relationshipDAO.getAll().stream()
            .filter(r -> r.getUser1().getUserID().equals(loggedInUser.getUserID())
                && (r.getrStatus().equals("accepted") || r.getrStatus().equals("restricted"))
                && r.getUser2().getUserName().toLowerCase().contains(searchName.toLowerCase()))
            .collect(Collectors.toList());

        if (relationships.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Không tìm thấy bạn bè nào có tên chứa: " + searchName,
                "Kết quả tìm kiếm",
                JOptionPane.INFORMATION_MESSAGE);
        }

        for (Relationship relationship : relationships) {
            User friend = relationship.getUser2();
            menuList.add(new Item_Friend(friend, loggedInUser, null), "wrap");
        }
        
        menuList.revalidate();
        menuList.repaint();
    }
    
    private void jtsearchActionPerformed(java.awt.event.ActionEvent evt) {
        buttonActionPerformed(evt);
    }

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button button;
    private application.AdminPart.SearchText jtsearch;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}