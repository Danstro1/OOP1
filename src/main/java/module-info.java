module com.example.oop1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.oop1 to javafx.fxml;
    exports com.example.oop1;
}