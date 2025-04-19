module org.example.letcontact {
    requires javafx.controls;
    requires javafx.fxml;
    exports application;
    opens application to javafx.fxml;
}