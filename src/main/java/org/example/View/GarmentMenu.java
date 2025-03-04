package org.example.View;

import org.example.Controller.*;
import org.example.Controller.Commands.OrderDetailsPipeline;
import org.example.Model.Customer;
import org.example.Model.Order;

import java.util.HashMap;
import java.util.Scanner;

public class GarmentMenu {
    private static GarmentMenu instance;
    private Customer currentCustomer;

    private GarmentMenu(){

    }

    public static GarmentMenu getInstance(){
        if (instance == null){
            instance = new GarmentMenu();
        }
        return instance;
    }

    public void createGarmentMenu(Order order){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Place/Review order\n");
        System.out.println("1: Order new item");
        System.out.println("2: Review current order");
        System.out.println("3: Exit to main menu");

        processGarmentMenuChoice(order);


    }
    private void processGarmentMenuChoice(Order order){
        Scanner scanner = new Scanner(System.in);
        try {
            int userChoice = Integer.parseInt(scanner.next());
            switch (userChoice){
                case 1:
                        createOrderGarmentType();
                    break;
                case 2:
                    createReviewMenu(order);
                    break;
                case 3:
                    System.out.println("Returning to welcome screen will cancel any current order.\nProceed? Y/N");
                    if (scanner.next().equalsIgnoreCase("y")){
                        WelcomeMenu.getInstance().setCurrentCustomer(this.currentCustomer);
                        //WelcomeMenu.getInstance().createWelcomeMenu();
                    } else {
                        createGarmentMenu(order);
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
                    createGarmentMenu(order);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Entry");
            createGarmentMenu(order);
        }
    }


    private void createOrderGarmentType(){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose garment type\n");
        System.out.println("1: Trousers");
        System.out.println("2: T-Shirt");
        System.out.println("3: Skirt");
        processGarmentType();
    }

    private void processGarmentType(){
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    OrderService.getInstance().createTrousersOrder();
                    createGarmentMenu(OrderService.getInstance().getOrder());
                    break;
                case 2:
                    OrderService.getInstance().createTShirtOrder();
                    createGarmentMenu(OrderService.getInstance().getOrder());
                    break;
                case 3:
                    OrderService.getInstance().createSkirtOrder();
                    createGarmentMenu(OrderService.getInstance().getOrder());
                    break;
                default:
                    System.out.println("Invalid Choice");
                    createOrderGarmentType();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Entry");
            createOrderGarmentType();
        }
    }

    public void createReviewMenu(Order order){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Review Order\n");

        OrderDetailsPipeline pipeline = new OrderDetailsPipeline();

        if (OrderService.getInstance().getTotalOrder().isEmpty()){
            System.out.println("Basket Empty");
            System.out.println("\n1: Return to Order Menu");

            try {
                int choice = Integer.parseInt(new Scanner(System.in).next());
                if (choice == 1) {
                    createGarmentMenu(order);
                } else {
                    throw new Exception();
                }
            } catch (Exception e){
                System.out.println("Invalid Entry");
                createReviewMenu(order);
            }

        } else {
            double total = 0;

            for (int i = 0; i < OrderService.getInstance().getTotalOrder().size(); i++) {
                HashMap orderItem = OrderService.getInstance().getTotalOrder().get(i);
                System.out.println("Order Item: "+ (i+1));
                switch (String.valueOf(orderItem.get("Garment"))){
                    case "Trousers":
                        System.out.println(pipeline.execute(0,orderItem));
                        break;
                    case "T-Shirt":
                        System.out.println(pipeline.execute(1,orderItem));
                        break;
                    case "Skirt":
                        System.out.println(pipeline.execute(2,orderItem));
                        break;
                    default:
                        break;
                }
                total += Double.parseDouble(String.valueOf(orderItem.get("Price")));
                System.out.println();
            }
//            for (Garment garment : order.getGarments()){
//                System.out.println(garment.orderPrintout());
//                total += (garment.getPrice());
//            }
            System.out.println("Total Price: " + (String.format("%.2f", total)));
            System.out.println("\n1: Place Order");
            System.out.println("\n2: Return to Order Menu");
            try {
                int choice = Integer.parseInt(new Scanner(System.in).next());
                switch (choice){
                    case 1:
                        OrderService.getInstance().placeOrder();
                        createGarmentMenu(order);
                        break;
                    case 2:
                        createGarmentMenu(order);
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e){
                System.out.println("Invalid Entry");
                createReviewMenu(order);
            }
        }

    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
