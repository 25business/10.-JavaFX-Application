package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFX Application");
        stage.setWidth(600);
        stage.setHeight(400);

        Label label = new Label("A JavaFX Label");
        Hyperlink link = new Hyperlink("This is a link!");
        link.setOnAction( actionEvent -> {
            System.out.println("Clicked!");
        });
        Button classicButton = new Button("Classic");

        VBox vBox = new VBox();
        vBox.getChildren().add(label);
        vBox.getChildren().add(link);
        vBox.getChildren().add(classicButton);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        FXApplication.launch(args);
    }
}
