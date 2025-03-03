package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;
import org.example.Model.Garments.Trousers.TrouserLength;
import org.example.View.MenuUI;

import java.util.Scanner;

public class OrderLengthCommand implements OrderCommand{
    private String output;
    @Override
    public String process() {
        createMenu();
        return output;
    }

    @Override
    public void createMenu() {
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose length\n");
        System.out.println("1: Regular");
        System.out.println("2: Long");
        parseUserInput();
    }

    @Override
    public void parseUserInput() {
        Scanner scanner = new Scanner(System.in);


        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    output = String.valueOf(TrouserLength.Regular);
                    break;
                case 2:
                    output = String.valueOf(TrouserLength.Long);
                    break;
                default:
                    System.out.println("Invalid Entry");
                    createMenu();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Entry");
            createMenu();
        }
    }
}
