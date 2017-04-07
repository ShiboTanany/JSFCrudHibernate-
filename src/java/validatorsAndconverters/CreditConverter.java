/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatorsAndconverters;

import com.control.Credit;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author shibo
 */
@FacesConverter("com.shibo.test")
public class CreditConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Credit c=null;
        String[] y = string.split("-");
        if(y.length >=2){
         c = new Credit(y[0], y[1], y[2]);}
        else{
        FacesMessage msg
                    = new FacesMessage("creidt card not complete .");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       
     Credit x=(Credit)o;
     
        //System.out.println(""+x.getPart1()+"-"+x.getPart2()+"-"+x.getPart3());
    return x.getPart1()+"-"+x.getPart2()+"-"+x.getPart3();
            
    }

}
//public class CreditConverter {
//
//    public static void main(String[] args) {
//        String x = "123-235-325";
//        String[] y = x.split("-");
//        for (String string : y) {
//            System.out.println("" + string);
//        }
//    }
//}
