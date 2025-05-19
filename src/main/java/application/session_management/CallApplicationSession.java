package application.session_management;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CallApplicationSession {
    private static CallApplicationSession instance;

    public static Stage stage;
    public static Scene scene;

    private CallApplicationSession() {
    }

    public static CallApplicationSession getInstance() {
        if (instance == null) {
            instance = new CallApplicationSession();
        }
        return instance;
    }
}
