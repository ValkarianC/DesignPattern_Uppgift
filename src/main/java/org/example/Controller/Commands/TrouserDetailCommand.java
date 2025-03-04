package org.example.Controller.Commands;

import java.util.HashMap;

public class TrouserDetailCommand implements OrderDetailsCommand{
    @Override
    public String process(HashMap<String,String> orderDetails) {
        return "Item: "+ orderDetails.get("Size") + " " + orderDetails.get("Colour") + " " + orderDetails.get("Material") + " Trousers"+
                "\nFit: " + orderDetails.get("Fit") + " Length: " + orderDetails.get("Length") +
                "\nPrice: " + orderDetails.get("Price");
    }
}
