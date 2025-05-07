module com.example.him {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.him to javafx.fxml;
    exports com.example.him;
}