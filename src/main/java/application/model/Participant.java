package application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ParticipantID", length = 200, nullable = false)
    private String participantId;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "ConversationID")
    private Conversation conversationId;

    @Column(name = "Role", length = 200)
    private String role = "member";

    public Participant() {
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Conversation getConversationId() {
        return conversationId;
    }

    public void setConversationId(Conversation conversationId) {
        this.conversationId = conversationId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}