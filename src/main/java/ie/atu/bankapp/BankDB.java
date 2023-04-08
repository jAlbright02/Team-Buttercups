package ie.atu.bankapp;

import java.sql.*;
public class BankDB {
    //create account

    //show balance

    //withdraw

    //deposit

    //delete acc
    public static void Update(int custNum) {
        String updateSQL = "DELETE FROM accounts WHERE id =" + custNum;
        String updateSQL2 = "DELETE FROM customers WHERE id =" + custNum;
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
                int rowsUpdated = statement.executeUpdate(updateSQL);
                System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
                e.printStackTrace();
            }
        try (Connection connection = BankDB_Connection.getConnection();
             Statement statement = connection.createStatement()) {
            int rowsUpdated = statement.executeUpdate(updateSQL2);
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
