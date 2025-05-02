package application.controller;

import application.dto.CallRequest;
import application.dto.MessageType;
import application.model.User;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

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
