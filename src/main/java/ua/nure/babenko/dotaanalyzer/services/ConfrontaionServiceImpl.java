package ua.nure.babenko.dotaanalyzer.services;

import ua.nure.babenko.dotaanalyzer.db.dao.ConfrontationDao;
import ua.nure.babenko.dotaanalyzer.db.dao.TransactionManager;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

import java.util.List;

/**
 * Created by fomenko on 16.06.2017.
 */
public class ConfrontaionServiceImpl implements ConfrontationService {
    private ConfrontationDao confrontationDao;
    private TransactionManager transactionManager;

    public ConfrontaionServiceImpl(ConfrontationDao confrontationDao, TransactionManager transactionManager) {
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
