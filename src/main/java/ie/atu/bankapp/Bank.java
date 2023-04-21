package ie.atu.bankapp;
import java.util.Scanner;
public class Bank extends BankDB{
    private int accNumber;

    private String userName;    //setup for the login
    private String name;
    private String password;
    private float balance;
    private boolean config;

    //made Scanner object static, so it can be referenced in static methods
    static Scanner sc = new Scanner(System.in);

        public void configCustomer()  //loop for new or returning customer
        {
            System.out.println("Enter true if registered customer, enter false if new customer : ");
            config = sc.nextBoolean();
            if(config == true)
            {
                logIn();
            }
            else{
                createAccount();
            }
        }

        public void logIn () {  //asking the user to enter their login details
            System.out.println("Enter account number");
            accNumber = sc.nextInt();
            System.out.println("Enter name");
            name = sc.next();
            System.out.println("Enter password");
            password = sc.next();
            System.out.println("Enter balance");
            balance = sc.nextLong();
        }


        public void deposit () { //depositing money to bank account
            long amount;
            System.out.println("Amount to be deposited");
            amount = sc.nextLong();
            balance = balance + amount;
        }

        public static void withdrawal(int accNumber) { //withdrawal
            float amount;
            System.out.println("Enter amount to be withdrawn");
            amount = sc.nextLong();
            Withdraw(accNumber, amount);
            showBalance(accNumber);
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
            String email = sc.nextLine();

            String fullName = firstName + " " + lastName;

            Create(fullName, userName, pass, email);

            System.out.println("Account created!");
        }

        public void checkBal () {

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
