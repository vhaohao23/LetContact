package application.dto;

import application.model.LoginSession;

import java.io.Serializable;

public class UserSessionResponse implements Serializable {
    private String type;
    private LoginSession loginSession;
    private String content;

    public UserSessionResponse(String type, LoginSession loginSession, String content) {
        this.type = type;
        this.loginSession = loginSession;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LoginSession getLoginSession() {
        return loginSession;
    }

    public void setLoginSession(LoginSession loginSession) {
        this.loginSession = loginSession;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
