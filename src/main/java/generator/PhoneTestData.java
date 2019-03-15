package generator;

/**
 * @author Morten
 */
public class PhoneTestData {

    private String description;
    private int number;

    public PhoneTestData(String description, int number) {
        this.description = description;
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
