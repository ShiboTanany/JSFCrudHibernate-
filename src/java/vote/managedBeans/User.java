/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vote.managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author shibo
 */
@ManagedBean(name = "user",eager=true)
@SessionScoped
public class User implements Serializable {

    @ManagedProperty( value = "#{CatalogeVote}")
    private CatalogeVote catalogeVote;

    public CatalogeVote getCatalogeVote() {
        return catalogeVote;
    }

    public void setCatalogeVote(CatalogeVote catalogeVote) {
        this.catalogeVote = catalogeVote;
    }

    private boolean choosen;
    private String choice;

//    public CatalogeVote getCatalogeVote() {
//        return CatalogeVote;
//    }
//
//    public void setCatalogeVote(CatalogeVote CatalogeVote) {
//        this.CatalogeVote = CatalogeVote;
//    }

    public boolean isChoosen() {
        return choosen;
    }

    public void setChoosen(boolean choosen) {
        this.choosen = choosen;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public User() {
    }

    public String voteButtonBack() {
        
        System.out.println("accessssssed"+getChoice());
        if (getChoice() != null) {

            catalogeVote.editVote(Integer.parseInt(getChoice()));
            System.out.println("updated");
            setChoosen(true);
            return "showResults";
        } else {
            return null;
        }

    }
}
