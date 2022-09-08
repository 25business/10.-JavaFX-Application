package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class FXApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("JavaFX Application");
        stage.setWidth(600);
        stage.setHeight(400);

        ToggleGroup theme_buttons = new ToggleGroup();
        ToggleButton button_light = new ToggleButton();
        button_light.setPrefWidth(30);
        button_light.getStyleClass().addAll("toggle", "enabled");
        button_light.setSelected(true);
        button_light.setDisable(true);
        ToggleButton button_dark = new ToggleButton();
        button_dark.getStyleClass().addAll("toggle", "disabled");
        button_dark.setPrefWidth(30);
        button_light.setToggleGroup(theme_buttons);
        button_dark.setToggleGroup(theme_buttons);
        button_dark.setOnAction( actionEvent -> {
            button_dark.setDisable(true);
            button_light.setDisable(false);
        });
        button_light.setOnAction( actionEvent -> {
            button_light.setDisable(true);
            button_dark.setDisable(false);
        });

        HBox hbox_theme_buttons = new HBox(button_light, button_dark);
        hbox_theme_buttons.getStylesheets().add("fx1_style.css");
        VBox main_layout = new VBox();
        main_layout.getChildren().add(hbox_theme_buttons);
        Scene scene = new Scene(main_layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        FXApplication.launch(args);
    }
}
