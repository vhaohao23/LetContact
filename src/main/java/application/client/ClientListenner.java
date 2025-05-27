package application.client;

import application.ChatInterface.Chat_Body;
import application.ChatInterface.event.EventChat;
import application.ChatInterface.event.PublicEvent;
import application.ChatInterface.form.Chat;
import application.Main;
import application.controller.CallNotificationController;
import application.controller.CallVideoController;
import application.controller.LoginController;
import application.dto.*;
import application.model.Message;
import application.model.User;
import application.session_management.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

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
                ip = Inet6Address.getByName("2600:1f18:2403:789b:c81b:4dd7:1d9e:f22");
//                ip = Inet6Address.getByName("localhost");
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
        } else if (baseResponse.getType() == MessageType.MESSAGE) {
            MessageDTO messageDTO = (MessageDTO) baseResponse;
            byte[] contentBytes = messageDTO.getMessage().getContent();
            String contentString = new String(contentBytes, StandardCharsets.UTF_8);
            System.out.println("\n=== Message Received in ClientListener ===");
            System.out.println("Raw message content: " + contentString);
            System.out.println("Message sender: " + messageDTO.getMessage().getParticipant().getUser().getUserName());
            
            try {
                // Get chat instance directly
                Chat chat = ChatSession.getInstance().getChat();
                if (chat == null) {
                    System.out.println("ERROR: Chat instance is null");
                    return;
                }
                System.out.println("Found Chat instance");
                System.out.println("Current chat windows: " + chat.chatBodyMap.keySet().stream()
                    .map(User::getUserName)
                    .toList());

                // Process message directly using Swing's event dispatch thread
                System.out.println("Scheduling message processing...");
                try {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                System.out.println("Starting message processing in EDT");
                                Message message = messageDTO.getMessage();
                                User sender = message.getParticipant().getUser();
                                System.out.println("Processing message from: " + sender.getUserName());
                                
                                // Get or create chat window for sender
                                Chat_Body chatBody = chat.chatBodyMap.get(sender);
                                if (chatBody == null) {
                                    System.out.println("Creating new chat window for: " + sender.getUserName());
                                    try {
                                        chatBody = new Chat_Body();
                                        chat.chatBodyMap.put(sender, chatBody);
                                        System.out.println("Successfully created new chat window");
                                    } catch (Exception e) {
                                        System.out.println("Error creating chat window: " + e.getMessage());
                                        e.printStackTrace();
                                        return;
                                    }
                                } else {
                                    System.out.println("Using existing chat window for: " + sender.getUserName());
                                }
                                
                                // Add message to chat window
                                if (chatBody != null) {
                                    System.out.println("Adding message to chat window");
                                    try {
                                        chatBody.addItemLeft(message);
                                        System.out.println("Message added successfully");
                                        // Force UI update
                                        chatBody.revalidate();
                                        chatBody.repaint();
                                        // Also update the parent container
                                        chat.revalidate();
                                        chat.repaint();
                                        
                                        // Automatically select the chat window
                                        System.out.println("Selecting chat window for: " + sender.getUserName());
                                        PublicEvent.getInstance().getEventMenuLeft().selectUser(sender);
                                        PublicEvent.getInstance().getEventMenuRight().selectUser(sender);
                                    } catch (Exception e) {
                                        System.out.println("Error adding message to chat window: " + e.getMessage());
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("ERROR: Chat body is null for sender: " + sender.getUserName());
                                }
                            } catch (Exception e) {
                                System.out.println("Error in message processing: " + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    });
                    System.out.println("Message processing scheduled successfully");
                } catch (Exception e) {
                    System.out.println("Error scheduling SwingUtilities.invokeLater: " + e.getMessage());
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("Error in message handling: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println("=== End Message Processing in ClientListener ===\n");
        }
    }

    public void loginHandler(LoginSuccessResponse loginSuccessResponse){
        SessionManagement.getInstance().setLoginSession(loginSuccessResponse.getLoginSession());

        javafx.application.Platform.runLater(() -> {
            try {
                Scene scene = MainApplicationSession.getInstance().scene;
                LoginController controller = (LoginController) scene.getRoot().getUserData();
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
