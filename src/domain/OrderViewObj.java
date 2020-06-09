package domain;

import infrastructure.DatabaseConnector;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderViewObj {
    //DB fields
    private int InvoiceID;
    private int CustomerID;
    private String Date;
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

    public OrderViewObj(int InvoiceID, int CustomerID, String Date, double TotalPrice, int SubsidiaryID, int StageID, String CustomerName, String SubsidiaryName, String Status){
        //DB fields
        this.InvoiceID=InvoiceID;
        this.CustomerID=CustomerID;
        this.Date=Date;
        this.TotalPrice=TotalPrice;
        this. SubsidiaryID=SubsidiaryID;
        this.StageID=StageID;
        //extracted fields
        this.CustomerName=CustomerName;
        this.SubsidiaryName=SubsidiaryName;
        this.Status=Status;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        InvoiceID = invoiceID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public int getSubsidiaryID() {
        return SubsidiaryID;
    }

    public void setSubsidiaryID(int subsidiaryID) {
        SubsidiaryID = subsidiaryID;
    }

    public int getStageID() {
        return StageID;
    }

    public void setStageID(int stageID) {
        StageID = stageID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getSubsidiaryName() {
        return SubsidiaryName;
    }

    public void setSubsidiaryName(String subsidiaryName) {
        SubsidiaryName = subsidiaryName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
