/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPack;

import java.io.Serializable;

/**
 *
 * @author studentadmin
 */
public class ContactList implements Serializable{
    private String cFname;
    private String cLname;
    public ContactList(){}

    public String getcFname() {
        return cFname;
    }

    public void setcFname(String cFname) {
        this.cFname = cFname;
    }

    public String getcLname() {
        return cLname;
    }

    public void setcLname(String cLname) {
        this.cLname = cLname;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }
    private String cnumber;
    

    
}
