package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
/**
 * 
 * @author jörg
 */
public class PersonFacade implements interfaces.IPersonFacade{
    
    private EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    

    @Override
    public Person getInfoFromPersonByPhoneNumber(int phoneNumber) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getAllPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPersonByCity(String cityName) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getCountOfPeopleWithGivenHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getAllZipFromCountry(int zipCode) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPersonByID(int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
