package com.entity;
// Generated Mar 29, 2017 1:12:29 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="testShibo"
)
public class Product  implements java.io.Serializable {


     private int id;
     private String name;
     private String category;
     private double price;
     private int qunatity;

    public Product() {
    }

    public Product(int id, String name, String category, double price, int qunatity) {
       this.id = id;
       this.name = name;
       this.category = category;
       this.price = price;
       this.qunatity = qunatity;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="category", nullable=false, length=45)
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    
    @Column(name="price", nullable=false, precision=22, scale=0)
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    
    @Column(name="qunatity", nullable=false)
    public int getQunatity() {
        return this.qunatity;
    }
    
    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }




}


