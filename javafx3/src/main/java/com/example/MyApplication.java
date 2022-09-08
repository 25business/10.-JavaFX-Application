package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("First JavaFX Application");
        stage.setWidth(800);
        stage.setHeight(600);
        String content = "";

        Thread t = new Thread(new JavalinServer());
        t.start();

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("datetime.html");
            content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }catch (Exception exception) {
            content = exception.getLocalizedMessage();
        }

        VBox main_layout = new VBox();
        WebView webview = new WebView();
        webview.getEngine().loadContent(content, "text/html");
        main_layout.getChildren().add(webview);

        Scene scene = new Scene(main_layout);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        JavalinServer.app.stop();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

