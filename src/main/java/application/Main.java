package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/Login.fxml"));
        Parent root = loader.load();
        Scene scene=new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("/application/css/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
