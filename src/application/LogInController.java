package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import domain.SessionUser;
import infrastructure.DatabaseConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    @FXML
    private Label validatorLabel;
    private static SessionUser currentUser = new SessionUser();
    MainController c = new MainController();
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXTextField empNoTF;
    @FXML
    private JFXPasswordField passwordTF;

    public static SessionUser getSessionUser(){
        return currentUser;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void btn_login() throws Exception {
        currentUser.password = passwordTF.getText();
        if (empNoTF.getText().matches("[0-9]+")) {
            currentUser.id = Integer.valueOf(empNoTF.getText());
        } else {
            System.out.println("invalid user number");
            return;
        }
        if (comparePassword()) {
            savePosition();
            empNoTF.setText("");
            passwordTF.setText("");
            validatorLabel.setText("LoginSucces");
            startDashBoard();
            c.closeWindow(loginButton);
        } else {
            System.out.println("login failed");
        }
    }

    private boolean comparePassword() {
        boolean result = false;
        DatabaseConnector.query("select * from LogCred where EmployeeID=" + currentUser.id);
        try {
            DatabaseConnector.getResultSet().next();
            if (currentUser.password.equals(DatabaseConnector.getResultSet().getString("Code")))
                result = true;
            if(currentUser.password.equals(DatabaseConnector.getResultSet().getString("Code")))
                result=true;
            return result;
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
        validatorLabel.setText("Failed to Login try again");
        return result;
    }

    public void savePosition() {
        DatabaseConnector.query("select Position from Employees where EmployeeID=" + currentUser.id);
        try {
            DatabaseConnector.getResultSet().next();
            currentUser.position = DatabaseConnector.getResultSet().getString("Position");
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
        System.out.println("saving position: " + currentUser.position);
    }

    @FXML
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
}
