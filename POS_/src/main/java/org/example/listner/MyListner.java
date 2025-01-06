package org.example.listner;

import jakarta.servlet.ServletContext;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class MyListner implements ServletContextListener {
    private static SessionFactory sessionFactory;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       /* try {
            System.out.println("Initializing Hibernate");
          *//*  sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            sce.getServletContext().setAttribute("SessionFactory", sessionFactory);*//*
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Customer.class);

            Session session = configuration.buildSessionFactory().openSession();
            Transaction transaction =session.beginTransaction();
            Customer customerDTO = new  Customer("sherul","Galle","s");
            session.save(customerDTO);
            transaction.commit();
            session.close();

            System.out.println("Hibernate initialized successfully");
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }*/


        try {
            System.out.println("Initializing Hibernate");
            sessionFactory = new Configuration().configure().buildSessionFactory();
            sce.getServletContext().setAttribute("SessionFactory", sessionFactory);
            System.out.println("Hibernate initialized successfully");
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
