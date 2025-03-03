package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;
import org.example.Model.Garments.GarmentMaterial;
import org.example.View.MenuUI;

import java.util.Scanner;

public class OrderMaterialCommand implements OrderCommand {
    private String output;
    @Override
    public String process() {
        createMenu();
        return output;
    }

    @Override
    public void createMenu() {
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose material\n");
        System.out.println("1: Cotton");
        System.out.println("2: Wool");
        System.out.println("3: Polyester");
        parseUserInput();
    }

    @Override
    public void parseUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    output = String.valueOf(GarmentMaterial.Cotton);
                    break;
                case 2:
                    output = String.valueOf(GarmentMaterial.Wool);
                    break;
                case 3:
                    output = String.valueOf(GarmentMaterial.Polyester);
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
