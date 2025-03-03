package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;
import org.example.Model.Garments.Trousers.TrouserFit;
import org.example.View.MenuUI;

import java.util.Scanner;

public class OrderFitCommand implements OrderCommand {
    private String output;
    @Override
    public String process() {
        createMenu();
        return output;
    }

    @Override
    public void createMenu() {
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose fit\n");
        System.out.println("1: Straight");
        System.out.println("2: Flared");
        parseUserInput();
    }

    @Override
    public void parseUserInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    output = String.valueOf(TrouserFit.Straight);
                    break;
                case 2:
                    output = String.valueOf(TrouserFit.Flared);
                    break;
                default:
                    System.out.println("Invalid Entry");
                    createMenu();
            }
        } catch (RuntimeException e) {
            System.out.println("Invalid Entry");
            createMenu();
        }
    }
}
