package facade;

import dto.PersonDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
    public PersonDTO getInfoFromPersonByPhoneNumber(int phoneNumber) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PersonDTO (p) FROM Person p JOIN p.phones ph WHERE ph.number = :phoneNumber");
        return (PersonDTO) query.setParameter("phoneNumber", phoneNumber).getSingleResult();
    }

    @Override
    public List<PersonDTO> getAllPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO getPersonByCity(String cityName) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getCountOfPeopleWithGivenHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonDTO> getAllZipFromCountry(int zipCode) {
        EntityManager em = emf.createEntityManager();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO getPersonByID(int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
