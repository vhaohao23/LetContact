package application.controller;

import application.Main;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Register3Controller {
    @FXML
    private ImageView avatarImageView;

    @FXML
    private StackPane imageContainer;

    private static Stage stage;

    public void initialize(){
        AvatarDisplayUtil.avatarDisplay(avatarImageView, imageContainer,new Image(Main.class.getResource("/application/img/DefaultAvatar.png").toExternalForm()));
    }

    public void setAvatarImage(MouseEvent e) throws IOException {
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG file","*.jpg"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG file","*.PNG"));


        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        File file =fc.showOpenDialog(stage);

        byte[] imageData =ImageUtil.getImageData(file);

        Image image=ImageUtil.getImage(imageData);

        AvatarDisplayUtil.avatarDisplay(avatarImageView, imageContainer,image);
    }
}
