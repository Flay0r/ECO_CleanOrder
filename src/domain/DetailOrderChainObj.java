package domain;

/**
 * The Details for the Details List Creator-class for the ListView with orders in the System
  */

public class DetailOrderChainObj {
    private int InvoiceID;
    private int LocationID;
    private String TimeDate;
    private int EmployeeID;
    private String NewLocation;
    private String FullName;

    /**
     * Instantiates a new Detail order chain obj.
     *
     * @param InvoiceID   the invoice id
     * @param LocationID  the location id
     * @param TimeDate    the time date
     * @param EmployeeID  the employee id
     * @param NewLocation the new location
     * @param FullName    the full name
     */
    public DetailOrderChainObj(int InvoiceID, int LocationID, String TimeDate, int EmployeeID, String NewLocation, String FullName){
        this.InvoiceID=InvoiceID;
        this.LocationID=LocationID;
        this.TimeDate=TimeDate;
        this.EmployeeID=EmployeeID;
        this.NewLocation=NewLocation;
        this.FullName=FullName;
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
     * Gets location id.
     *
     * @return the location id
     */
    public int getLocationID() {
        return LocationID;
    }

    /**
     * Sets location id.
     *
     * @param locationID the location id
     */
    public void setLocationID(int locationID) {
        LocationID = locationID;
    }

    /**
     * Gets time date.
     *
     * @return the time date
     */
    public String getTimeDate() {
        return TimeDate;
    }

    /**
     * Sets time date.
     *
     * @param timeDate the time date
     */
    public void setTimeDate(String timeDate) {
        TimeDate = timeDate;
    }

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     * Sets employee id.
     *
     * @param employeeID the employee id
     */
    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    /**
     * Gets new location.
     *
     * @return the new location
     */
    public String getNewLocation() {
        return NewLocation;
    }

    /**
     * Sets new location.
     *
     * @param newLocation the new location
     */
    public void setNewLocation(String newLocation) {
        NewLocation = newLocation;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
