package application.ChatInterface.event;

import application.model.Conversation;
import application.model.Participant;
import application.model.User;

public interface EventMenuRight {
    public void selectUser(User user);

    public void selectConversation(Conversation conversation, Participant participant);
}
