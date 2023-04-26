package ie.atu.bankapp;

import java.util.Scanner;

public class BankApp extends Bank{

    //face of the application
    //make it nice to interact with for the user
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int a = -1;
        int choice;
        System.out.println("Welcome to the Banking App! "); //welcome page

        System.out.println("Please make a choice : ");
        System.out.println("1. Log in");
        System.out.println("2. Create an Account");
        System.out.println("3. Exit");
        choice = sc.nextInt();



        while(a != 1)
        {
            switch (choice) //user has choice to og in or create account
            {
                case 1 : logIn();
                    break;
                case 2: createAccount();
                break;
                case 3: a = 1;
                break;
            }
        }
        int logChoice;
        while(choice == 1) // while choice is 1, user can check balance, withdraw and deposit
        {
            System.out.println("Please make a choice : ");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");

            logChoice = sc.nextInt();

                switch(logChoice)
                {
                    case 1 : checkBal();
                    break;
                    case 2 : withdrawal();
                    break;
                    case 3 : deposit();
                    break;
                    case 4 : choice = 2;
                    break;
                }
        }






         /*
        System.out.println("Welcome, transfer funds");
        System.out.println("Enter account number: ");

        int custNum = sc.nextInt();

        System.out.println("Enter second account number: ");

        int custNum2 = sc.nextInt();

        System.out.println("Enter amount to deposit: ");

        int balance = sc.nextInt();


        Transfer(custNum, custNum2, balance);

        showBalance(custNum);
        showBalance(custNum2);
        */
    }
}
