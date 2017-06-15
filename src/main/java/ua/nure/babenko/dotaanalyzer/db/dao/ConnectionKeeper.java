package ua.nure.babenko.dotaanalyzer.db.dao;


import java.sql.Connection;

public class ConnectionKeeper {

    private static final ThreadLocal<Connection> connectionWrapper = new ThreadLocal<>();

    public static Connection getConnection(){
        return connectionWrapper.get();
    }

    public static void setConnection(Connection con){
        connectionWrapper.set(con);
    }

    public static void removeConnection(){
        connectionWrapper.remove();
    }
}
