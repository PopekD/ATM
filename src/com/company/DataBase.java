package com.company;
import java.sql.*;

public class DataBase {
    Connection c = null;
    Card card = new Card();
    public void Connection() throws Exception {
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:atmDB.sqlite");
        }catch (Exception e){
            throw new Exception("Couldn't connect to the database", e);
        }
        System.out.println("Connected to the database successfully");
    }
    public boolean SqlStatement(String sql, String UN){
        Statement stmt;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:atmDB.sqlite");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String data = rs.getString(1);
                if (UN.equals(data)){
                    return true;
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public void InsertAcc(String cardName, String pin, String cardNumber, int cvv, String expiration){
        Statement stmt;
        String getusr = "SELECT id FROM Users WHERE Username ='"+cardName+"'";

        try {
            c = DriverManager.getConnection("jdbc:sqlite:atmDB.sqlite");
            String usr = "INSERT INTO Users(Username, PIN) VALUES ('"+cardName+"','"+pin+"')";
            stmt = c.createStatement();
            stmt.executeUpdate(usr);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        try{
            c = DriverManager.getConnection("jdbc:sqlite:atmDB.sqlite");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getusr);
            String uId = rs.getString(1);
            String sql = "INSERT INTO Card('Card Number', CVV, Expiration, id) VALUES ('"+cardNumber+"',"+cvv+",'"+expiration+
                    "',"+uId+")";
            stmt.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
