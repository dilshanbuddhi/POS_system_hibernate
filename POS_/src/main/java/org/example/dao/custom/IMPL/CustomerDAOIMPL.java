package org.example.dao.custom.IMPL;

import jakarta.servlet.ServletContext;
import org.example.dao.custom.CustomerDAO;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class CustomerDAOIMPL implements CustomerDAO {


    @Override
    public ArrayList<Customer> getAll(ServletContext ds) {
        SessionFactory sessionFactory = (SessionFactory) ds.getAttribute("SessionFactory");
        System.out.println("4");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ArrayList<Customer> customers = (ArrayList<Customer>) session.createQuery("FROM Customer").list();
        session.getTransaction().commit();
        System.out.println("5");
        session.close();
        return customers;
    }
}
