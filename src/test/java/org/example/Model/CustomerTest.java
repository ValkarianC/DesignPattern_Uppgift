package org.example.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerTest {
    Customer customer;
    Customer emptyCustomer;
    Address mockedAddress = mock(Address.class);

    @BeforeEach
    void setup(){
        customer = new Customer("1", "Jack", "b@p.com", mockedAddress);
        emptyCustomer = new Customer();
    }

    @Test
    void whenGetEmailInvokedReturnString() {
        String result = customer.getEmail();
        String expected = "b@p.com";
        assertEquals(expected,result);
    }

    @Test
    void whenSetEmailInvokedAttributeContainsString() {
        customer.setEmail("hello@world.se");
        assertEquals("hello@world.se", customer.getEmail());
    }

    @Test
    void whenGetAddressInvokedReturnAddress() {
        assertEquals(true, customer.getAddress() != null);
    }

    @Test
    void whenSetAddressAttributeContainsString() {
        emptyCustomer.setAddress(mockedAddress);
        assertTrue(emptyCustomer.getAddress() != null);
    }
}