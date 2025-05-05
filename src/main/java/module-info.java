module com.example.him {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.him to javafx.fxml;
    exports com.example.him;
}