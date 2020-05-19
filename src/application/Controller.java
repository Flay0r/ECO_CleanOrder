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

    @FXML
    public void btn_login(){
        currentUserID = Integer.valueOf(empNoTF.getText());
        tempPW = passwordTF.getText();

        DatabaseConnector.query("select * from LogCred where EmployeeID=" + currentUserID);
        try {
            DatabaseConnector.getResultSet().next();
            if(tempPW.equals(DatabaseConnector.getResultSet().getString("Code"))) System.out.println("LOGIN SUCCESSFUL");
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
    }

    /*
    Pane-Chooser
    @FXML
    void goToBurger(ActionEvent event) {
        mainCourse.setVisible(false);
        dessertPane.setVisible(false);
        sideDish.setVisible(false);
        burgers.setVisible(true);
        potatoPane.setVisible(false);
    }

    @FXML
    void goToDesert(ActionEvent event) {
        sideDish.setVisible(false);
        burgers.setVisible(false);
        mainCourse.setVisible(false);
        dessertPane.setVisible(true);
        potatoPane.setVisible(false);
    }
     */
}