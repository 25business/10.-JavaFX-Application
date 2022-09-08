package com.example.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ButtonHandler implements EventHandler<ActionEvent> {
    private TextField txt_x;
    private TextField txt_y;
    private Label label_result;
    private String operation;

    public ButtonHandler(String operation, TextField txt_x,
                         TextField txt_y, Label label_result) {
        this.operation = operation;
        this.txt_x = txt_x;
        this.txt_y = txt_y;
        this.label_result = label_result;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        double x = Double.parseDouble(this.txt_x.getText());
        double y = Double.parseDouble(this.txt_y.getText());
        this.label_result.setText(
                "Result: " + switch (this.operation) {
                    case "+" -> String.valueOf(x + y);
                    case "-" -> String.valueOf(x - y);
                    case "*" -> String.valueOf(x * y);
                    case "/" -> String.valueOf(x / y);
                    default -> "";
                }
        );
    }
}
