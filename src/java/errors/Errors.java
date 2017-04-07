/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 *
 * @author shibo
 */
public class Errors extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    public Errors(ExceptionHandler wrapped) {
        this.wrapped = wrapped;

    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;

    }

    @Override
    public void handle() throws FacesException {

        Iterator i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) i.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            Throwable throwable = context.getException();
            try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
                navigationHandler.handleNavigation(facesContext, null, "/faces/error.xhtml");
                facesContext.renderResponse();
            } finally {
                i.remove();
            }
        }
        getWrapped().handle();  
    }

}
