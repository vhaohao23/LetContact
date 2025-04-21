package application.controller;

import application.util.AvatarDisplayUtil;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Register3Controller {
    @FXML
    private ImageView avatarImageView;

    @FXML
    private AnchorPane imageContainer;

    public void initialize(){
        AvatarDisplayUtil.avatarDisplay(avatarImageView, imageContainer);
    }
}
