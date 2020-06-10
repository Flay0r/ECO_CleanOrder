package domain;

public class DetailLaundryListObj {
    private int LaundryListID;
    private int InvoiceID;
    private int ItemID;
    private String Alias;

    public DetailLaundryListObj(int LaundryListID, int InvoiceID, int ItemID, String Alias){
        this.LaundryListID=LaundryListID;
        this.InvoiceID=InvoiceID;
        this.ItemID=ItemID;
        this.Alias=Alias;
    }

    public int getLaundryListID() {
        return LaundryListID;
    }

    public void setLaundryListID(int laundryListID) {
        LaundryListID = laundryListID;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        InvoiceID = invoiceID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }
}
