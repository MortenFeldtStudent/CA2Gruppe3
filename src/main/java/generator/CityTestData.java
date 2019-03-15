package generator;

/**
 * @author Morten
 */
public class CityTestData {

    private String city;
    private int zipCode;

    public CityTestData(String city, int zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

}
