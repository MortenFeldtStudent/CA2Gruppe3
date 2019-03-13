package generator;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    
    private List<String> testDataCollection;

    public TestData() {
        testDataCollection = new ArrayList();
    }
    
    public void addTestData(String newTestData){
        testDataCollection.add(newTestData);
    }

    public List<String> getTestDataCollection() {
        return testDataCollection;
    }

    public void setTestDataCollection(List<String> testDataCollection) {
        this.testDataCollection = testDataCollection;
    }

}
