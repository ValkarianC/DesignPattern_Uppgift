package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;
import org.example.Model.Garments.TShirt.TShirtNeck;
import org.example.View.MenuUI;

import java.util.Scanner;

public class OrderNeckCommand implements OrderCommand {
    private String output;
    @Override
    public String process() {
        createMenu();
        return output;
    }

    @Override
    public void createMenu() {
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose neckline\n");
        System.out.println("1: Polo");
        System.out.println("2: Turtleneck");
        parseUserInput();
    }

    @Override
    public void parseUserInput() {
        Scanner scanner =  new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    this.output = String.valueOf(TShirtNeck.Polo);
                    break;
                case 2:
                    this.output = String.valueOf(TShirtNeck.Turtleneck);
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Invalid Entry");
            createMenu();
        }
    }
}
