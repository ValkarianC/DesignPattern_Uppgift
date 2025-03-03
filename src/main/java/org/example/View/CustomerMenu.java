package org.example.View;

import org.example.Model.Address;
import org.example.Model.Customer;

import java.util.Scanner;
import java.util.UUID;

public class CustomerMenu {
    private static CustomerMenu instance;

    private CustomerMenu(){
    }

    public static CustomerMenu getInstance(){
        if (instance == null){
            instance = new CustomerMenu();
        }
        return instance;
    }


    public void createCustomerMenu(Customer customer){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        if (customer == null){
            System.out.println("        Create Customer profile\n");
        } else {
            System.out.println("        Edit Customer profile\n");
        }

        System.out.println("ID : " + (customer==null ? "" : customer.getId()));
        if (customer == null || customer.getName() == null){
            System.out.println("1: Enter Name");
        } else {
            System.out.println("1: Name: "+ customer.getName());
        }
        if (customer == null || customer.getAddress() == null){
            System.out.println("2: Enter Address");
        } else {
            System.out.println("2: Address: " + customer.getAddress().getFullAddress());
        }
        System.out.println("\n3: Exit to main menu");
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("Enter option:");
        processCustomerMenuChoice(customer);
    }

    public void processCustomerMenuChoice(Customer customer){
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    customerNameEntry(customer);
                    break;
                case 2:
                    customerAddressEntry(customer);
                    break;
                case 3:
                    WelcomeMenu.getInstance().setCurrentCustomer(customer);
                    //WelcomeMenu.getInstance().createWelcomeMenu();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    createCustomerMenu(customer);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Choice");
            createCustomerMenu(customer);
        }
    }

    public void customerNameEntry(Customer customer){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("Enter First Name(s):");
        name += scanner.next();
        System.out.println("Enter Last Name(s):");
        name += " " + scanner.next();
        if (customer == null){
            customer = new Customer();
            assignID(customer);
        }
        customer.setName(name);
        createCustomerMenu(customer);
    }

    public void customerAddressEntry(Customer customer){
        Scanner scanner = new Scanner(System.in);
        Address address;
        if (customer == null || customer.getAddress()==null){
            address = new Address();
        } else {
            address = customer.getAddress();
        }
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        address.setAddressLine1(processAddressInput(false, "First Line of Address"));
        System.out.println(address.getAddressLine1());
        address.setAddressLine2(processAddressInput(true, "Second Line of Address"));
        address.setTown(processAddressInput(false, "Town"));
        address.setCounty(processAddressInput(true, "County"));
        address.setCountry(processAddressInput(false, "Country"));
        address.setPostcode(processAddressInput(false, "Postcode"));

        if (customer == null){
            customer = new Customer();
            assignID(customer);
        }
        customer.setAddress(address);

        createCustomerMenu(customer);
    }

    public String processAddressInput(boolean optional, String line){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter "+ line+":");
        String input = "";
        input = scanner.nextLine();

        if (!optional && input.isBlank()){
            System.out.println("This line is required");
            input = processAddressInput(optional, line);
        } else {
            return input;
        }
        return input;
    }

    public void assignID(Customer customer){
        UUID uuid = UUID.randomUUID();
        customer.setId("C" + uuid.hashCode());
        System.out.println("ID assigned to customer");
    }
}
