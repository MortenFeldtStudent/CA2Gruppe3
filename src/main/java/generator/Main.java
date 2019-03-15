package generator;

import java.util.Collections;
import java.util.List;

/**
 * @author Morten
 */
public class Main {

    public static void main(String[] args) {

        int countSample = 2000;
        if (countSample % 1000 == 0) {
            Generator generator = new Generator();
            generator.initializeZipCodesAndCity();
            final int countZipCodesInSQL = generator.amountOfZipCodes();
            if (countSample >= countZipCodesInSQL) {
                boolean noDublicates = true;
                TestDataCollection testData = generator.generate(countSample, countZipCodesInSQL);
                List<String> testDataGeneratedList = testData.getTestDataCollection();
                for (int i = 0; i < testDataGeneratedList.size(); i++) {
                    int amount = Collections.frequency(testDataGeneratedList, testDataGeneratedList.get(i));
                    if (amount > 1) {
                        noDublicates = false;
                    }
                }
                if (noDublicates) {
                    for (String sqlStr : testDataGeneratedList) {
                        System.out.println(sqlStr);
                    }
                    System.out.println("Antal rækker af test data (uden ZipCodes): " + testDataGeneratedList.size());
                } else {
                    System.out.println("LISTEN INDEHOLDER DUBLETTER - PRØV IGEN!");
                }
            } else {
                System.out.println("Du skal minimum sætte countSample til antal ZipCodes i SQL = " + countZipCodesInSQL);
            }
        } else {
            System.out.println("Du skal vælge et sample size deleligt med 1000 (f.eks. 2000,3000 etc.)!!!");
        }

    }

}
