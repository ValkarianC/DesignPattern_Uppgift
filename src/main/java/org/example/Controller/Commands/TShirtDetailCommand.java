package org.example.Controller.Commands;

import java.util.HashMap;

public class TShirtDetailCommand implements OrderDetailsCommand{
    @Override
    public String process(HashMap<String, String> orderDetails) {
        return "Item: "+ orderDetails.get("Size") + " " + orderDetails.get("Colour") + " " + orderDetails.get("Material") + " T-Shirt"+
                "\nSleeves: " + orderDetails.get("Sleeves") + " Neckline: " + orderDetails.get("Neck") +
                "\nPrice: " + orderDetails.get("Price");
    }
}
