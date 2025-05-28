package application.ChatInterface.form;

import application.ChatInterface.Chat_Body;
import application.ChatInterface.Chat_Bottom;
import application.ChatInterface.Chat_Title;
import application.ChatInterface.event.EventChat;
import application.ChatInterface.event.EventMenuLeft;
import application.ChatInterface.event.EventMenuRight;
import application.ChatInterface.event.PublicEvent;
import application.dao.ParticipantDAO;
import application.dto.MessageDTO;
import application.dto.MessageType;
import application.model.Conversation;
import application.model.Message;
import application.model.Participant;
import application.model.User;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import net.miginfocom.swing.MigLayout;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class Chat extends javax.swing.JPanel {

    private Chat_Title chatTitle;
    public Map<User, Chat_Body> chatBodyMap;
    private Map<User, Chat_Bottom> chatBottomMap;
    private User currentUser;
    private Conversation currentConversation;
    private Chat_Body currentChatBody;
    private Chat_Bottom currentChatBottom;
    private EventChat eventChat;

    public Chat() {
        initComponents();
        init();
    }

    private void init() {
        System.out.println("\n=== Initializing Chat ===");
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, fill]0[shrink 0]0"));
        chatTitle = new Chat_Title();
        chatBodyMap = new HashMap<>();
        chatBottomMap = new HashMap<>();

        currentChatBody = null;
        currentChatBottom = null;

        setVisible(false);

        add(chatTitle, "wrap");

        System.out.println("Setting up event system");
        eventChat = new EventChat() {
            @Override
            public void sendMessage(Message message) {
                if (currentUser != null) {
                    Chat_Body chatBody = chatBodyMap.get(currentUser);
                    if (chatBody != null) {
                        try {
                            // Kiểm tra loại tin nhắn
                            if ("image".equals(message.getType())) {
                                // Hiển thị hình ảnh bên phải
                                chatBody.addItemRight(message.getContent());
                            } else {
                                // Hiển thị text bên phải
                                chatBody.addItemRight(new String(message.getContent(), StandardCharsets.UTF_8));
                            }
                            
                            // Gửi tin nhắn lên server
                            TCPSocketSession.getInstance().out.writeObject(
                                    new MessageDTO(MessageType.MESSAGE, message));
                            TCPSocketSession.getInstance().out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, 
                                "Lỗi khi gửi tin nhắn", 
                                "Lỗi", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            @Override
            public void receiveMessage(Message message) {
                if (message != null && message.getParticipant() != null) {
                    User sender = message.getParticipant().getUser();
                    Chat_Body chatBody = chatBodyMap.get(sender);
                    
                    if (chatBody != null) {
                        try {
                            // Xử lý tất cả loại tin nhắn trong một phương thức
                            chatBody.addItemLeft(message);
                            
                            // Cập nhật UI nếu đang chat với người gửi
                            if (currentUser != null && currentUser.equals(sender)) {
                                chatBody.revalidate();
                                chatBody.repaint();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null,
                                "Lỗi khi hiển thị tin nhắn",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            @Override
            public User getCurrentUser() {
                return currentUser;
            }
        };
        PublicEvent.getInstance().addEventChat(eventChat);
        System.out.println("Event system setup complete");
        System.out.println("=== Chat Initialization Complete ===\n");

        // Event for selecting a user
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void selectUser(User user) {
                System.out.println("\n=== Selecting User ===");
                System.out.println("Selecting user: " + user.getUserName());
                
                currentUser = user;
                chatTitle.setName(user.getUserName());
                if ("ACTIVE".equalsIgnoreCase(user.getStatus())) {
                    chatTitle.statusActive();
                } else {
                    chatTitle.setStatusText(user.getStatus());
                }

                // Remove current components if they exist
                if (currentChatBody != null) {
                    remove(currentChatBody);
                }
                if (currentChatBottom != null) {
                    remove(currentChatBottom);
                }

                // Get or create Chat_Body for this user
                Chat_Body chatBody = chatBodyMap.get(user);
                if (chatBody == null) {
                    System.out.println("Creating new chat body for user: " + user.getUserName());
                    chatBody = new Chat_Body();
                    chatBodyMap.put(user, chatBody);
                } else {
                    System.out.println("Using existing chat body for user: " + user.getUserName());
                }

                // Get or create Chat_Bottom for this user
                Chat_Bottom chatBottom = chatBottomMap.get(user);
                if (chatBottom == null) {
                    System.out.println("Creating new chat bottom for user: " + user.getUserName());
                    chatBottom = new Chat_Bottom();
                    chatBottomMap.put(user, chatBottom);
                } else {
                    System.out.println("Using existing chat bottom for user: " + user.getUserName());
                }

                // Update current components
                currentChatBody = chatBody;
                currentChatBottom = chatBottom;

                // Add new components to layout
                add(currentChatBody, "wrap");
                add(currentChatBottom, "h ::40%");

                // Refresh UI
                revalidate();
                repaint();
                setVisible(true);
                
                System.out.println("=== User Selection Complete ===\n");
                PublicEvent.getInstance().getEventMenuRight().selectUser(user);
            }

            @Override
            public void selectConversation(Conversation conversation, Participant participant) {
                currentConversation = conversation;
                if (participant != null && conversation.equals(participant.getConversation())) {
                    currentUser = participant.getUser();
                }
                chatTitle.setName(conversation.getNameGroup());
                if ("group".equalsIgnoreCase(conversation.getType())) {
                    chatTitle.statusActive();
                } else {
                    chatTitle.setStatusText(conversation.getType());
                }

                if (currentChatBody != null) {
                    remove(currentChatBody);
                }
                if (currentChatBottom != null) {
                    remove(currentChatBottom);
                }

                Chat_Body chatBody = chatBodyMap.get(currentUser);
                if (chatBody == null) {
                    System.out.println("Creating new chat body for user: " + (currentUser != null ? currentUser.getUserName() : "null"));
                    chatBody = new Chat_Body();
                    chatBodyMap.put(currentUser, chatBody);
                } else {
                    System.out.println("Using existing chat body for user: " + (currentUser != null ? currentUser.getUserName() : "null"));
                }

                Chat_Bottom chatBottom = chatBottomMap.get(currentUser);
                if (chatBottom == null) {
                    System.out.println("Creating new chat bottom for user: " + (currentUser != null ? currentUser.getUserName() : "null"));
                    chatBottom = new Chat_Bottom();
                    chatBottomMap.put(currentUser, chatBottom);
                } else {
                    System.out.println("Using existing chat bottom for user: " + (currentUser != null ? currentUser.getUserName() : "null"));
                }

                currentChatBody = chatBody;
                currentChatBottom = chatBottom;

                add(currentChatBody, "wrap");
                add(currentChatBottom, "h ::40%");

                revalidate();
                repaint();
                setVisible(true);

                System.out.println("=== Conversation Selection Complete ===\n");
                PublicEvent.getInstance().getEventMenuRight().selectConversation(conversation, participant);
                // Chuyển sang Menu_Right_Group
                HomeChat homeChat = (HomeChat) SwingUtilities.getAncestorOfClass(HomeChat.class, Chat.this); // Sửa từ 'this' thành 'Chat.this'
                if (homeChat != null) {
                    homeChat.showRightMenu(new Menu_Right_Group());
                } else {
                    System.err.println("HomeChat ancestor not found!");
                }
            }

            @Override
            public void newUser(List<User> users) {
            }

            @Override
            public void userConnect(String userID) {
            }

            @Override
            public void userDisconnect(String userID) {
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

    public EventChat getEventChat() {
        return eventChat;
    }

    @SuppressWarnings("unchecked")
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
}