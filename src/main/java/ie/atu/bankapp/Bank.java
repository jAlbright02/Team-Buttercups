package ie.atu.bankapp;
import java.util.Scanner;
public class Bank {
    private String accNumber;
    private String name;
    private String password;
    Scanner sc = new Scanner(System.in);

    public void logIn(){
        System.out.println("Enter account number");
        accNumber = sc.next();
        System.out.println("Enter name");
        name = sc.next();
        System.out.println("Enter password");
        password = sc.next();
    }
    public void showLogIn(){
        System.out.println("Name of account: " + accNumber);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
    }



    //log in
    //check user name
    //check password
    //take user input (Scanner)
    //database function to compare against (James' Job)



    //create account - the code for this is basically already made just hold it in a function
    //take info - instead of a million print lines like i've left it as
    //store into database - already done by my Create() function

    //show balance (easy enough stuff) lol

    //withdraw

    //deposit

    //delete acc (done, just make the menu and i'll fix the function to fit how its made)
}
