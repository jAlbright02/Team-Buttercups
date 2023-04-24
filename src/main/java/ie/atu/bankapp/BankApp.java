package ie.atu.bankapp;

import java.util.Scanner;

public class BankApp extends Bank{

    //face of the application
    //make it nice to interact with for the user
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //all this to be cleaned up. everything in here should just be calling functions basically

        System.out.println("Welcome to Banking App! ");

        System.out.println("1. Log in");
        System.out.println("2. Create an Account");
        System.out.println("3. Exit");

        int x = -1;
        while(x != 1)
        {
            switch (x){
                case 1 : logIn();
                    break;
                case 2: createAccount();
                break;
                case 3: x=1;
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

        System.out.println("Enter account number: ");

        int custNum = sc.nextInt();

        withdrawal(custNum);
        showBalance(custNum);
    }
}
