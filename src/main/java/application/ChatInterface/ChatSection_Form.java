package application.ChatInterface;

import application.ChatInterface.event.EventImageView;
import application.ChatInterface.event.PublicEvent;
import application.ChatInterface.form.Chat;
import application.ChatInterface.form.Menu_Right;
import application.dao.UserDAO;
import application.model.User;
import application.session_management.SessionManagement;

import javax.swing.Icon;
import java.util.List;
import java.awt.Component;

public class ChatSection_Form extends javax.swing.JPanel {

    
    public ChatSection_Form() {
        initComponents();
        view_Image.setVisible(false);
        home.setVisible(true);
        initEvent();
        initializeFriendsList();
    }

    private void initializeFriendsList() {
        User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
        if (currentUser != null) {
            UserDAO userDAO = new UserDAO();
            List<User> friends = userDAO.selectFriend(currentUser);
        }
    }
    
    private void initEvent() {
        PublicEvent.getInstance().addEventImageView(new EventImageView(){
            @Override
            public void viewImage(Icon image) {
                view_Image.viewImage(image);
            }
            
            @Override
            public void saveImage(Icon image) {
                System.out.println("Save Image next update");
            }
        });
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        border = new javax.swing.JPanel();
        body = new javax.swing.JLayeredPane();
        view_Image = new application.ChatInterface.form.View_Image();
        home = new application.ChatInterface.form.HomeChat();

        border.setBackground(new java.awt.Color(229, 229, 229));

        body.setLayout(new java.awt.CardLayout());
        body.setLayer(view_Image, javax.swing.JLayeredPane.POPUP_LAYER);
        body.add(view_Image, "card3");
        body.add(home, "card2");

        javax.swing.GroupLayout borderLayout = new javax.swing.GroupLayout(border);
        border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(
                borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1673, Short.MAX_VALUE)
        );
        borderLayout.setVerticalGroup(
                borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(body)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane body;
    private javax.swing.JPanel border;
    private application.ChatInterface.form.HomeChat home;
    private application.ChatInterface.form.View_Image view_Image;
    // End of variables declaration//GEN-END:variables

    public void resetAndRefresh() {
        // Ẩn chat và menu_right nếu đang hiển thị
        if (home != null) {
            Component[] components = home.getComponents();
            for (Component comp : components) {
                if (comp instanceof Chat) {
                    ((Chat) comp).setVisible(false);
                } else if (comp instanceof Menu_Right) {
                    ((Menu_Right) comp).setVisible(false);
                }
            }
        }

        // Cập nhật lại danh sách bạn bè
        initializeFriendsList();

        // Refresh giao diện
        revalidate();
        repaint();
    }
}