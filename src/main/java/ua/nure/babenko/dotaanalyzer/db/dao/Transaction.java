package ua.nure.babenko.dotaanalyzer.db.dao;


import java.sql.SQLException;

public interface Transaction<T> {
    T execute() throws SQLException;
}
