package org.example.dao.custom;

import jakarta.servlet.ServletContext;
import org.example.dao.CrudDAO;
import org.example.entity.Customer;

import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
    ArrayList<Customer> getAll(ServletContext ds);
}
