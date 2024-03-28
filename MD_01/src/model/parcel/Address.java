package model.parcel;

public class Address {
    private City city;
    private String streetOrHouseTitle;
    private int houseNo;

    public Address() throws Exception {
        setCity(City.RIGA);
        setHouseNo(10);
        setStreetOrHouseTitle("Liepu");
    }

    public Address(City city, String streetOrHouseTitle, int houseNo) throws Exception {
        setCity(city);
        setHouseNo(houseNo);
        setStreetOrHouseTitle(streetOrHouseTitle);
    }

    public void setCity(City city) throws Exception {
        this.city = city;
    }

    public void setStreetOrHouseTitle(String streetOrHouseTitle) throws Exception {
        if (streetOrHouseTitle != null && streetOrHouseTitle.matches("[A-Z]{1}[a-z]+") && streetOrHouseTitle.length() < 100) {
            this.streetOrHouseTitle = streetOrHouseTitle;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");   
    }

    public void setHouseNo(int houseNo) throws Exception {
        if (houseNo > 0) {
            this.houseNo = houseNo;  
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");
    }

    public City getCity() {
        return city;
    }
    public int getHouseNo() {
        return houseNo;
    }
    public String getStreetOrHouseTitle() {
        return streetOrHouseTitle;
    }

    public String toString() {
        return "[ " + this.city + " , " + this.streetOrHouseTitle + " , " + this.houseNo + " ]";
    }
}
