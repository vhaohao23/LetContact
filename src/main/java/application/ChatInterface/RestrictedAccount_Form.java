package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.form.Item_Restricted;
import application.AdminPart.SearchText;
import application.dao.RelationshipDAO;
import application.dao.UserDAO;
import application.model.Relationship;
import application.model.User;
import application.raven.swing.Button;
import application.session_management.SessionManagement;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;


public class RestrictedAccount_Form extends javax.swing.JLayeredPane {
    private User currentUser;
    private UserDAO userDAO;
    private RelationshipDAO relationshipDAO;

    public RestrictedAccount_Form() {
        initComponents();
        this.currentUser = SessionManagement.getInstance().getLoginSession().getUser();
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
        
        // Lấy danh sách các user bị restricted
        List<Relationship> restrictedRelationships = relationshipDAO.getAll().stream()
            .filter(r -> r.getUser1().getUserID().equals(currentUser.getUserID())
                     && "restricted".equals(r.getrStatus()))
            .collect(Collectors.toList());

        int row = 0;
        for (Relationship relationship : restrictedRelationships) {
            User restrictedUser = relationship.getUser2();
            menuList.add(new Item_Restricted(currentUser, restrictedUser), "wrap");
            row++;
        }

        menuList.revalidate();
        menuList.repaint();
    }

    private void jtsearchActionPerformed(java.awt.event.ActionEvent evt) {
        buttonActionPerformed(evt);
    }

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String searchText = jtsearch.getText().trim().toLowerCase();
        
        if (searchText.isEmpty()) {
            showPeople();
            return;
        }

        menuList.removeAll();
        
        // Tìm kiếm trong danh sách restricted users theo userName
        List<Relationship> restrictedRelationships = relationshipDAO.getAll().stream()
            .filter(r -> {
                User user2 = r.getUser2();
                return r.getUser1().getUserID().equals(currentUser.getUserID()) 
                    && "restricted".equals(r.getrStatus())
                    && user2.getUserName().toLowerCase().contains(searchText.toLowerCase());
            })
            .collect(Collectors.toList());

        if (restrictedRelationships.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Không tìm thấy người dùng nào có tên chứa: " + searchText,
                "Kết quả tìm kiếm",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Relationship relationship : restrictedRelationships) {
                User restrictedUser = relationship.getUser2();
                menuList.add(new Item_Restricted(currentUser, restrictedUser), "wrap");
            }
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
        jtsearch = new SearchText();

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
    private SearchText jtsearch;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}