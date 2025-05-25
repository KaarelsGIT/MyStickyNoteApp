module com.kaarel.stickynotes.stickynotesapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kaarel.stickynotes.stickynotesapp to javafx.fxml;
    exports com.kaarel.stickynotes.stickynotesapp;
}