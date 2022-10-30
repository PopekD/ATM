package com.company;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountManager {
    Card card = new Card();
    DataBase db = new DataBase();
    Console console = System.console();
    public void CreateAccount()throws Exception {
        db.Connection();
        Scanner scanner = new Scanner(console.reader());

        console.writer().println("CardName");
        card.setNameCard( scanner.nextLine() );

        while (true){
            console.writer().println("Card Number (Without Space)");
            String cardNumber = scanner.nextLine();
            boolean didMatch = Pattern.matches("\\d{16}", cardNumber);
            if (!didMatch){
                console.writer().println("Please Input correct card Number");
            }else{
                card.setCardNumber(cardNumber);
                break;
            }
        }
        while(true){
            console.writer().println("Expiration Date (00/00)");
            String expDate = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
            simpleDateFormat.setLenient(false);
            boolean didMatch = expDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}");
            if(!didMatch){ console.writer().println("Please input valid data"); }
            try{
                Date expiry = simpleDateFormat.parse(expDate);
                boolean expired = expiry.before(new Date());
                if (!expired){
                    card.setExpirationDate(expDate);
                    break;
                }else { console.writer().println("Please input valid data"); }
            }catch (ParseException e){
                System.out.println();
            }
        }
        while (true){
            console.writer().println("CVV");
            String cvv = scanner.nextLine();
            boolean didMatch = cvv.matches("\\d{3}");
            if(!didMatch){
                System.out.println("Please input valid data");
            } else { card.setCvv(Integer.parseInt(cvv));
                break;
            }
        }
        while (true){
            console.writer().println("PIN");
            String pin = scanner.nextLine();
            boolean didMatch = pin.matches("\\d{4}");
            if(!didMatch){
                System.out.println("Please input correct pin");
            }else { card.setPin(pin);
                break;
            }
        }
        db.InsertAcc(card.getNameCard(), card.getPin(), card.getCardNumber(), card.getCvv(), card.getExpirationDate());
    }
}
