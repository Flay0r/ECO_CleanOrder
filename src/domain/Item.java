package domain;

public class Item {
    private int ItemID;
    private String Alias;
    private String Info;
    private float Price;

    public Item(int ItemID, String Alias, float Price){
        this.ItemID=ItemID;
        this.Alias=Alias;
        this.Price=Price;
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

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
