package ie.atu.bankapp;

import java.util.Scanner;

public class BankApp extends Bank{
    //face of the application
    //make it nice to interact with for the user
    public static void main(String[] args) {

        //all this to be cleaned up. everything in here should just be calling functions basically


        Scanner sc = new Scanner(System.in);


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






        /*
        System.out.println("Create new account: ");
        System.out.println("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter username: ");
        String userName = sc.nextLine();
        System.out.println("Create password: ");
        String pass = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();

        String fullName = firstName + " " + lastName;

        Create(fullName, userName, pass, email);

        System.out.println("Account created!");
        */
    }
}
