package org.example;

import org.example.Model.Address;
import org.example.Model.Customer;

import org.example.View.WelcomeMenu;

public class Main {
    public static void main(String[] args) {
        WelcomeMenu welcomeMenu = WelcomeMenu.getInstance();

//        //Premade customer to use to bypass creating a new customer in the app
//        Address address = new Address("123 House","Empty Road","Ghost Town","Gloucestershire","West Country","123 98");
//        welcomeMenu.setCurrentCustomer(new Customer("C1","John Smith", "hello@world.com", address));

        welcomeMenu.createWelcomeMenu();
    }
}