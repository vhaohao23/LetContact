package application;

import application.client.ClientListenner;
import application.client.ClientSender;
import application.session_management.TCPSocketSession;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try{
            TCPSocketSession.getInstance().socket=new Socket("127.0.0.1", 5000);

            ClientListenner clientListenner = new ClientListenner();
            new Thread(clientListenner).start();

            ClientSender clientSender=new ClientSender();
            new Thread(clientSender).start();

            System.out.println("Connected to server");
        } catch (Exception e) {
            e.printStackTrace();
        }

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/Login.fxml"));
        Parent root = loader.load();
        Scene scene=new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("/application/css/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
