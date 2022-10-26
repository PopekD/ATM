package com.company;
import java.sql.*;

public class DataBase {

    public void Connection() throws Exception {
        Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:atmDB.sqlite");
        }catch (Exception e){
            throw new Exception("Couldn't connect to the database", e);
        }
        System.out.println("Database created successfully");
    }

}
