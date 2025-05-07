package application.session_management;

import application.model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPSocketSession {
    private static TCPSocketSession instance;

    public  Socket socket;
    public ObjectInputStream in;
    public ObjectOutputStream out;

    private TCPSocketSession() {
    }

    public static TCPSocketSession getInstance() {
        if (instance == null) {
            instance = new TCPSocketSession();
        }
        return instance;
    }

}
