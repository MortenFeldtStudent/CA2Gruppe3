/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.PersonDTO;
import entity.Person;


/**
 *
 * @author jörg
 */
public interface IPersonTestFacade {

    //Get information about a person (address, hobbies etc) given a phone number.
    public void getInfoFromPersonByPhoneNumberTest();

    //Get all persons with a given hobby
    public void getAllPersonsByHobbyTest();

    //Get all persons living in a given city
    public void getAllPersonsByCityTest();

    //Get the count of people with a given hobby
    public void getCountOfPeopleWithGivenHobbyTest();

    // Get a list of all zip codes in Denmark
    public void getAllZipCodesTest();

    // Get a Person by Id
    public void getPersonByIDTest();
    
     // Get all persons and information
    public void getAllPersonsAndInfoTest();
    
    // Post a Person with Addresss and Phone
    public void postPersonWithAddressAndPhone();
    
    // GET id, firstName, lastName, email, addresse, phone
    public void getAllPersonsContactInfoTest();
    
    // GET id, firstName, lastName, email, address, phone
    public void getSinglePersonContactInfoTest();
    
    // Returns error if the person does not exist. 
    public void deletePersonByIdTest();
    
    // Takes firstName, lastName and email as input parameters.  
    public void editPersonTest();

}
