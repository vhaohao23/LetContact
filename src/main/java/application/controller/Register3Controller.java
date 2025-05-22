package application.controller;

import application.ChatInterface.ChatMain;
import application.Main;
import application.dao.UserDAO;
import application.session_management.SessionManagement;
import application.session_management.UserSession;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import application.util.SwitchSceneUtil;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
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
        System.out.println(imageData);
    }

    public void letRegister(MouseEvent e) throws IOException {
        UserSession.getInstance().getUser().setAvatar(imageData);
        UserDAO userDAO=new UserDAO();
        userDAO.insert(UserSession.getInstance().getUser());

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration Successful");
        alert.setHeaderText("Registration Successful");
        alert.setContentText("You have successfully registered. You can now login.");
        alert.showAndWait();

        // Close the current JavaFX stage
//        Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        currentStage.close();

        // Start the ChatMain interface
//        java.awt.EventQueue.invokeLater(() -> {
//            ChatMain chatMain = new ChatMain();
//            chatMain.setVisible(true);
//        });
        SwitchSceneUtil.switchScene("view/Login.fxml",e);
    }
}
