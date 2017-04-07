/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import com.control.Credit;
import com.control.PersonControl;
import com.control.product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author shibo
 */
public class getSession {

    static Session session;

    public static Session getSess() {
        SessionFactory fac = new Configuration()
                .configure().buildSessionFactory();
        Session session = fac.openSession();
        //session.beginTransaction();
        System.out.println("success");
        return session;

    }

    public boolean loginUser(PersonControl p) {

        Session session = getSession.getSess();
        String sql = "from Person2  p where p.email=:name and p.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("name", p.getEmail());
        query.setParameter("pass", p.getPassword());
        List<Person2> list = query.list();
        if (query.list().size() > 0) {

            session.close();
            return true;
        } else {
            return false;
        }
    }
      public boolean validateEmail(String email) {

        Session session = getSession.getSess();
        String sql = "from Person2  p where p.email=:name ";
        Query query = session.createQuery(sql);
        query.setParameter("name", email);
        
        List<Person2> list = query.list();
        if (query.list().size() > 0) {

            session.close();
            return true;
        } else {
            return false;
        }
    }

    public PersonControl loginUserByObject(PersonControl p) {
        PersonControl person = new PersonControl();

        Session session = getSession.getSess();
        String sql = "from Person2  p where p.email=:name and p.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("name", p.getEmail());
        query.setParameter("pass", p.getPassword());
        List<Person2> list = query.list();
        person.setId(list.get(0).getId());
        person.setBirthdate(list.get(0).getBirthdate());
        person.setEmail(list.get(0).getEmail());
        person.setLogin(true);
        if (query.list().size() > 0) {
            person.setLogin(true);
            session.close();
            return person;
        } else {
            return null;
        }
    }

//}  
    public void signUp(PersonControl aThis) {
        Session session = getSess();
        session.getTransaction().begin();
        Person2 person = new Person2();
        person.setId(aThis.getId());
        person.setName(aThis.getName());
        person.setEmail(aThis.getEmail());
        person.setPassword(aThis.getPassword());
        person.setCredit(aThis.getCredit().toString());
        person.setBirthdate(aThis.getBirthdate());
        System.out.println("" + person);

        session.persist(person);
        session.getTransaction().commit();
        System.out.println("success");

    }

//    public static void main(String[] args) {
//        PersonControl aThis = new PersonControl();
//
//        aThis.setBirthdate(new Date());
//        aThis.setCredit(new Credit("123", "456", "789"));
//        aThis.setEmail("shaaddsds;dls;");
//        aThis.setId(2);
//        aThis.setName("dksjds");
//        aThis.setPassword("kkdskds");
//
//        try {
//
//            getSession x = new getSession();
//            x.signUp(aThis);
////            Person2 person = new Person2();
////            person.setId(aThis.getId());
////            person.setName(aThis.getName());
////            person.setEmail(aThis.getEmail());
////            person.setPassword(aThis.getPassword());
////            person.setCredit(aThis.getCredit().toString());
////            person.setBirthdate(aThis.getBirthdate());
////            System.out.println("" + person);
//
//            //session.save(aThis);
//            // do some work
//        } catch (RuntimeException e) {
//
//        }
//
//        System.out.println("success");
//
////        getSession g = new getSession();
////        g.signUp(p);
//    }
    public static List<Product> getAllProducts() {

        Session session = getSess();
        session.getTransaction().begin();
        return session.createQuery("from Product").list();

    }

    public static List<product> getAllProductsForBean() {
        List<product> temp = new ArrayList<>();
        List<Product> p = getAllProducts();
        for (Product x : p) {
            temp.add(new product(x.getId(), x.getName(), x.getCategory(), x.getPrice(), x.getQunatity()));
        }
        return temp;
    }

    public static void addProduct(product p) {
        Product product = new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getQunatity());
        Session session = getSess();
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();

    }

    public static void updateProduct(product p) {
        Product product = new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getQunatity());

        Session session = getSess();
        session.getTransaction().begin();
        session.update(product);
        session.getTransaction().commit();

    }

    public static void deleteProduct(product p) {
        Product product = new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getQunatity());

        Session session = getSess();
        session.getTransaction().begin();
        session.delete(product);
        session.getTransaction().commit();

    }

    public static void main(String[] args) {

//        for (product arg : getSession.getAllProductsForBean()) {
//            System.out.println("" + arg.getName());
//        }
        getSession ge = new getSession();
        //ge.deleteProduct(new product(9, "4545", "dfdfds", 10, 0));
        System.out.println(""+ge.validateEmail("shaaban.altanany@yahoo.com"));
    }
}
