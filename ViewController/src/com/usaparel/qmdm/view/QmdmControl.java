package com.usaparel.qmdm.view;

import java.io.StringReader;

import java.util.Random;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.binding.DCIteratorBindingDef;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.event.PollEvent;

public class QmdmControl {
    private RichImage goshtImage;
    private RichInputText ritCoupon;
    private String tokenRedeemedString = "COUPONS REMAINING" ;
    private String redeemString;
    private RichInputText ritBulkLocation;
    private RichInputText ritBulkQuantity;
    private RichButton bdone;
    private RichOutputText otMessage;


    public void setTokenRedeemedString(String tokenRedeemedString) {
        this.tokenRedeemedString = tokenRedeemedString;
    }

    public String getTokenRedeemedString() {
        String description = tokenRedeemedString;
               if (description != null)
                   description = description.replaceAll("\n", "<br/>");
            
        return tokenRedeemedString;
    }

    public QmdmControl() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

   

  

    public String callCommit() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String filter() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("ExecuteWithParams");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("error");
            return null;
        }
        return null;
    }

    public void couponEntered(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue()==null){
            return;
        }
        
        BindingContainer bc = getBindings();
        AttributeBinding ab = (AttributeBinding) bc.get("coupon");
        System.out.println(ab.getInputValue()+" <<<");
        int coupon = Integer.parseInt(valueChangeEvent.getNewValue().toString());
        ab.setInputValue(coupon);
        
        filter();
        AttributeBinding abPaid = (AttributeBinding)bc.get("IsPaid");
        
        if (Integer.parseInt(abPaid.getInputValue().toString())==1) {
            String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
           System.out.println("yes meat");

            getGoshtImage().setSource(contextPath+"/faces/javax.faces.resource/yes_meat1_red.png?ln=images");
            
            AdfFacesContext.getCurrentInstance().addPartialTarget(getGoshtImage());
            
            
           
            
            
        }else{
            System.out.println(" no meat");
            String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            
            getGoshtImage().setSource(contextPath+"/faces/javax.faces.resource/no_meat1_red.jpg?ln=images");
            
            AdfFacesContext.getCurrentInstance().addPartialTarget(getGoshtImage());
            
        }
        
        getRitCoupon().resetValue();
        ab.setInputValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getRitCoupon());
        
        if (Integer.parseInt(abPaid.getInputValue().toString())==0){

            abPaid.setInputValue(1);
            
            callCommit();   
        }
        
        refreshStats();
    }


    private void refreshStats(){
        BindingContainer bc = getBindings();
        DCBindingContainer bdc = (DCBindingContainer)bc;
        DCIteratorBinding it =  bdc.findIteratorBinding("VOStat1Iterator");
        DCIteratorBinding it2 =  bdc.findIteratorBinding("VOStatUnitWise1Iterator");
        it.getViewObject().executeQuery();
        
        it2.getViewObject().executeQuery();
        
        
    }
   

    public void setGoshtImage(RichImage goshtImage) {
        this.goshtImage = goshtImage;
    }

    public RichImage getGoshtImage() {
        return goshtImage;
    }

    public void setRitCoupon(RichInputText ritCoupon) {
        this.ritCoupon = ritCoupon;
    }

    public RichInputText getRitCoupon() {
        return ritCoupon;
    }

    public void setRedeemString(String redeemString) {
        this.redeemString = redeemString;
    }

    public String getRedeemString() {
        return redeemString;
    }

    public void transactionTypeChanged(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue().toString().equals("true")) {
            System.out.println("here");
            getRitBulkLocation().setDisabled(false);
            getRitBulkQuantity().setDisabled(false);
            getBdone().setDisabled(false);
        }else{
            getRitBulkLocation().setDisabled(true);
            getRitBulkQuantity().setDisabled(true);
            getBdone().setDisabled(true);
        }
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(getRitBulkLocation());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getRitBulkQuantity());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getBdone());
    }

    public void setRitBulkLocation(RichInputText ritBulkLocation) {
        this.ritBulkLocation = ritBulkLocation;
    }

    public RichInputText getRitBulkLocation() {
        return ritBulkLocation;
    }

    public void setRitBulkQuantity(RichInputText ritBulkQuantity) {
        this.ritBulkQuantity = ritBulkQuantity;
    }

    public RichInputText getRitBulkQuantity() {
        return ritBulkQuantity;
    }

    public void setBdone(RichButton bdone) {
        this.bdone = bdone;
    }

    public RichButton getBdone() {
        return bdone;
    }

    public String bulkTransaction() {
        int total = Integer.parseInt(getRitBulkQuantity().getValue().toString());
        BindingContainer bc = getBindings();
        DCBindingContainer bdc = (DCBindingContainer)bc;
        DCIteratorBinding it =  bdc.findIteratorBinding("VOQmdmKhan1Iterator");
        ViewObject vo = it.getViewObject();
        Random rand = new Random();
        
        
        
        for (int i = 0; i< total; i++) {
            int id = Math.abs( rand.nextInt()+6000); 
            Row r =  vo.createRow();
            r.setAttribute("EmployeeName", getRitBulkLocation().getValue().toString());
            r.setAttribute("IsPaid", 1);
            //r.setAttribute("EmployeeId", id);
            r.setAttribute("CouponNumber", id);
            r.setAttribute("EmployeeUnit", 6);
            
        }
        
        callCommit();
        refreshStats();
        
        return null;
    }

    public void setOtMessage(RichOutputText otMessage) {
        this.otMessage = otMessage;
    }

    public RichOutputText getOtMessage() {
        return otMessage;
    }

    public void refreshThings(PollEvent pollEvent) {
        System.out.println(" called");
        DCBindingContainer d = (DCBindingContainer)getBindings();
        DCIteratorBinding it= d.findIteratorBinding("VOStat1Iterator");
        it.getViewObject().executeQuery();
        
         it= d.findIteratorBinding("VOStatUnitWise1Iterator");
        it.getViewObject().executeQuery();
        
        
    }
}
