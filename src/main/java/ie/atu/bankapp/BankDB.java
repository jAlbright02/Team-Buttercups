package ie.atu.bankapp;

import java.sql.*;
public class BankDB {
    //create account
    public static void Create(String fullName, String userName, String pass, String email) {

        String createCommand =  "INSERT INTO customers (name, userName, pass, email) VALUES(?, ?, ?, ?);";
        String createCommand2 = "INSERT INTO accounts (customer_id, balance) VALUES ((SELECT id FROM customers ORDER BY id DESC LIMIT 1), 0);";

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(createCommand);
            prepSt.setString(1, fullName);
            prepSt.setString(2, userName);
            prepSt.setString(3, pass);
            prepSt.setString(4, email);

            prepSt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createCommand2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //show balance
    public static void showBalance(int custNum) {

        String balanceCommand = "SELECT balance FROM accounts WHERE customer_id = ?;";

        ResultSet rs;

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(balanceCommand);
            prepSt.setInt(1, custNum);
            rs = prepSt.executeQuery();
            rs.next();
            System.out.println("Balance = " + rs.getInt("balance"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //withdraw
    public static void Withdraw(int custNum, double Balance) {

        String withdrawCommand =  "UPDATE accounts SET balance = balance - ? WHERE customer_id = ?;";

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(withdrawCommand);
            prepSt.setDouble(1, Balance);
            prepSt.setInt(2, custNum);


            prepSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //deposit
    public static void Deposit(int custNum, double balance) {

        String depositCommand = "UPDATE accounts SET balance = balance + ? WHERE customer_id = ?;";

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(depositCommand);
            prepSt.setDouble(1, balance);
            prepSt.setInt(2, custNum);

            prepSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete acc
    public static void Delete(int custNum) {
        String deleteCommand = "DELETE FROM accounts WHERE id =" + custNum;
        String deleteCommand2 = "DELETE FROM customers WHERE id =" + custNum;
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
                int rowsUpdated = statement.executeUpdate(deleteCommand);
                System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
                e.printStackTrace();
            }
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            int rowsUpdated = statement.executeUpdate(deleteCommand2);
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //transaction between accounts
    public static void Transfer(int sourceCustNum, int recieverCustNum, double balance) {

        //updates the balances of accounts
        String depositCommand = "UPDATE accounts SET balance = balance + ? WHERE customer_id = ?;";
        String withdrawCommand = "UPDATE accounts SET balance = balance - ? WHERE customer_id = ?;";

        //database connection
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {


            // Deposit to the reciever account
            PreparedStatement recieverSt = connection.prepareStatement(depositCommand);
            recieverSt.setDouble(1, balance);
            recieverSt.setInt(2, recieverCustNum);

            //updates amount in database
            recieverSt.executeUpdate();

            // Withdraw from source account
            PreparedStatement withdrawSt = connection.prepareStatement(withdrawCommand);
            withdrawSt.setDouble(1, balance);
            withdrawSt.setInt(2, sourceCustNum);

            //updates amount in database
            withdrawSt.executeUpdate();

            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
