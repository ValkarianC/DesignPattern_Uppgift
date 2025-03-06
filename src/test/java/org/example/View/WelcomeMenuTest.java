package org.example.View;

import org.example.Model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WelcomeMenuTest {
    WelcomeMenu welcomeMenu;
    Customer mockCustomer = mock(Customer.class);

    @BeforeEach
    void setup(){
        welcomeMenu = WelcomeMenu.getInstance();
    }

    @Test
    void whenGetInstanceInvokedCreateInstance() {
        welcomeMenu = WelcomeMenu.getInstance();
        assertTrue(welcomeMenu instanceof WelcomeMenu);
    }

    @Test
    void whenSetCurrentCustomerInvokedAttributeContainsCustomer() {
        WelcomeMenu.getInstance().setCurrentCustomer(mockCustomer);
        assertTrue(WelcomeMenu.getInstance().getCurrentCustomer() != null);
    }
}