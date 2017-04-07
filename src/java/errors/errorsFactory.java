/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author shibo
 */
public class errorsFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory parent;

    public errorsFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {

        return new Errors(parent.getExceptionHandler()); 
    }

}
