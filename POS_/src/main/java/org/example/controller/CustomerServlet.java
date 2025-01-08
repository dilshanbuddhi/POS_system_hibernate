package org.example.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBO;
import org.example.dto.CustomerDTO;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        ServletContext context = req.getServletContext();
        ArrayList<CustomerDTO> customerArrayList = customerBO.getAll(context);
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();

        for (CustomerDTO customer : customerArrayList) {
            JsonObjectBuilder jsonObject = Json.createObjectBuilder(); // Create a new JsonObjectBuilder in each iteration
            jsonObject.add("id", customer.getId());
            jsonObject.add("name", customer.getName());
            jsonObject.add("address", customer.getAddress());
            jsonObject.add("tel", customer.getPhone());
            jsonArray.add(jsonObject);
        }

        resp.getWriter().print(jsonArray.build().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("tel");

        System.out.println("id : " + id + " name : " + name + " address : " + address + " phone : " + phone);
        ServletContext context = req.getServletContext();
        boolean issaved = customerBO.saveCustomer(new CustomerDTO(name, address, phone), context);

        if (issaved) {
            resp.getWriter().print("Customer Saved");
        } else {
            resp.getWriter().print("Customer Not Saved");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject jsonObject = Json.createReader(req.getReader()).readObject();
        Long cid = Long.valueOf(jsonObject.getString("id"));
        String name = jsonObject.getString("name");
        String address = jsonObject.getString("address");
        String tel = jsonObject.getString("tel");

        ServletContext context = req.getServletContext();
        boolean ok = customerBO.updateCustomer(new CustomerDTO(cid, name, address, tel), context);
        if (ok) {
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete ekata awa");
        Long id = Long.valueOf(req.getParameter("id"));
        System.out.println(id+"delete ekt en ek");
        ServletContext context = req.getServletContext();
        boolean ok = customerBO.deleteCustomer(id, context);
        if (ok) {
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
