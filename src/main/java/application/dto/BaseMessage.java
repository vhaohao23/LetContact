package application.dto;

import java.io.Serializable;

public abstract class BaseMessage implements Serializable {
    private MessageType type;

    public BaseMessage(MessageType type) {
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
