/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shibo
 */
public class product {

    private int id;
    private String name;
    private String category;
    private double price;
    private int qunatity;
    
    public static List<product> products=getProduct();
 
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public product(int id, String name, String category, double price, int qunatity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.qunatity = qunatity;
    }

    public static List<product> getProduct() {
        List<product> p = new ArrayList<product>();
        p.add(new product(1, "dskdsj", "dslkds", 0, 0));
        p.add(new product(2, "dskdsj", "dslkds", 0, 0));
        p.add(new product(3, "dskdsj", "dslkds", 0, 0));
        p.add(new product(4, "dskdsj", "dslkds", 0, 0));
        p.add(new product(5, "dskdsj", "dslkds", 0, 0));
        p.add(new product(6, "dskdsj", "dslkds", 0, 0));
        p.add(new product(7, "dskdsj", "dslkds", 0, 0));
        p.add(new product(8, "dskdsj", "dslkds", 0, 0));
        p.add(new product(9, "dskdsj", "dslkds", 0, 0));
        p.add(new product(10, "dskdsj", "dslkds", 0, 0));
        return p;
    }

    @Override
    public String toString() {
        return "product{" + "id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", qunatity=" + qunatity + '}';
    }

    public product() {
    }

}
