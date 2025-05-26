module com.kaarel.stickynotes.stickynotesapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.fxmisc.richtext;


    opens com.kaarel.stickynotes.stickynotesapp to javafx.fxml;
    exports com.kaarel.stickynotes.stickynotesapp;
}