package domain;

public class DetailOrderChainObj {
    private int InvoiceID;
    private int LocationID;
    private String TimeDate;
    private int EmployeeID;
    private String NewLocation;
    private String FullName;

    public DetailOrderChainObj(int InvoiceID, int LocationID, String TimeDate, int EmployeeID, String NewLocation, String FullName){
        this.InvoiceID=InvoiceID;
        this.LocationID=LocationID;
        this.TimeDate=TimeDate;
        this.EmployeeID=EmployeeID;
        this.NewLocation=NewLocation;
        this.FullName=FullName;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        InvoiceID = invoiceID;
    }

    public int getLocationID() {
        return LocationID;
    }

    public void setLocationID(int locationID) {
        LocationID = locationID;
    }

    public String getTimeDate() {
        return TimeDate;
    }

    public void setTimeDate(String timeDate) {
        TimeDate = timeDate;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getNewLocation() {
        return NewLocation;
    }

    public void setNewLocation(String newLocation) {
        NewLocation = newLocation;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
