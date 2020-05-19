package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import domain.SessionUser;
import infrastructure.DatabaseConnector;
import javafx.fxml.FXML;
import javax.xml.crypto.Data;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Sample Skeleton for 'LogIn.fxml' Controller Class
 */
public class Controller {

    @FXML
    private JFXTextField empNoTF;
    @FXML
    private JFXTextField passwordTF;
    @FXML
    private JFXButton loginButton;



    private static SessionUser currentUser;

    @FXML
    public void btn_login() throws Exception{
        currentUser.password = passwordTF.getText();
        if (empNoTF.getText().matches("[0-9]+")){
            currentUser.id = Integer.valueOf(empNoTF.getText());
        } else {
            System.out.println("invalid user number");
            return;
        }

        if(comparePassword()) {

            empNoTF.setText("");
            passwordTF.setText("");
            System.out.println("login successful");

            startDashBoard();
            closeWindow();
            savePosition();
            switch(currentUser.position){
                case "Manager":
                    managerUI();
                    break;
                case "Employee":
                    assistantUI();
                    break;
                case "Driver":
                    driverUI();
                    break;
            }

        } else {
            System.out.println("login failed");
        }
    }

    private boolean comparePassword(){
        boolean result=false;
        DatabaseConnector.query("select * from LogCred where EmployeeID=" + currentUser.id);
        try {
            DatabaseConnector.getResultSet().next();
            if(currentUser.password.equals(DatabaseConnector.getResultSet().getString("Code"))) result=true;
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
        return result;
    }

    public void savePosition(){
        DatabaseConnector.query("select Position from Employees where EmployeeID=" + currentUser.id);
        try {
            DatabaseConnector.getResultSet().next();
            currentUser.position=DatabaseConnector.getResultSet().getString("Position");
        } catch ( Exception e) {
            System.out.println("empty resultset");
        }
        System.out.println("saving position: " + currentUser.position);
    }

    public void logout() {
        //TODO hier muss aufruf zum login screen hin
        currentUser.id=0;
        currentUser.position="";
        currentUser.password="";
    }

    private void closeWindow(){
       Stage stage = (Stage) loginButton.getScene().getWindow();
       stage.close();

    }

    public Stage startDashBoard() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/Main.fxml"));
        Scene scene = new Scene(root, 1200, 650);
        Stage stage = new Stage();
        stage.setTitle("DashBoard Minimal UI");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
        return stage;
    }

    public void managerUI(){

    //TODO Show the UI!
    }

    public void assistantUI(){

            //TODO Show the UI!
    }

    public void driverUI(){
            //TODO Show the UI!
        }



    public void newOrder(int CustomerID, int SubsidiaryID){



        /* we need:
        customerID
        TimeDate, to be calculated and inserted during runtime
        TotalPrice, to be calculated and inserted after list of items have been appended to this invoice
        SubsidiaryID, correct id to be calculated by db join during runtime through alias

         */
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