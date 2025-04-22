package application.session_management;

import application.model.User;

public class UserSession {
    private static UserSession instance;

    private static User user;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
             user = new User();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
