
package application.ChatInterface.form;

import application.AdminPart.ScrollBar;
import javax.swing.JLayeredPane;

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

import java.util.List;


public class Menu_Left extends javax.swing.JPanel {

    private UserDAO userDAO;
    private RelationshipDAO relationshipDAO;
    private ConversationDAO conversationDAO = new ConversationDAO();
    private ParticipantDAO participantDAO = new ParticipantDAO();
    private HomeChat homeChat;

    public Menu_Left(HomeChat homeChat) {
        this.homeChat = homeChat;
        userDAO = new UserDAO();
        relationshipDAO = new RelationshipDAO();
        initComponents();
        init();
    }

    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx","0[]0", "0[]2"));
        showPeople();
    }
    private void showPeople() {
        menuList.removeAll();
        User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
        if (currentUser == null || currentUser.getUserName() == null) {
            System.err.println("No logged-in user found. Cannot load relationships.");
            refreshMenuList();
            return;
        }

        String currentUserName = currentUser.getUserName();
        List<Relationship> relationships = relationshipDAO.selectByUserName(currentUserName);

        for (Relationship relationship : relationships) {
            if (relationship.getUser1().getUserName().equals(currentUserName) && "accepted".equals(relationship.getrStatus())) {
                User otherUser = relationship.getUser2();
                if (otherUser != null) {
                    menuList.add(new Item_People(otherUser), "wrap");
                }
            }
        }
        refreshMenuList();
    }

    private void showGroup(){
        menuList.removeAll();
        User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
        if (currentUser == null || currentUser.getUserID() == null) {
            System.err.println("No logged-in user found. Cannot load groups.");
            refreshMenuList();
            return;
        }
        List<Participant> participants = participantDAO.selectByUserID(currentUser.getUserID());
        for (Participant participant : participants) {
            Conversation conversation = conversationDAO.selectById(participant.getConversation().getConversationID());
            if (conversation != null) {
                long participantCount = participantDAO.countParticipantsByConversationID(conversation.getConversationID());
                if (participantCount >= 3) {
                    menuList.add(new Item_Group(conversation, participant), "wrap");
                }
            }
        }
        refreshMenuList();
    }
    
    private void refreshMenuList(){
        menuList.repaint();
        menuList.revalidate();  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new application.ChatInterface.MenuButton();
        menuGroup = new application.ChatInterface.MenuButton();
        menuButton1 = new application.ChatInterface.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setLayout(new java.awt.GridLayout(1, 2));

        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/icons8-chat-32color.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/icons8-chat-32.png"))); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/icons8-group-32.png"))); // NOI18N
        menuGroup.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/icons8-group-32color.png"))); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/icons8-group-32.png"))); // NOI18N
        menuGroup.setOpaque(true);
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/create.png"))); // NOI18N
        menuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(evt);
            }
        });
        menu.add(menuButton1);

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(211, 221, 235));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addComponent(menu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if(!menuMessage.isSelected()){
            menuMessage.setSelected(true);
            menuGroup.setSelected(false);
            showPeople();
        }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        if(!menuGroup.isSelected()){
            menuMessage.setSelected(false);
            menuGroup.setSelected(true);
            showGroup();
        }
    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton1ActionPerformed
        // TODO add your handling code here:
        homeChat.showMenu(new Menu_Left_Create_Group(homeChat));
    }//GEN-LAST:event_menuButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private application.ChatInterface.MenuButton menuButton1;
    private application.ChatInterface.MenuButton menuGroup;
    private javax.swing.JLayeredPane menuList;
    private application.ChatInterface.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
