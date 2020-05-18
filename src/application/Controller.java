package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import infrastructure.DatabaseConnector;
import javafx.fxml.FXML;

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
    private String currentPosition;
    private String tempPW;

    public void btn_login(){
        currentUserID = Integer.valueOf(empNoTF.getText());
        tempPW = passwordTF.getText();

        DatabaseConnector.select("select * from LogCred where EmployeeID=" + currentUserID);
        try {
            DatabaseConnector.getResultSet().next();
            if(tempPW.equals(DatabaseConnector.getResultSet().getString("Code"))) System.out.println("LOGIN SUCCESSFUL");
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
    }
}