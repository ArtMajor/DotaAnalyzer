package ua.nure.babenko.dotaanalyzer.exceptions;

import java.sql.SQLException;

public class DBException extends RuntimeException {

    public DBException(String message){
        super(message);
    }

    public DBException(String message, SQLException e){
        super(message, e);
    }
}
