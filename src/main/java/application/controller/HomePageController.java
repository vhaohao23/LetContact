package application.controller;

import application.Main;
import application.dao.UserDAO;
import application.model.User;
import application.session_management.UserSession;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HomePageController {
    @FXML
    private ImageView yourAvatarImageView;

    @FXML
    private Label yourUsername;

    @FXML
    private StackPane yourAvatarContainer;

    byte[] imageData;

    Image image;

    @FXML
    private ListView<String> FriendList;

    public void initialize() throws IOException, URISyntaxException {

        imageData= UserSession.getInstance().getUser().getAvatar();
        image=ImageUtil.getImage(imageData);
        AvatarDisplayUtil.avatarDisplay(yourAvatarImageView, yourAvatarContainer,image);
        yourUsername.setText(UserSession.getInstance().getUser().getUserName());

        UserDAO userDAO=new UserDAO();
        List<User> friendList= userDAO.selectFriend(UserSession.getInstance().getUser());

        for (User friend : friendList) {
            FriendList.getItems().add(friend.getUserName());
        }
        FriendList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("Selected item: " + FriendList.getSelectionModel().getSelectedItem());
            }
        });

    }
}
