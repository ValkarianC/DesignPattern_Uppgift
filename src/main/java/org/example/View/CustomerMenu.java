package org.example.View;

import org.example.Model.Address;
import org.example.Model.Customer;

import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

public class CustomerMenu {
    private static CustomerMenu instance;
    private Customer currentCustomer;

    private CustomerMenu(){
    }

    public static CustomerMenu getInstance(){
        if (instance == null){
            instance = new CustomerMenu();
        }
        return instance;
    }


    public void createCustomerMenu(){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        if (currentCustomer == null){
            System.out.println("        Create Customer profile\n");
        } else {
            System.out.println("        Edit Customer profile\n");
        }

        System.out.println("ID : " + (currentCustomer==null ? "" : currentCustomer.getId()));
        if (currentCustomer == null || currentCustomer.getName() == null){
            System.out.println("1: Enter Name");
        } else {
            System.out.println("1: Name: "+ currentCustomer.getName());
        }
        if (currentCustomer == null || currentCustomer.getAddress() == null){
            System.out.println("2: Enter Address");
        } else {
            System.out.println("2: Address: " + currentCustomer.getAddress().getFullAddress());
        }
        if (currentCustomer == null || currentCustomer.getEmail() == null){
            System.out.println("3: Enter email");
        } else {
            System.out.println("3: Email: " + currentCustomer.getEmail());
        }
        System.out.println("\n4: Exit to main menu");
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("Enter option:");
        processCustomerMenuChoice();
    }

    public void processCustomerMenuChoice(){
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    customerNameEntry();
                    break;
                case 2:
                    customerAddressEntry();
                    break;
                case 3:
                    customerEmailEntry();
                case 4:
                    if (currentCustomer == null || currentCustomer.getName() == null || currentCustomer.getEmail() == null || currentCustomer.getAddress() == null){
                        System.out.println("Please ensure you have entered your name, address, and email");
                        createCustomerMenu();
                    } else {
                        WelcomeMenu.getInstance().setCurrentCustomer(currentCustomer);
                    }
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid Choice");
            createCustomerMenu();
        }
    }

    public void customerNameEntry(){
        String name = "";
        name += processNameInput("First") + " " + processNameInput("Last");
        if (currentCustomer == null){
            currentCustomer = new Customer();
            assignID();
        }
        currentCustomer.setName(name);
        createCustomerMenu();
    }

    public String processNameInput(String nameType){
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("Enter "+ nameType + " Name(s):" );
        String input;
        input = scanner.nextLine();
        if (input.isBlank()){
            System.out.println("Please enter your " + nameType + "Name(s):");
            input = processNameInput(nameType);
        } else {
            return input;
        }
        return input;
    }

    public void customerAddressEntry(){
        Address address;
        if (currentCustomer == null || currentCustomer.getAddress()==null){
            address = new Address();
        } else {
            address = currentCustomer.getAddress();
        }
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        address.setAddressLine1(processAddressInput(false, "First Line of Address"));
        System.out.println(address.getAddressLine1());
        address.setAddressLine2(processAddressInput(true, "Second Line of Address"));
        address.setTown(processAddressInput(false, "Town"));
        address.setCounty(processAddressInput(true, "County"));
        address.setCountry(processAddressInput(false, "Country"));
        address.setPostcode(processAddressInput(false, "Postcode"));

        if (currentCustomer == null){
            currentCustomer = new Customer();
            assignID();
        }
        currentCustomer.setAddress(address);

        createCustomerMenu();
    }

    public String processAddressInput(boolean optional, String line){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter "+ line+":");
        String input;
        input = scanner.nextLine();

        if (!optional && input.isBlank()){
            System.out.println("This line is required");
            input = processAddressInput(optional, line);
        } else {
            return input;
        }
        return input;
    }

    public void customerEmailEntry(){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("Enter email: ");

        currentCustomer.setEmail(processEmailInput());
        createCustomerMenu();
    }

    public String processEmailInput(){
        String emailRegex = "^(.+)@(\\S+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Scanner scanner = new Scanner(System.in);

        String input;
        input = scanner.nextLine();

        if (input.isBlank() || !pattern.matcher(input).matches()){
            System.out.println("Please enter a valid email.");
            input = processEmailInput();
        } else {
            return input;
        }
        return input;
    }

    public void assignID(){
        UUID uuid = UUID.randomUUID();
        currentCustomer.setId("C" + uuid.hashCode());
        System.out.println("ID assigned to customer");
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
