package ie.atu.bankapp;

import java.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;

public class BankDB_Connection {

    //setting essentials to connect to DB
    private static final String URL = "jdbc:mysql://localhost:3306/bankdatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final DataSource dataSource;

    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);
        dataSource = mysqlDataSource;
    }

    //getting connection
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
