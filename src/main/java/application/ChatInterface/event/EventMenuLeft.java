package application.ChatInterface.event;

import application.model.Conversation;
import application.model.Participant;
import application.model.User;
import java.util.List;

public interface EventMenuLeft {

    public void newUser(List<User> users);

    public void userConnect(String userID);

    public void userDisconnect(String userID);

    public void selectUser(User user);

    public void selectConversation(Conversation conversation, Participant participant);
}
