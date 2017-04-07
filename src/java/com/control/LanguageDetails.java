/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author shibo
 */
@ManagedBean
@SessionScoped
public class LanguageDetails {

    private static String locale = Locale.getDefault().getDisplayLanguage();

    public void setLocale(String locale1) {
        this.locale = locale1;
    }

    public synchronized String getLocale() {
        return locale;
    }

    public synchronized String changeLanguage() {
        System.out.println("locale now is "+locale);
        if (locale.equals("English")) {
            setLocale("ar");
             } else  {
                
            setLocale(Locale.getDefault().getDisplayLanguage());
        }

        return "signup";

    }

}
