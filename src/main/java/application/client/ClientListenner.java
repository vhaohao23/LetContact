package application.client;

import application.Main;
import application.controller.CallNotificationController;
import application.controller.CallVideoController;
import application.controller.LoginController;
import application.dto.*;
import application.session_management.MainApplicationSession;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import application.session_management.UDPSocketSession;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

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
        }else if (baseResponse.getType()==MessageType.START_CALL){
            System.out.println("Start call");
            handleCallVideo((OtherInfomationCallVideo)baseResponse);
        }else if (baseResponse.getType()==MessageType.INFO_REQUEST){
            InetAddress ip= null;
            int port=0;
            try {
                ip = Inet6Address.getByName("localhost");
//                ip = InetAddress.getByName("34.201.147.74");

                port=9876;
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            for (int i=1;i<=20;i++){
                    DatagramPacket packet=new DatagramPacket(new byte[100],100,ip,port);
                try {
                    UDPSocketSession.getInstance().socket.send(packet);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
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
        Platform.runLater(()-> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/CallNotification.fxml"));
            Parent root = null;
            try {
                root = loader.load();

                CallNotificationController callNotificationController=loader.getController();
                callNotificationController.init(callRequest.getCaller(),callRequest.getCallee());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene=new Scene(root);
            scene.getStylesheets().add(Main.class.getResource("/application/css/style.css").toExternalForm());
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.setTitle("Call notification");
            stage.show();
        });
    }
    public void handleCallVideo(OtherInfomationCallVideo otherInfomationCallVideo){
        System.out.println("You are in a call with: "+otherInfomationCallVideo.getLoginSession().getUser().getUserName()+
                " and his ip is: "+otherInfomationCallVideo.getLoginSession().getUdpIpAddress()+" port:"+otherInfomationCallVideo.getLoginSession().getUdpPort());
//        System.out.println("your ip"+TCPSocketSession.getInstance().socket.getLocalAddress().getHostAddress()+" port:"+TCPSocketSession.getInstance().socket.getLocalPort());;
        Platform.runLater(()-> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/CallVideo.fxml"));
            Parent root = null;
            try {
                root = loader.load();

                CallVideoController CallVideoController=loader.getController();
                CallVideoController.init(otherInfomationCallVideo);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene=new Scene(root);
            scene.getStylesheets().add(Main.class.getResource("/application/css/style.css").toExternalForm());
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.setTitle("Call Video");
            stage.show();
        });
    }
}
