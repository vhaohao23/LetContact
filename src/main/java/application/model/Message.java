package application.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MessageID", length = 200)
    private String messageId;

    @ManyToOne
    @JoinColumn(name = "ParticipantID")
    private Participant participantId;

    @Lob
    @Column(name = "Content")
    private byte[] content;

    @Column(name = "Time")
    @Temporal(TemporalType.DATE)
    private Date time;

    @Column(name = "Type", length = 50)
    private String type;

    public Message() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Participant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Participant participantId) {
        this.participantId = participantId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
