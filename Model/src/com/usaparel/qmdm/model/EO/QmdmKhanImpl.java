package com.usaparel.qmdm.model.EO;

import java.math.BigDecimal;

import oracle.jbo.Key;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Aug 11 22:07:50 PKT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class QmdmKhanImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        EmployeeName,
        EmployeeId,
        EmployeeDesignation,
        IsPaid,
        EmployeeDept,
        EmployeeUnit,
        RfidNumber,
        CouponNumber,
        VersionNumber;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int EMPLOYEENAME = AttributesEnum.EmployeeName.index();
    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int EMPLOYEEDESIGNATION = AttributesEnum.EmployeeDesignation.index();
    public static final int ISPAID = AttributesEnum.IsPaid.index();
    public static final int EMPLOYEEDEPT = AttributesEnum.EmployeeDept.index();
    public static final int EMPLOYEEUNIT = AttributesEnum.EmployeeUnit.index();
    public static final int RFIDNUMBER = AttributesEnum.RfidNumber.index();
    public static final int COUPONNUMBER = AttributesEnum.CouponNumber.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();

    /**
     * This is the default constructor (do not remove).
     */
    public QmdmKhanImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.usaparel.qmdm.model.EO.QmdmKhan");
    }


    /**
     * Gets the attribute value for EmployeeName, using the alias name EmployeeName.
     * @return the value of EmployeeName
     */
    public String getEmployeeName() {
        return (String) getAttributeInternal(EMPLOYEENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeName.
     * @param value value to set the EmployeeName
     */
    public void setEmployeeName(String value) {
        setAttributeInternal(EMPLOYEENAME, value);
    }

    /**
     * Gets the attribute value for EmployeeId, using the alias name EmployeeId.
     * @return the value of EmployeeId
     */
    public BigDecimal getEmployeeId() {
        return (BigDecimal) getAttributeInternal(EMPLOYEEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeId.
     * @param value value to set the EmployeeId
     */
    public void setEmployeeId(BigDecimal value) {
        setAttributeInternal(EMPLOYEEID, value);
    }

    /**
     * Gets the attribute value for EmployeeDesignation, using the alias name EmployeeDesignation.
     * @return the value of EmployeeDesignation
     */
    public String getEmployeeDesignation() {
        return (String) getAttributeInternal(EMPLOYEEDESIGNATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeDesignation.
     * @param value value to set the EmployeeDesignation
     */
    public void setEmployeeDesignation(String value) {
        setAttributeInternal(EMPLOYEEDESIGNATION, value);
    }

    /**
     * Gets the attribute value for IsPaid, using the alias name IsPaid.
     * @return the value of IsPaid
     */
    public BigDecimal getIsPaid() {
        return (BigDecimal) getAttributeInternal(ISPAID);
    }

    /**
     * Sets <code>value</code> as the attribute value for IsPaid.
     * @param value value to set the IsPaid
     */
    public void setIsPaid(BigDecimal value) {
        setAttributeInternal(ISPAID, value);
    }

    /**
     * Gets the attribute value for EmployeeDept, using the alias name EmployeeDept.
     * @return the value of EmployeeDept
     */
    public String getEmployeeDept() {
        return (String) getAttributeInternal(EMPLOYEEDEPT);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeDept.
     * @param value value to set the EmployeeDept
     */
    public void setEmployeeDept(String value) {
        setAttributeInternal(EMPLOYEEDEPT, value);
    }

    /**
     * Gets the attribute value for EmployeeUnit, using the alias name EmployeeUnit.
     * @return the value of EmployeeUnit
     */
    public String getEmployeeUnit() {
        return (String) getAttributeInternal(EMPLOYEEUNIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeUnit.
     * @param value value to set the EmployeeUnit
     */
    public void setEmployeeUnit(String value) {
        setAttributeInternal(EMPLOYEEUNIT, value);
    }

    /**
     * Gets the attribute value for RfidNumber, using the alias name RfidNumber.
     * @return the value of RfidNumber
     */
    public BigDecimal getRfidNumber() {
        return (BigDecimal) getAttributeInternal(RFIDNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for RfidNumber.
     * @param value value to set the RfidNumber
     */
    public void setRfidNumber(BigDecimal value) {
        setAttributeInternal(RFIDNUMBER, value);
    }

    /**
     * Gets the attribute value for CouponNumber, using the alias name CouponNumber.
     * @return the value of CouponNumber
     */
    public BigDecimal getCouponNumber() {
        return (BigDecimal) getAttributeInternal(COUPONNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for CouponNumber.
     * @param value value to set the CouponNumber
     */
    public void setCouponNumber(BigDecimal value) {
        setAttributeInternal(COUPONNUMBER, value);
    }

    /**
     * Gets the attribute value for VersionNumber, using the alias name VersionNumber.
     * @return the value of VersionNumber
     */
    public BigDecimal getVersionNumber() {
        return (BigDecimal) getAttributeInternal(VERSIONNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for VersionNumber.
     * @param value value to set the VersionNumber
     */
    public void setVersionNumber(BigDecimal value) {
        setAttributeInternal(VERSIONNUMBER, value);
    }

    /**
     * @param couponNumber key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal couponNumber) {
        return new Key(new Object[] { couponNumber });
    }


}

