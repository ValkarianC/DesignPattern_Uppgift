package org.example.View;

import org.example.Model.Customer;

import java.util.Scanner;

public class WelcomeMenu {
    private static WelcomeMenu instance;
    private GarmentMenu garmentMenu;
    private Customer currentCustomer;

    private WelcomeMenu(){
        garmentMenu = GarmentMenu.getInstance();
        currentCustomer = null;
    }

    public static WelcomeMenu getInstance(){
        if (instance == null){
            instance = new WelcomeMenu();
        }
        return instance;
    }



    public void createWelcomeMenu(){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Welcome to Wigellkoncernens \"Clothes-on-Demand\"\n");
        if (currentCustomer == null){
            System.out.println("1: Create profile (Required before placing order)");
        } else {
            System.out.println("1: Review Profile: "+ currentCustomer.getName());
        }
        System.out.println("2: Place Order\n" +
                "3: Exit application");
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("Enter option: ");
        processUserChoice();
    }

    private void processUserChoice(){
        Scanner scanner = new Scanner(System.in);
        try{
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    CustomerMenu.getInstance().createCustomerMenu(currentCustomer);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Are you sure you want to quit? Y/N");
                    if (scanner.next().equalsIgnoreCase("Y")){
                        System.out.println("Goodbye");
                        break;
                    } else {
                        createWelcomeMenu();
                    }
                    break;
                default:
                    System.out.println("Invalid Entry");
                    createWelcomeMenu();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Entry");
            createWelcomeMenu();
        }
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
