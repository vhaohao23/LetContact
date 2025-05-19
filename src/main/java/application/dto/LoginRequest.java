package application.dto;

import application.model.User;

import java.io.Serializable;

public class LoginRequest extends BaseMessage implements Serializable{
    private User user;
    private String content;

    public LoginRequest(MessageType type) {
        super(type);
    }

    public LoginRequest(MessageType type, User user, String content) {
        super(type);
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
