package com.company;
import java.io.Console;
import java.util.Scanner;

public class Main extends DataBase {
    public static void main(String[] args) throws Exception {

        AccountManager acc = new AccountManager();
        DataBase db = new DataBase();
        db.Connection();
        Console console = System.console();
        Scanner scanner = new Scanner(console.reader());
        try {
            console.writer().println("Welcome to The ATM machine");
            console.writer().println("Do you have an account ? 1 = Yes | 2 = No");
            while (true) {
                int choice = scanner.nextInt();
                if (choice == 2) {
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

            console.writer().println("Insert your Username");
            int i = 0;

            while(true){
                scanner.nextLine();
                String uN = scanner.nextLine();
                String usernames = "SELECT Username FROM Users";
                if(db.SqlStatement(usernames, uN)){
                    break;
                }else{
                    i++;
                    if (i == 3){
                        System.out.println("Too many mistakes");
                        return;
                    }
                    System.out.println("Incorrect Username"+ "\r\n" + "Please insert the correct username;" + " Remaining chances(" + (3-i) + ")");
                }
            }
            while(true){
                console.writer().println("Insert your PIN");
                String pin = "SELECT PIN FROM Users";
            }

    }
}
