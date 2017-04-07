/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vote.bean;

import java.io.Serializable;

/**
 *
 * @author shibo
 */
public class product  implements Serializable{
    private int id;
    private String name;
    private int voteNumber;

    public product(int id, String name, int voteNumber) {
        this.id = id;
        this.name = name;
        this.voteNumber = voteNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }
    
    
    
}
