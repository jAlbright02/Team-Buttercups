package ie.atu.bankapp;
import java.util.Scanner;
public class Bank {
    private String accNumber;
    private String name;
    private String password;
    private long balance;
    Scanner sc = new Scanner(System.in);

    public void logIn(){
        System.out.println("Enter account number");
        accNumber = sc.next();
        System.out.println("Enter name");
        name = sc.next();
        System.out.println("Enter password");
        password = sc.next();
        System.out.println("Enter balance");
        balance = sc.nextLong();
    }
    public void showLogIn(){
        System.out.println("Name of account: " + accNumber);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println("Balance: " + balance);
    }

    public void deposit(){ //depositing
        long amount;
        System.out.println("Amount to be deposited");
        amount = sc.nextLong();
        balance = balance + amount;
    }
    public void withdrawal(){ //withdrawal
        long amount;
        System.out.println("Enter amount to be withdrawn");
        amount = sc.nextLong();
        if(balance >= amount){
            balance = balance - amount;
            System.out.println("Balance after withdrawal" + balance);
        }else{
            System.out.println("Your balance is less than " + amount);
        }
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
