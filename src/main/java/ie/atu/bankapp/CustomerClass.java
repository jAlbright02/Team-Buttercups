package ie.atu.bankapp;
import java.util.Scanner;

public class CustomerClass {
    public static String email;
    private static String userName;
    private static String name;


    public CustomerClass()
    {

    }
    public CustomerClass(String name, String userName, String email)
    {
        this.name = name;
        this.userName = userName;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        CustomerClass.email = email;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        CustomerClass.userName = userName;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String fullName) {
        CustomerClass.name = fullName;
    }
}
