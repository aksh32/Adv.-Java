/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author studentadmin
 */
public class RegisterUser extends org.apache.struts.action.ActionForm {
    
    private String name;
    private String designation;
    private String org;
    private String exp;
    private String gender;
    private String email;
    private String contNo;
    private String Nameerror;
    private String designationError;
    private String orgError;

    public String getNameerror() {
        return Nameerror;
    }

    public void setNameerror(String Nameerror) {
        this.Nameerror = "<span style='color:red'>"+Nameerror+"</span>";
    }

    public String getDesignationError() {
        return designationError;
    }

    public void setDesignationError(String designationError) {
        this.designationError = "<span style='color:red'>"+designationError+"</span>";
    }

    public String getOrgError() {
        return orgError;
    }

    public void setOrgError(String orgError) {
        this.orgError = "<span style='color:red'>"+orgError+"</span>";
    }

    public String getExpError() {
        return expError;
    }

    public void setExpError(String expError) {
        this.expError = "<span style='color:red'>"+expError+"</span>";
    }

    public String getGenderError() {
        return genderError;
    }

    public void setGenderError(String genderError) {
        this.genderError = "<span style='color:red'>"+genderError+"</span>";
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = "<span style='color:red'>"+emailError+"</span>";
    }

    public int getContNoError() {
        return contNoError;
    }

    public void setContNoError(String contNoError) {
        this.contNoError = "<span style='color:red'>"+contNoError+"</span>";
    }
    private String expError;
    private String genderError;
    private String emailError;
    private int contNoError;
    
    

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContNo() {
        return contNo;
    }

    public void setContNo(int contNo) {
        this.contNo = contNo;
    }
    
    

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * @return
     */

    /**
     *
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
