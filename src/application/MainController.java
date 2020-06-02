package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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
    private VBox sideBarAssistant = new VBox();

    @FXML
    private JFXButton orderButton;

    @FXML
    private VBox sideBarDriver = new VBox();

    @FXML
    private JFXButton workflowButton;

    @FXML
    private JFXButton locationsButton;

    @FXML
    private JFXButton calendarButton;

    @FXML
    private VBox sideBarManager = new VBox();

    @FXML
    private JFXButton staffButton;

    @FXML
    private JFXButton statisticsButton;

    @FXML
    private JFXButton usersProfiles;

    private static SessionUser currentUser = new SessionUser();


    @FXML
    private StackPane stackedSideBars;
    @FXML
    private Group groupSideBars;
    @FXML
    private Label contentLabel; //Use setText on Button Press for each ContentArea
    @FXML
    private AnchorPane newOrderPane;
    @FXML
    void openNewOrderPane(ActionEvent event) {
        System.out.println("Clicked");
        contentLabel.setText("Place a new Order");
        newOrderPane.setVisible(true);
        newOrderPane.toFront();
        orderPane.setVisible(false);
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);

    }
    @FXML
    void orderClicked(ActionEvent event) {
        System.out.println("Clicked");
        contentLabel.setText("Manage/seek orders");
        orderPane.setVisible(true);
        orderPane.toFront();
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
        newOrderPane.setVisible(false);

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
        newOrderPane.setVisible(false);
    }
    @FXML
    void openLocationPane(ActionEvent event) {
        contentLabel.setText("Live tracking Trucks");
        locationPane.setVisible(true);
        locationPane.toFront();
        calendarPane.setVisible(false);
        orderPane.setVisible(false);
        statisticsPane.setVisible(false);
        newOrderPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openStaffPane(ActionEvent event) {
        contentLabel.setText("Manage staff");
        staffPane.setVisible(true);
        staffPane.toFront();
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        newOrderPane.setVisible(false);
        adminUsersPane.setVisible(false);
        orderPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openStatisticsPane(ActionEvent event) {
        contentLabel.setText("Stats 42/0/0");
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        orderPane.setVisible(false);
        adminUsersPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
        statisticsPane.setVisible(true);
        statisticsPane.toFront();

    }
    @FXML
    void openUsersPane(ActionEvent event) {
        contentLabel.setText("Manage the Users");
        adminUsersPane.setVisible(true);
        adminUsersPane.toFront();
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        newOrderPane.setVisible(false);
        orderPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
    }
    @FXML
    void openWorkFlowPane(ActionEvent event) {
        contentLabel.setText("Manage WorkFlow Here");
        workFlowPane.setVisible(true);
        workFlowPane.toFront();
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        newOrderPane.setVisible(false);
        staffPane.setVisible(false);

    }

    @FXML
    public void closeWindow(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void managerUI() { sideBarManager.toFront(); }
    @FXML
    public void assistantUI() {
        sideBarAssistant.toFront();
    }
    @FXML
    public void driverUI() {
        sideBarDriver.toFront();
    }

    public void newOrder(int CustomerID, int SubsidiaryID) {

    }

    @FXML
    public void logout() throws IOException {
        closeWindow(logoutButton);
        Parent root = FXMLLoader.load(getClass().getResource("/UI/LogIn.fxml"));
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
    }
    @FXML
    public void printTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @FXML
    public void newInvoice(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        //int customerID = TEXTFELD.getText


        String sql = "insert into Invoice values (1, '" + dtf.format(now) + "', 54321, 1, 1)";
        System.out.println("SQL statement: " + sql);
        DatabaseConnector.insert(sql);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}