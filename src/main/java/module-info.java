module com.naheulback.ledonjondenaheulback {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;

    opens com.naheulback.ledonjondenaheulback to javafx.fxml;
    exports com.naheulback.ledonjondenaheulback;
    exports com.naheulback.ledonjondenaheulback.controllers;
    opens com.naheulback.ledonjondenaheulback.controllers to javafx.fxml;
    exports com.naheulback.ledonjondenaheulback.classes;
    opens com.naheulback.ledonjondenaheulback.classes to javafx.fxml;
}