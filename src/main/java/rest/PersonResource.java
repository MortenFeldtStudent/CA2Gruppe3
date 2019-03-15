package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
import exceptions.ExceptionDTO;
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

    @GET
    @Path("/all/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPersonsAndInfo() {
        List<PersonDTO> allInfo = pf.getAllPersonsAndInfo();
        if (allInfo == null) {
            throw new NotFoundException("Could not find any persons.");
        }
        return Response.ok().entity(gson.toJson(allInfo)).build();

    }

    @GET
    @Path("/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int personId) {
        PersonDTO p = null;
        try {
            p = pf.getPersonByID(personId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Response.ok().entity(gson.toJson(p)).build();
    }

    @GET
    @Path("/all/contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsContactInfo() {
        List<PersonDTO> allInfo = pf.getAllPersonsContactInfo();
        if (allInfo == null) {
            throw new NotFoundException("Could not find any persons.");
        }

        return Response.ok()
                .entity(gson.toJson(allInfo)).build();
    }

    @GET
    @Path("/phone/{phonenumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonByPhoneNumber(@PathParam("phonenumber") int phone) {
        PersonDTO person = pf.getInfoFromPersonByPhoneNumber(phone);
        return Response.ok().entity(gson.toJson(person)).build();
    }

    @GET
    @Path("/all/hobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByHobby(@PathParam("hobby") String hobby) {
        List<PersonDTO> persons = pf.getAllPersonsByHobby(hobby);
        return Response.ok().entity(gson.toJson(persons)).build();
    }

    @GET
    @Path("/all/city/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByCity(@PathParam("city") String city) {
        List<PersonDTO> persons = pf.getAllPersonsByCity(city);
        return Response.ok().entity(gson.toJson(persons)).build();
    }

    @GET
    @Path("/contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSinglePersonContactInfo(@PathParam("id") int personId) {
        return Response.ok().entity(gson.toJson(pf.getSinglePersonContactInfo(personId))).build();
    }

    @GET
    @Path("/count/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countPersonsForHobby(@PathParam("hobby") String hobby) {
        Long count = pf.getCountOfPeopleWithGivenHobby(hobby);
        return Response.ok().entity(gson.toJson(count)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deletePersonById(@PathParam("id") int id) {
        pf.deletePersonById(id);
        return Response.ok().build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPersonWithAddressAndPhone(String content, @QueryParam("phone") int phonenumber,
            @QueryParam("pdescription") String pdescription,
            @QueryParam("street") String street,
            @QueryParam("sinfo") String sinfo,
            @QueryParam("zipcode") String zipcode,
            @QueryParam("city") String cityname) {

        Phone phone = new Phone(phonenumber, pdescription);
        Address address = new Address(street, sinfo);
        CityInfo city = new CityInfo(zipcode, cityname);

        PersonDTO person = pf.postPersonWithAddressAndPhone(gson.fromJson(content, Person.class), phone, address, city);
        return Response.ok().entity(gson.toJson(person)).build();
    }

}
