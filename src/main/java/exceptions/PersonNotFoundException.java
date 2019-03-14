package exceptions;

import com.sun.jersey.api.Responses;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class PersonNotFoundException extends WebApplicationException {

   
    public PersonNotFoundException(String message) {
        super(Response.status(Responses.NOT_FOUND).entity(message).type("text/plain").build());
    }

}
