package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;
import org.example.Model.Garments.Skirt.SkirtWaistline;
import org.example.View.MenuUI;

import java.util.Scanner;

public class OrderWaistlineCommand implements OrderCommand {
    private String output;
    @Override
    public String process() {
        createMenu();
        return output;
    }

    @Override
    public void createMenu() {
        System.out.println(MenuUI.LINEBREAK.ELEMENT);
        System.out.println("        Choose waistline\n");
        System.out.println("1: High Waist");
        System.out.println("2: Low Rise");
        parseUserInput();
    }

    @Override
    public void parseUserInput() {
        Scanner scanner = new Scanner(System.in);

        try{
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    output = String.valueOf(SkirtWaistline.High_Waist);
                    break;
                case 2:
                    output = String.valueOf(SkirtWaistline.Low_Rise);
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
