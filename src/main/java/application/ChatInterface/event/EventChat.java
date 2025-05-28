
package application.ChatInterface.event;


import application.model.Message;
import application.model.User;

public interface EventChat {
    public void sendMessage (Message message);
    public void receiveMessage (Message message);
    User getCurrentUser();
}
