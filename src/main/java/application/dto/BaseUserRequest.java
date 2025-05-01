package application.dto;

import application.model.User;

import java.io.Serializable;

public class BaseUserRequest implements Serializable {
    private String type;
    private User user;
    private String content;

    public BaseUserRequest(String type, User user, String content) {
        this.type = type;
        this.user = user;
        this.content = content;
    }

    public String getType() { return type; }
    public User getUser() { return user; }
    public String getContent() { return content; }
}
