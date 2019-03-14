package rest;

import com.google.gson.Gson;
import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
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
<<<<<<< HEAD
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
=======
>>>>>>> c359629364b13c2a8da2f04540c7436edafc8607
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("person")

public class Ca2gruppe3Resource {

    @Context
    private UriInfo context;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
    PersonFacade pf = new PersonFacade(emf);
    Gson gson = new Gson();

    /**
     * Creates a new instance of Ca2gruppe3Resource
     */
    public Ca2gruppe3Resource() {
    }

    /**
     * Retrieves representation of an instance of rest.Ca2gruppe3Resource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "TEST Joerg Hallo";
    }

    /**
     * PUT method for updating or creating an instance of Ca2gruppe3Resource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Path("/persons/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPersonsAndInfo() {
        List<PersonDTO> allInfo = pf.getAllPersonsAndInfo();
        return Response.ok().entity(gson.toJson(allInfo)).build();
    }

    @GET
    @Path("/person/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int personId) {
        return Response.ok().entity(gson.toJson(pf.getPersonByID(personId))).build();
    }

    @GET
    @Path("/persons/contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsContactInfo(){
        return Response.ok().entity(gson.toJson(pf.getAllPersonsContactInfo())).build();
    }
        
    @GET
    @Path("/person/{phonenumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonByPhoneNumber(@PathParam("phonenumber") int phone) {
        PersonDTO person = pf.getInfoFromPersonByPhoneNumber(phone);
        return Response.ok().entity(gson.toJson(person)).build();
    }

    @GET
    @Path("/persons/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByHobby(@PathParam("hobby") String hobby) {
        List<PersonDTO> persons = pf.getAllPersonsByHobby(hobby);
        return Response.ok().entity(gson.toJson(persons)).build();
    }

    @GET
    @Path("/persons/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByCity(@PathParam("city") String city) {
        List<PersonDTO> persons = pf.getAllPersonsByCity(city);
        return Response.ok().entity(gson.toJson(persons)).build();
    }
    
    @GET
    @Path("/person/contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSinglePersonContactInfo(@PathParam("id") int personId){
        return Response.ok().entity(gson.toJson(pf.getSinglePersonContactInfo(personId))).build();
    }
    
    @GET
    @Path("persons/count/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countPersonsForHobby(@PathParam("hobby") String hobby) {
        Long count = pf.getCountOfPeopleWithGivenHobby(hobby);
        return Response.ok().entity(gson.toJson(count)).build();
    }
    
    @DELETE
    @Path("person/{id}")
    public Response deletePersonById(@PathParam("id") int id) {
        pf.deletePersonById(id);
        return Response.ok().build();
    }
    
    @POST
    @Path("/person/add")
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
