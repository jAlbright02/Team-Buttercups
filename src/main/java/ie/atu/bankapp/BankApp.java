package ie.atu.bankapp;

import java.util.Scanner;

public class BankApp extends Bank{


    //face of the application
    //make it nice to interact with for the user
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank myBank = new Bank();

        int a = -1, b = -1;
        int choice = 0;

        System.out.println("Welcome to the Banking App! "); //welcome page

        while (b == -1) {

            while (a != 1) {
                System.out.println("Please make a choice : ");
                System.out.println("1. Log in");
                System.out.println("2. Create an Account");
                System.out.println("3. Exit");
                choice = sc.nextInt();

                switch (choice) //user has choice to og in or create account
                {
                    case 1:
                        if (myBank.logIn()) {
                            a = 1;
                        }
                        ;
                        break;
                    case 2:
                        myBank.createAccount();
                        a = 1;
                        break;
                    case 3:
                        System.out.println("Thank you for using the Banking App.");
                        a = 1;
                        b = 1;
                        break;
                }
            }
            int logChoice;
            while (choice == 1 || choice == 2) // while choice is 1, user can check balance, withdraw and deposit
            {
                System.out.println("Please make a choice : ");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Log Out");

                logChoice = sc.nextInt();

                switch (logChoice) {
                    case 1:
                        myBank.checkBal();
                        break;
                    case 2:
                        myBank.withdrawal();
                        break;
                    case 3:
                        myBank.deposit();
                        break;
                    case 4:
                        System.out.println("Thank you for using the Banking App.\n");
                        choice = 3;
                        a = -1;
                        break;
                }
            }
        }







    }
}
