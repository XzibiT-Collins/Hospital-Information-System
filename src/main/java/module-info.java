module com.example.him {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    exports com.example.him.controllers to javafx.fxml;
    opens com.example.him to javafx.fxml;
    opens com.example.him.controllers to javafx.fxml;
    exports com.example.him;
}