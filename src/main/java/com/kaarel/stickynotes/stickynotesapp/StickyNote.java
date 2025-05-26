package com.kaarel.stickynotes.stickynotesapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.fxmisc.richtext.InlineCssTextArea;

public class StickyNote {

    private final Stage stage;
    private final InlineCssTextArea richTextArea;
    private final ComboBox<Integer> fontSizeSelector;
    private final ToggleButton boldToggle;

    public StickyNote() {
        stage = new Stage();
        stage.setTitle("Märkmik");
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.DECORATED);

        // RichTextFX editor
        richTextArea = new InlineCssTextArea();
        richTextArea.setWrapText(true);
        richTextArea.replaceText("Kirjuta siia...");

        // Font size selector
        fontSizeSelector = new ComboBox<>();
        fontSizeSelector.getItems().addAll(12, 14, 16, 18, 20, 24);
        fontSizeSelector.setValue(14);
        fontSizeSelector.setOnAction(e -> applyStyle());

        // Bold toggle
        boldToggle = new ToggleButton("Bold");
        boldToggle.setOnAction(e -> applyStyle());

        // Toolbar
        HBox toolbar = new HBox(10, new Label("Suurus:"), fontSizeSelector, boldToggle);
        toolbar.setPadding(new Insets(5));
        toolbar.setStyle("-fx-background-color: #f2f2f2;");

        VBox layout = new VBox(toolbar, richTextArea);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
    }

    private void applyStyle() {
        int start = richTextArea.getSelection().getStart();
        int end = richTextArea.getSelection().getEnd();

        if (start == end) return; // Ära tee midagi kui pole valikut

        int fontSize = fontSizeSelector.getValue();
        boolean isBold = boldToggle.isSelected();

        String style = "-fx-font-size: " + fontSize + "px;";
        if (isBold) {
            style += " -fx-font-weight: bold;";
        } else {
            style += " -fx-font-weight: normal;";
        }

        richTextArea.setStyle(start, end, style);
    }

    public void show() {
        stage.show();
    }
}