package application.dto;

import application.model.LoginSession;

import java.io.Serializable;

public class OtherInfomationCallVideo extends BaseMessage implements Serializable {
   LoginSession loginSession;

    public OtherInfomationCallVideo(MessageType type, LoginSession loginSession) {
        super(type);
        this.loginSession = loginSession;
    }

    public LoginSession getLoginSession() {
        return loginSession;
    }

    public void setLoginSession(LoginSession loginSession) {
        this.loginSession = loginSession;
    }
}
