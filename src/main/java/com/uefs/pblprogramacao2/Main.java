package com.uefs.pblprogramacao2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*AnchorPane pan = FXMLLoader.load(getClass().getResource("costumerRegister-view.fxml"));
        Scene scene = new Scene(pan);
        stage.setScene(scene);
        stage.show();*/

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("costumerRegister-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Technical Manegment!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}