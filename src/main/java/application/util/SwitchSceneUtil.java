package application.util;

import application.Main;
import application.session_management.MainApplicationSession;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchSceneUtil {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public static void switchScene(String pathScene, MouseEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(pathScene));
        root=loader.load();
        root.setUserData(loader.getController());
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("/application/css/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        MainApplicationSession.getInstance().scene=scene;
    }
}
