package facade;

import entity.Person;
import java.util.List;

public class PersonFacade implements interfaces.IPersonFacade{

    @Override
    public Person getInfoFromPersonByPhoneNumber(int phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getAllPersonsByHobby(String hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPersonByCity(String cityName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getCountOfPeopleWithGivenHobby(String hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getAllZipFromCountry(int zipCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
