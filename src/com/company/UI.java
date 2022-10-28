package com.company;


import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    DataBase db = new DataBase();
    Console console = System.console();
    Scanner scanner = new Scanner(console.reader());

    public void UserInterface(String User)throws Exception{
            db.Connection();
            console.writer().println("                          1 - Withdraw      2-Deposit\r\n                          3-Info    4-Change Currency");
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    Main.clearScreen();
                    Withdraw(User);
                case "2":
                    Main.clearScreen();
                    Deposit();
                case "3":
                    Main.clearScreen();
                    Info();
                case "4":
                    Main.clearScreen();
                    ChangeCurrency();
                default:
                    Main.clearScreen();
                    console.writer().println("Choose a proper option");
                    UserInterface(User);
            }
    }
    public void Withdraw(String usr)throws Exception{

        db.Connection();
        String amount = db.info(usr, 6);

        console.writer().println("                          1-10       4-200\r\n                          2-50       5-500\r\n                          3-100      6-1000\r\n                              7-come Back");
        String option = scanner.nextLine();
        console.writer().println("Are you sure ? y/n");
        String choice = scanner.nextLine();
        if(choice.equals("y")){
            Main.clearScreen();
            console.writer().println("Operation succeeded");
        }else{ Main.clearScreen(); Withdraw(usr); }

        int moneyBefore = Integer.valueOf(amount);
        int after;

        if (option.equals("1")){
            after =  moneyBefore - 10;
            if(after < 0){
                System.out.println("You don't have that much money to withdraw, Please check your account info");
                db.close();
                Main.clearScreen();
                UserInterface(usr);
            }
            db.UpdateAmount(after, usr);
        }else if(option.equals("2")){
            after =  moneyBefore - 50;
            if(after < 0){
                System.out.println("You don't have that much money to withdraw, Please check your account info");
                db.close();
                Main.clearScreen();
                UserInterface(usr);
            }
            db.UpdateAmount(after, usr);
        }else if(option.equals("3")){
            after =  moneyBefore - 100;
            if(after < 0){
                System.out.println("You don't have that much money to withdraw, Please check your account info");
                db.close();
                UserInterface(usr);
            }
            db.UpdateAmount(after, usr);
        }else if(option.equals("4")){
            after =  moneyBefore - 200;
            if(after < 0){
                System.out.println("You don't have that much money to withdraw, Please check your account info");
                db.close();
                UserInterface(usr);
            }
            db.UpdateAmount(after, usr);
        }else if(option.equals("5")){
            after =  moneyBefore - 500;
            if(after < 0){
                System.out.println("You don't have that much money to withdraw, Please check your account info");
                db.close();
                UserInterface(usr);
            }
            db.UpdateAmount(after, usr);
        }else if(option.equals("6")){
            after =  moneyBefore - 1000;
            if(after < 0){
                System.out.println("You don't have that much money to withdraw, Please check your account info");
                db.close();
                UserInterface(usr);
            }
            db.UpdateAmount(after, usr);
        }else if(option.equals("7")){
            db.close();
            Main.clearScreen();
            UserInterface(usr);
        }else{
            console.writer().println("Please select proper option");
            db.close();
            Withdraw(usr);
        }

        while (true){
            console.writer().println("Do you want to continue ? y/n");
            String didContinue= scanner.nextLine();
            if(didContinue.equals("n")){System.exit(0);
            }else if(didContinue.equals("y")) {
                Main.clearScreen();
                UserInterface(usr);
            }else{Main.clearScreen(); console.writer().println("Please select proper option");}
        }
    }
    public void Deposit()throws Exception{
        db.Connection();
    }
    public void Info()throws Exception{
        db.Connection();
    }
    public void ChangeCurrency()throws Exception{
        db.Connection();
    }
}
