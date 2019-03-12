package facade;

import entity.Person;
import entity.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jörg
 */
public class PersonTest implements interfaces.IPersonTestFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test", null);
    private static PersonFacade facade = new PersonFacade(emf);

    public PersonTest() {
    }

    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        // Create Test Person entities
        Person p1 = new Person("oertel@gmail.com", "Jörg", "Oertel");
        Person p2 = new Person("porse@gmail.com", "Rasmus", "Porse");
        Person p3 = new Person("rojahn@gmail.com", "Nikolai", "Rojahn");
        Person p4 = new Person("feldt@gmail.com", "Morten", "Feldt");
        // Create Test Phone entities
        Phone ph1 = new Phone(12345, "Home");
        Phone ph2 = new Phone(56789, "Privat");
        Phone ph3 = new Phone(74125, "Mobil");
        Phone ph4 = new Phone(89632, "Landline");

        // Add Person to Phone
        ph1.addPerson(p1);
        ph2.addPerson(p2);
        ph3.addPerson(p3);
        ph4.addPerson(p4);

        try {
            // Start Transaction
            em.getTransaction().begin();
            // Persist Person to Tset DataBase
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            //Persist Phone to DataBase
            em.persist(ph1);
            em.persist(ph2);
            em.persist(ph3);
            em.persist(ph4);
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
        // Act
        // Assert
    }

    @Test
    @Override
    public void getAllPersonsByHobbyTest() {
        // Arrange
        // Act
        // Assert
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
