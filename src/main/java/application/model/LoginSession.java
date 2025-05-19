package application.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "loginsession")
public class LoginSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="SessionID")
    private String sessionID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "IPAddress")
    private String ipAddress;

    @Column(name = "Port")
    private int port;

    @Column(name = "UDPIPAddress")
    private String udpIpAddress=null;

    @Column(name = "UDPPort")
    private int udpPort=0;

    public LoginSession() {
    }

    public LoginSession(User user, String ipAddress, int port) {
        this.user = user;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUdpIpAddress() {
        return udpIpAddress;
    }

    public void setUdpIpAddress(String udpIpAddress) {
        this.udpIpAddress = udpIpAddress;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }
}