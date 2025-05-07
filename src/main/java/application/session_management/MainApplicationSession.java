package application.session_management;

import application.model.LoginSession;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplicationSession {
    private static MainApplicationSession instance;

    public static Stage stage;
    public static Scene scene;

    private MainApplicationSession() {
    }

    public static MainApplicationSession getInstance() {
        if (instance == null) {
            instance = new MainApplicationSession();
        }
        return instance;
    }
}
