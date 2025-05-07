package application.client;

import application.session_management.TCPSocketSession;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSender implements Runnable{
    @Override
    public void run() {
        try {
            TCPSocketSession.getInstance().out=new ObjectOutputStream(TCPSocketSession.getInstance().socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
