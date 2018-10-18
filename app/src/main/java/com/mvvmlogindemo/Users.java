package com.mvvmlogindemo;

import android.util.Patterns;

import java.util.regex.Pattern;

public class Users {
    private String email;
    private String pass;

    public Users(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        if(email==null){
            return "";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        if (pass==null){
            return "";
        }
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isEmailValid(){
        return Patterns.EMAIL_ADDRESS.matcher(getEmail().toString()).matches();
    }

    public boolean isPasswordGreaterthenfive(){
        return getPass().length()>5;
    }

}
