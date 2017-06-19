package ua.nure.babenko.dotaanalyzer.services;


import ua.nure.babenko.dotaanalyzer.db.dao.TransactionManager;
import ua.nure.babenko.dotaanalyzer.db.dao.UserDao;

public class UserServiceImpl implements UserService{

    private TransactionManager transactionManager;
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao, TransactionManager transactionManager){
        this.transactionManager = transactionManager;
        this.userDao = userDao;
    }
}
