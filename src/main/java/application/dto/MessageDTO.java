package application.dto;

import application.model.Message;

import java.io.Serializable;

public class MessageDTO extends BaseMessage implements Serializable {
    private Message message;

    public MessageDTO(MessageType type, Message message) {
        super(type);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}