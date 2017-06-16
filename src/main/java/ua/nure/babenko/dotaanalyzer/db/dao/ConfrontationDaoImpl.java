package ua.nure.babenko.dotaanalyzer.db.dao;

import ua.nure.babenko.dotaanalyzer.constants.SQLQuerys;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;
import ua.nure.babenko.dotaanalyzer.exceptions.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fomenko on 16.06.2017.
 */
public class ConfrontationDaoImpl implements ConfrontationDao {

    public int createConfrontation(ConfrontationEntity entity) {
        Connection connection = ConnectionKeeper.getConnection();
        int resultId = 0;
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLQuerys.CREATE_CONTFRONTAION,
                PreparedStatement.RETURN_GENERATED_KEYS)){
            statement.setInt(1, entity.getFirstHeroId());
            statement.setInt(2, entity.getSecondHeroId());
            statement.setInt(3,entity.getProfitability());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                resultId = resultSet.getInt(1);
            }
            resultSet.close();
            return resultId;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Error");
        }
    }

    public boolean isConfrontationExist(ConfrontationEntity entity) {
        return false;
    }

    public boolean updateContforntation(ConfrontationEntity entity) {
        return false;
    }

    public List<ConfrontationEntity> getConfrontationByHeroId() {
        return null;
    }
}
