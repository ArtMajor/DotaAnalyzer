package ua.nure.babenko.dotaanalyzer.services;

import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

import java.util.List;

/**
 * Created by fomenko on 16.06.2017.
 */
public interface ConfrontationService {
    int addConfrontation(ConfrontationEntity entity);
    List<ConfrontationEntity> getAllConfrontation();
}
