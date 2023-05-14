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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DBUtils;

/**
 *
 * @author vince
 */
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        throw new ServletException(this.getServletName() + " does not support GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String queryCheck = "SELECT * FROM Student WHERE username = ? COLLATE Latin1_General_CS_AS";

        try (
            Connection connection = DBUtils.getConnection();
        ) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            try (
                PreparedStatement statement = connection.prepareStatement(queryCheck,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ) {
                statement.setString(1, username);
                ResultSet results = statement.executeQuery();

                if (results.next() && !results.isLast()) {
                    throw new SQLException("Username exists");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("create_status.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            request.setAttribute("status", "failed");
            request.getRequestDispatcher("create_status.jsp").forward(request, response);
            return;
        }

        String queryInsert = "INSERT INTO Student(username, password) VALUES (?, ?)";

        try (
                Connection connection = DBUtils.getConnection();
        ) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            try (
                    PreparedStatement statement = connection.prepareStatement(queryInsert);
            ) {
                statement.setString(1, username);
                statement.setString(2, password);

                if (statement.executeUpdate() != 1) {
                    throw new SQLException("Can't insert into Student");
                }

                connection.commit();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                connection.rollback();
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("create_status.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            request.setAttribute("status", "failed");
            request.getRequestDispatcher("create_status.jsp").forward(request, response);
        }

        request.setAttribute("status", "successful");
        request.getRequestDispatcher("create_status.jsp").forward(request, response);
    }
}
