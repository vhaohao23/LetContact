package application.session_management;

import application.model.LoginSession;
import application.model.User;

public class SessionManagement {
    private static SessionManagement instance;

    private static LoginSession loginSession;

    private SessionManagement() {
    }

    public static SessionManagement getInstance() {
        if (instance == null) {
            instance = new SessionManagement();
        }
        if (loginSession == null){
            loginSession = new LoginSession();
        }
        return instance;
    }

    public  LoginSession getLoginSession() {
        return loginSession;
    }

    public  void setLoginSession(LoginSession loginSession) {
        SessionManagement.loginSession = loginSession;
    }
}
