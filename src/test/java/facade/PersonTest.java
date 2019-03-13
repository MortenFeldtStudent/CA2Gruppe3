package facade;

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
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jörg
 */
public class PersonTest  {
    
}

//    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test");
//    private PersonFacade facade = new PersonFacade(emf);
//    // Create Lists  for testing
//    private List<Person> personList = new ArrayList<>();
//    private List<Hobby> hobbyList = new ArrayList<>();
//    private List<Phone> phoneList = new ArrayList<>();
//    private List<CityInfo> cityList = new ArrayList<>();
//    private List<Address> addressList = new ArrayList<>();
//
//    // Create Test Persons entities   
//    Person person1 = new Person("oertel@gmail.com", "Jörg", "Oertel");
//    Person person2 = new Person("porse@gmail.com", "Rasmus", "Porse");
//    Person person3 = new Person("rojahn@gmail.com", "Nikolai", "Rojahn");
//    Person person4 = new Person("feldt@gmail.com", "Morten", "Feldt");
//    // Create Test Phone entities
//    Phone phone1 = new Phone(12345, "Home");
//    Phone phone2 = new Phone(56789, "Privat");
//    Phone phone3 = new Phone(74125, "Mobil");
//    Phone phone4 = new Phone(89632, "Landline");
//    // Create Test Hobby entities
//    Hobby hobby1 = new Hobby("football", "VFB Stuttgart");
//    Hobby hobby2 = new Hobby("boardgames", "Cafe Bastard");
//    Hobby hobby3 = new Hobby("running", "Copenhagen Marathon");
//
////    public PersonTest() {
////        personList.add(person1);
////        personList.add(person2);
////        personList.add(person3);
////        personList.add(person4);
////        //
////        phoneList.add(phone1);
////        phoneList.add(phone2);
////        phoneList.add(phone3);
////        phoneList.add(phone4);
////        //
////        hobbyList.add(hobby1);
////        hobbyList.add(hobby2);
////        hobbyList.add(hobby3);
////        //
////    }
//    @Before
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            // Start Transaction
//            em.getTransaction().begin();
//            //
////            em.createQuery("delete from CityInfo").executeUpdate();
////            em.createQuery("delete from Address").executeUpdate();
//            em.createQuery("delete from Hobby").executeUpdate();
//            em.createQuery("delete from Phone").executeUpdate();
//            em.createQuery("delete from Person").executeUpdate();
//            //Persist Person to DataBase
//            em.persist(person1);
//            em.persist(person2);
//            em.persist(person3);
//            em.persist(person4);
//            //Persist Phone to DataBase
//            em.persist(phone1);
//            em.persist(phone2);
//            em.persist(phone3);
//            em.persist(phone4);
//            //Persist Hobbies to Database
//            em.persist(hobby1);
//            em.persist(hobby2);
//            em.persist(hobby3);
//            // Add Person to Phone
//            phone1.setPerson(person1);
//            phone2.setPerson(person2);
//            phone3.setPerson(person3);
//            phone4.setPerson(person4);
//            person1.addPhone(phone1);
//            person2.addPhone(phone2);
//            person3.addPhone(phone3);
//            person4.addPhone(phone4);
//            //Add Person to Hobbies
//            person1.setHobbies(hobby1);
//            person1.setHobbies(hobby2);
//            person3.setHobbies(hobby3);
//            person2.setHobbies(hobby3);
//            person4.setHobbies(hobby3);
//            // Add Hobbies to Person
//            hobby1.addPersons(person1);
//            hobby2.addPersons(person1);
//            hobby3.addPersons(person3);
//            hobby3.addPersons(person2);
////            hobby3.addPersons(person4);
//            //
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//
//    }

//    @Test
//    @Override
//    public void getInfoFromPersonByPhoneNumberTest() {
//         Arrange
//        PersonDTO p = facade.getInfoFromPersonByPhoneNumber(phoneList.get(1).getNumber());
//        System.out.println(p);
//         Act
//        String expected = phoneList.get(1).getPerson().getEmail();
//        String actual = p.getEmail();
//         Assert
//        Assert.assertEquals(expected.toLowerCase(), actual);
//
//
//    }
//
//    @Test
//    @Override
//    public void getAllPersonsByHobbyTest() {
//        // Arrange
//        String hobby = "running";
//        List<PersonDTO> personDTOList = facade.getAllPersonsByHobby(hobby.toLowerCase());
//        // Act
//        int actual = personDTOList.size();
//        int expectual = 3;
//        // Assert
//        Assert.assertEquals(expectual, actual);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//
//    }
//
//    @Test
//    @Override
//    public void getAllPersonsByCityTest() {
////        // Arrange
////        String cityName = cityList.get(0).getCity();
////        List<PersonDTO> p = facade.getAllPersonsByCity(cityName);
////        // Act
////        String actual = cityName;
////        String expectual = p.get(0).getAddress().getCity().getCity();
////        // Assert
////        Assert.assertEquals(expectual, actual);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//
//    }
//
//    @Test
//    @Override
//    public void getCountOfPeopleWithGivenHobbyTest() {
//        // Arrange
//        // Act
//        // Assert
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Test
//    @Override
//    public void getAllZipFromCountryTest() {
//        // Arrange
//        // Act
//        // Assert
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Test
//    @Override
//    public void getPersonByIDTest() {
//        // Arrange
//        // Act
//        // Assert
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}

