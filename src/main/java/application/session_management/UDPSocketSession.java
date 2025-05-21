package application.session_management;

import application.model.User;

import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class UDPSocketSession {
    private static UDPSocketSession instance;

    public DatagramSocket socket;

    {
        try {
            socket = new DatagramSocket(9877);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    private UDPSocketSession() {
    }

    public static UDPSocketSession getInstance() throws SocketException {
        if (instance == null) {
            instance = new UDPSocketSession();
        }
        return instance;
    }


}
