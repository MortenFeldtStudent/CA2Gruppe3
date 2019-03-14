/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author porse
 */
public class InternalServerException extends ExceptionDTO {
    
    public InternalServerException(Throwable ex, int code, boolean debug) {
        super(ex, code, debug);
    }
    
}
