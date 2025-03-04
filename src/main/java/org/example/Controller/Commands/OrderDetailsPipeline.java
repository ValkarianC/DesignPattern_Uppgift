package org.example.Controller.Commands;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsPipeline {
    private ArrayList<OrderDetailsCommand> pipeline = new ArrayList<>();

    public OrderDetailsPipeline() {
        addDetailCommands();
    }

    private void addDetailCommands(){
        pipeline.add(new TrouserDetailCommand());
        pipeline.add(new TShirtDetailCommand());
        pipeline.add(new SkirtDetailCommand());

    }
    public String execute(int index, HashMap order){
        return pipeline.get(index).process(order);
    }

}
