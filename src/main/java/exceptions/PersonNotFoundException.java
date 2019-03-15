package exceptions;


public class PersonNotFoundException extends Exception {

   
    public PersonNotFoundException(String message) {
        super(message);
    }
//    public PersonNotFoundException(String message) {
//        super(Response.status(Responses.NOT_FOUND).entity(message).type("text/plain").build());
//    }

}
