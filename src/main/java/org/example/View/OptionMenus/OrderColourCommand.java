package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;
import org.example.Model.Garments.GarmentColour;
import org.example.View.MenuUI;

import java.util.Scanner;

public class OrderColourCommand implements OrderCommand {
    private String output;

    @Override
    public String process() {

        createMenu();
        return output;

    }

    public void createMenu(){
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose colour\n");
        System.out.println("1: Red");
        System.out.println("2: Yellow");
        System.out.println("3: Blue");
        parseUserInput();
    }

    public void parseUserInput(){
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    this.output = String.valueOf(GarmentColour.Red);
                    break;
                case 2:
                    this.output = String.valueOf(GarmentColour.Yellow);
                    break;
                case 3:
                    this.output = String.valueOf(GarmentColour.Blue);
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
