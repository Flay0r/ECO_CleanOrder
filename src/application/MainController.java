package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import domain.Item;
import domain.OrderViewObj;
import domain.SessionUser;
import infrastructure.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.text.html.CSS;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    private JFXRadioButton updateStatusButt;

    @FXML
    private JFXButton updater, sendOrderToArchive, updateButt, cancelButt, skirtButt, pantsButt, pantiesButt, dressButt, shirtButt, tShirtButt, blazerButt, sockButt, dressPantsButt, newOrderButton, userProfile, logoutButton, orderPaneOrderButton, mailSearch, orderPaneOrderButton1, mailSearch1, orderButton, workflowButton, locationsButton, calendarButton, staffButton, statisticsButton, usersProfiles;
    @FXML
    private AnchorPane orderDetails, addNewCustomer, allThePanesAreHere, statisticsPane, orderPane, staffPane, workFlowPane, calendarPane, locationPane, adminUsersPane, newOrderPane;
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
    private StackPane stackedSideBars;
    @FXML
    private Group groupSideBars;
    @FXML
    private Label contentLabel; //Use setText on Button Press for each ContentArea
    @FXML
    TableView<Item> orderTable;
    @FXML
    TableColumn itemColumn, priceColumn;
    @FXML
    TableView<OrderViewObj> searchOrderTableview;
    @FXML
    TableColumn searchOrderNoColumn, searchCustomerColumn, searchDateColumn, searchTotalPriceColumn, searchStatusColumn, searchLocationColumn;
    @FXML
    TableView<OrderViewObj> driverTableview;

    @FXML
    TableColumn driverLocationColumn, driverStatusColumn, driverOrderNoColumn;

    private static SessionUser currentUser;
    private static ObservableList<Item> items = FXCollections.observableArrayList();
    private static ObservableList<Item> orderList = FXCollections.observableArrayList();
    private static ObservableList<OrderViewObj> invoiceList = FXCollections.observableArrayList();
    private static ObservableList<OrderViewObj> driverList = FXCollections.observableArrayList();
    private static ObservableList<TablePosition> selectedCells = FXCollections.observableArrayList();

    @FXML
    void openNewOrderPane(ActionEvent event) {
        unsee();
        System.out.println("Clicked");
        contentLabel.setText("Place a new Order");
        newOrderPane.setVisible(true);
        newOrderPane.toFront();
        newOrderButton.setVisible(false);
        searchBarTF1.setText("");
        orderList.clear();

    }

    @FXML
    void orderClicked(ActionEvent event) {
        unsee();
        contentLabel.setText("Manage orders");
        sendOrderToArchive.setVisible(true);
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
    @FXML
    void openCustomerPane(ActionEvent event) {
        unsee();
        contentLabel.setText("Add another Customer to DB :) ");
        addNewCustomer.setVisible(true);
        addNewCustomer.toFront();
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
        addNewCustomer.setVisible(false);
        orderDetails.setVisible(false);
        sendOrderToArchive.setVisible(false);
        contentLabel.setText("");
    }

    public double roundTo2(double value, int places){
        if (places < 0) throw new IllegalArgumentException();

        return new BigDecimal(value).setScale(places, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @FXML
    public void closeWindow(Button button) {
        System.out.println("logout Button reached closeWind");
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        System.out.println("Closed Window");
    }
    @FXML
    void getMoreInformation(MouseEvent event){
        try {
            searchOrderTableview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getButton().equals(MouseButton.PRIMARY)) {
                        if (event.getClickCount() == 2) {
                            OrderViewObj selection = searchOrderTableview.getSelectionModel().getSelectedItem();
                            openOrderDetails();


                        }
                    }
                }
            });
        }catch (NullPointerException e)
        {
            System.out.println("Error");
        }
    }

    void openOrderDetails() {
        unsee();
        contentLabel.setText("Here you get some Intel ");
        orderDetails.setVisible(true);
        orderDetails.toFront();
        newOrderButton.setVisible(true);

    }


    @FXML
    void handleDeletion(ActionEvent event) {

        OrderViewObj toBeDeleted = searchOrderTableview.getSelectionModel().getSelectedItem();
        if (toBeDeleted == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ecoSolution");
            alert.setHeaderText("No valid order was selected ");
            alert.setContentText("Please select a valid order for deletion. ");

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStyleClass().remove("alert");
            dialogPane.getStylesheets().add(
                    getClass().getResource("../UI/CSS/alertPane.css").toExternalForm());
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("ecoSolution");
        alert.setHeaderText("Confirm the deletion of the order. ");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("Delete Order!");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStyleClass().remove("alert");
        dialogPane.getStylesheets().add(
                getClass().getResource("../UI/CSS/alertPane.css").toExternalForm());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            int InvoiceID = toBeDeleted.getInvoiceID();
            DatabaseConnector.delete("delete from LaundryList where InvoiceID=" + InvoiceID);
            DatabaseConnector.delete("delete from OrderChain where InvoiceID=" + InvoiceID);
            DatabaseConnector.delete("delete from Invoice where InvoiceID=" + InvoiceID);
            loadOrdersFromDb();
        }
    }

    @FXML
    public void managerUI() {
        sideBarManager.toFront();
        updateStatusButt.setVisible(false);
        updater.setVisible(false);
    }

    @FXML
    public void assistantUI() {
        sideBarAssistant.toFront();
        updater.setVisible(false);
        updateStatusButt.setVisible(false);
    }

    @FXML
    public void driverUI() {
        sideBarDriver.toFront();
        sendOrderToArchive.setVisible(false);
        newOrderButton.setVisible(false);
        updateStatusButt.setVisible(true);
        updater.setVisible(true);
        sendOrderToArchive.setVisible(false);
    }

    @FXML
    public void toogleSelection() {
        driverTableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    public void driverShiftWorkflow(ActionEvent evevnt){
        ObservableList<OrderViewObj> selectedItems = driverTableview.getSelectionModel().getSelectedItems();
        System.out.println(selectedItems.get(0).getInvoiceID());
        System.out.println(selectedItems.get(1).getCustomerName());

        // TEST
        ArrayList<OrderViewObj> selectedIDs = new ArrayList<OrderViewObj>();
        for (OrderViewObj row : selectedItems) {
//            selectedIDs.add(row.get(0)); Have Fun triggering Logic
        }

        ListIterator<OrderViewObj> iterator = selectedIDs.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @FXML
    public void doCancellation(ActionEvent event) throws InterruptedException {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("ecoSolution");
        alert.setHeaderText("Confirm the deletion of the order. ");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("Delete Order!");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStyleClass().remove("alert");
        dialogPane.getStylesheets().add(
                getClass().getResource("../UI/CSS/alertPane.css").toExternalForm());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            orderList.clear();
        }

    }

    @FXML
    public void logout() throws IOException {
        System.out.println("Before close Wind");
        closeWindow(logoutButton);
        System.out.println("Before the crashing FXML");
        Parent root = FXMLLoader.load(getClass().getResource("/UI/LogIn.fxml"));
        Scene scene = new Scene(root, 800, 650);
        Stage stage = new Stage();
        stage.setTitle("EcoCleaner Login");
        stage.setScene(scene);
        stage.setMinHeight(650);
        stage.setMinWidth(800);
        stage.show();
        currentUser.id = 0;
        currentUser.position = "";
        currentUser.password = "";
        System.out.println("LogOut ran through");
    }

    @FXML
    public void newInvoice() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String email = searchBarTF1.getText();
        int customerID = 0;
        String sql = "";
        double totalPrice = 0;
        int subsidiaryID = 0;
        int InvoiceID = 0;

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("eCoSolution");
        alert.setHeaderText("This will save the order irrevocably ");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("Save it!");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStyleClass().remove("alert");
        dialogPane.getStylesheets().add(
                getClass().getResource("../UI/CSS/alertPane.css").toExternalForm());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            DatabaseConnector.query("select * from Customers where Email='" + email + "'");
            try {
                DatabaseConnector.getResultSet().next();
                customerID = Integer.parseInt(DatabaseConnector.getResultSet().getString("CustomerID"));
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("empty resultset for customerID select");
            }

            DatabaseConnector.query("select SubsidiaryID from Employees where EmployeeID=" + currentUser.id);
            try {
                DatabaseConnector.getResultSet().next();
                subsidiaryID = Integer.parseInt(DatabaseConnector.getResultSet().getString("SubsidiaryID"));
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("empty resultset for subsidiaryID select");
            }

            for (Item i : orderList) {
                totalPrice = totalPrice + i.getPrice();
            }

            if (customerID != 0 && totalPrice != 0 && subsidiaryID != 0 && !searchBarTF1.getText().equals("")) {
                sql = "insert into Invoice values (" + customerID + ", '" + dtf.format(now) + "', " + roundTo2(totalPrice, 2) + "," + subsidiaryID + ", 1)";
                DatabaseConnector.insert(sql);
                contentLabel.setText("New Invoice created successfully");
                searchBarTF1.setText("");

                DatabaseConnector.query("select InvoiceID from Invoice where CustomerID=" + customerID + " order by InvoiceID desc");
                try {
                    DatabaseConnector.getResultSet().next();
                    InvoiceID = Integer.parseInt(DatabaseConnector.getResultSet().getString("InvoiceID"));
                    System.out.println("invoice id grabbed successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                for (Item i : orderList) {
                    DatabaseConnector.insert("insert into LaundryList values (" + InvoiceID + "," + i.getItemID() + ",'')");
                }
                DatabaseConnector.insert("insert into OrderChain(InvoiceID, FromSubsidiaryID, ToSubsidiaryID, TimeDate, EmployeeID)" +
                        "values (" + InvoiceID + "," + subsidiaryID + ", " + subsidiaryID + ",'" + dtf.format(now) + "'," + currentUser.id + ")");

                orderList.clear();
                searchBarTF1.setText("");

            } else {
                System.out.println("invoice not created, due to not all parameters being present");
                contentLabel.setText("Failed");
            }
        }

        loadOrdersFromDb();
    }

    @FXML
    void pantsSelect(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Pants")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void selectPanties(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Underpants")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void selectdressPants(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Dress pants")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void shirtSelect(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Shirt")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void skirtSelect(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Skirt")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void sockSelect(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Socks")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void tShirtSelect(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("T-Shirt")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void blazerSelect(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Jacket")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
    }

    @FXML
    void dressSelect(ActionEvent event) {
        for (Item i : items) {
            if (i.getAlias().equals("Dress")) {
                orderList.add(new Item(i.getItemID(), i.getAlias(), i.getPrice()));
            }
        }
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

    public static void loadOrdersFromDb(){
        System.out.println("--> loadOrderFromDb");

        int InvoiceID=0;
        int CustomerID=0;
        String TimeDate="";
        double TotalPrice=0;
        int SubsidiaryID=0;
        int StageID=0;
        String FullName="";
        String Subsidiary="";
        String Status="";

        invoiceList.clear();
        driverList.clear();

        DatabaseConnector.query("select * from OrderViewObjects");

        try{
            DatabaseConnector.getResultSet().next();
            do {
                InvoiceID = Integer.parseInt(DatabaseConnector.getResultSet().getString("InvoiceID"));
                CustomerID = Integer.parseInt(DatabaseConnector.getResultSet().getString("CustomerID"));
                TimeDate = DatabaseConnector.getResultSet().getString("TimeDate");
                TotalPrice = Double.parseDouble(DatabaseConnector.getResultSet().getString("TotalPrice"));
                SubsidiaryID = Integer.parseInt(DatabaseConnector.getResultSet().getString("SubsidiaryID"));
                StageID = Integer.parseInt(DatabaseConnector.getResultSet().getString("StageID"));

                FullName = DatabaseConnector.getResultSet().getString("FullName");
                Subsidiary = DatabaseConnector.getResultSet().getString("Subsidiary");
                Status = DatabaseConnector.getResultSet().getString("Status");

                invoiceList.add(new OrderViewObj(InvoiceID, CustomerID, TimeDate, TotalPrice, SubsidiaryID, StageID, FullName, Subsidiary, Status));
            } while (DatabaseConnector.getResultSet().next());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("empty resultset for loadOrderFromDb");
        }

        for(OrderViewObj o : invoiceList){
            if(o.getStageID()==1 || o.getStageID()==5) {
                driverList.add(o);
            }
        }
    }

    @FXML
    void updateLocationStatus(ActionEvent event){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentUser = LogInController.getSessionUser();
        if (currentUser.position != null) {
            if (currentUser.position.equals("1")) managerUI();
            if (currentUser.position.equals("3")) assistantUI();
            if (currentUser.position.equals("2")) driverUI();
        }
        loadItemsFromDb();
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("Alias"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        orderTable.setItems(orderList);

        loadOrdersFromDb();
        searchOrderNoColumn.setCellValueFactory(new PropertyValueFactory<>("InvoiceID"));
        searchCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        searchDateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        searchTotalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
        searchStatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        searchLocationColumn.setCellValueFactory(new PropertyValueFactory<>("SubsidiaryName"));
        searchOrderTableview.setItems(invoiceList);

        driverStatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        driverLocationColumn.setCellValueFactory(new PropertyValueFactory<>("SubsidiaryName"));
        driverOrderNoColumn.setCellValueFactory(new PropertyValueFactory<>("InvoiceID"));
        driverTableview.setItems(driverList);
    }
}