package domain;


import java.time.LocalDateTime;

/**
 * Invoice creator Class
 */
public class Invoice {

    private int customerID;
    private LocalDateTime timeDate;
    private float totalPrice;
    private int subsidiaryID;
    private String stage;

    /**
     * Instantiates a new Invoice.
     *
     * @param customerID   the customer id
     * @param subsidiaryID the subsidiary id
     */
    public Invoice(int customerID, int subsidiaryID) {
        this.customerID=customerID;
        this.subsidiaryID=subsidiaryID;
        fillTimeDate();
    }

    /**
     * Fill time date column.
     */
    public void fillTimeDate(){
        this.timeDate = LocalDateTime.now();
    }
}
