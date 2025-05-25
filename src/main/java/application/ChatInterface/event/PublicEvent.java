package application.ChatInterface.event;

public class PublicEvent {
    private static PublicEvent instance;
    private EventImageView evetImageView;
    private EventChat eventChat;
    private EventMenuLeft eventMenuLeft;
    private EventMenuRight eventMenuRight;

    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }

    private PublicEvent() {
    }

    public void addEventImageView(EventImageView event) {
        this.evetImageView = event;
    }

    public void addEventChat(EventChat event) {
        this.eventChat = event;
    }

    // Thêm phương thức này
    public void addEventMenuRight(EventMenuRight event) {
        this.eventMenuRight = event;
    }

    public EventMenuRight getEventMenuRight() {
        return eventMenuRight;
    }

    public void addEventMenuLeft(EventMenuLeft event) {
        this.eventMenuLeft = event;
    }

    public EventImageView getEventImageView() {
        return evetImageView;
    }

    public EventChat getEventChat() {
        return eventChat;
    }

    public EventMenuLeft getEventMenuLeft() {
        return eventMenuLeft;
    }
}