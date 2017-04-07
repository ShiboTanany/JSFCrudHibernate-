/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.entity.Person2;
import com.entity.getSession;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shibo
 */
@ManagedBean(name = "personControl")
@SessionScoped
public class PersonControl implements Serializable {

    private int id;
    private String email;
    private String name;
    private String password;
    private Date birthdate;

    private Credit credit;
    private String errorMessage;
    private boolean login;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public String loginUser() {

        getSession P = new getSession();
        PersonControl flag = P.loginUserByObject(this);
        if (flag != null) {
            // this.setLogin(flag.isLogin());
            this.setBirthdate(flag.getBirthdate());
            this.setEmail(flag.getEmail());
            this.setName(flag.getName());
            this.setPassword(flag.getPassword());
            System.out.println("" + this);
            errorMessage = "";
            this.setLogin(true);
            System.out.println("the boolean in method" + isLogin());

            return "profile.xhtml";

        } else {
            errorMessage = "you have not any creditaals";
            this.setLogin(false);

            return "login.xhtml";
        }

    }

//    public void loginUser2() {t,
//        
//        getSession P = new getSession();
//        boolean flag = P.loginUser(this);
//        if (flag) {
//            errorMessage = "";
//           this.setLogin(true);
//            //return "profile.xhtml";
//
//        } else {
//            errorMessage = "you have not any creditaals";
//            this.setLogin(false);
//            // return "login.xhtml";
//        }
//        
//    }
//    
    public String signUp() {
        getSession P = new getSession();
        P.signUp(this);
        return "profile";
    }

    public void validateName(FacesContext fc, UIComponent c, Object value) {
getSession P = new getSession();
        if (!P.validateEmail(email)) {
            throw new ValidatorException(new FacesMessage("email was registered before"));
        }
    }

    @Override
    public String toString() {
        return "PersonControl{" + "id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", birthdate=" + birthdate + ", credit=" + credit + ", errorMessage=" + errorMessage + ", login=" + login + '}';
    }

    public String logout() {
        PersonControl c = null;
        if(isLogin())
        setLogin(false);
        
        // ((HttpServletRequest) request).getSession().removeAttribute("personControl");

        System.out.println("from logout" + isLogin());
        return "login.xhtml";
    }
}
