package org.example.View.OptionMenus;

import org.example.Controller.Commands.OrderCommand;

import java.util.ArrayList;

public class GarmentOptionMenus {
    private ArrayList<OrderCommand> OrderOptions = new ArrayList<>();

    public GarmentOptionMenus() {
        addOptionMenus();
    }

    private void addOptionMenus(){
        OrderOptions.add(new OrderSizeCommand());
        OrderOptions.add(new OrderMaterialCommand());
        OrderOptions.add(new OrderColourCommand());
        OrderOptions.add(new OrderFitCommand());
        OrderOptions.add(new OrderLengthCommand());
        OrderOptions.add(new OrderSleevesCommand());
        OrderOptions.add(new OrderNeckCommand());
        OrderOptions.add(new OrderWaistlineCommand());
        OrderOptions.add(new OrderPatternCommand());

    }

    public String execute(int index){
        return OrderOptions.get(index).process();
    }
}
