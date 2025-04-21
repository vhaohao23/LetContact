package application.controller;

import application.util.SwitchSceneUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Register2Controller {
    @FXML
    private Button btnNext2;

    @FXML
    private Label lblLogin;

    public void gotoLogin(MouseEvent e) throws IOException {
        SwitchSceneUtil.switchScene("view/Login.fxml", e);
    }

    public void gotoRegister3(MouseEvent e) throws IOException {
        SwitchSceneUtil.switchScene("view/Register3.fxml", e);
    }
}
