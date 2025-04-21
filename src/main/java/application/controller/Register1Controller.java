package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    private Button btnLogin;

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

            eye.setImage(new Image(getClass().getResource("/img/eye.png").toExternalForm()));
            isHide = false;
            tfPassword.requestFocus();
            tfPassword.positionCaret(tfPassword.getText().length());
        } else {
            pfPassword.setManaged(true);
            pfPassword.setVisible(true);
            tfPassword.setManaged(false);
            tfPassword.setVisible(false);

            eye.setImage(new Image(getClass().getResource("/img/hideEye.png").toExternalForm()));
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

            confirmEye.setImage(new Image(getClass().getResource("/img/eye.png").toExternalForm()));
            isConfirmHide = false;
            tfConfirm.requestFocus();
            tfConfirm.positionCaret(tfConfirm.getText().length());
        } else {
            pfConfirm.setManaged(true);
            pfConfirm.setVisible(true);
            tfConfirm.setManaged(false);
            tfConfirm.setVisible(false);

            confirmEye.setImage(new Image(getClass().getResource("/img/hideEye.png").toExternalForm()));
            isConfirmHide = true;
            pfConfirm.requestFocus();
            pfConfirm.positionCaret(tfConfirm.getText().length());
        }
    }
}
