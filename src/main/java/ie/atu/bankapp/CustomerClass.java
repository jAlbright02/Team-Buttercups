package ie.atu.bankapp;
import java.util.Scanner;

public class CustomerClass extends Bank
{
    public static String email;
    private static String userName;
    private static String fullName;

    public CustomerClass()
    {

    }
    public CustomerClass(String fullName, String userName, String email)
    {

        this. fullName = fullName;
        this.userName = userName;
        this.email = email;

    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        CustomerClass.email = email;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        CustomerClass.userName = userName;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        CustomerClass.fullName = fullName;
    }
}
