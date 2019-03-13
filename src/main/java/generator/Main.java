package generator;

public class Main {

    public static void main(String[] args) {

        int countSample = 10;

        Generator generator = new Generator();

        TestData testData;

        testData = generator.generate(countSample);

        for (String sqlStr : testData.getTestDataCollection()) {
            System.out.println(sqlStr);
        }

    }

}
