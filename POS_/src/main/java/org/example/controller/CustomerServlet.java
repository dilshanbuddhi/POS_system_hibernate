package org.example.controller;

import com.mysql.cj.xdevapi.JsonArray;
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
import javax.json.JsonObjectBuilder;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
     /*   ServletContext context = req.getServletContext();
        System.out.println("1");
       // BasicDataSource ds = (BasicDataSource) context.getAttribute("dataSource");
        ArrayList<CustomerDTO> customerArrayList = customerBO.getAll(context);
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        JsonObjectBuilder jsonObject = Json.createObjectBuilder();

        for (CustomerDTO customer : customerArrayList) {
            jsonObject.add("id",customer.getId());
            jsonObject.add("name",customer.getName());
            jsonObject.add("address",customer.getAddress());
            jsonObject.add("phone",customer.getPhone());
            jsonArray.add(jsonObject.build());
        }
        resp.getWriter().print(jsonArray.build());


    }*/
}
