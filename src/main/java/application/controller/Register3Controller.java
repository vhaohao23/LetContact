package application.controller;

import application.Main;
import application.dao.UserDAO;
import application.session_management.UserSession;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Register3Controller {
    @FXML
    private ImageView avatarImageView;

    @FXML
    private StackPane imageContainer;

    private static Stage stage;

    byte[] imageData;

    Image image;

    public void initialize() throws IOException, URISyntaxException {
        imageData=ImageUtil.getImageData(new File(Main.class.getResource("/application/img/DefaultAvatar.png").toURI()));
        image=ImageUtil.getImage(imageData);
        AvatarDisplayUtil.avatarDisplay(avatarImageView, imageContainer,image);
    }

    public void setAvatarImage(MouseEvent e) throws IOException {
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG file","*.jpg"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG file","*.PNG"));


        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        File file =fc.showOpenDialog(stage);

        imageData =ImageUtil.getImageData(file);
        image=ImageUtil.getImage(imageData);

        AvatarDisplayUtil.avatarDisplay(avatarImageView, imageContainer,image);
    }

    public void letRegister(MouseEvent e) throws IOException {
        UserSession.getInstance().getUser().setAvatar(imageData);
        UserDAO userDAO=new UserDAO();
        userDAO.insert(UserSession.getInstance().getUser());
    }
}
