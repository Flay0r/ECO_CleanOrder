package domain;

import java.text.SimpleDateFormat;

public class Invoice {

    private int customerID;
    private SimpleDateFormat timeDate;
    private float totalPrice;
    private int subsidiaryID;
    private String stage;

    public Invoice(int customerID) {
        this.customerID=customerID;
    }

    public void fillTimeDate(){
        //TODO
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
}
