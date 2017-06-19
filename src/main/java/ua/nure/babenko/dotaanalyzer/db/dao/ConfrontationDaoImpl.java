package ua.nure.babenko.dotaanalyzer.db.dao;

import ua.nure.babenko.dotaanalyzer.constants.DatabaseFields;
import ua.nure.babenko.dotaanalyzer.constants.SQLQuerys;
import ua.nure.babenko.dotaanalyzer.db.entity.ConfrontationEntity;
import ua.nure.babenko.dotaanalyzer.exceptions.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

    public boolean updateConfrontation(ConfrontationEntity entity) {
        return false;
    }

    public List<ConfrontationEntity> getAllConfrontation() {
        Connection connection = ConnectionKeeper.getConnection();
        ResultSet resultSet = null;
        List<ConfrontationEntity> confrontationEntityList = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SQLQuerys.GET_ALL_CONFRONTATION)) {
            resultSet = statement.executeQuery();
            confrontationEntityList = parseConfrontationList(resultSet);

            resultSet.close();
            return confrontationEntityList;
        }catch (SQLException e) {

            throw new DBException("Error");
        }
    }

    private List<ConfrontationEntity> parseConfrontationList(ResultSet resultSet)throws SQLException {
        List<ConfrontationEntity> confrontationEntityList = new ArrayList<>();
        ConfrontationEntity confrontationEntity = new ConfrontationEntity();
        while (resultSet.next()) {
            confrontationEntity = parseConfrontation(resultSet);
            confrontationEntityList.add(confrontationEntity);
        }
        return confrontationEntityList;
    }

    private ConfrontationEntity parseConfrontation(ResultSet resultSet) throws SQLException{
        ConfrontationEntity confrontationEntity = new ConfrontationEntity();
        confrontationEntity.setFirstHeroId(resultSet.getInt(DatabaseFields.FIRST_HERO_FIELD));
        confrontationEntity.setSecondHeroId(resultSet.getInt(DatabaseFields.SECOND_HERO_FIELD));
        confrontationEntity.setProfitability(resultSet.getInt(DatabaseFields.HERO_CONFRONTATION));
        return confrontationEntity;
    }
}
