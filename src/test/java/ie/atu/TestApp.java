package ie.atu;

import org.junit.jupiter.api.Test;
import ie.atu.bankapp.CustomerClass;

import static org.junit.jupiter.api.Assertions.*;

public class TestApp {

    //basic test to check if customer class is holding correct data when entered
    @Test
    public void checkSetGet() {
        CustomerClass customer = new CustomerClass();

        customer.setName("James Albright");
        customer.setUserName("JamesA");
        customer.setEmail("james@atu.ie");

        assertEquals("James Albright", customer.getName());
        assertNotEquals("NotJamesA", customer.getUserName());
        assertEquals("james@atu.ie", customer.getEmail());

    }

}
