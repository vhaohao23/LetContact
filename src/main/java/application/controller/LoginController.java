// Java
package application.controller;

import application.dao.UserDAO;
import application.dto.BaseUserRequest;
import application.dto.UserSessionResponse;
import application.model.LoginSession;
import application.model.User;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import application.util.BcrypyUtil;
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
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class LoginController {
    @FXML
    private ImageView eye;
    boolean isHide = true;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblRegister;

    @FXML
    private TextField tfUsername;

    public void initialize() {
        // By default, show the PasswordField and hide the TextField.
        pfPassword.setManaged(true);
        pfPassword.setVisible(true);
        tfPassword.setManaged(false);
        tfPassword.setVisible(false);

        // Bind the text properties together.
        tfPassword.textProperty().bindBidirectional(pfPassword.textProperty());
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

    public void gotoRegister(MouseEvent e) throws IOException {
        SwitchSceneUtil.switchScene("view/Register1.fxml", e);
    }

    public void letLogin(MouseEvent e) throws IOException {
        UserDAO userDAO=new UserDAO();

        User exampleUser = userDAO.selectByUsername(tfUsername.getText());

        if (exampleUser != null) {
            if (tfUsername.getText().equals(exampleUser.getUserName())){
                if (BcrypyUtil.verifyPassword(tfPassword.getText(),exampleUser.getPassword())==true) {
                    BaseUserRequest loginRequest = new BaseUserRequest("login",exampleUser,"attempt to login");
                    TCPSocketSession.getInstance().out.writeObject(loginRequest);
                    TCPSocketSession.getInstance().out.flush();

                    try {
                        UserSessionResponse userSessionResponse = (UserSessionResponse) TCPSocketSession.getInstance().in.readObject();
                        SessionManagement.getInstance().setLoginSession(userSessionResponse.getLoginSession());
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                    SwitchSceneUtil.switchScene("view/HomePage.fxml", e);

                }
            }
        }
    }
}