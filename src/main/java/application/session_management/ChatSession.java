package application.session_management;

import application.ChatInterface.form.Chat;
import application.ChatInterface.event.PublicEvent;

public class ChatSession {
    private static ChatSession instance;
    private static Chat chat;

    private ChatSession() {
        // Initialize chat instance
        chat = new Chat();
        // Register the chat's event handler
        PublicEvent.getInstance().addEventChat(chat.getEventChat());
    }

    public static ChatSession getInstance() {
        if (instance == null) {
            instance = new ChatSession();
        }
        return instance;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat newChat) {
        if (newChat != null && newChat != chat) {
            // Unregister old event handler
            PublicEvent.getInstance().addEventChat(null);
            // Update chat instance
            chat = newChat;
            // Register new event handler
            PublicEvent.getInstance().addEventChat(chat.getEventChat());
        }
    }
}