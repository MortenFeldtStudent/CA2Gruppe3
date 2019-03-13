/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.PersonDTO;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.transform.Source;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author oerte
 */
public class PersonTestNew implements interfaces.IPersonTestFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test", null);
    private PersonFacade facade = new PersonFacade(emf);

    
    private List<Person> personList = new ArrayList<>();
    private List<Phone> phoneList = new ArrayList<>();



    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        try {
            // Start Transaction
            em.getTransaction().begin();
            //
            em.createQuery("delete from Phone").executeUpdate();
            em.createQuery("delete from Person").executeUpdate();
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
            // Add Person to Phone
            phone1.setPerson(person1);
            phone2.setPerson(person2);
            phone3.setPerson(person3);
            phone4.setPerson(person4);
            person1.addPhone(phone1);
            person2.addPhone(phone2);
            person3.addPhone(phone3);
            person4.addPhone(phone4);
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
        for (Person person : personList) {
            System.out.println(person);
        }
        // Assert
        Assert.assertEquals(expected.toLowerCase(), actual);

    }

    @Override
    public void getAllPersonsByHobbyTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllPersonsByCityTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCountOfPeopleWithGivenHobbyTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllZipFromCountryTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPersonByIDTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
