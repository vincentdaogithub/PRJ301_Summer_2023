package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        throw new ServletException(this.getServletName() + " does not support GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] productsChosen = request.getParameterValues("products");

        if (productsChosen == null) {
            request.setAttribute("productsChosen", "");
            request.getRequestDispatcher("/lab1/product_get.jsp").forward(request, response);
            return;
        }

        StringBuilder builder = new StringBuilder();

        for (String item : productsChosen) {
            builder.append(item);
            builder.append(", ");
        }

        String result = builder.substring(0, builder.length() - 2);
        request.setAttribute("productsChosen", result);
        request.getRequestDispatcher("/lab1/product_get.jsp").forward(request, response);
    }
}
