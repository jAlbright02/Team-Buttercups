package ie.atu.bankapp;
import java.util.Scanner;
public class Bank extends BankDB{
    private static String password;
    private static float amount;
    private static String userReceiver;


    //made Scanner object static, so it can be referenced in static methods
    Scanner sc = new Scanner(System.in);

    CustomerClass customer = new CustomerClass();

    public boolean logIn () {  //asking the user to enter their login details
        System.out.println("Enter user name: ");
        customer.setUserName(sc.nextLine());
        System.out.println("Enter password: ");
        password = sc.nextLine();
        boolean login = Login(customer.getUserName(), password);
        return login;
    }


    public void deposit () { //depositing money to bank account
        System.out.println("Amount to be deposited");
        amount = sc.nextLong();
        Deposit(customer.getUserName(), amount);
        showBalance(customer.getUserName());
    }

    public void withdrawal() { //withdrawal
        System.out.println("Enter amount to be withdrawn");
        amount = sc.nextLong();
        Withdraw(customer.getUserName(), amount);
        showBalance(customer.getUserName());
    }

    public void transfer(){  //creating a transfer function
        System.out.println("Please enter amount you desire to transfer");
        amount = sc.nextLong();
        System.out.println("Please enter account number you wish to transfer funds to");
        userReceiver = sc.nextLine();
        Transfer(customer.getUserName(), userReceiver, amount);
    }

    public void checkBalance() {
        showBalance(customer.getUserName());
    }

    public void createAccount () {  //setup for new account
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
        customer.setEmail(sc.nextLine());

        String fullName = firstName + " " + lastName;

        Create(fullName, userName, pass, customer.getEmail());

        System.out.println("Account created!");
    }

}
