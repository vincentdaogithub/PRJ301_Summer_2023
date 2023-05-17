package business;

import controllers.Pages;
import dao.UserDAO;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obj.User;


public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String error = this.getServletName() + " does not support GET";
        LOGGER.log(Level.SEVERE, error);
        throw new ServerException(error);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object checkUserExist = request.getSession().getAttribute("user");

        if (checkUserExist != null) {
            request.setAttribute("page", Pages.INDEX);
            return;
        }
        
        String userID = request.getParameter("txtUserID");
        String password = request.getParameter("txtPassword");
        User user = UserDAO.getUser(userID, password);

        if (user == null) {
            request.setAttribute("failedLogin", true);
            request.setAttribute("prevUserID", userID);
            request.setAttribute("prevPassword", password);
        } else {
            request.getSession().setAttribute("user", user);

            switch (user.getRoleID()) {
                case "AD":
                    request.setAttribute("page", Pages.ADMIN);
                    break;

                case "US":
                    request.setAttribute("page", Pages.INDEX);
                    break;

                default:
                    request.setAttribute("page", Pages.INDEX);
            }
        }
    }
}
