package ie.atu.bankapp;

import java.util.Scanner;

public class BankApp extends BankDB{
    //face of the application
    //make it nice to interact with for the user
    public static void main(String[] args) {

        //all this to be cleaned up. everything in here should just be calling functions basically

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome");
        System.out.println("Enter account number: ");

        int custNum = sc.nextInt();

        System.out.println("Enter amount to deposit: ");

        int balance = sc.nextInt();


        Deposit(custNum, balance);

        showBalance(custNum);

        System.out.println("Enter account number: ");

        custNum = sc.nextInt();

        System.out.println("Enter amount to withdraw: ");

        balance = sc.nextInt();


        Withdraw(custNum, balance);

        showBalance(custNum);
    }
}
