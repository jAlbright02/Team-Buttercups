package ie.atu.bankapp;

import java.util.Scanner;

public class BankApp extends BankDB{
    //face of the application
    //make it nice to interact with for the user
    public static void main(String[] args) {
        System.out.println("Welcome");
        System.out.println("Enter account number: ");
        Scanner sc = new Scanner(System.in);
        int custNum = sc.nextInt();
        Update(custNum);
    }
}
