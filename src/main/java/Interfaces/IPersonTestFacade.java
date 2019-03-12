/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

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
    public void getPersonByCityTest();

    //Get the count of people with a given hobby
    public void getCountOfPeopleWithGivenHobbyTest();

    // Get a list of all zip codes in Denmark
    public void getAllZipFromCountryTest();

    // Get a Person by Id
    public void getPersonByIDTest();

}
