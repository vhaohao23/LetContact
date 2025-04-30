package application.model;

import jakarta.persistence.*;


@Entity
@Table(name = "sessions")
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="SessionID")
    private String sessionID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    @Column
    private User userID;

    private String ipAddress;

    public Sessions() {
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}