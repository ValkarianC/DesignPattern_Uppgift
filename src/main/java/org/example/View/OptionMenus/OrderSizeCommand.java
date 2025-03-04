package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;
import org.example.Model.Garments.GarmentSize;
import org.example.View.MenuUI;

import java.util.Scanner;

public class OrderSizeCommand implements OrderCommand {
    private String output;
    @Override
    public String process() {
        createMenu();
        return output;
    }

    @Override
    public void createMenu() {
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose size\n");
        System.out.println("1: Small");
        System.out.println("2: Medium");
        System.out.println("3: Large");
        parseUserInput();
    }

    @Override
    public void parseUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    output = String.valueOf(GarmentSize.Small);
                    break;
                case 2:
                    output = String.valueOf(GarmentSize.Medium);
                    break;
                case 3:
                    output = String.valueOf(GarmentSize.Large);
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid Entry");
            createMenu();
        }
    }
}
