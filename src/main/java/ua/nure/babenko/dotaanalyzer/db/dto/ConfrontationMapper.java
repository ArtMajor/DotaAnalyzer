package ua.nure.babenko.dotaanalyzer.db.dto;

import ua.nure.babenko.dotaanalyzer.constants.Params;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fomenko on 16.06.2017.
 */
public class ConfrontationMapper {
    public ConfrontationEntity getConfrontation(HttpServletRequest request){
        ConfrontationEntity confrontation = new ConfrontationEntity();
        confrontation.setFirstHeroId(Integer.parseInt(request.getParameter(Params.REQ_FIRST_HERO)));
        confrontation.setSecondHeroId(Integer.parseInt(request.getParameter(Params.REQ_SECOND_HERO)));
        confrontation.setProfitability(Integer.parseInt(request.getParameter(Params.REQ_CONFRONTATION)));
        return confrontation;
    }
}
