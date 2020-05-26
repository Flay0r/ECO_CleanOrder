package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import domain.SessionUser;
import infrastructure.DatabaseConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private JFXTextField empNoTF;
    @FXML
    private JFXTextField passwordTF;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton logoutButton;
    @FXML
    private StackPane stackedSideBars;
    @FXML
    private VBox sideBarManager = new VBox();
    @FXML
    private VBox sideBarAssistant = new VBox();
    @FXML
    private VBox sideBarDriver = new VBox();
    @FXML
    private Group groupSideBars;

    private static SessionUser currentUser = new SessionUser();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        if(currentUser.position != null) {
            if (currentUser.position.equals("Manager")) managerUI();
            if (currentUser.position.equals("Employee")) assistantUI();
            if (currentUser.position.equals("Driver")) driverUI();
        }
    }

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
            savePosition();
            empNoTF.setText("");
            passwordTF.setText("");
            System.out.println("login successful");
            startDashBoard();
            closeWindow(loginButton);
        } else {
            System.out.println("login failed");
        }
    }

    private boolean comparePassword(){
        boolean result=false;
        DatabaseConnector.query("select * from LogCred where EmployeeID=" + currentUser.id);
        try {
            DatabaseConnector.getResultSet().next();
            if(currentUser.password.equals(DatabaseConnector.getResultSet().getString("Code")))
                result=true;
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
        currentUser.id=0;
        currentUser.position="";
        currentUser.password="";
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


    public void managerUI() {
        sideBarManager.toFront();
    }

    public void assistantUI(){
        sideBarAssistant.toFront();
    }


    public void driverUI(){
        sideBarDriver.toFront();
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