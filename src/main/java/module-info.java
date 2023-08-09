module com.example.sw_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;


    opens com.example.sw_final to javafx.fxml;
    exports com.example.sw_final;
}