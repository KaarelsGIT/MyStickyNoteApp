package com.kaarel.stickynotes.stickynotesapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StickyNote {
    private final Stage stage;
    private final TextArea textArea;
    private final ComboBox<Integer> fontSizeSelector;
    private final ToggleButton boldToggle;

    public StickyNote() {
        stage = new Stage();
        stage.setTitle("Märkmik");
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.DECORATED);

        textArea = new TextArea("Kirjuta siia...");
        textArea.setWrapText(true);
        textArea.setFont(Font.font(14));

        fontSizeSelector = new ComboBox<>();
        fontSizeSelector.getItems().addAll(12, 14, 16, 18, 20, 24);
        fontSizeSelector.setValue(14);
        fontSizeSelector.setOnAction(e ->
                textArea.setFont(Font.font(fontSizeSelector.getValue()))
        );

        boldToggle = new ToggleButton("Bold");
        boldToggle.setOnAction(e -> {
            boolean isBold = boldToggle.isSelected();
            Font currentFont = textArea.getFont();
            textArea.setStyle(isBold ? "-fx-font-weight: bold;" : "-fx-font-weight: normal;");
            textArea.setFont(Font.font(currentFont.getFamily(), currentFont.getSize()));
        });

        HBox toolbar = new HBox(10, new Label("Suurus:"), fontSizeSelector, boldToggle);
        toolbar.setPadding(new Insets(5));
        toolbar.setStyle("-fx-background-color: #f2f2f2;");

        VBox layout = new VBox(toolbar, textArea);
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
