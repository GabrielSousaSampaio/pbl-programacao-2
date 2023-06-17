package com.uefs.pbl2;

import com.uefs.pbl2.dao.DAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(DAO.getTechnician().FindById(2).getName());
        System.out.println(DAO.getTechnician().FindById(2).getEmail());
        System.out.println(DAO.getTechnician().FindById(2).getPassword());
        System.out.println(DAO.getTechnician().FindById(2).getWorkingOn());
        System.out.println(DAO.getWorkOrder().FindById(1).getTechnician());

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Te amo ZE FOFO");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}