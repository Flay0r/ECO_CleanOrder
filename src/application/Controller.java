package application;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Sample Skeleton for 'LogIn.fxml' Controller Class
 */
public class Controller {


        @FXML // fx:id="welcomeLabel"
        private Label welcomeLabel; // Value injected by FXMLLoader

        @FXML // fx:id="TF_userName"
        private JFXTextField TF_userName; // Value injected by FXMLLoader

        @FXML // fx:id="TFPassword"
        private JFXTextField TFPassword; // Value injected by FXMLLoader



    void printer() {
        System.out.println(welcomeLabel.getText());
    }




}
