/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.CityInfoDTO;
import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author oerte
 */
public class PersonTest implements interfaces.IPersonTestFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test", null);
    private PersonFacade facade = new PersonFacade(emf);
    //Create Lists  for testing
    private List<Person> personList = new ArrayList<>();
    private List<Phone> phoneList = new ArrayList<>();
    private List<Hobby> hobbyList = new ArrayList<>();
    private List<Address> addressList = new ArrayList<>();
    private List<CityInfo> cityList = new ArrayList<>();

    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        try {
            // Start Transaction
            em.getTransaction().begin();
            // Delete Tables from data
            em.createQuery("delete from Phone").executeUpdate();
            em.createQuery("delete from Person").executeUpdate();
            em.createQuery("delete from Address").executeUpdate();
            em.createQuery("delete from CityInfo").executeUpdate();
            em.createQuery("delete from Hobby").executeUpdate();
            // Create Test Persons entities   
            Person person1 = new Person("oertel@gmail.com", "Jörg", "Oertel");
            Person person2 = new Person("porse@gmail.com", "Rasmus", "Porse");
            Person person3 = new Person("rojahn@gmail.com", "Nikolai", "Rojahn");
            Person person4 = new Person("feldt@gmail.com", "Morten", "Feldt");
            // Create Test Phone entities
            Phone phone1 = new Phone(12345, "Home");
            Phone phone2 = new Phone(56789, "Privat");
            Phone phone3 = new Phone(74125, "Mobil");
            Phone phone4 = new Phone(89632, "Landline");
            // Create Test Hobby entities
            Hobby hobby1 = new Hobby("football", "VFB Stuttgart");
            Hobby hobby2 = new Hobby("boardgames", "Cafe Bastard");
            Hobby hobby3 = new Hobby("running", "Copenhagen Marathon");
            // Create Test City entities
            CityInfo city1 = new CityInfo("2800", "Lyngby");
            CityInfo city2 = new CityInfo("3800", "Stuttgart");
            CityInfo city3 = new CityInfo("4200", "Copenhagen");
            CityInfo city4 = new CityInfo("8900", "Lissabon");
            // Create Test Address entities
            Address address1 = new Address("BaunehøjVej 6", "Vej");
            Address address2 = new Address("Lyngvej 98", "Street");
            Address address3 = new Address("Carlshøjvej 52", "Autobahn");
            Address address4 = new Address("Hovedvej 12", "Motorvej");
            //
            personList.add(person1);
            personList.add(person2);
            personList.add(person3);
            personList.add(person4);

            phoneList.add(phone1);
            phoneList.add(phone2);
            phoneList.add(phone3);
            phoneList.add(phone4);
            //
            personList.add(person1);
            personList.add(person2);
            personList.add(person3);
            personList.add(person4);
            //
            phoneList.add(phone1);
            phoneList.add(phone2);
            phoneList.add(phone3);
            phoneList.add(phone4);
            //
            hobbyList.add(hobby1);
            hobbyList.add(hobby2);
            hobbyList.add(hobby3);
            //
            cityList.add(city1);
            cityList.add(city2);
            cityList.add(city3);
            cityList.add(city4);
            //
            addressList.add(address1);
            addressList.add(address2);
            addressList.add(address3);
            addressList.add(address4);
            //Persist Person to DataBase
            em.persist(person1);
            em.persist(person2);
            em.persist(person3);
            em.persist(person4);
            //Persist Phone to DataBase
            em.persist(phone1);
            em.persist(phone2);
            em.persist(phone3);
            em.persist(phone4);
            //Persist Hobbies to Database
            em.persist(hobby1);
            em.persist(hobby2);
            em.persist(hobby3);
            //Persist Address to DataBase
            em.persist(address1);
            em.persist(address2);
            em.persist(address3);
            em.persist(address4);
            //Persist City to DataBase
            em.persist(city1);
            em.persist(city2);
            em.persist(city3);
            em.persist(city4);
            // Add Phone to Person and Person to Phone
            person1.addPhone(phone1);
            person2.addPhone(phone2);
            person3.addPhone(phone3);
            person4.addPhone(phone4);
            //Add Person to Hobbies and add Hobbies to Person
            person1.addHobby(hobby1);
            person1.addHobby(hobby2);
            person3.addHobby(hobby3);
            person2.addHobby(hobby3);
            person4.addHobby(hobby3);
            //Add Address to Person
            person1.setAddress(address1);
            person2.setAddress(address2);
            person3.setAddress(address3);
            person4.setAddress(address4);
            //Add City to Address
            address1.setCity(city1);
            address2.setCity(city2);
            address3.setCity(city3);
            address4.setCity(city4);

            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

    @Test
    @Override
    public void getInfoFromPersonByPhoneNumberTest() {
        //Arrange
        PersonDTO p = facade.getInfoFromPersonByPhoneNumber(phoneList.get(0).getNumber());
        //Act
        String expected = phoneList.get(0).getPerson().getEmail();
        String actual = p.getEmail();
        // Assert
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());

    }

    @Test
    @Override
    public void getAllPersonsByHobbyTest() {
        // Arrange
        String hobby = "running";
        List<PersonDTO> personDTOList = facade.getAllPersonsByHobby(hobby.toLowerCase());
        // Act
        int actual = personDTOList.size();
        int expectual = 3;
        // Assert
        Assert.assertEquals(expectual, actual);

    }

    @Test
    @Override
    public void getAllPersonsByCityTest() {
        // Arrange
        String cityName = cityList.get(0).getCity();
        List<PersonDTO> p = facade.getAllPersonsByCity(cityName);
        // Act
        String actual = cityName;
        String expected = p.get(0).getAddress().getCity().getCity();
        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    @Override
    public void getCountOfPeopleWithGivenHobbyTest() {
        // Arrange
        String hobby = "running";
        long count = facade.getCountOfPeopleWithGivenHobby(hobby);
        // Act
        long actual = count;
        long expected = 3;
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Override
    public void getAllZipCodesTest() {
        // Arrange
        List<String> zipCodes = facade.getAllZipCodes();
        // Act
        int actual = zipCodes.size();
        int expected = cityList.size();
        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    @Override
    public void getPersonByIDTest() {
        // Arrange
        int personId = personList.get(0).getId();
        PersonDTO personDto = facade.getPersonByID(personId);
        // Act
        int actual = personDto.getId();
        int expected = personId;
        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    @Override
    public void getAllPersonsAndInfoTest() {
        // Arrange
        List<PersonDTO> personList = facade.getAllPersonsAndInfo();
        for (PersonDTO personDTO : personList) {
            System.out.println(personDTO.toStringAll());
        }
        // Act
        int actual = personList.size();
        int expected = 4;
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Override
    public void postPersonWithAddressAndPhone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
