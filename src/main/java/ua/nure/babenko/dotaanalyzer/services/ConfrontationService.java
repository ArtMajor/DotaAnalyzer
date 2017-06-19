package ua.nure.babenko.dotaanalyzer.services;

import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

import java.util.List;


public interface ConfrontationService {
    int addConfrontation(ConfrontationEntity entity);
    List<ConfrontationEntity> getAllConfrontation();
}
