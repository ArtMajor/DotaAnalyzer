package ua.nure.babenko.dotaanalyzer.web.servlets;

import ua.nure.babenko.dotaanalyzer.constants.Params;
import ua.nure.babenko.dotaanalyzer.constants.WebPath;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;
import ua.nure.babenko.dotaanalyzer.services.ConfrontationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ViewConfrontationServlet", urlPatterns = "/view")
public class ViewConfrontationServlet extends HttpServlet {

    private ConfrontationService confrontationService;

    @Override
    public void init() throws ServletException {
        super.init();
        confrontationService = (ConfrontationService) getServletContext().getAttribute(Params.CONFRONTATION_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(WebPath.CONFRONTATION_LIST_VIEW).forward(request, response);
    }
}
