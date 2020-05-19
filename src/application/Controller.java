package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import infrastructure.DatabaseConnector;
import javafx.fxml.FXML;

/**
 * Sample Skeleton for 'LogIn.fxml' Controller Class
 */
public class Controller {

    @FXML
    private JFXTextField empNoTF;
    @FXML
    private JFXTextField passwordTF;
    @FXML
    private JFXButton btn_login;

    private int currentUserID;
    private String currentPosition;
    private String tempPW;

    public void btn_login(){
        currentUserID = Integer.valueOf(empNoTF.getText());
        tempPW = passwordTF.getText();

        DatabaseConnector.query("select * from LogCred where EmployeeID=" + currentUserID);
        try {
            DatabaseConnector.getResultSet().next();
            if(tempPW.equals(DatabaseConnector.getResultSet().getString("Code"))) System.out.println("login successful");
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
    }

    private boolean comparePassword(){
        boolean result=false;
        DatabaseConnector.query("select * from LogCred where EmployeeID=" + currentUserID);
        try {
            DatabaseConnector.getResultSet().next();
            if(tempPW.equals(DatabaseConnector.getResultSet().getString("Code"))) result=true;
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
        return result;
    }

    public void savePosition(){
        DatabaseConnector.query("select * from Employees where EmployeeID=" );
    }
}