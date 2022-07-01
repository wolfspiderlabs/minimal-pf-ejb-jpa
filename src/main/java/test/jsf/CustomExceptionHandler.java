package test.jsf;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import static org.primefaces.component.contextmenu.ContextMenuBase.PropertyKeys.event;

/**
 *
 * @author empyreanx
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    private final ExceptionHandler wrapped;

    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }
    
    @Override
    public void handle() throws FacesException {
        Iterable<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents();
        
        for (ExceptionQueuedEvent event: events) {
            FacesContext context = FacesContext.getCurrentInstance();
            
            if (context.getPartialViewContext().isAjaxRequest()) {
                            System.out.println("HERHER");

                String viewId = "/error.xhtml";
                ViewHandler viewHandler = context.getApplication().getViewHandler();
                context.setViewRoot(viewHandler.createView(context, viewId));
                context.getPartialViewContext().setRenderAll(true);
                context.renderResponse();
                return;
            } else {
                //context.getExternalContext().redirect("/error.xhtml");
                return;
            }
        }
    }
}
