package com.uefs.pblprogramacao2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;
    private static Scene loginScene;
    private static Scene adminMenuScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setResizable(false);

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        loginScene = new Scene(fxmlLogin, 640, 480);

        Parent fxmlAdminMenu = FXMLLoader.load(getClass().getResource("admin-menu-view.fxml"));
        adminMenuScene = new Scene(fxmlAdminMenu, 640, 480);

        stage.setScene(loginScene);
        stage.show();
    }

    public static void changeView (String view){
        switch (view){
            case "loginScene":
                stage.setScene(loginScene);
                break;
            case "adminMenuScene":
                stage.setScene(adminMenuScene);
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}