/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obj.Student;
import utils.DBUtils;

/**
 *
 * @author vince
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        throw new ServletException(this.getServletName() + " does not support GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("txtName");
        String password = request.getParameter("txtPass");
        String queryLogin = "SELECT * FROM Student WHERE name = ? AND password = ? COLLATE Latin1_General_CS_AS" ;

        try (
            Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(queryLogin,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next() && result.isLast()) {
                Student student = new Student(result.getInt("id"), result.getString("name"), result.getString("password"));
                request.setAttribute("student", student);
                request.setAttribute("status", "successful");
            } else {
                request.setAttribute("status", "failed");
            }
        } catch (Exception e) {
            request.setAttribute("status", "exception");
        }

        request.getRequestDispatcher("/lab1/login_status.jsp").forward(request, response);
    }
}
