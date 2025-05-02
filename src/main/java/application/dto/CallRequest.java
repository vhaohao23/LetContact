package application.dto;

import application.model.User;

import java.io.Serializable;

public class CallRequest extends BaseMessage implements Serializable {
    private User caller;
    private User callee;

    public CallRequest(MessageType type, User caller, User callee) {
        super(type);
        this.caller = caller;
        this.callee = callee;
    }

    public User getCaller() {
        return caller;
    }

    public void setCaller(User caller) {
        this.caller = caller;
    }

    public User getCallee() {
        return callee;
    }

    public void setCallee(User callee) {
        this.callee = callee;
    }
}
