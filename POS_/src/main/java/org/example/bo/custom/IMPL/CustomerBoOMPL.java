package org.example.bo.custom.IMPL;

import jakarta.servlet.ServletContext;
import org.example.bo.custom.CustomerBO;
import org.example.dao.DaoFactory;
import org.example.dao.custom.CustomerDAO;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;

import java.util.ArrayList;

public class CustomerBoOMPL implements CustomerBO {

    private CustomerDAO customerDAO = (CustomerDAO) DaoFactory.getdaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAll(ServletContext servletContext) {
        ArrayList<Customer> customers = customerDAO.getAll(servletContext);
        System.out.println("3");
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            System.out.println(customer.getAddress()+customer.getName());
            customerDTOS.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO, ServletContext context) {
        return customerDAO.save(new Customer(customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPhone()), context);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO, ServletContext context) {
        return customerDAO.update(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPhone()), context);
    }

    @Override
    public boolean deleteCustomer(Long id, ServletContext context) {
        return customerDAO.delete(id, context);
    }
}
