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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
//OneLiner
public class MainController implements Initializable {
    @FXML
    private BorderPane border_pane;
    @FXML
    private VBox content_area;
    @FXML
    private HBox menubar, ContentArea;
    @FXML
    private TextField searchBarTF, searchOrderNumber, searchBarTF1, searchMail, searchBillingName, searchStoreID, searchStatus, searchOrderNumber1, searchStatus1, searchMail1, searchBillingName1, searchStoreID1;
    @FXML
    private JFXButton   skirtButt, pantsButt, pantiesButt, dressButt, shirtButt, tShirtButt, blazerButt, sockButt, dressPantsButt, newOrderButton, userProfile, logoutButton, orderPaneOrderButton, mailSearch, orderPaneOrderButton1, mailSearch1, orderButton, workflowButton, locationsButton, calendarButton, staffButton, statisticsButton, usersProfiles;
    @FXML
    private AnchorPane allThePanesAreHere, statisticsPane, orderPane, staffPane, workFlowPane, calendarPane, locationPane, adminUsersPane, newOrderPane;
    @FXML
    private CategoryAxis timeAxis;
    @FXML
    private NumberAxis salesAxix;
    @FXML
    private JFXListView<?> listViewOrderPane;
    @FXML
    private JFXListView<?> listViewStaffPane;
    @FXML
    private Tab tab;
    @FXML
    private Tab statisticsTab;
    @FXML
    private StackPane stackedSideBar;
    @FXML
    private VBox sideBarAssistant = new VBox();
    @FXML
    private VBox sideBarDriver = new VBox();
    @FXML
    private VBox sideBarManager = new VBox();
    @FXML
    private TableView orderList;
    @FXML
    private StackPane stackedSideBars;
    @FXML
    private Group groupSideBars;
    @FXML
    private Label contentLabel; //Use setText on Button Press for each ContentArea
    @FXML
    TableView<Item> orderTable;
    @FXML
    TableColumn itemColumn, priceColumn;

    private static SessionUser currentUser;
    private static ObservableList<Item> items = FXCollections.observableArrayList();

    @FXML
    void openNewOrderPane(ActionEvent event) {
        unsee();
        System.out.println("Clicked");
        contentLabel.setText("Place a new Order");
        newOrderPane.setVisible(true);
        newOrderPane.toFront();
        newOrderButton.setVisible(false);

    }
    @FXML
    void orderClicked(ActionEvent event) {
        unsee();
        contentLabel.setText("Manage/seek orders");
        orderPane.setVisible(true);
        newOrderButton.setVisible(true);
    }
    @FXML
    void openCalenderPane(ActionEvent event) {
        unsee();
        contentLabel.setText("Welcome to the Calender");
        calendarPane.setVisible(true);
        calendarPane.toFront();
        newOrderButton.setVisible(true);
    }
    @FXML
    void openLocationPane(ActionEvent event) {
        unsee();
        contentLabel.setText("Live tracking Trucks");
        locationPane.setVisible(true);
        locationPane.toFront();
        newOrderButton.setVisible(true);
    }
    @FXML
    void openStaffPane(ActionEvent event) {
        unsee();
        contentLabel.setText("Manage staff");
        staffPane.setVisible(true);
        staffPane.toFront();
        newOrderButton.setVisible(true);
    }
    @FXML
    void openStatisticsPane(ActionEvent event) {
        unsee();
        contentLabel.setText("Manage the numbers");
        statisticsPane.setVisible(true);
        statisticsPane.toFront();
        newOrderButton.setVisible(true);


    }
    @FXML
    void openUsersPane(ActionEvent event) {
        unsee();
        contentLabel.setText("Manage the Users");
        adminUsersPane.setVisible(true);
        adminUsersPane.toFront();
        newOrderButton.setVisible(true);

    }
    @FXML
    void openWorkFlowPane(ActionEvent event) {
        unsee();
        contentLabel.setText("Manage WorkFlow Here");
        workFlowPane.setVisible(true);
        workFlowPane.toFront();
        newOrderButton.setVisible(true);

    }

    private void unsee(){
        calendarPane.setVisible(false);
        locationPane.setVisible(false);
        statisticsPane.setVisible(false);
        adminUsersPane.setVisible(false);
        newOrderPane.setVisible(false);
        staffPane.setVisible(false);
        workFlowPane.setVisible(false);
        orderPane.setVisible(false);

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


    @FXML
    void pantsSelect(ActionEvent event) {
//     pantsButt//Button - Hose
    }

    @FXML
    void selectPanties(ActionEvent event) {
//       pantiesButt//Button - Unterhose
    }

    @FXML
    void selectdressPants(ActionEvent event) {
//        dressPantsButt//Button - AnzugHose
    }

    @FXML
    void shirtSelect(ActionEvent event) {
//        shirtButt//Button - Hemd

    }

    @FXML
    void skirtSelect(ActionEvent event) {
//        skirtButt//Button - Rock
//
    }

    @FXML
    void sockSelect(ActionEvent event) {
//        sockButt

    }

    @FXML
    void tShirtSelect(ActionEvent event) {
//        tShirtButt

    }

    @FXML
    void blazerSelect(ActionEvent event) {
//        blazerButt

    }

    @FXML
    void dressSelect(ActionEvent event) {
//        dressButt

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
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("Alias"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }

    /*
       TextInputDialog dialog = new TextInputDialog("Tran");

        dialog.setTitle("Category");
        dialog.setHeaderText("Please enter new categories");
        dialog.setContentText("Come on do it now:");
        Optional<String> result = dialog.showAndWait();
         result.ifPresent(name -> {
            tbData.getSelectionModel().getSelectedItem().setCategory(result.get());

            DB.updateSQL("update tblVideos set Category='" + result.get() + "' where Title='" + selection.getTitle() + "'");
            DB.manualDisconnect();
            loadVideoList();


     */
}