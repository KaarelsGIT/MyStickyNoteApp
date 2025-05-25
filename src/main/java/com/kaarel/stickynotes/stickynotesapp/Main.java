package com.kaarel.stickynotes.stickynotesapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Tere, Sticky Note!");
        Scene scene = new Scene(label, 300, 200);
        stage.setTitle("StickyNote");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
