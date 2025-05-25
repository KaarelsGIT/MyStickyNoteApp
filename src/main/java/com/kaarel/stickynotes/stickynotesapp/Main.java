package com.kaarel.stickynotes.stickynotesapp;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        StickyNote note = new StickyNote();
        note.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
