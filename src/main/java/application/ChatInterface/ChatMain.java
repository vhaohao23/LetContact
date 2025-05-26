
package application.ChatInterface;

import application.AdminPart.EventMenuSelected;
import application.ChatInterface.event.EventImageView;
import application.ChatInterface.event.PublicEvent;
import application.ChatInterface.form.MainForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.swing.*;

import application.ChatInterface.form.Setting_Frame;
import application.Main;
import application.dao.UserDAO;
import application.model.User;
import application.session_management.MainApplicationSession;
import application.session_management.SessionManagement;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ChatMain extends javax.swing.JFrame {

    private final MigLayout layout;
    private final MainForm main;
    private final MenuLayout menu;
    private final Animator animator;
    private User currentUser;
    
    public ChatMain() {
        initComponents();
        setBackground(Color.yellow);
        layout = new MigLayout("fill", "0[fill]0", "0[fill]0");
        main = new MainForm();
        menu = new MenuLayout();
        menu.getMenu().initMoving(ChatMain.this);
        main.initMoving(ChatMain.this);
        mainPanel.setLayer(menu, JLayeredPane.POPUP_LAYER);
        mainPanel.setLayout(layout);
        mainPanel.add(main);
        mainPanel.add(menu, "pos -284 0 100% 100%", 0);

        init();

        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                float x = (fraction * 284);
                float alpha;
                if(menu.isShow()){
                    x = -x;
                    alpha = 0.5f - (fraction / 2);
                } else{
                    x -= 284;
                    alpha = fraction / 2;
                }
                layout.setComponentConstraints(menu, "pos " + (int) x + " 0 100% 100%");
                if(alpha<0){
                    alpha = 0;
                }
                menu.setAlpha(alpha);
                mainPanel.revalidate();
            }
            @Override
            public void end() {
                menu.setShow(!menu.isShow());
                if (!menu.isShow()){
                    menu.setVisible(false);
                }
            }
        };
        animator = new Animator(200, target);
        menu.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me) {
                if(SwingUtilities.isLeftMouseButton(me)){
                    if(!animator.isRunning()){
                        if(menu.isShow()){
                            animator.start();
                        }
                    }
                }
            }
        });
        main.addEvenMenu(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()){
                    if (!menu.isShow()){
                        menu.setVisible(true);
                        animator.start();
                    }
                }
            }
        });
        menu.getMenu().addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0){
                    main.show(new ChatSection_Form());
                } else if (index == 1){
                    if (currentUser != null) {
                        main.show(new MessageWaiting_Form(currentUser));
                    } else {
                        JOptionPane.showMessageDialog(ChatMain.this, "User session is not available. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (index == 4){
                    main.show(new ListFriends_Form());
                } else if (index == 5){
                    if (currentUser != null) {
                        main.show(new SearchFriends_Form(currentUser));
                    } else {
                        JOptionPane.showMessageDialog(ChatMain.this, "User session is not available. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (index == 7){
                    main.show(new RestrictedAccount_Form());
                } else if (index == 8){
                    main.show(new ReportAccount_Form());
                } else if (index == 9){
                    if (currentUser != null) {
                        new Setting_Frame(currentUser).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(ChatMain.this, "User session is not available. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (index == 10){
                    setVisible(false);
                }
            }
        });
    }

    private void init() {
        URL url_icon_signup = Setting_Frame.class.getResource("/application/AdminImage/iconChat.png");
        Image img = Toolkit.getDefaultToolkit().createImage(url_icon_signup);
        setIconImage(img);
        setTitle("KHchat");

        currentUser = SessionManagement.getInstance().getLoginSession().getUser();
        if (currentUser == null) {
            System.out.println("Warning: currentUser is null. Session may not be initialized.");
            JOptionPane.showMessageDialog(this, "Session expired. Please log in again.", "Session Error", JOptionPane.ERROR_MESSAGE);
        } else {
            UserDAO userDAO = new UserDAO();
            List<User> friends = userDAO.selectFriend(currentUser);
            System.out.println("User: " + currentUser.getUserName() + ", Friends: " + friends.size());
            menu.getMenu().repaint();
        }
    }


    @SuppressWarnings("unchecked")
    private void initComponent() {
        mainPanel = new javax.swing.JLayeredPane();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainPanel.setBackground(new java.awt.Color(229, 229, 229));
        mainPanel.setOpaque(true);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1354, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 731, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel)
        );

        pack();
        setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(229, 229, 229));
        mainPanel.setOpaque(true);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1354, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(() -> new ChatMain().setVisible(true));;
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane mainPanel;
    // End of variables declaration//GEN-END:variables

}
