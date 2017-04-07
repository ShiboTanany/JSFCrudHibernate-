/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.entity.getSession;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author shibo
 */
@ManagedBean
@SessionScoped
public class profile {

    private product product = new product();
//    private List<product> p =product.products;
//    private DataModel<product> model = new ListDataModel<product>(product.products);

//    public List<product> getP() {
//        return p;
//    }
//
//    public void setP(List<product> p) {
//        this.p = p;
//    }
 private DataModel<product> model = new ListDataModel<product>(getSession.getAllProductsForBean());
    
    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }

    public profile() {
        // model = new ListDataModel<product>(getSession.getAllProductsForBean());
        //model=
    }

    public DataModel<product> getModel() {
        return model;
    }

    public void setModel(DataModel<product> model) {
        this.model = model;
    }

    public void deleteProduct() {

        product p = model.getRowData();
//        this.p.remove(p);
        
          getSession.deleteProduct(p);
          model = new ListDataModel<product>(getSession.getAllProductsForBean());
//        for (product object : model) {
//            System.out.println(""+object.getName());
//        }
//        System.out.println("////////////////////////////");
//        for (product object : this.p) {
//            System.out.println(""+object.getName());
//        }
    }

    public void editProduct() {

        product produ = model.getRowData();
        System.out.println("in edit product " + new Date() + "" + produ);
        getSession.updateProduct(produ);
        model = new ListDataModel<product>(getSession.getAllProductsForBean());

    }

    public void addProduct() {

       // product pr = model.getRowData();
//        this.p.add(pr);
//        System.out.println("" + product);
        getSession.addProduct(product);
        model = new ListDataModel<product>(getSession.getAllProductsForBean());

    }
}
