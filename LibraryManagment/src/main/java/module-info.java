module Library.Managment {
    requires javafx.controls;
    requires javafx.fxml;

    opens library to javafx.fxml;
    exports library;

    opens dto to javafx.fxml;
    exports dto;

}