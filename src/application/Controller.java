package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import infrastructure.DatabaseConnector;
import infrastructure.DtbWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Sample Skeleton for 'LogIn.fxml' Controller Class
 */
public class Controller {

    @FXML // fx:id="TF_userName"
    private JFXTextField empNoTF; // Value injected by FXMLLoader
    @FXML // fx:id="TFPassword"
    private JFXTextField passwordTF; // Value injected by FXMLLoader
    @FXML
    private JFXButton btn_login;

    private int currentUserID;
    private String tempPW;

    public void btn_login(){
        currentUserID = Integer.valueOf(empNoTF.getText());
        tempPW = passwordTF.getText();

        DatabaseConnector.createConnection();
    }
}