package ua.nure.babenko.dotaanalyzer.services;

import ua.nure.babenko.dotaanalyzer.db.dao.ConfrontationDao;
import ua.nure.babenko.dotaanalyzer.db.dao.TransactionManager;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

import java.util.List;


public class ConfrontationServiceImpl implements ConfrontationService {
    private ConfrontationDao confrontationDao;
    private TransactionManager transactionManager;

    public ConfrontationServiceImpl(ConfrontationDao confrontationDao, TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.confrontationDao = confrontationDao;
    }

    @Override
    public int addConfrontation(ConfrontationEntity entity) {
        return transactionManager.execute(() -> confrontationDao.createConfrontation(entity));
    }

    @Override
    public List<ConfrontationEntity> getAllConfrontation() {
        return transactionManager.execute(() -> confrontationDao.getAllConfrontation());
    }
}
