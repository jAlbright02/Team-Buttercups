package ie.atu;

import ie.atu.bankapp.BankDB;
import ie.atu.bankapp.BankDB_Connection;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestDB {
    BankDB myBank = new BankDB();

    @Test
    public void checkUserAdded() {

        //connect to db
        try (Connection connection = BankDB_Connection.getConnection()) {
            try (Statement statement = connection.createStatement()) {

                //fill in details for create method
                String name = "Test McTester";
                String userName = "TesterMcT";
                String pass = "testing123";
                String email = "test@atu.ie";

                //create the customer
                myBank.Create(name, userName, pass, email);

                //check the db holds the expected values
                int custID;

                //order by desc id, checks newly added account
                try (ResultSet rs = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC;")){
                    //point cursor to next entry
                    rs.next();
                    custID = rs.getInt("id");
                    assertEquals(name, rs.getString("name"));
                    assertEquals(userName, rs.getString("userName"));
                    assertEquals(pass, rs.getString("pass"));
                    assertEquals(email, rs.getString("email"));

                }

                //delete created account to keep db clean
                myBank.Delete(userName);

                //fix auto_increment value after testing
                String alterCust = "ALTER TABLE customers AUTO_INCREMENT = ?;";
                PreparedStatement prepSt = connection.prepareStatement(alterCust);
                prepSt.setInt(1, custID);
                String alterAcc = "ALTER TABLE accounts AUTO_INCREMENT = ?;";
                PreparedStatement prepSt2 = connection.prepareStatement(alterAcc);
                prepSt2.setInt(1, custID);

                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
