package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;

import java.util.ArrayList;

public class GarmentOptionMenu {
    private ArrayList<OrderCommand> menuOptions = new ArrayList<>();

    public GarmentOptionMenu() {
        addOptionMenus();
    }

    private void addOptionMenus(){
        menuOptions.add(new OrderSizeCommand());
        menuOptions.add(new OrderMaterialCommand());
        menuOptions.add(new OrderColourCommand());
        menuOptions.add(new OrderFitCommand());
        menuOptions.add(new OrderLengthCommand());
        menuOptions.add(new OrderSleevesCommand());
        menuOptions.add(new OrderNeckCommand());
        menuOptions.add(new OrderWaistlineCommand());
        menuOptions.add(new OrderPatternCommand());

    }

    public String execute(int index){
        return menuOptions.get(index).process();
    }
}
