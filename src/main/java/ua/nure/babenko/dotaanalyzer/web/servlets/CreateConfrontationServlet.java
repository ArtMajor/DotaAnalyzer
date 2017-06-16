package ua.nure.babenko.dotaanalyzer.web.servlets;

import ua.nure.babenko.dotaanalyzer.constants.Params;
import ua.nure.babenko.dotaanalyzer.constants.WebPath;
import ua.nure.babenko.dotaanalyzer.db.dto.ConfrontationMapper;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;
import ua.nure.babenko.dotaanalyzer.services.ConfrontationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/createConfrontation")
public class CreateConfrontationServlet extends HttpServlet {
    private ConfrontationService confrontationService;

    @Override
    public void init() throws ServletException {
        super.init();
        confrontationService = (ConfrontationService)getServletContext().getAttribute(Params.CONFRONTATION_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(WebPath.CREATE_CONFRONTANION_VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConfrontationEntity confrontationEntity = new ConfrontationMapper().getConfrontation(req);
        confrontationService.addConfrontation(confrontationEntity);
        resp.sendRedirect("createConfrontation");
    }
}
