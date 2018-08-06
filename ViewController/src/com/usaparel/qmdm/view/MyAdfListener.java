package com.usaparel.qmdm.view;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import javax.faces.event.PhaseListener;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;


public class MyAdfListener implements PhaseListener {
    public MyAdfListener() {
    }


    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        // TODO Implement this method
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        // TODO Implement this method
//        System.out.println(phaseEvent.getPhaseId().toString()+"-"+ getGoshtImage().getClientId());
//        BindingContainer bc = getBindings();
//        if (phaseEvent.getPhaseId().toString().equals("UPDATE_MODEL_VALUES 4")) {
//            AttributeBinding abPaid = (AttributeBinding)bc.get("IsPaid");
//            System.out.println(abPaid+" ");
//            if (Integer.parseInt(abPaid.getInputValue().toString())==1) {
//                String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
//               
//                
//                getGoshtImage().setSource(contextPath+"/faces/javax.faces.resource/yes_meat.png?ln=images");
//                
//                AdfFacesContext.getCurrentInstance().addPartialTarget(getGoshtImage());
//                
//                
//               
//                
//                
//            }else{
//                String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
//                
//                getGoshtImage().setSource(contextPath+"/faces/javax.faces.resource/no_meat1.png?ln=images");
//                
//                AdfFacesContext.getCurrentInstance().addPartialTarget(getGoshtImage());
//                
//            }
//        }
    }
    
    
    public RichImage getGoshtImage(){
        return (RichImage)FacesContext .getCurrentInstance().getViewRoot().findComponent("i2");
    }

    @Override
    public PhaseId getPhaseId() {
        
        return null;
    }
}
