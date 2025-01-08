package org.example.bo.custom;

import jakarta.servlet.ServletContext;
import org.example.bo.SuperBO;
import org.example.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    ArrayList<CustomerDTO> getAll(ServletContext ds);

    boolean saveCustomer(CustomerDTO customerDTO, ServletContext context);

    boolean updateCustomer(CustomerDTO customerDTO, ServletContext context);

    boolean deleteCustomer(Long aLong, ServletContext context);
}
