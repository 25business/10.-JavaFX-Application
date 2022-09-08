package com.example;

import com.example.events.ButtonHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FXApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String default_styles = """
                -fx-font-family: "Arial";
                -fx-font-size: 18px;
                """;
        String button_style = """
                -fx-padding: 6px;
                -fx-background-color: #1c53a6;
                -fx-text-fill: white;
                """;

        stage.setTitle("JavaFX Application");
        stage.setWidth(600);
        stage.setHeight(400);

        Label label_x = new Label("x:");
        label_x.setStyle(default_styles);
        TextField txt_x = new TextField();
        txt_x.setStyle(default_styles);
        HBox hbox_x = new HBox(label_x, txt_x);
        hbox_x.setSpacing(5);
        Label label_y = new Label("y:");
        label_y.setStyle(default_styles);
        TextField txt_y = new TextField();
        txt_y.setStyle(default_styles);
        HBox hbox_y = new HBox(label_y, txt_y);
        hbox_y.setSpacing(5);

        Button btn_plus = new Button("+");
        btn_plus.setStyle(default_styles + button_style);
        btn_plus.setPrefWidth(50);
        Button btn_minus = new Button("-");
        btn_minus.setPrefWidth(50);
        btn_minus.setStyle(default_styles + button_style);
        Button btn_multiply = new Button("*");
        btn_multiply.setPrefWidth(50);
        btn_multiply.setStyle(default_styles + button_style);
        Button btn_divide = new Button("/");
        btn_divide.setPrefWidth(50);
        btn_divide.setStyle(default_styles + button_style);
        HBox hbox_buttons = new HBox(btn_plus, btn_minus,
                btn_multiply, btn_divide);
        hbox_buttons.setSpacing(10);
        Label label_result = new Label("Result: -");
        label_result.setStyle(default_styles);

        btn_plus.setOnAction(new ButtonHandler("+", txt_x, txt_y, label_result));
        btn_minus.setOnAction(new ButtonHandler("-", txt_x, txt_y, label_result));
        btn_multiply.setOnAction(new ButtonHandler("*", txt_x, txt_y, label_result));
        btn_divide.setOnAction(new ButtonHandler("/", txt_x, txt_y, label_result));

        VBox main_layout = new VBox();
        main_layout.setStyle("-fx-padding: 15px;");
        main_layout.setSpacing(8);
        main_layout.getChildren().addAll(hbox_x, hbox_y,
                hbox_buttons, label_result);
        Scene scene = new Scene(main_layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        FXApplication.launch(args);
    }
}
