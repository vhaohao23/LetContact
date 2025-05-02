package application.dto;

import application.model.LoginSession;

import java.io.Serializable;

public class LoginSuccessResponse extends BaseMessage implements Serializable {
    private LoginSession loginSession;
    private String content;

    public LoginSuccessResponse(MessageType type, LoginSession loginSession, String content) {
        super(type);
        this.loginSession = loginSession;
        this.content = content;
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
