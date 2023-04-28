package ie.atu.bankapp;

import java.sql.*;
public class BankDB {

    //creates user account
    public static void Create(String fullName, String userName, String pass, String email) {

        //sql code to add received details into connected database
        String createCommand = "INSERT INTO customers (name, userName, pass, email) VALUES(?, ?, ?, ?);";
        String createCommand2 = "INSERT INTO accounts (customer_id, balance) VALUES ((SELECT id FROM customers ORDER BY id DESC LIMIT 1), 0);";

        //attempt to connect to database and execute the sql query, if unsuccessful catch and print error
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            //prepared statement used to sub in values from user, quicker compilation after first use as the database doesn't have to recompile and is good security
            PreparedStatement prepSt = connection.prepareStatement(createCommand);
            prepSt.setString(1, fullName);
            prepSt.setString(2, userName);
            prepSt.setString(3, pass);
            prepSt.setString(4, email);

            prepSt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //a workaround to match customer_id in accounts database, this is so it matches the id in customers
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createCommand2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //show balance
    public static void showBalance(String userName) {

        String balanceCommand = "SELECT balance FROM accounts WHERE customer_id = (SELECT id FROM customers WHERE userName = ?);";

        //create resultset object, used to retieve information from the database and points to one entry
        ResultSet rs;

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(balanceCommand);
            prepSt.setString(1, userName);
            rs = prepSt.executeQuery();
            //need this to move cursor forward otherwise it is pointing at nothing and it will display nothing
            rs.next();
            System.out.println("Balance = " + rs.getFloat("balance"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //withdraw
    public static void Withdraw(String userName, float amount) {

        String withdrawCommand = "UPDATE accounts SET balance = balance - ? WHERE customer_id = (SELECT id FROM customers WHERE userName = ?);";
        String checkAmount = "SELECT balance FROM accounts WHERE customer_id = (SELECT id FROM customers WHERE userName = ?);";

        //create resultset object, used to retieve information from the database and points to one entry
        ResultSet rs;

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(checkAmount);
            connection.setAutoCommit(false);
            prepSt.setString(1, userName);
            rs = prepSt.executeQuery();

            //check if there is any value in result set
            if (rs.next()) {

                //grab value from balance depending on customer id
                float balance = rs.getFloat("balance");

                //check if the amount withdrawn is larger than balance
                if (balance > amount) {

                    //if less than balance, attempt to withdraw amount entered
                    try {
                        PreparedStatement prepSt2 = connection.prepareStatement(withdrawCommand);
                        prepSt2.setFloat(1, amount);
                        prepSt2.setString(2, userName);

                        prepSt2.executeUpdate();

                        connection.commit();
                        connection.setAutoCommit(true);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                //if not enough, print error for user to understand
                else {
                    System.out.println("Insufficient funds to withdraw.");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //deposit
    public static void Deposit(String userName, float amount) {
        //updates balance
        String depositCommand = "UPDATE accounts SET balance = balance + ? WHERE customer_id = (SELECT id FROM customers WHERE userName = ?);";

        //connects to the database
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(depositCommand);
            connection.setAutoCommit(false);
            prepSt.setFloat(1, amount);
            prepSt.setString(2, userName);

            //update balance
            prepSt.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete account
    public static void Delete(String userName) {

        //sql commands to be processed, didn't use prepared statements here, will change later
        String deleteCommand = "DELETE FROM accounts WHERE customer_id =(SELECT id FROM customers WHERE userName = ?);";
        String deleteCommand2 = "DELETE FROM customers WHERE customer_id =(SELECT id FROM customers WHERE userName = ? );";

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(deleteCommand);
            prepSt.setString(1, userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(deleteCommand2);
            prepSt.setString(1, userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //transaction between accounts
    public static void Transfer(String userName, String userReciever, float amount) {

        //updates the balances of accounts
        String depositCommand = "UPDATE accounts SET balance = balance + ? WHERE userName = ?;";
        String withdrawCommand = "UPDATE accounts SET balance = balance - ? WHERE userName = ?;";

        //database connection
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {


            // Deposit to the reciever account
            PreparedStatement recieverSt = connection.prepareStatement(depositCommand);
            connection.setAutoCommit(false);
            recieverSt.setFloat(1, amount);
            recieverSt.setString(2, userReciever);

            //updates amount in database
            recieverSt.executeUpdate();

            // Withdraw from source account
            PreparedStatement withdrawSt = connection.prepareStatement(withdrawCommand);
            withdrawSt.setFloat(1, amount);
            withdrawSt.setString(2, userName);

            //updates amount in database
            withdrawSt.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean Login(String userName, String password) {

        boolean found = false;

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM customers");

            while (rs.next()) {
                String usernameFromDB = rs.getString("userName");
                String passwordFromDB = rs.getString("pass");

                if((userName.equals(usernameFromDB)) && (password.equals(passwordFromDB))) {
                    found = true;
                    break;
                }
            }

            rs.close();

            if (found) {
                System.out.println("Login successful!\n");
            } else {
                System.out.println("Incorrect username or password.\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return found;

    }
}







