package facade;

import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
import exceptions.PersonNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public PersonFacade() {
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
        Query query = em.createQuery("SELECT NEW dto.PersonDTO (p) FROM Person p JOIN p.hobbies hb WHERE hb.name = :name ORDER BY hb.name ASC");
        query.setParameter("name", hobby);
        List<PersonDTO> list = query.getResultList();

        return list;
    }

    @Override
    public List<PersonDTO> getAllPersonsByCity(String cityName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PersonDTO (p) FROM Person p JOIN p.address ad WHERE ad.city.city = :city");
        return query.setParameter("city", cityName).getResultList();

    }

    @Override
    public long getCountOfPeopleWithGivenHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(p.id) FROM Person p JOIN p.hobbies hb WHERE hb.name = :name");
        query.setParameter("name", hobby);
        long count = (long) query.getSingleResult();
        return count;
    }

    @Override
    public List<String> getAllZipCodes() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.CityInfoDTO (c) FROM CityInfo c");
        return query.getResultList();
    }

    @Override
    public PersonDTO getPersonByID(int personId) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PersonDTO (p) FROM Person p WHERE p.id = :id");
        query.setParameter("id", personId);
        PersonDTO p = null;
        try {
            p = (PersonDTO) query.getSingleResult();
        } catch (Exception ex) {
            throw new PersonNotFoundException("Person does not exist.");
        }
        return p;
    }

    @Override
    public List<PersonDTO> getAllPersonsAndInfo() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PersonDTO (p) FROM Person p");
        List<PersonDTO> list = query.getResultList();
        return list;
    }

    @Override
    public PersonDTO postPersonWithAddressAndPhone(Person person, Phone phone, Address address, CityInfo city) {
        EntityManager em = emf.createEntityManager();
        address.setCity(city);
        person.addPhone(phone);
        person.setAddress(address);

        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }

    @Override
    public List<PersonDTO> getAllPersonsContactInfo() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT (p) FROM Person p");
        List<Person> personList = query.getResultList();
        List<PersonDTO> personDTOs = new ArrayList();
        for (Person p : personList) {
            personDTOs.add(new PersonDTO(p.getId(), p.getEmail(), p.getFirstName(), p.getLastName(), p.getPhones(), p.getAddress()));
        }
        return personDTOs;
    }

    @Override
    public PersonDTO getSinglePersonContactInfo(int id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PersonDTO(p) FROM Person p WHERE p.id = :id");
        query.setParameter("id", id);
        return (PersonDTO) query.getSingleResult();
    }

    @Override
    public void deletePersonById(int id) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        Person person = null;
        
        try {
        person = (Person) em.createQuery("SELECT p FROM Person p WHERE p.id = :id").setParameter("id", id).getSingleResult();
        } catch (Exception ex) {
            throw new PersonNotFoundException("Person with id: " + id + " does not exist.");
        }
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @Override
    public PersonDTO editPerson(Person p){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return new PersonDTO(p);
        } finally {
            em.close();
        }
    }
    
    @Override
    public Person getPersonByIdToEdit(int personId) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        query.setParameter("id", personId);
        Person p = null;
        try {
         p = (Person) query.getSingleResult();
        } catch (Exception ex) {
            throw new PersonNotFoundException("Person with id: " + personId + " does not exist.");
        }
        return p;
    }
}
