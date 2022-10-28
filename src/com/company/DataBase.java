package com.company;
import java.sql.*;

public class DataBase {
    Connection c = null;
    Card card = new Card();
    Statement stmt;
    public void Connection() throws Exception {
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:atmDB.sqlite");
        }catch (Exception e){
            throw new Exception("Couldn't connect to the database", e);
        }
    }
    public boolean SqlStatement(String sql, String UN){
        try{
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String data = rs.getString(1);
                if (UN.equals(data)){
                    return true;
                }
            }
            stmt.executeQuery(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public String FindPin(String sql){
        String pin = "";
        try{
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            pin = rs.getString(1);
            stmt.close();
            c.close();
        }catch(SQLException e){ System.out.println(e.getMessage()); }
        return pin;
    }
    public void InsertAcc(String cardName, String pin, String cardNumber, int cvv, String expiration){

        String getusr = "SELECT id FROM Users WHERE Username ='"+cardName+"'";

        try {

            String usr = "INSERT INTO Users(Username, PIN) VALUES ('"+cardName+"','"+pin+"')";
            stmt = c.createStatement();
            stmt.executeUpdate(usr);
            stmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        try{

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(getusr);
            String uId = rs.getString(1);
            String sql = "INSERT INTO Card('Card Number', CVV, Expiration, id) VALUES ('"+cardNumber+"',"+cvv+",'"+expiration+"',"+uId+")";
            stmt.executeUpdate(sql);
            stmt.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public String info(String user, int column){
        String get = "SELECT id FROM Users WHERE Username = "+"'"+user+"'";
        try{

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(get);
            int uid = rs.getInt(1);

            String sql = "SELECT * FROM Card WHERE id = "+"'"+uid+"'";

            stmt = c.createStatement();
            ResultSet info = stmt.executeQuery(sql);
            String information = info.getString(column);
            stmt.close();
            return information;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void close()throws Exception{
        stmt.close();
        c.close();
    }
    public void UpdateAmount(int after, String usr){


        String get = "SELECT id FROM Users WHERE Username = "+"'"+usr+"'";
        try{

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(get);
            int uid = rs.getInt(1);

            String sql = "UPDATE Card SET Amount = "+after+" WHERE id = "+"'"+uid+"'";

            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
