package facade;

import dto.PersonDTO;
import entity.Address;
import entity.City;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author jörg
 */
public class PersonFacade implements interfaces.IPersonFacade {

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
        Query query = em.createQuery("SELECT NEW dto.PersonDTO FROM Hobby h WHERE h.name = :name ORDER BY h.name ASC");
        query.setParameter("name", hobby);
        List<PersonDTO> list = query.getResultList();

        return list;
    }

    @Override
    public PersonDTO getPersonByCity(String cityName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PersonDTO FROM CityInfo c WHERE c.city = :city");
        return (PersonDTO) query.setParameter("city", cityName).getSingleResult();
         
    }

    @Override
    public long getCountOfPeopleWithGivenHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(p.id) FROM Person p JOIN Hobby h WHERE h.name = :name");
        query.setParameter("name", hobby);
        long count = (long) query.getSingleResult();
        return count;
    }

    @Override
    public List<PersonDTO> getAllZipFromCountry(int zipCode) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c.ZipCode FROM CityInfo c");
        return query.getResultList();
    }

    @Override
    public PersonDTO getPersonByID(int personId) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.Person FROM Person p WHERE p.id = :id");
        query.setParameter("id", personId);
        return (PersonDTO) query.getSingleResult();
    }

    public PersonDTO postPersonWithAddressAndPhone(Person person, Phone phone, Address address, City city) {
        EntityManager em = emf.createEntityManager();
        
        person.addPhone(phone);
        return null;
        
    }

}
