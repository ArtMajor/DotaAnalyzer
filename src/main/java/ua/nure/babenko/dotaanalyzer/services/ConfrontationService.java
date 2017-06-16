package ua.nure.babenko.dotaanalyzer.services;

import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

/**
 * Created by fomenko on 16.06.2017.
 */
public interface ConfrontationService {
    int addConfrontation(ConfrontationEntity entity);
}
