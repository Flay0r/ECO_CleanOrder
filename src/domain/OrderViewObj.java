package domain;

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
    private String Subsidiary;
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

    }
}
