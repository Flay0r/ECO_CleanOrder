package domain;

/**
 * The Creator for hte order view objects.
 */
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

    /**
     * Instantiates a new Order view obj.
     *
     * @param InvoiceID      the invoice id
     * @param CustomerID     the customer id
     * @param Date           the date
     * @param TotalPrice     the total price
     * @param SubsidiaryID   the subsidiary id
     * @param StageID        the stage id
     * @param CustomerName   the customer name
     * @param SubsidiaryName the subsidiary name
     * @param Status         the status
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

    /**
     * Gets invoice id.
     *
     * @return the invoice id
     */
    public int getInvoiceID() {
        return InvoiceID;
    }

    /**
     * Sets invoice id.
     *
     * @param invoiceID the invoice id
     */
    public void setInvoiceID(int invoiceID) {
        InvoiceID = invoiceID;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * Sets customer id.
     *
     * @param customerID the customer id
     */
    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return Date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        Date = date;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return TotalPrice;
    }

    /**
     * Sets total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    /**
     * Gets subsidiary id.
     *
     * @return the subsidiary id
     */
    public int getSubsidiaryID() {
        return SubsidiaryID;
    }

    /**
     * Sets subsidiary id.
     *
     * @param subsidiaryID the subsidiary id
     */
    public void setSubsidiaryID(int subsidiaryID) {
        SubsidiaryID = subsidiaryID;
    }

    /**
     * Gets stage id.
     *
     * @return the stage id
     */
    public int getStageID() {
        return StageID;
    }

    /**
     * Sets stage id.
     *
     * @param stageID the stage id
     */
    public void setStageID(int stageID) {
        StageID = stageID;
    }

    /**
     * Gets customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return CustomerName;
    }

    /**
     * Sets customer name.
     *
     * @param customerName the customer name
     */
    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    /**
     * Gets subsidiary name.
     *
     * @return the subsidiary name
     */
    public String getSubsidiaryName() {
        return SubsidiaryName;
    }

    /**
     * Sets subsidiary name.
     *
     * @param subsidiaryName the subsidiary name
     */
    public void setSubsidiaryName(String subsidiaryName) {
        SubsidiaryName = subsidiaryName;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        Status = status;
    }
}
