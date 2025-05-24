package application.ChatInterface.form;

import application.ChatInterface.Chat_Body;
import application.ChatInterface.Chat_Bottom;
import application.ChatInterface.Chat_Title;
import application.ChatInterface.event.EventChat;
import application.ChatInterface.event.EventMenuLeft;
import application.ChatInterface.event.PublicEvent;
import application.model.User;
import net.miginfocom.swing.MigLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class Chat extends javax.swing.JPanel {

    private Chat_Title chatTitle;
    private Map<User, Chat_Body> chatBodyMap;
    private Map<User, Chat_Bottom> chatBottomMap;
    private User currentUser;
    private Chat_Body currentChatBody;
    private Chat_Bottom currentChatBottom;

    public Chat() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, fill]0[shrink 0]0"));
        chatTitle = new Chat_Title();
        chatBodyMap = new HashMap<>();
        chatBottomMap = new HashMap<>();
        currentChatBody = new Chat_Body();
        currentChatBottom = new Chat_Bottom();

        setVisible(false);

        // Add initial components (will be replaced when a user is selected)
        add(chatTitle, "wrap");
        add(currentChatBody, "wrap");
        add(currentChatBottom, "h ::40%");

        // Event for sending messages
        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void sendMessage(String text) {
                if (currentUser != null) {
                    Chat_Body chatBody = chatBodyMap.get(currentUser);
                    if (chatBody != null) {
                        chatBody.addItemRight(text);
                    }
                }
            }
        });

        // Event for selecting a user
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

                // Get or create Chat_Body for this user
                Chat_Body newChatBody = chatBodyMap.get(user);
                if (newChatBody == null) {
                    newChatBody = new Chat_Body();
                    chatBodyMap.put(user, newChatBody);
                }

                // Get or create Chat_Bottom for this user
                Chat_Bottom newChatBottom = chatBottomMap.get(user);
                if (newChatBottom == null) {
                    newChatBottom = new Chat_Bottom();
                    chatBottomMap.put(user, newChatBottom);
                }

                // Remove current Chat_Body and Chat_Bottom
                remove(currentChatBody);
                remove(currentChatBottom);

                // Update current components
                currentChatBody = newChatBody;
                currentChatBottom = newChatBottom;

                // Add new components to layout
                add(currentChatBody, "wrap");
                add(currentChatBottom, "h ::40%");

                // Refresh UI
                revalidate();
                repaint();
                setVisible(true);
            }
        });
    }

    public void resetChat() {
        currentUser = null;
        currentChatBody.clearChat();
        chatTitle.setName("");
        chatTitle.setStatusText("");
        setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
    }
    // </editor-fold>
}
