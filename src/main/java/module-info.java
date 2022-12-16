module com.naheulback.ledonjondenaheulback {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.naheulback.nhlbck to javafx.fxml;
    exports com.naheulback.nhlbck.controllers;
    opens com.naheulback.nhlbck.controllers to javafx.fxml;
    exports com.naheulback.nhlbck.classes;
    opens com.naheulback.nhlbck.classes to javafx.fxml;
    exports com.naheulback.nhlbck;
}