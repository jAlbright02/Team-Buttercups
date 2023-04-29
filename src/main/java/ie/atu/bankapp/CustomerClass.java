package ie.atu.bankapp;
import java.util.Scanner;

public class CustomerClass {
    public static String email;
    private static String userName;
    private static String name;
    private static String phone;
    private static String street;
    private static String city;
    private static String county;

    public CustomerClass()
    {

    }
    public CustomerClass(String name, String userName, String email, String phone, String street, String city, String county)
    {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.county = county;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        CustomerClass.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        CustomerClass.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        CustomerClass.name = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        CustomerClass.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        CustomerClass.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        CustomerClass.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        CustomerClass.county = county;
    }
}
