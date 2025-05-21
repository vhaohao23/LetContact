
package application.ChatInterface.event;

public class PublicEvent {
    private static PublicEvent instance;
    private EventImageView evetImageView;
    private EventChat eventChat;
    
    public static PublicEvent getInstance(){
        if (instance == null){
            instance = new PublicEvent();
        }
        return instance;
    }
    
    private PublicEvent(){
        
    }
    
    public void addEventImageView(EventImageView event){
        this.evetImageView = event;
    }
    
    public void addEventChat(EventChat event){
        this.eventChat = event;
    }
    
    public EventImageView getEventImageView(){
        return evetImageView;
    }
    
    public EventChat getEventChat(){
        return eventChat;
    }
}
