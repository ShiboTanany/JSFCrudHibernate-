/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vote.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedProperty;

import vote.bean.product;

/**
 *
 * @author shibo
 */
@ManagedBean(name ="CatalogeVote",eager = true)
@ApplicationScoped
public class CatalogeVote implements Serializable{

    List<product> list = new ArrayList<>();
    
   
    public List<product> getList() {
        return list;
    }

    public void setList(List<product> list) {
        this.list = list;
    }

    /**
     * Creates a new instance of CatalogeVote
     */
    public CatalogeVote() {
        list.add(new product(1, "nokia", 0));
        list.add(new product(2, "samsung", 0));
        list.add(new product(3, "apple", 0));
        list.add(new product(4, "amazon", 0));
        list.add(new product(5, "ibm", 0));
        list.add(new product(6, "hp", 0));
        list.add(new product(7, "soft 7aga", 0));
    }

    public void editVote(String value) {
        
        for (product object : list) {
            if (value.equals(object.getName())) {
                int x = object.getVoteNumber();
                object.setVoteNumber(++x);
                System.out.println("changedkfjdkfkdjkfjd"+object.getVoteNumber());
            }
        }
        
    }

    public void editVote(int value) {
        for (product object : list) {
            if (value == object.getId()) {
                int x = object.getVoteNumber();
                object.setVoteNumber(++x);
            }
        

    }
    
}
}