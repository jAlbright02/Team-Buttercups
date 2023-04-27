package ie.atu.bankapp;
import java.util.Scanner;
public class Bank extends BankDB{
    private static int accNumber;
    private static String password;
    private static float balance;
    private static float transfer;
    private static String transferAccNum;
    private boolean config;


    //made Scanner object static, so it can be referenced in static methods
    Scanner sc = new Scanner(System.in);

    CustomerClass customer = new CustomerClass();

    public void logIn () {  //asking the user to enter their login details
            System.out.println("Enter account number");
            accNumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name");
            customer.setName(sc.nextLine());
            System.out.println("Enter password");
            password = sc.next();
        }


        public void deposit () { //depositing money to bank account
            long amount;
            System.out.println("Amount to be deposited");
            amount = sc.nextLong();
            balance = balance + amount;
        }

        public void withdrawal() { //withdrawal
            float amount;
            System.out.println("Enter amount to be withdrawn");
            amount = sc.nextLong();
            Withdraw(accNumber, amount);
            showBalance(accNumber);
        }

    public void transfer(){  //creating a transfer function
        System.out.println("Please enter amount you desire to transfer");
        transfer = sc.nextLong();
        System.out.println("Please enter account number you wish to transfer funds to");
        String transferAccNum = sc.nextLine();
    }

    public void checkBal () {     //checking how much money the account holder has
        System.out.println("Your balance is" +balance);
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
