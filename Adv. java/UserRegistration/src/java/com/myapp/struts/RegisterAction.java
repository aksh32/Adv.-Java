/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author studentadmin
 */
public class RegisterAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        RegisterUser formBean = (RegisterUser) form;
        String name = formBean.getName();
        String des = formBean.getDesignation();
        String org = formBean.getOrg();
        String gender = formBean.getGender();
        String email = formBean.getEmail();
        int contNo = formBean.getContNo();
        
        if(name == null || name.equals("") || name.matches("[0-9]!@#$%^&*()_+")){
            formBean.setError("name cannot be empty");
            return mapping.findForward(FAILURE);
        }
        if(des == null || des.equals("") || des.matches("\"[0-9]!@#$%^&*()_+\"")){
            formBean.setError("designation cannot be empty");
            return mapping.findForward(FAILURE);
        }
        if(org == null || org.equals("") || org.matches("\"[0-9]!@#$%^&*()_+\"")){
            formBean.setError("organisation cannot be empty");
            return mapping.findForward(FAILURE);
        }
        if(gender == null || gender.equals("")){
            formBean.setError("select Gender");
            return mapping.findForward(FAILURE);
        }
        if(email == null || email.indexOf("@") == -1 || email.indexOf(".") == -1){
            formBean.setError("Please Enter a valid email id");
            return mapping.findForward(FAILURE);
        }
        int len = Integer.toString(contNo).length();
        if(len < 10 || len == -1 ){
            formBean.setError("Please Enter a valid Phone Number");
            return mapping.findForward(FAILURE);
        }
        return mapping.findForward(SUCCESS);
    }
}
