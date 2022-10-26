package com.company;
import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        DataBase db = new DataBase();
        db.Connection();

        Console console = System.console();
        try {
            console.writer().println("Welcome to The ATM machine");
            console.writer().println("PIN");
            Scanner scanner = new Scanner(console.reader());
        }catch (Exception e){
            throw new Exception("Console is not visible", e);
        }
    }
}
