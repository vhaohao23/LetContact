package application.controller;

import application.Main;
import application.model.User;
import application.session_management.UserSession;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class HomePageController {
    @FXML
    private ImageView yourAvatarImageView;

    @FXML
    private Label yourUsername;

    @FXML
    private StackPane yourAvatarContainer;

    byte[] imageData;

    Image image;

    public void initialize() throws IOException, URISyntaxException {

        imageData= UserSession.getInstance().getUser().getAvatar();
        image=ImageUtil.getImage(imageData);
        AvatarDisplayUtil.avatarDisplay(yourAvatarImageView, yourAvatarContainer,image);
        yourUsername.setText(UserSession.getInstance().getUser().getUserName());
    }
}
