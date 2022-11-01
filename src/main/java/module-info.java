module com.naheulback.ledonjondenaheulback {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.naheulback.ledonjondenaheulback to javafx.fxml;
    exports com.naheulback.ledonjondenaheulback;
}