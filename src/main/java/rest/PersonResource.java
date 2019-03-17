package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
import exceptions.ExceptionDTO;
import exceptions.InputException;
import exceptions.PersonNotFoundException;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
    PersonFacade pf = new PersonFacade(emf);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public PersonResource() {
    }

    /**
     * A test that shows an error message, error code and the stacktrace.
     *
     * @return exDTO(e, 406, true)
     */
    @GET
    @Path("/test/ex")
    @Produces(MediaType.APPLICATION_JSON)
    public String testExceptionDTO() {
        try {
            throw new NotFoundException("Person doesn't exist!");
        } catch (NotFoundException e) {
            ExceptionDTO exDTO = new ExceptionDTO(e, 406, true);
            return gson.toJson(exDTO);
        }

    }

    /**
     * Retrieves a list with all persons and information build to json.
     *
     * @return ok response and the list build as Json.
     * @throws PersonNotFoundException
     */
    @GET
    @Path("/all/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPersonsAndInfo() throws PersonNotFoundException {
        List<PersonDTO> allInfo = pf.getAllPersonsAndInfo();
        return Response.ok().entity(gson.toJson(allInfo)).build();

    }

    /**
     * Retrieves all information of selected person by the Id parameter.
     *
     * @param personId Specific person id - Int
     * @return One person and belonging information.
     */
    @GET
    @Path("/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int personId) {
        PersonDTO p = null;
        try {
            p = pf.getPersonByID(personId);
        } catch (PersonNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(ex.getMessage())).build();
        }
        return Response.ok().entity(gson.toJson(p)).build();
    }

    /**
     * Retrieves all persons and their contact information only.
     *
     * @return A list of all persons with name, address, phone, email.
     */
    @GET
    @Path("/all/contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsContactInfo() {
        List<PersonDTO> allInfo = pf.getAllPersonsContactInfo();
        return Response.ok()
                .entity(gson.toJson(allInfo)).build();
    }

    /**
     * Retrieves a person by the phone parameter.
     *
     * @param phone Belonging to the desired person. - Int
     * @return A person and all information.
     */
    @GET
    @Path("/phone/{phonenumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonByPhoneNumber(@PathParam("phonenumber") int phone) {
        List<PersonDTO> person =  pf.getInfoFromPersonByPhoneNumber(phone);
        return Response.ok().entity(gson.toJson(person)).build();
    }

    /**
     * Retrieves a list of persons with a specific hobby.
     *
     * @param hobby Name of hobby - String
     * @return A list of persons and all belonging information.
     */
    @GET
    @Path("/all/hobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByHobby(@PathParam("hobby") String hobby) {
        List<PersonDTO> persons = pf.getAllPersonsByHobby(hobby);
        return Response.ok().entity(gson.toJson(persons)).build();
    }

    /**
     * Retrieves a list of persons sorted by specific city.
     *
     * @param city Name of city - String
     * @return List of persons and all their information.
     */
    @GET
    @Path("/all/city/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByCity(@PathParam("city") String city) {
        List<PersonDTO> persons = pf.getAllPersonsByCity(city);
        return Response.ok().entity(gson.toJson(persons)).build();
    }

    /**
     * Retrieves a single person and all contact information.
     *
     * @param personId Specific personId - Int
     * @return One person and all contact info(Name, email, address, phone)
     */
    @GET
    @Path("/contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSinglePersonContactInfo(@PathParam("id") int personId) {
        return Response.ok().entity(gson.toJson(pf.getSinglePersonContactInfo(personId))).build();
    }

    /**
     * Counts how many persons there are for a given hobby.
     *
     * @param hobby Name of hobby
     * @return Integer of how many persons for a hobby.
     */
    @GET
    @Path("/count/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countPersonsForHobby(@PathParam("hobby") String hobby) {
        Long count = pf.getCountOfPeopleWithGivenHobby(hobby);
        return Response.ok().entity(gson.toJson(count)).build();
    }

    /**
     * Removes a person and all belonging information.
     *
     * @param id Id for the person that is to be removed.
     * @return Ok response and Id for the deleted person.
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deletePersonById(@PathParam("id") int id) {
        try {
            pf.deletePersonById(id);
        } catch (PersonNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(ex.getMessage())).build();
        }
        return Response.ok().entity(gson.toJson("Person with id: " + id + " was successfully deleted")).build();
    }

    /**
     * Adds a person with given personal information.
     *
     * @param content Data in Json format.
     * @param phonenumber - Phone number
     * @param pdescription - Phone description
     * @param street - Name of street and number
     * @param sinfo - Type of street
     * @param zipcode - Zipcode of city
     * @param cityname - Name of city
     * @return Builds the information.
     * @throws InputException - If the given information is invalid ie. letters
     * instead of numbers.
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPersonWithAddressAndPhone(String content,
            @QueryParam("phone") int phonenumber,
            @QueryParam("pdescription") String pdescription,
            @QueryParam("street") String street,
            @QueryParam("sinfo") String sinfo,
            @QueryParam("zipcode") String zipcode,
            @QueryParam("city") String cityname) throws InputException {
        try {
            Phone phone = new Phone(phonenumber, pdescription);
            Address address = new Address(street, sinfo);
            CityInfo city = new CityInfo(zipcode, cityname);
            PersonDTO person = pf.postPersonWithAddressAndPhone(gson.fromJson(content, Person.class), phone, address, city);
            return Response.ok().entity(gson.toJson(person)).build();
        } catch (Exception ex) {
            throw new InputException("One or more inputs are not correct.");
        }
    }

    /**
     * Used to edit information on an existing person.
     *
     * @param content Data in Json format
     * @param id Person id
     * @return The edited person object.
     * @throws PersonNotFoundException If the given id does not correlate to an
     * existing person, the exception is thrown.
     */
    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPerson(String content, @PathParam("id") int id) throws PersonNotFoundException {
        Person newPerson = gson.fromJson(content, Person.class);
        Person person = null;
        try {
            person = pf.getPersonByIdToEdit(id);
        } catch (PersonNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(ex.getMessage())).build();
        }
        if (!newPerson.getFirstName().isEmpty()) {
            person.setFirstName(newPerson.getFirstName());
        }
        if (!newPerson.getLastName().isEmpty()) {
            person.setLastName(newPerson.getLastName());
        }
        if (!newPerson.getEmail().isEmpty()) {
            person.setEmail(newPerson.getEmail());
        }
        return Response.ok().entity(gson.toJson(pf.editPerson(person))).build();
    }

}
