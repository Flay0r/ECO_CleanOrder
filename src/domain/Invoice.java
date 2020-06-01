package domain;


import java.time.LocalDateTime;

public class Invoice {

    private int customerID;
    private LocalDateTime timeDate;
    private float totalPrice;
    private int subsidiaryID;
    private String stage;

    public Invoice(int customerID, int subsidiaryID) {
        this.customerID=customerID;
        this.subsidiaryID=subsidiaryID;
        fillTimeDate();
    }

    public void fillTimeDate(){
        this.timeDate = LocalDateTime.now();
    }

    public void fillTotalPrice(){
        //TODO
    }

    public void fillSubsidiaryID(){
        //TODO
    }

    public void fillStage(){
        //TODO
    }

    public void writeInDb(){

    }
}
