package generator;

/**
 * @author Morten
 */
public class AddressTestData {

    private String info;
    private String street;
    private int city_id;

    public AddressTestData(String info, String street, int city_id) {
        this.info = info;
        this.street = street;
        this.city_id = city_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

}
