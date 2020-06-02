package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import domain.Item;
import domain.SessionUser;
import infrastructure.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private TextField searchOrderNumber, searchBarTF1;

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
    private TextField searchOrderNumber1, searchStatus1, searchMail1, searchBillingName1, searchStoreID1;

    @FXML
    private AnchorPane workFlowPane;

    @FXML
    private Tab tab;

    @FXML
    private Tab statisticsTab;

    @FXML
    private AnchorPane calendarPane, locationPane, adminUsersPane;
    @FXML
    private StackPane stackedSideBar;

    @FXML
    private VBox sideBarAssistant = new VBox();

    @FXML
    private JFXButton orderButton;

    @FXML
    private VBox sideBarDriver = new VBox();

    @FXML
    private JFXButton workflowButton, locationsButton, calendarButton;

    @FXML
    private VBox sideBarManager = new VBox();

    @FXML
    private JFXButton staffButton;

    @FXML
    private JFXButton statisticsButton;

    @FXML
    private JFXButton usersProfiles;

    @FXML
    private TableView orderList;

    private static SessionUser currentUser;


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
        System.out.println("logout Button reached closeWind");
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        System.out.println("Closed Window");
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
        System.out.println("Before close Wind");
        closeWindow(logoutButton);
        System.out.println("Before the crashing FXML");
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
        System.out.println("LogOut ran through");
    }
    @FXML
    public void printTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    public static ObservableList<Item> items = FXCollections.observableArrayList();

    @FXML
    public void newInvoice(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String email = searchBarTF1.getText();
        int customerID=0;
        String sql="";
        float totalPrice=0;
        int subsidiaryID=0;

        DatabaseConnector.query("select * from Customers where Email='" + email + "'");
        try {
            DatabaseConnector.getResultSet().next();
            customerID = Integer.parseInt(DatabaseConnector.getResultSet().getString("CustomerID"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("empty resultset for customeID select");
        }

        DatabaseConnector.query("select SubsidiaryID from Employees where EmployeeID=" + currentUser.id + "'");
        try {
            DatabaseConnector.getResultSet().next();
            subsidiaryID = Integer.parseInt(DatabaseConnector.getResultSet().getString("SubsidiaryID"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("empty resultset for subsidiaryID select");
        }

        //hier muss totale preisberechnung der itemsliste im ordermenu rein

        if(customerID!=0 && totalPrice!=0 && subsidiaryID!=0) {
            sql = "insert into Invoice values (" + customerID + ", '" + dtf.format(now) + "', TOTALPRICE," + subsidiaryID + ", 1)";
            DatabaseConnector.insert(sql);
        } else System.out.println("invoice not created, due to not all parameters being present");
        System.out.println("SQL statement: " + sql);

    }

    public static void loadItemsFromDb(){
        System.out.println("--> loadItemFromDb()");

        String sql = "select ItemID, Alias, Price from Items";
        String Alias="";
        int ItemID=0;
        float Price=0;

        DatabaseConnector.query(sql);
        items.clear();

        try{
            DatabaseConnector.getResultSet().next();
            do
            {
                ItemID = Integer.parseInt(DatabaseConnector.getResultSet().getString("ItemID"));
                Alias = DatabaseConnector.getResultSet().getString("Alias");
                Price = Float.parseFloat(DatabaseConnector.getResultSet().getString("Price"));

                items.add(new Item(ItemID, Alias, Price));
            } while(DatabaseConnector.getResultSet().next());
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("loadItemsFromDb encountered a problem");
            return;
        }
        System.out.println("--> loadItemFromDb successful");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentUser = LogInController.getSessionUser();
        if (currentUser.position != null) {
            if (currentUser.position.equals("Manager")) managerUI();
            if (currentUser.position.equals("Employee")) assistantUI();
            if (currentUser.position.equals("Driver")) driverUI();
        }
        loadItemsFromDb();
    }
}