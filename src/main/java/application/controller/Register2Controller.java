package application.controller;

import application.session_management.SessionManagement;
import application.session_management.UserSession;
import application.util.SwitchSceneUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Date;

public class Register2Controller {
    @FXML
    private Button btnNext2;

    @FXML
    private Label lblLogin;

    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private DatePicker dpDoB;
    @FXML
    private TextField tfGender;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfAddress;


    public void gotoLogin(MouseEvent e) throws IOException {
        SwitchSceneUtil.switchScene("view/Login.fxml", e);
    }

    public void gotoRegister3(MouseEvent e) throws IOException {
        UserSession.getInstance().getUser().setFirstName(tfFirstName.getText());
        UserSession.getInstance().getUser().setLastName(tfLastName.getText());
        UserSession.getInstance().getUser().setDob(Date.valueOf(dpDoB.getValue().toString()));
        UserSession.getInstance().getUser().setGender(tfGender.getText());
        UserSession.getInstance().getUser().setPhone(tfPhone.getText());
        UserSession.getInstance().getUser().setAddress(tfAddress.getText());
        SwitchSceneUtil.switchScene("view/Register3.fxml", e);
    }
}
