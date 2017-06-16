package ua.nure.babenko.dotaanalyzer.services;

import ua.nure.babenko.dotaanalyzer.db.dao.ConfrontationDao;
import ua.nure.babenko.dotaanalyzer.db.dao.TransactionManager;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;

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
}
