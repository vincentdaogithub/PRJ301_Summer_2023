package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Actions action = Actions.convertAction(request.getParameter("a"));

        if (action != null) {
            request.getRequestDispatcher(action.getURL()).include(request, response);
        }

        Pages page = Pages.convertPage(request.getParameter("p"));

        if (page != null) {
            request.getRequestDispatcher(page.getURL()).forward(request, response);
        } else {
            Pages secondPage = (Pages) request.getAttribute("page");

            if (secondPage != null) {
                request.getRequestDispatcher(secondPage.getURL()).forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
