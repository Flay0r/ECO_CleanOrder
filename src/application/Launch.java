package application;

import infrastructure.DatabaseConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/LogIn.fxml"));
        stage.setTitle("EcoCleaner");
        stage.setScene(new Scene(root, 1200, 650));
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.show();

        DatabaseConnector.createConnection();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}