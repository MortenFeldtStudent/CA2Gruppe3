/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Person;
import java.util.List;

/**
 *
 * @author jörg
 */
public interface IPersonFacade {

    //Get information about a person (address, hobbies etc) given a phone number.
    public Person getInfoFromPersonByPhoneNumber(int phoneNumber);
    
    //Get all persons with a given hobby
    public List<Person> getAllPersonsByHobby(String hobby);
    
    //Get all persons living in a given city
    public Person getPersonByCity(String cityName);
    
    //Get the count of people with a given hobby
    public long getCountOfPeopleWithGivenHobby(String hobby);
    
    // Get a list of all zip codes in Denmark
    public List<Person> getAllZipFromCountry(int zipCode);
    
    // Get Person By Id
    public Person getPersonByID(int personId);
    
    
    
}