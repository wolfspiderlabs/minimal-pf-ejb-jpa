package test.jsf;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;

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
        
        Iterator<ExceptionQueuedEvent> i = events.iterator();
        
        while (i.hasNext()) {
            ExceptionQueuedEvent event = i.next();
        
        //for (ExceptionQueuedEvent event: events) {
            FacesContext context = FacesContext.getCurrentInstance();
            
            if (context.getPartialViewContext().isAjaxRequest()) {
                String viewId = "error.xhtml";
                ViewHandler viewHandler = context.getApplication().getViewHandler();
                context.setViewRoot(viewHandler.createView(context, viewId));
                context.getPartialViewContext().setRenderAll(true);
                context.renderResponse();
                
                 /*try {
                    System.out.println("HERHER");

                    UIViewRoot viewRoot = context.getViewRoot();
                    ViewHandler viewHandler = context.getApplication().getViewHandler();                
                    ViewDeclarationLanguage vdl = viewHandler.getViewDeclarationLanguage(context, viewId);
                    vdl.buildView(context, viewRoot);
                    context.getApplication().publishEvent(context, PreRenderViewEvent.class, viewRoot);
                    vdl.renderView(context, viewRoot);
                    context.responseComplete();
                } catch (IOException e) {
                    System.out.println("IOException!!!");
                }*/
                    
                i.remove();
                getWrapped().handle();
                return;
            } else {
                //context.getExternalContext().redirect("/error.xhtml");
                return;
            }
        }
    }
}
