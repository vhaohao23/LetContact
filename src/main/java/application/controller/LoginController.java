// Java
package application.controller;

import application.ChatInterface.ChatMain;
import application.dao.UserDAO;
import application.dto.BaseMessage;
import application.dto.LoginRequest;
import application.dto.LoginSuccessResponse;
import application.dto.MessageType;
import application.model.LoginSession;
import application.model.User;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import application.util.BcrypyUtil;
import application.util.SwitchSceneUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private MouseEvent lastEvent;

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
        UserDAO userDAO = new UserDAO();
        User exampleUser = userDAO.selectByUsername(tfUsername.getText());

        if (exampleUser != null && tfUsername.getText().equals(exampleUser.getUserName())) {
            if (BcrypyUtil.verifyPassword(tfPassword.getText(), exampleUser.getPassword())) {
                lastEvent = e;
                LoginRequest loginRequest = new LoginRequest(MessageType.LOGIN, exampleUser, "attempt to login");
                TCPSocketSession session = TCPSocketSession.getInstance();
                if (session.out != null) {
                    session.out.writeObject(loginRequest);
                    session.out.flush();
                    System.out.println("flush success");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Connection Error");
                    alert.setHeaderText("Cannot send login request");
                    alert.setContentText("The connection to the server is not established. Please try again later.");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText("Incorrect Password");
                alert.setContentText("The password you entered is incorrect. Please try again.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("User Not Found");
            alert.setContentText("The username does not exist. Please check and try again.");
            alert.showAndWait();
        }
    }

    public void onLoginSuccess() {
        Platform.runLater(() -> {
            if (lastEvent != null) {
                User user = SessionManagement.getInstance().getLoginSession() != null ?
                        SessionManagement.getInstance().getLoginSession().getUser() :
                        new UserDAO().selectByUsername(tfUsername.getText());
                LoginSession loginSession = new LoginSession();
                loginSession.setSessionID(java.util.UUID.randomUUID().toString());
                loginSession.setUser(user);
                loginSession.setIpAddress("localhost");
                loginSession.setPort(5000);
                SessionManagement.getInstance().setLoginSession(loginSession);

                // Close stage JavaFX
                Stage currentStage = (Stage) btnLogin.getScene().getWindow();
                currentStage.close();

                // Open ChatMain
                java.awt.EventQueue.invokeLater(() -> {
                    ChatMain chatMain = new ChatMain();
                    chatMain.setVisible(true);
                });
            }
        });
    }
}