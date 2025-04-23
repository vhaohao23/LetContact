module org.example.letcontact {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires jbcrypt;
    requires java.desktop;
    requires jdk.jdi;
    requires TimingFramework;
    requires miglayout;
    requires swingx.all;
    exports application;
    opens application to javafx.fxml;
    exports application.controller;
    opens application.controller to javafx.fxml;
    opens  application.model to org.hibernate.orm.core;
}