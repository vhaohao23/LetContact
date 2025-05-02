package application.client;

import application.Main;
import application.controller.LoginController;
import application.dto.BaseMessage;
import application.dto.CallRequest;
import application.dto.LoginSuccessResponse;
import application.dto.MessageType;
import application.session_management.MainApplicationSession;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientListenner implements Runnable{
    @Override
    public void run() {
        try {
            TCPSocketSession.getInstance().in=new ObjectInputStream(TCPSocketSession.getInstance().socket.getInputStream());
            while (true){
                Object message = TCPSocketSession.getInstance().in.readObject();

                if (message instanceof BaseMessage) {
                    handleBaseMessage((BaseMessage) message);
                } else {
                    System.out.println("Unknown message type: " + message.getClass());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void handleBaseMessage(BaseMessage baseResponse){
        if (baseResponse.getType() == MessageType.LOGIN_SUCCESS) {
            LoginSuccessResponse loginSuccessResponse = (LoginSuccessResponse) baseResponse;
            System.out.println("Login successful: " + loginSuccessResponse.getLoginSession());
            loginHandler(loginSuccessResponse);
        }else if (baseResponse.getType() == MessageType.CALL_REQUEST){
            CallRequest callRequest=(CallRequest)baseResponse;
            handleCallRequest(callRequest);
        }
    }

    public void loginHandler(LoginSuccessResponse loginSuccessResponse){
        SessionManagement.getInstance().setLoginSession(loginSuccessResponse.getLoginSession());

        javafx.application.Platform.runLater(() -> {
            try {
                Scene scene = MainApplicationSession.getInstance().scene;
                LoginController controller = (LoginController) scene.lookup("#loginController").getUserData();
                if (controller != null) {
                    controller.onLoginSuccess();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void handleCallRequest(CallRequest callRequest){
        System.out.println("Call request received from: " + callRequest.getCaller().getUserName());



    }
}
