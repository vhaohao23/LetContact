package application.model;

import jakarta.persistence.*;


@Entity
@Table(name = "relationship")
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RelationshipID", length = 200)
    private String relationshipID;

    @ManyToOne
    @JoinColumn(name = "UserID1")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "UserID2")
    private User user2;

    @Column(name = "R_Status", length = 200, nullable = true, columnDefinition = "VARCHAR(200) DEFAULT 'pending'")
    private String rStatus = "pending";

    // Default constructor
    public Relationship() {
    }

    public String getRelationshipID() {
        return relationshipID;
    }

    public void setRelationshipID(String relationshipID) {
        this.relationshipID = relationshipID;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }
}