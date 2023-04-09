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

    //withdraw

    //deposit

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
