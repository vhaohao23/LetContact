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
            public void sendMessage(String text) {
                System.out.println("sendMessage called with text: " + text);
                if (currentUser != null) {
                    Chat_Body chatBody = chatBodyMap.get(currentUser);
                    if (chatBody != null) {
                        // Hiển thị tin nhắn của mình ngay lập tức bên phải
                        chatBody.addItemRight(text);

                        Participant participant = (new ParticipantDAO()).selectParticipantOneByTwoUser(
                                SessionManagement.getInstance().getLoginSession().getUser(),
                                currentUser);

                        Message message = new Message(participant, text.getBytes(),
                                new Date(System.currentTimeMillis()), "text");

                        try {
                            // Gửi tin nhắn lên server
                            TCPSocketSession.getInstance().out.writeObject(
                                    new MessageDTO(MessageType.MESSAGE, message));
                            TCPSocketSession.getInstance().out.flush();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            @Override
            public void receiveMessage(Message message) {
                System.out.println("\n=== Message Received in Chat Event ===");
                System.out.println("EventChat.receiveMessage called");
                if (message != null && message.getParticipant() != null) {
                    User sender = message.getParticipant().getUser();
                    User currentLoginUser = SessionManagement.getInstance().getLoginSession().getUser();
                    System.out.println("Message details:");
                    System.out.println("- From: " + sender.getUserName());
                    System.out.println("- Current login user: " + currentLoginUser.getUserName());
                    System.out.println("- Current chat user: " + (currentUser != null ? currentUser.getUserName() : "null"));
                    System.out.println("- Chat windows in map: " + chatBodyMap.keySet().stream().map(User::getUserName).toList());

                    // Get or create chat window for sender
                    Chat_Body chatBody = chatBodyMap.get(sender);
                    if (chatBody == null) {
                        System.out.println("\nCreating new chat window for: " + sender.getUserName());
                        try {
                            chatBody = new Chat_Body();
                            chatBodyMap.put(sender, chatBody);
                            System.out.println("Successfully created chat body");
                            
                            // Only create chat bottom if this is the current user
                            if (currentUser != null && currentUser.equals(sender)) {
                                Chat_Bottom chatBottom = new Chat_Bottom();
                                chatBottomMap.put(sender, chatBottom);
                                System.out.println("Successfully created chat bottom");
                            }
                        } catch (Exception e) {
                            System.out.println("ERROR creating chat window: " + e.getMessage());
                            e.printStackTrace();
                            return;
                        }
                    }

                    // Add message to chat window
                    if (chatBody != null) {
                        System.out.println("Adding message to chat window");
                        try {
                            chatBody.addItemLeft(message);
                            System.out.println("Successfully added message to chat window");
                            
                            // If this is the current chat window, make sure it's visible
                            if (currentUser != null && currentUser.equals(sender)) {
                                chatBody.revalidate();
                                chatBody.repaint();
                            }
                        } catch (Exception e) {
                            System.out.println("ERROR adding message to chat window: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }

                    // If message is from current login user (multi-device sync)
                    if (sender.equals(currentLoginUser) && currentUser != null) {
                        System.out.println("\nProcessing multi-device sync message");
                        Chat_Body currentBody = chatBodyMap.get(currentUser);
                        if (currentBody != null) {
                            System.out.println("Adding sync message to chat window");
                            try {
                                currentBody.addItemRight(new String(message.getContent(), StandardCharsets.UTF_8));
                                System.out.println("Successfully added sync message");
                                currentBody.revalidate();
                                currentBody.repaint();
                            } catch (Exception e) {
                                System.out.println("ERROR adding sync message: " + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    System.out.println("ERROR: Message or participant is null");
                    if (message == null) {
                        System.out.println("Message is null");
                    }
                    if (message != null && message.getParticipant() == null) {
                        System.out.println("Participant is null");
                    }
                }
                System.out.println("=== End Message Processing ===\n");
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