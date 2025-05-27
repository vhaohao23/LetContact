package application.controller;

import application.Main;
import application.dto.CallRequest;
import application.dto.MessageType;
import application.model.User;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class FriendListCellController {
    @FXML
    private ImageView friendAvatar;

    @FXML
    private StackPane friendAvatarContainer;

    @FXML
    private Label friendUserName;

    @FXML
    private ImageView callIcon;

    private User friend;

    public void setFriend(User friend) {
        this.friend = friend;
        friendUserName.setText(friend.getUserName());

        Image image= ImageUtil.getImage(friend.getAvatar());
        AvatarDisplayUtil.avatarDisplay(friendAvatar, friendAvatarContainer, image);

        Image originalImage = new Image(Main.class.getResource("img/call.png").toExternalForm());
        Image hoverImage = new Image(Main.class.getResource("img/callHover.png").toExternalForm());
        Image activeImage = new Image(Main.class.getResource("img/callPress.png").toExternalForm());
        callIcon.setOnMouseEntered(e -> callIcon.setImage(hoverImage));
        callIcon.setOnMouseExited(e -> callIcon.setImage(originalImage));
        callIcon.setOnMouseClicked(e -> {
            letCall(e);
            callIcon.setImage(activeImage);
            // Wait 100 milliseconds before reverting back to the original image
            PauseTransition pause = new PauseTransition(Duration.millis(50));
            pause.setOnFinished(event -> callIcon.setImage(hoverImage));
            pause.play();
        });
    }

    public void letCall(MouseEvent e){
        CallRequest callRequest=new CallRequest(MessageType.CALL_REQUEST, SessionManagement.getInstance().getLoginSession().getUser(), friend);

        try {
            TCPSocketSession.getInstance().out.writeObject(callRequest);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
