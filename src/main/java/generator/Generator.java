package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    
    private final Random random = new Random();

    private final TestData testData = new TestData();

    private final List<Integer> testDataGeneratePhone = new ArrayList();
    
    private final int[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public TestData generate(int countSample) {

        //Generating PhoneNumbers in List
        generateListInt(countSample);

        //City
        //See ZipCode SQL file in CA2 Exercise
        
        //Address
        for (int i = 1; i <= countSample; i++) {
            String info = "AddressInfo" + i;
            String street = "AddressStreet" + i;
            int city_id = i;
            String sql = "INSERT INTO ADDRESS (INFO,STREET,FK_City) VALUES "
                    + "("
                    + "'" + info + "',"
                    + "'" + street + "',"
                    + city_id
                    + ");";
            testData.addTestData(sql);
        }
        //Address
        for (int i = 1; i <= countSample; i++) {
            if (i % 4 == 0) {
            String info = "AddressInfo" + i + i;
            String street = "AddressStreet" + i + i;
            int city_id = i;
            String sql = "INSERT INTO ADDRESS (INFO,STREET,FK_City) VALUES "
                    + "("
                    + "'" + info + "',"
                    + "'" + street + "',"
                    + city_id
                    + ");";
            testData.addTestData(sql);
            }
        }
        //Hobby
        for (int i = 1; i <= countSample; i++) {
            String descriptionHobby = "HobbyDescription" + i;
            String name = "HobbyName" + i;
            String sql = "INSERT INTO HOBBY (DESCRIPTION,NAME) VALUES "
                    + "("
                    + "'" + descriptionHobby + "',"
                    + "'" + name + "'"
                    + ");";
            testData.addTestData(sql);
        }
        //Person
        for (int i = 1; i <= countSample; i++) {
            String email = "PersonEmail" + i;
            String fName = "PersonFirstName" + i;
            String lName = "PersonLastName" + i;
            int address_id = i;
            String sql = "INSERT INTO PERSON (EMAIL,FIRSTNAME,LASTNAME,FK_Address) VALUES "
                    + "("
                    + "'" + email + "',"
                    + "'" + fName + "',"
                    + "'" + lName + "',"
                    + address_id
                    + ");";
            testData.addTestData(sql);
        }
        //Person
        for (int i = 1; i <= countSample; i++) {
            if (i % 4 == 0) {
                String email = "PersonEmail" + i + i;
                String fName = "PersonFirstName" + i + i;
                String lName = "PersonLastName" + i + i;
                int address_id = i;
                String sql = "INSERT INTO PERSON (EMAIL,FIRSTNAME,LASTNAME,FK_Address) VALUES "
                        + "("
                        + "'" + email + "',"
                        + "'" + fName + "',"
                        + "'" + lName + "',"
                        + address_id
                        + ");";
                testData.addTestData(sql);
            }
        }
        //Phone
        for (int i = 1; i <= countSample; i++) {
            String descriptionPhone = "PhoneDescription" + i;
            int number = testDataGeneratePhone.remove(0);
            int person_id_phone = i;
            String sql = "INSERT INTO PHONE (DESCRIPTION,NUMBER,PERSON_ID) VALUES "
                    + "("
                    + "'" + descriptionPhone + "',"
                    + number + ","
                    + person_id_phone
                    + ");";
            testData.addTestData(sql);
        }
        //Phone
        for (int i = 1; i <= countSample; i++) {
            if (i % 4 == 0) {
                String descriptionPhone = "PhoneDescription" + i + i;
                int number = testDataGeneratePhone.remove(0);
                int person_id_phone = i;
                String sql = "INSERT INTO PHONE (DESCRIPTION,NUMBER,PERSON_ID) VALUES "
                        + "("
                        + "'" + descriptionPhone + "',"
                        + number + ","
                        + person_id_phone
                        + ");";
                testData.addTestData(sql);
            }
        }
        //Hobby_Person
        for (int i = 1; i <= countSample; i++) {
            int hobby_id = i;
            int person_id_hobby_person = i;
            String sql = "INSERT INTO PERSON_HOBBY (hobbies_ID,persons_ID) VALUES "
                    + "("
                    + hobby_id + ","
                    + person_id_hobby_person
                    + ");";
            testData.addTestData(sql);
            //Rest %2 = 0
            if (i % 2 == 0) {
                hobby_id = i;
                person_id_hobby_person = i - 1;
                sql = "INSERT INTO PERSON_HOBBY (hobbies_ID,persons_ID) VALUES "
                        + "("
                        + hobby_id + ","
                        + person_id_hobby_person
                        + ");";
                testData.addTestData(sql);
            }
            //Rest %4 = 0
            if (i % 4 == 0) {
                if (i <= countSample) {
                    hobby_id = i + 1;
                }
                person_id_hobby_person = i - 1;
                sql = "INSERT INTO PERSON_HOBBY (hobbies_ID,persons_ID) VALUES "
                        + "("
                        + hobby_id + ","
                        + person_id_hobby_person
                        + ");";
                testData.addTestData(sql);
            }
        }

        return testData;
    }

    public void generateListInt(int countSample) {
        int totalCountSample = countSample * 10;
        int value = findRandomInt(arrInt);

        for (int i = 0; i < totalCountSample; i++) {
            while (!addStringToList(value)) {
                value = findRandomInt(arrInt);
            }

        }
    }

    public int findRandomInt(int[] arr) {
        String str = "";
        for (int i = 0; i < 8; i++) {
            str += String.valueOf(arr[random.nextInt(arr.length)]);
        }
        return Integer.parseInt(str);
    }

    public boolean addStringToList(int phoneNumber) {
        while (!isIntInList(phoneNumber)) {
            testDataGeneratePhone.add(phoneNumber);
            return true;
        }
        return false;
    }

    public boolean isIntInList(int phoneNumber) {
        return testDataGeneratePhone.contains(phoneNumber);
    }

}
