package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import infrastructure.DatabaseConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

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
    @FXML
    private JFXButton logoutButton;
    @FXML
    private StackPane stackedSidebar;
    @FXML
    private VBox sideBarManager;
    @FXML
    private VBox getSideBarShopAssistant;
    @FXML
    private VBox sideBarDriver;

    private int currentUserID;
    private String currentPosition;
    private String tempPW;

    @FXML
    public void btn_login() throws Exception {
        currentUserID = Integer.valueOf(empNoTF.getText());
        tempPW = passwordTF.getText();
        if (empNoTF.getText().matches("[0-9]+")){
            currentUserID = Integer.valueOf(empNoTF.getText());
        } else {
            System.out.println("invalid user number");
            return;
        }

        if(comparePassword()) {

            empNoTF.setText("");
            passwordTF.setText("");
            System.out.println("login successful");

            startDashBoard();
            closeWindow(loginButton);
            savePosition();
            switch(currentPosition){
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
        DatabaseConnector.query("select Position from Employees where EmployeeID=" + currentUserID);
        try {
            DatabaseConnector.getResultSet().next();
            currentPosition=DatabaseConnector.getResultSet().getString("Position");
        } catch ( Exception e) {
            System.out.println("empty resultset");
        }
        System.out.println("saving position: " + currentPosition);
    }

    @FXML
    public void logout() throws IOException {
        closeWindow(logoutButton);
        Parent root = FXMLLoader.load(getClass().getResource("/UI/LogIn.fxml"));
        Stage stage = new Stage();
        stage.setTitle("EcoCleaner Login");
        stage.setScene(new Scene(root, 1200, 650));
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.show();
        currentUserID=0;
        currentPosition="";
        tempPW="";
    }

    private void closeWindow(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
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
        Scene scene =   stackedSidebar.getChildren().get(0).getScene();
        Stage stage = new Stage();
        stage.setTitle("DashBoard Manager UI");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();

        }


    public void assistantUI(){
        Scene scene = stackedSidebar.getChildren().get(1).getScene();
        Stage stage = new Stage();
        stage.setTitle("DashBoard Manager UI");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    public void driverUI(){
        Scene scene = stackedSidebar.getChildren().get(2).getScene();
        Stage stage = new Stage();
        stage.setTitle("DashBoard Manager UI");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
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