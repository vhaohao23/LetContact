package application.dto;

import java.io.Serializable;
import java.net.InetAddress;

public class SendToOther implements Serializable {
    public byte[] imageData;
    public byte[] voiceData;
    public InetAddress ip;
    public int port;

    public SendToOther(byte[] imageData, byte[] voiceData, InetAddress ip, int port) {
        this.imageData = imageData;
        this.voiceData = voiceData;
        this.ip = ip;
        this.port = port;
    }
}
