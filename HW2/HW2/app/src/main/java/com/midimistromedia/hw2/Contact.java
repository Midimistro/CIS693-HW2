package com.midimistromedia.hw2;

import android.provider.ContactsContract;

public class Contact {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;

    //Universal Constructor
    public Contact(String fn, String ln, String em, String pn){
        if(!fn.isEmpty()){
            firstName=fn;
        }
        if(!ln.isEmpty()){
            lastName=ln;
        }
        if(!em.isEmpty()){
            email=em;
        }
        phoneNumber = pn;
    }


    //Set methods
    public void setLastName(String ln){
        lastName=ln;
    }
    public void setFirstName(String fn){
        firstName=fn;
    }
    public void setEmail(String em){
        email=em;
    }
    public void setPhoneNumber(String pn){
        phoneNumber=pn;
    }

    //Get Methods:
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

}
