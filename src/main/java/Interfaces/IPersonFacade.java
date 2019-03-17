/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
import exceptions.PersonNotFoundException;
import java.util.List;

/**
 *
 * @author jörg
 */
public interface IPersonFacade {

    //Get information about a person (address, hobbies etc) given a phone number.
    public List<PersonDTO> getInfoFromPersonByPhoneNumber(int phoneNumber);
    
    //Get all persons with a given hobby
    public List<PersonDTO> getAllPersonsByHobby(String hobby);
    
    //Get all persons living in a given city
    public List<PersonDTO> getAllPersonsByCity(String cityName);
    
    //Get the count of people with a given hobby
    public long getCountOfPeopleWithGivenHobby(String hobby);
    
    // Get a list of all zip codes in Denmark
    public List<String> getAllZipCodes();
    
    // Get PersonDTO By Id
    public PersonDTO getPersonByID(int personId) throws PersonNotFoundException;
    
    // Get all persons with associated information as DTO objects.
    public List<PersonDTO> getAllPersonsAndInfo();
    
    // Post a Person with Addresss and Phone
    public PersonDTO postPersonWithAddressAndPhone(Person person, Phone phone, Address address, CityInfo city);
    
    //  GET id, firstName, lastName, email, addresse, phone
    public List<PersonDTO> getAllPersonsContactInfo();
    
    // GET id, firstName, lastName, email, address, phone 
    public PersonDTO getSinglePersonContactInfo(int id);
     
    // Returns error if the person does not exist. 
    public void deletePersonById(int id) throws PersonNotFoundException;
     
    // Takes firstName, lastName and email as input parameters.  
    public PersonDTO editPerson(Person p);
     
    // Get Person object by ID
    public Person getPersonByIdToEdit(int personId) throws PersonNotFoundException;
    
}