package application.controller;

import application.Main;
import application.dao.UserDAO;
import application.model.User;
import application.session_management.SessionManagement;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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
    private VBox friendList;

    public void initialize() throws IOException, URISyntaxException {

        imageData= SessionManagement.getInstance().getLoginSession().getUser().getAvatar();
        image=ImageUtil.getImage(imageData);
        AvatarDisplayUtil.avatarDisplay(yourAvatarImageView, yourAvatarContainer,image);
        yourUsername.setText(SessionManagement.getInstance().getLoginSession().getUser().getUserName());

        UserDAO userDAO=new UserDAO();
        List<User> friends= userDAO.selectFriend(SessionManagement.getInstance().getLoginSession().getUser());

        for (User friend : friends) {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/FriendListCell.fxml"));
            Parent root = loader.load();

            FriendListCellController controller = loader.getController();
            controller.setFriend(friend);

            friendList.getChildren().add(root);
        }
    }
}
