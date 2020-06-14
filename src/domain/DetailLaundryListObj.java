package domain;

/**
 * The Details for the Laundry List Creator class for the ListView with Laundry items in the System
 */
public class DetailLaundryListObj {
    private int LaundryListID;
    private int InvoiceID;
    private int ItemID;
    private String Alias;

    /**
     * Instantiates a new Detail laundry list obj.
     *
     * @param LaundryListID the laundry list id
     * @param InvoiceID     the invoice id
     * @param ItemID        the item id
     * @param Alias         the name of the item.
     */
    public DetailLaundryListObj(int LaundryListID, int InvoiceID, int ItemID, String Alias){
        this.LaundryListID=LaundryListID;
        this.InvoiceID=InvoiceID;
        this.ItemID=ItemID;
        this.Alias=Alias;
    }

    /**
     * Gets laundry list id.
     *
     * @return the laundry list id
     */
    public int getLaundryListID() {
        return LaundryListID;
    }

    /**
     * Sets laundry list id.
     *
     * @param laundryListID the laundry list id
     */
    public void setLaundryListID(int laundryListID) {
        LaundryListID = laundryListID;
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
     * Gets the ID from the items.
     *
     * @return the item id
     */
    public int getItemID() {
        return ItemID;
    }

    /**
     * Sets the ID from the items.
     *
     * @param itemID the item id
     */
    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    /**
     * Gets names of the items.
     *
     * @return the alias
     */
    public String getAlias() {
        return Alias;
    }

    /**
     * Sets the name of the items.
     *
     * @param alias the alias
     */
    public void setAlias(String alias) {
        Alias = alias;
    }
}
