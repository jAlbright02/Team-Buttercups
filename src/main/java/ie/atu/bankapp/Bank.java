package ie.atu.bankapp;
import java.util.Scanner;
public class Bank extends BankDB{
    private int accNumber;

    private String userName;
    private String name;
    private String password;
    private double balance;
    Scanner sc = new Scanner(System.in);

    public void logIn(){
        System.out.println("Enter account number");
        accNumber = sc.nextInt();
        System.out.println("Enter name");
        name = sc.next();
        System.out.println("Enter password");
        password = sc.next();
        System.out.println("Enter balance");
        balance = sc.nextLong();
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
        Withdraw(accNumber, balance);

    }

    public void createAccount(){
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
    }



    //log in
    //check user name
    //check password
    //take user input (Scanner)




    //create account - the code for this is basically already made just hold it in a function
    //take info - instead of a million print lines like i've left it as
    //store into database - already done by my Create() function



    //withdraw

    //deposit

    //delete acc (done, just make the menu and i'll fix the function to fit how its made)
}
