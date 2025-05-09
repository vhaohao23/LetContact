package application.model;

import java.io.Serializable;
import java.net.InetAddress;

public class SendToOther implements Serializable {
    public byte[] imageData;
    public InetAddress ip;
    public int port;

    public SendToOther(byte[] imageData, InetAddress ip, int port) {
        this.imageData = imageData;
        this.ip = ip;
        this.port = port;
    }
}
