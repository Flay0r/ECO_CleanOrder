package application;

import infrastructure.DatabaseConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.naming.ldap.Control;

public class Main extends Application {

    private static Controller c;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/UI/LogIn.fxml"));
        primaryStage.setTitle("ECO Clean Handling");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        DatabaseConnector.createConnection();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
