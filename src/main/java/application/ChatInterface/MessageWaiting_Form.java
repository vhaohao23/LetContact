
package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.form.Item_People;
import application.ChatInterface.form.Item_Stranger;
import application.dao.RelationshipDAO;
import application.dao.UserDAO;
import application.model.Relationship;
import application.model.User;
import net.miginfocom.swing.MigLayout;

import java.util.List;
import java.util.stream.Collectors;


public class MessageWaiting_Form extends javax.swing.JLayeredPane {

    private User currentUser;

    public MessageWaiting_Form(User currentUser) {
        if (currentUser == null) {
            throw new IllegalArgumentException("Current user cannot be null");
        }
        this.currentUser = currentUser;
        initComponents();
        init();
    }
    
    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx, wrap 2", "[center]10[center]", "[]10[]"));
        showPeople();
    }
    private void showPeople() {
        RelationshipDAO relationshipDAO = new RelationshipDAO();
        UserDAO userDAO = new UserDAO();
        List<Relationship> relationships = relationshipDAO.getAll();

        List<Relationship> waitingRelationships = relationships.stream()
                .filter(r -> r.getUser1().getUserID().equals(currentUser.getUserID()))
                .filter(r -> r.getrStatus().equals("waiting"))
                .collect(Collectors.toList());

        menuList.removeAll();
        for (Relationship r : waitingRelationships) {
            User targetUser = r.getUser2(); // UserID2 là user gửi lời mời
            menuList.add(new Item_Stranger(currentUser, targetUser));
        }
        menuList.revalidate();
        menuList.repaint();
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        sp.setBackground(new java.awt.Color(222, 242, 255));

        menuList.setBackground(new java.awt.Color(200, 227, 255));

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
