package facade;

import dto.PersonDTO;
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
 * @author jörg
 */
public class PersonTest implements interfaces.IPersonTestFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test", null);
    private static PersonFacade facade = new PersonFacade(emf);
    // Create Lists  for testing
    List<Person> personList = new ArrayList<>();
    List<Hobby> hobbyList = new ArrayList<>();
    List<Phone> phoneList = new ArrayList<>();
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

    public PersonTest() {
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

    }

    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        try {
            // Start Transaction
            em.getTransaction().begin();
            //
//            em.createQuery("delete from Hobby").executeUpdate();
            em.createQuery("delete from Hobby").executeUpdate();
            em.createQuery("delete from Phone").executeUpdate();
            em.createQuery("delete from Person").executeUpdate();

            // Add Person to Phone
            phone1.addPerson(person1);
            phone2.addPerson(person2);
            phone3.addPerson(person3);
            phone4.addPerson(person4);
            //
//            person1.addPhoneNumber(phone1);
//            person2.addPhoneNumber(phone2);
//            person3.addPhoneNumber(phone3);
//            person4.addPhoneNumber(phone4);
//            // Add Person to Hobbies
//            person1.addHobbies(hobby1);
//            person1.addHobbies(hobby2);
//            person3.addHobbies(hobby3);
//            person2.addHobbies(hobby3);
//            person4.addHobbies(hobby3);
////            // Add Hobbies to Person
//            hobby1.addPersons(person1);
//            hobby2.addPersons(person1);
//            hobby3.addPersons(person3);
//            hobby3.addPersons(person2);
//            hobby3.addPersons(person4);
            // Persist Person to DataBase
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
//            em.persist(hobby1);
//            em.persist(hobby2);
//            em.persist(hobby3);

            // Commit Persist
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

    @Test
    @Override
    public void getInfoFromPersonByPhoneNumberTest() {
        // Arrange
        PersonDTO p = facade.getInfoFromPersonByPhoneNumber(phoneList.get(1).getNumber());
        System.out.println(p);
        // Act
        String expected = phoneList.get(1).getPerson().getEmail();
        String actual = p.getEmail();
        // Assert
        Assert.assertEquals(expected.toLowerCase(), actual);

    }

    @Test
    @Override
    public void getAllPersonsByHobbyTest() {
//        // Arrange
//        String hobby = "football";
//        List<PersonDTO> personDTOList = facade.getAllPersonsByHobby(hobby.toLowerCase());
//        // Act
//
//        // Assert
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Test
    @Override
    public void getPersonByCityTest() {
        // Arrange
        // Act
        // Assert
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    @Override
    public void getCountOfPeopleWithGivenHobbyTest() {
        // Arrange
        // Act
        // Assert
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    @Override
    public void getAllZipFromCountryTest() {
        // Arrange
        // Act
        // Assert
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    @Override
    public void getPersonByIDTest() {
        // Arrange
        // Act
        // Assert
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
