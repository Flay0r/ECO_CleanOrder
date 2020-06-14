package domain;

/**
 * The type Item creator class.
 */
public class Item {
    private int ItemID;
    private String Alias;
    private String Info;
    private float Price;

    /**
     * Instantiates a new Item.
     *
     * @param ItemID the item id
     * @param Alias  the alias
     * @param Price  the price
     */
    public Item(int ItemID, String Alias, float Price){
        this.ItemID=ItemID;
        this.Alias=Alias;
        this.Price=Price;
    }

    /**
     * Gets item id.
     *
     * @return the item id
     */
    public int getItemID() {
        return ItemID;
    }

    /**
     * Sets item id.
     *
     * @param itemID the item id
     */
    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    /**
     * Gets alias.
     *
     * @return the alias
     */
    public String getAlias() {
        return Alias;
    }

    /**
     * Sets alias.
     *
     * @param alias the alias
     */
    public void setAlias(String alias) {
        Alias = alias;
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public String getInfo() {
        return Info;
    }

    /**
     * Sets info.
     *
     * @param info the info
     */
    public void setInfo(String info) {
        Info = info;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public float getPrice() {
        return Price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(float price) {
        Price = price;
    }
}
