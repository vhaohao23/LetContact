
package application.ChatInterface.form;

import application.ChatInterface.Chat_Body;
import application.ChatInterface.Chat_Bottom;
import application.ChatInterface.Chat_Title;
import application.ChatInterface.event.EventChat;
import application.ChatInterface.event.EventMenuLeft;
import application.ChatInterface.event.PublicEvent;
import application.model.User;
import net.miginfocom.swing.MigLayout;

import java.util.List;


public class Chat extends javax.swing.JPanel {

    private Chat_Title chatTitle;
    private Chat_Body chatBody;
    private User currentUser;

    public Chat() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, bottom]0[shrink 0]0"));
        Chat_Title chatTitle = new Chat_Title();
        Chat_Body chatBody = new Chat_Body();
        Chat_Bottom chatBottom = new Chat_Bottom();

        setVisible(false);

        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void sendMessage(String text) {
                if (currentUser != null) {
                    chatBody.addItemRight(text);
                }
            }
        });
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<User> users) {
            }

            @Override
            public void userConnect(String userID) {
            }

            @Override
            public void userDisconnect(String userID) {
            }

            @Override
            public void selectUser(User user) {
                currentUser = user;
                chatTitle.setName(user.getUserName());
                if ("ACTIVE".equalsIgnoreCase(user.getStatus())) {
                    chatTitle.statusActive();
                } else {
                    chatTitle.setStatusText(user.getStatus());
                }
                chatBody.clearChat();
                setVisible(true);
            }
        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::40%");
    }

    public void resetChat() {
        currentUser = null;
        chatBody.clearChat();
        chatTitle.setName("");
        chatTitle.setStatusText("");
        setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
