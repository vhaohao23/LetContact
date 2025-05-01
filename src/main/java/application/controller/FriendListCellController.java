package application.controller;

import application.model.User;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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
}
