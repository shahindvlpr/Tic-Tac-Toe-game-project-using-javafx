module com.example.practice4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.practice4 to javafx.fxml;
    exports com.example.practice4;
}