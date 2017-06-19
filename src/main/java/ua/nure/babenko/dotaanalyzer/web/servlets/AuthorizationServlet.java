package ua.nure.babenko.dotaanalyzer.web.servlets;

import ua.nure.babenko.dotaanalyzer.constants.WebPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = WebPath.AUTHORIZATION_VEIW;
        request.getRequestDispatcher(path).forward(request, response);
    }
}
