package application.ChatInterface.event;

import application.model.User;
import java.util.List;

public interface EventMenuLeft {

    public void newUser(List<User> users);

    public void userConnect(String userID);

    public void userDisconnect(String userID);

    public void selectUser(User user);
}
