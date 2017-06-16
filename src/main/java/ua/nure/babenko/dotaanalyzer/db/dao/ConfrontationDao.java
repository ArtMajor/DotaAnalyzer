package ua.nure.babenko.dotaanalyzer.db.dao;

import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

import java.util.List;

/**
 * Created by fomenko on 16.06.2017.
 */
public interface ConfrontationDao {
    int createConfrontation(ConfrontationEntity entity);
    boolean isConfrontationExist(ConfrontationEntity entity);
    boolean updateContforntation(ConfrontationEntity entity);
    List<ConfrontationEntity> getConfrontationByHeroId();

}
