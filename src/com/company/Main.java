package com.company;
import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class Main extends DataBase {
    public static String uN;

    public static void clearScreen()throws Exception {
            if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
            Runtime.getRuntime().exec("clear");
    }

    public static void main(String[] args) throws Exception {
        clearScreen();
        AccountManager acc = new AccountManager();
        DataBase db = new DataBase();
        db.Connection();
        UI ui = new UI();
        Console console = System.console();
        Scanner scanner = new Scanner(console.reader());
        try {
            console.writer().println("Welcome to The ATM machine");
            console.writer().println("Do you have an account ? 1 = Yes | 2 = No");
            while (true) {
                int choice = scanner.nextInt();
                if (choice == 2) {
                    clearScreen();
                    acc.CreateAccount();
                    break;
                } else if (choice == 1) {
                    break;
                } else {
                    System.out.println("Please choose either option 1 or 2");
                }
            }
        }catch (Exception e) {
            throw new Exception("Console is not visible", e);
        }
            clearScreen();
            console.writer().println("Insert your Username");
            int i = 0;
            scanner.nextLine();
            while(true){
                uN = scanner.nextLine();
                String usernames = "SELECT Username FROM Users";
                boolean isTrue = db.SqlStatement(usernames, uN);
                if(isTrue){
                    break;
                }else{
                    i++;
                    if (i == 3){
                        System.out.println("Too many mistakes");
                        return;
                    }
                    clearScreen();
                    System.out.println("Incorrect Username"+ "\r\n" + "Please insert the correct username;" + " Remaining chances(" + (3-i) + ")");
                }
            }
            clearScreen();
            String sql = "SELECT PIN from Users WHERE Username = "+"'"+uN+"'";
            String findPin = db.FindPin(sql);
            while(true){
                console.writer().println("Insert your PIN");
                String pin = scanner.nextLine();
                if (findPin.equals(pin)){
                    console.writer().println("LogIn successfully");
                    clearScreen();
                    break;
                }else {
                    console.writer().println("Pin is incorrect");
                }
            }

            ui.UserInterface(uN);
    }
}
