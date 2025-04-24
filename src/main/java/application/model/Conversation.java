package application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ConversationID", length = 50)
    private String conversationID;

    @Column(name = "Type", length = 50)
    private String type;

    @Column(name = "Name_Group", length = 50)
    private String nameGroup;

    @Column(name = "Theme", length = 50)
    private String theme = "light"; // Default value as per table

    // Default constructor (required by Hibernate)
    public Conversation() {
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}