package application.session_management;

import application.ChatInterface.form.Chat;

public class ChatSession {
    private static ChatSession instance;
    private static Chat chat;

    private ChatSession() {
    }

    public static ChatSession getInstance() {
        if (instance == null) {
            instance = new ChatSession();
        }
        if (chat == null) {
            chat = new Chat();
        }
        return instance;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        ChatSession.chat = chat;
    }
}