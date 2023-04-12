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
    public static void Withdraw(int custNum, int Balance) {

        String withdrawCommand =  "UPDATE accounts SET balance = balance - ? WHERE customer_id = ?;";

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(withdrawCommand);
            prepSt.setInt(1, custNum);
            prepSt.setInt(2, Balance);


            prepSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //deposit
    public static void Deposit(int custNum, int balance) {

        String depositCommand = "UPDATE accounts SET balance = balance + ? WHERE customer_id = ?;";

        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement prepSt = connection.prepareStatement(depositCommand);
            prepSt.setInt(1, custNum);
            prepSt.setInt(2, balance);

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
}
