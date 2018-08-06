package com.usaparel.qmdm.view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

import org.apache.myfaces.trinidad.event.PollEvent;

public class Stat {
    public Stat() {
    }
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void onTime(PollEvent pollEvent){
        System.out.println(" called");
        DCBindingContainer d = (DCBindingContainer)getBindings();
        DCIteratorBinding it= d.findIteratorBinding("VOUnitWiseTotalToken1Iterator");
        it.getViewObject().executeQuery();
        
         it= d.findIteratorBinding("VOStatUnitWise1Iterator");
        it.getViewObject().executeQuery();
        
        
        it= d.findIteratorBinding("VOStat1Iterator");
        it.getViewObject().executeQuery();
        
        
        
        
    }
}
