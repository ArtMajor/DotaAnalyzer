package ua.nure.babenko.dotaanalyzer.db.dao;

import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

import java.util.List;


public interface ConfrontationDao {
    int createConfrontation(ConfrontationEntity entity);
    boolean isConfrontationExist(ConfrontationEntity entity);
    boolean updateConfrontation(ConfrontationEntity entity);
    List<ConfrontationEntity> getAllConfrontation();

}
