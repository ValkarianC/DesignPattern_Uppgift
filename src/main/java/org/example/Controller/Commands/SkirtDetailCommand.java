package org.example.Controller.Commands;

import java.util.HashMap;

public class SkirtDetailCommand implements OrderDetailsCommand{
    @Override
    public String process(HashMap<String, String> orderDetails) {
        return "Item: "+ orderDetails.get("Size") + " " + orderDetails.get("Colour") + " " + orderDetails.get("Material") + " Skirt"+
                "\nWaisline: " + orderDetails.get("Waistline") + " Pattern: " + orderDetails.get("Pattern") +
                "\nPrice: " + orderDetails.get("Price");
    }
}
