package generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Morten
 */
public class TestDataCollection {

    private List<String> testDataCollection;

    public TestDataCollection() {
        testDataCollection = new ArrayList();
    }

    public void addTestData(String newTestData) {
        testDataCollection.add(newTestData);
    }

    public List<String> getTestDataCollection() {
        return testDataCollection;
    }

    public void setTestDataCollection(List<String> testDataCollection) {
        this.testDataCollection = testDataCollection;
    }

}
