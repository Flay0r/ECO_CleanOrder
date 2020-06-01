package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import domain.SessionUser;
import infrastructure.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private BorderPane border_pane;

    @FXML
    private VBox content_area;

    @FXML
    private HBox menubar;

    @FXML
    private TextField searchBarTF;

    @FXML
    private JFXButton userProfile;

    @FXML
    private JFXButton logoutButton;

    @FXML
    private AnchorPane allThePanesAreHere;

    @FXML
    private HBox ContentArea;

    @FXML
    private AnchorPane statisticsPane;

    @FXML
    private CategoryAxis timeAxis;

    @FXML
    private NumberAxis salesAxix;

    @FXML
    private AnchorPane orderPane;

    @FXML
    private JFXButton orderPaneOrderButton;

    @FXML
    private JFXButton mailSearch;

    @FXML
    private JFXListView<?> listViewOrderPane;

    @FXML
    private TextField searchOrderNumber;

    @FXML
    private TextField searchMail;

    @FXML
    private TextField searchBillingName;

    @FXML
    private TextField searchStoreID;

    @FXML
    private TextField searchStatus;

    @FXML
    private AnchorPane staffPane;

    @FXML
    private JFXButton orderPaneOrderButton1;

    @FXML
    private JFXButton mailSearch1;

    @FXML
    private JFXListView<?> listViewStaffPane;

    @FXML
    private TextField searchOrderNumber1;

    @FXML
    private TextField searchMail1;

    @FXML
    private TextField searchBillingName1;

    @FXML
    private TextField searchStoreID1;

    @FXML
    private TextField searchStatus1;

    @FXML
    private AnchorPane workFlowPane;

    @FXML
    private Tab tab;

    @FXML
    private Tab statisticsTab;

    @FXML
    private AnchorPane calendarPane;

    @FXML
    private AnchorPane locationPane;

    @FXML
    private AnchorPane adminUsersPane;

    @FXML
    private StackPane stackedSideBar;

    @FXML
    private AnchorPane sideBarAssistant;

    @FXML
    private JFXButton orderButton;

    @FXML
    private AnchorPane sideBarDriver;

    @FXML
    private JFXButton workflowButton;

    @FXML
    private JFXButton locationsButton;

    @FXML
    private JFXButton calendarButton;

    @FXML
    private AnchorPane sideBarManager;

    @FXML
    private JFXButton staffButton;

    @FXML
    private JFXButton statisticsButton;

    @FXML
    private JFXButton usersProfiles;

    private static SessionUser currentUser = new SessionUser();
    @FXML
    private JFXTextField empNoTF;
    @FXML
    private JFXPasswordField passwordTF;
    @FXML
    private JFXButton loginButton;
    @FXML
    private StackPane stackedSideBars;
    @FXML
    private Group groupSideBars;
    @FXML
    private Label contentLabel; //Use setText on Button Press for each ContentArea
    @FXML
    private Label validatorLabel;
    @FXML
    void orderClicked(ActionEvent event) {
        System.out.println("Clicked");
        contentLabel.setText("Welcome");
        orderPane.setVisible(true);
        orderPane.toFront();
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);

    }
    @FXML
    void openCalenderPane(ActionEvent event) {
        contentLabel.setText("Welcome to the Calender");
        calendarPane.setVisible(true);
        calendarPane.toFront();
        orderPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openLocationPane(ActionEvent event) {
        contentLabel.setText("Welcome to the Calender");
        locationPane.setVisible(true);
        locationPane.toFront();
        calendarPane.setVisible(false);
        orderPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openStaffPane(ActionEvent event) {
        contentLabel.setText("Welcome to the Staff");
        staffPane.setVisible(true);
        staffPane.toFront();
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        orderPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openStatisticsPane(ActionEvent event) {
        contentLabel.setText("Welcome to the Stats");
        statisticsPane.setVisible(true);
        statisticsPane.toFront();calendarPane.setVisible(false);
        locationPane.setVisible(false);
        orderPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openUsersPane(ActionEvent event) {
        contentLabel.setText("Welcome to the Users");
        adminUsersPane.setVisible(true);
        adminUsersPane.toFront();
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        orderPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openWorkFlowPane(ActionEvent event) {
        contentLabel.setText("Welcome to the Workflow");
        workFlowPane.setVisible(true);
        workFlowPane.toFront();calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (currentUser.position != null) {
            if (currentUser.position.equals("Manager")) managerUI();
            if (currentUser.position.equals("Employee")) assistantUI();
            if (currentUser.position.equals("Driver")) driverUI();
        }
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
            closeWindow(loginButton);
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
        } catch (Exception e) {
            System.out.println("empty resultset");
        }
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
    public void logout() throws IOException {
        System.out.println("Before close Wind");
        closeWindow(logoutButton);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/UI/LogIn.fxml"));
        Scene scene = new Scene(root, 1200, 650);
        Stage stage = new Stage();
        stage.setTitle("EcoCleaner Login");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.show();
        currentUser.id = 0;
        currentUser.position = "";
        currentUser.password = "";
        System.out.println("LogOut ran through");
    }
    private void closeWindow(Button button) {
        System.out.println("logout Button reached closeWind");
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        System.out.println("Closed Window");
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
    public void assistantUI() {
        sideBarAssistant.toFront();
    }
    public void driverUI() {
        sideBarDriver.toFront();
    }
    public void newOrder(int CustomerID, int SubsidiaryID) {



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