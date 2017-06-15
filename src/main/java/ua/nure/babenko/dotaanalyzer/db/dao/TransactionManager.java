package ua.nure.babenko.dotaanalyzer.db.dao;


import org.apache.log4j.Logger;
import ua.nure.babenko.dotaanalyzer.constants.LogMessages;
import ua.nure.babenko.dotaanalyzer.exceptions.DBException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private static final Logger LOG = Logger.getLogger(TransactionManager.class);

    private DataSource dataSource;

    public TransactionManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public <T> T execute(Transaction<T> transaction){
        Connection con = null;
        try{
            con = dataSource.getConnection();
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ConnectionKeeper.setConnection(con);
            T value = transaction.execute();
            con.commit();
            LOG.debug(LogMessages.TRANSACTION_SUCCESS);
            return value;
        } catch (SQLException e) {
            LOG.error(LogMessages.TRANSACTION_FAIL);
            rollback(con);
            throw new DBException(LogMessages.TRANSACTION_FAIL, e);
        } finally {
            ConnectionKeeper.removeConnection();
            close(con);
        }
    }

    private void rollback(Connection con) {
        if(con != null) {
            try {
                con.rollback();
                LOG.info(LogMessages.ROLLBACK_SUCCESS);
            } catch (SQLException e) {
                LOG.error(LogMessages.ROLLBACK_FAILED, e);
                throw new DBException(LogMessages.ROLLBACK_FAILED, e);
            }
        }
    }

    private void close(Connection con) {
        if(con != null) {
            try {
                con.close();
                LOG.info(LogMessages.CONNECTION_CLOSED);
            } catch (SQLException e) {
                LOG.error(LogMessages.CLOSE_CONNECTION_FAIL, e);
                throw new DBException(LogMessages.CLOSE_CONNECTION_FAIL, e);
            }
        }
    }
}
