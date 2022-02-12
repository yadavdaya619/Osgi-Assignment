package com.mysite.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.type.IntersectionType;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
@Component(service = Servlet.class, property = {
        "sling.servlet.paths=" + "/bin/action/coffeeConfirm",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST
})
public class CoffeeConfirmServlet extends SlingAllMethodsServlet {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String coffeeType = request.getParameter("coffeeType");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        LOGGER.info("Entering the main code...");

        if(coffeeType.equals("Hot")){
            out.print("Your bill amounts to $" + quantity * 5);
        } else if(coffeeType.equals("Cold")){
            out.print("Your bill amounts to $" + quantity * 8);
        } else if(coffeeType.equals("Black")){
            out.print("Your bill amounts to $" + quantity * 10);
        }

        LOGGER.info("Exiting the main code...");

        out.println();
        out.print("Order confirmed. Please collect your orders from the counter");

    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("Testing");
    }
}
