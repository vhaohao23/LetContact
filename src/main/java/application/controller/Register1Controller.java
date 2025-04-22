package application.controller;

import application.session_management.UserSession;
import application.util.SwitchSceneUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Register1Controller {
    @FXML
    private ImageView eye;
    boolean isHide = true;
    @FXML
    private ImageView confirmEye;
    boolean isConfirmHide = true;

    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfPassword;

    @FXML
    private PasswordField pfConfirm;
    @FXML
    private TextField tfConfirm;

    @FXML
    private Button btnNext1;

    @FXML
    private Label lblLogin;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfUsername;

    public void initialize() {
        // By default, show the PasswordField and hide the TextField.
        pfPassword.setManaged(true);
        pfPassword.setVisible(true);
        tfPassword.setManaged(false);
        tfPassword.setVisible(false);

        pfConfirm.setManaged(true);
        pfConfirm.setVisible(true);
        tfConfirm.setManaged(false);
        tfConfirm.setVisible(false);

        // Bind the text properties together.
        tfPassword.textProperty().bindBidirectional(pfPassword.textProperty());
        tfConfirm.textProperty().bindBidirectional(pfConfirm.textProperty());
    }

    public void HideShowPassword(MouseEvent e) {
        if (isHide) {
            tfPassword.setManaged(true);
            tfPassword.setVisible(true);
            pfPassword.setManaged(false);
            pfPassword.setVisible(false);

            eye.setImage(new Image(getClass().getResource("/application/img/eye.png").toExternalForm()));
            isHide = false;
            tfPassword.requestFocus();
            tfPassword.positionCaret(tfPassword.getText().length());
        } else {
            pfPassword.setManaged(true);
            pfPassword.setVisible(true);
            tfPassword.setManaged(false);
            tfPassword.setVisible(false);

            eye.setImage(new Image(getClass().getResource("/application/img/hideEye.png").toExternalForm()));
            isHide = true;
            pfPassword.requestFocus();
            pfPassword.positionCaret(pfPassword.getText().length());
        }
    }

    public void HideShowConfirm(MouseEvent e) {
        if (isConfirmHide) {
            tfConfirm.setManaged(true);
            tfConfirm.setVisible(true);
            pfConfirm.setManaged(false);
            pfConfirm.setVisible(false);

            confirmEye.setImage(new Image(getClass().getResource("/application/img/eye.png").toExternalForm()));
            isConfirmHide = false;
            tfConfirm.requestFocus();
            tfConfirm.positionCaret(tfConfirm.getText().length());
        } else {
            pfConfirm.setManaged(true);
            pfConfirm.setVisible(true);
            tfConfirm.setManaged(false);
            tfConfirm.setVisible(false);

            confirmEye.setImage(new Image(getClass().getResource("/application/img/hideEye.png").toExternalForm()));
            isConfirmHide = true;
            pfConfirm.requestFocus();
            pfConfirm.positionCaret(tfConfirm.getText().length());
        }
    }

    public void gotoLogin(MouseEvent e) throws IOException {
        SwitchSceneUtil.switchScene("view/Login.fxml", e);
    }

    public void gotoRegister2(MouseEvent e) throws IOException {
        if (pfConfirm.getText().equals(pfPassword.getText())==false) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Confirmation Error");
            alert.setHeaderText("Password and Confirm Password do not match");
            alert.setContentText("Please check your password and confirm password");
            alert.showAndWait();
            return;
        }

        UserSession.getInstance().getUser().setEmail(tfEmail.getText());
        UserSession.getInstance().getUser().setUserName(tfUsername.getText());
        UserSession.getInstance().getUser().setPassword(pfPassword.getText());

        SwitchSceneUtil.switchScene("view/Register2.fxml", e);
    }
}
