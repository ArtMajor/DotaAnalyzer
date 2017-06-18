package ua.nure.babenko.dotaanalyzer.web.servlets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by fomenko on 16.06.2017.
 */
@WebServlet(name = "JsonConfrontationServlet", urlPatterns = "/confrontationsEdit")
public class JsonConfrontationServlet extends HttpServlet {

    private ConfrontationService confrontationService;

    @Override
    public void init() throws ServletException {
        confrontationService = (ConfrontationService) getServletContext().getAttribute(Params.CONFRONTATION_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ConfrontationEntity> confrontationEntityList = confrontationService.getAllConfrontation();
        JSONArray jsonObject = sendJsonFromList(confrontationEntityList);
        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        printWriter.print(jsonObject.toString());
        printWriter.flush();

        printWriter.close();

    }

    private JSONArray sendJsonFromList(List<ConfrontationEntity> confrontationEntityList) {
        JSONArray jsonArray = new JSONArray();
        for (ConfrontationEntity confrontationEntity : confrontationEntityList) {
            JSONObject object = new JSONObject();
            object.put("firstHeroId", confrontationEntity.getFirstHeroId());
            object.put("secondHeroId", confrontationEntity.getSecondHeroId());
            object.put("profitability", confrontationEntity.getProfitability());
            jsonArray.put(object);
        }
        return jsonArray;
    }


}
