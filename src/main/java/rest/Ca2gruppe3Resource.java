package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("ca2gruppe3")
public class Ca2gruppe3Resource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Ca2gruppe3Resource
     */
    public Ca2gruppe3Resource() {
    }

    /**
     * Retrieves representation of an instance of rest.Ca2gruppe3Resource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "TEST Joerg Hallo";
    }

    /**
     * PUT method for updating or creating an instance of Ca2gruppe3Resource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
