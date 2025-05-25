
package application.ChatInterface.event;


import application.model.Message;
import application.model.User;

public interface EventChat {
    public void sendMessage (String text);
    public void receiveMessage (Message message);
}
