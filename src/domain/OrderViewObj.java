package domain;

import infrastructure.DatabaseConnector;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderViewObj {
    //DB fields
    private int InvoiceID;
    private int CustomerID;
    private LocalDateTime Date;
    private double TotalPrice;
    private int SubsidiaryID;
    private int StageID;
    //extracted fields
    private String CustomerName;
    private String SubsidiaryName;
    private String Status;
/*
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    dtf.format(now)
*/

    public OrderViewObj(int InvoiceID, int CustomerID, LocalDateTime Date, double TotalPrice, int SubsidiaryID, int StageID){
        //DB fields
        this.InvoiceID=InvoiceID;
        this.CustomerID=CustomerID;
        this.Date=Date;
        this.TotalPrice=TotalPrice;
        this. SubsidiaryID=SubsidiaryID;
        this.StageID=StageID;
        //extracted fields
        DatabaseConnector.query("select FullName from Customers where CustomerID=" + CustomerID);
        try{
            DatabaseConnector.getResultSet().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DatabaseConnector.query("select FullName from Customers where CustomerID=" + CustomerID);
        try{
            DatabaseConnector.getResultSet().next();
            CustomerName = DatabaseConnector.getResultSet().getString("FullName");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("selecting customer name for creating orderviewobject did not work");
        }

        DatabaseConnector.query("select Alias from Subsidiaries where SubsidiaryID=" + SubsidiaryID);
        try{
            DatabaseConnector.getResultSet().next();
            SubsidiaryName = DatabaseConnector.getResultSet().getString("Alias");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("selecting subsidiary for creating orderviewobject did not work");
        }

        DatabaseConnector.query("select Alias from Stage where StageID=" + StageID);
        try{
            DatabaseConnector.getResultSet().next();
            Status = DatabaseConnector.getResultSet().getString("Alias");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("selecting status for creating orderviewobject did not work");
        }
    }
}
