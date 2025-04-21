module org.example.letcontact {
    requires javafx.controls;
    requires javafx.fxml;
    exports application;
    opens application to javafx.fxml;
    exports application.controller;
    opens application.controller to javafx.fxml;
}