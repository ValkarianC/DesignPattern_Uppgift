package org.example.Controller;

import org.example.Model.CEO;
import org.example.Model.Customer;
import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;
import org.example.Model.Garments.Skirt.Skirt;
import org.example.Model.Garments.Skirt.SkirtPattern;
import org.example.Model.Garments.Skirt.SkirtWaistline;
import org.example.Model.Garments.TShirt.TShirt;
import org.example.Model.Garments.TShirt.TShirtNeck;
import org.example.Model.Garments.TShirt.TShirtSleeves;
import org.example.Model.Garments.Trousers.TrouserFit;
import org.example.Model.Garments.Trousers.TrouserLength;
import org.example.Model.Garments.Trousers.Trousers;
import org.example.Model.Order;
import org.example.Model.Receipt;
import org.example.View.OptionMenus.GarmentOptionMenus;
import org.example.View.WelcomeMenu;


import java.util.HashMap;
import java.util.UUID;

public class OrderService {
    private static OrderService instance;
    private Order order;
    private HashMap<Integer, HashMap> totalOrder;
    private HashMap<String, String> individualOrder;
    private int itemIndex;
    private OrderObserver orderObserver;
    private CEO ceo;
    GarmentOptionMenus optionMenu = new GarmentOptionMenus();


    private OrderService() {
        this.ceo = new CEO("E-01", "The Boss");
        orderObserver = new OrderObserver(order);
        orderObserver.addPropertyChangeListener(ceo);
    }

    public static OrderService getInstance(){
        if (instance == null){
            instance = new OrderService();
        }
        return instance;
    }

    public void createNewOrder(Customer customer){
        order = new Order();
        order.setId(createOrderId());
        order.setName(createOrderName());
        order.setOrderingCustomer(customer);
        totalOrder = new HashMap<>();

        itemIndex = 0;
    }
    public void createTrousersOrder(){
        individualOrder = new HashMap<>();
        individualOrder.put("Garment", "Trousers");
        individualOrder.put("Size", optionMenu.execute(0));
        individualOrder.put("Material", optionMenu.execute(1));
        individualOrder.put("Colour", optionMenu.execute(2));
        individualOrder.put("Fit", optionMenu.execute(3));
        individualOrder.put("Length", optionMenu.execute(4));
        individualOrder.put("Price", String.valueOf(new Trousers().getPrice()));
        totalOrder.put(itemIndex, individualOrder);
        itemIndex++;
    }

    public void createTShirtOrder(){
        individualOrder = new HashMap<>();
        individualOrder.put("Garment", "T-Shirt");
        individualOrder.put("Size", optionMenu.execute(0));
        individualOrder.put("Material", optionMenu.execute(1));
        individualOrder.put("Colour", optionMenu.execute(2));
        individualOrder.put("Sleeves", optionMenu.execute(5));
        individualOrder.put("Neck", optionMenu.execute(6));
        individualOrder.put("Price", String.valueOf(new TShirt().getPrice()));
        totalOrder.put(itemIndex, individualOrder);
        itemIndex++;
    }

    public void createSkirtOrder(){
        individualOrder = new HashMap<>();
        individualOrder.put("Garment", "Skirt");
        individualOrder.put("Size", optionMenu.execute(0));
        individualOrder.put("Material", optionMenu.execute(1));
        individualOrder.put("Colour", optionMenu.execute(2));
        individualOrder.put("Waistline", optionMenu.execute(7));
        individualOrder.put("Pattern", optionMenu.execute(8));
        individualOrder.put("Price", String.valueOf(new Skirt().getPrice()));
        totalOrder.put(itemIndex, individualOrder);
        itemIndex++;
    }

    public void placeOrder(){
        boolean problemWithOrder = false;
        for (HashMap item : totalOrder.values()){
            orderObserver.itemOrdered(item.get("Size")+" "+ item.get("Colour")+ " "+ item.get("Material"), true);
            orderObserver.setPassedStep("Item Ordered");
            switch (String.valueOf(item.get("Garment"))){
                case "Trousers":
                    buildTrousers(item);
                    break;
                case "T-Shirt":
                    buildTShirt(item);
                    break;
                case "Skirt":
                    buildSkirt(item);
                    break;
                default:
                    break;
            }
            if (orderObserver.isItemOrdered()){
                orderObserver.setItemCreated(false);
                orderObserver.setItemOrdered(false);
            } else {
                problemWithOrder = true;
            }
        }
        if (!problemWithOrder){
            orderObserver.orderCompleted(this.order,true);
            orderObserver.setPassedStep("Order Completed");

            System.out.println("Thank you for your order!");
            Receipt receipt = new Receipt();
            receipt.setOrder(this.order);
            receipt.printReceipt();
            WelcomeMenu.getInstance().createWelcomeMenu();

        } else{
            orderObserver.problemWithOrder("Order Completion");
        }
    }

    public void buildTrousers(HashMap item){
        Trousers trousers;
        TrouserBuilder builder = new TrouserBuilder();


        builder.setSize(GarmentSize.valueOf(String.valueOf(item.get("Size"))));
        builder.setMaterial(GarmentMaterial.valueOf(String.valueOf(item.get("Material"))));
        builder.setColour(GarmentColour.valueOf(String.valueOf(item.get("Colour"))));
        builder.setFit(TrouserFit.valueOf(String.valueOf(item.get("Fit"))));
        builder.setLength(TrouserLength.valueOf(String.valueOf(item.get("Length"))));
        trousers = builder.build();
        orderObserver.itemCreated(trousers, true);
        orderObserver.setPassedStep("Item Created");
        order.getGarments().add(trousers);
    }
    public void buildTShirt(HashMap item){
        TShirt tshirt;
        TShirtBuilder builder = new TShirtBuilder();

        builder.setSize(GarmentSize.valueOf(String.valueOf(item.get("Size"))));
        builder.setMaterial(GarmentMaterial.valueOf(String.valueOf(item.get("Material"))));
        builder.setColour(GarmentColour.valueOf(String.valueOf(item.get("Colour"))));
        builder.setSleeves(TShirtSleeves.valueOf(String.valueOf(item.get("Sleeves"))));
        builder.setNeck(TShirtNeck.valueOf(String.valueOf(item.get("Neck"))));

        tshirt = builder.build();
        orderObserver.itemCreated(tshirt,true);
        orderObserver.setPassedStep("Item Created");
        order.getGarments().add(tshirt);
    }
    public void buildSkirt(HashMap item){
        Skirt skirt;
        SkirtBuilder builder = new SkirtBuilder();

        builder.setSize(GarmentSize.valueOf(String.valueOf(item.get("Size"))));
        builder.setMaterial(GarmentMaterial.valueOf(String.valueOf(item.get("Material"))));
        builder.setColour(GarmentColour.valueOf(String.valueOf(item.get("Colour"))));
        builder.setWaistline(SkirtWaistline.valueOf(String.valueOf(item.get("Waistline"))));
        builder.setPattern(SkirtPattern.valueOf(String.valueOf(item.get("Pattern"))));

        skirt = builder.build();
        orderObserver.itemCreated(skirt, true);
        orderObserver.setPassedStep("Item Created");
        order.getGarments().add(skirt);
    }


    public String createOrderId(){
        int uuid = UUID.randomUUID().hashCode();
        if (uuid < 0){
            uuid *= -1;
        }
        return ("O-" + uuid);
    }

    public String createOrderName(){
        return "Order No: " + order.getId();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public HashMap<Integer, HashMap> getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(HashMap<Integer, HashMap> totalOrder) {
        this.totalOrder = totalOrder;
    }

    public HashMap<String, String> getIndividualOrder() {
        return individualOrder;
    }

    public void setIndividualOrder(HashMap<String, String> orderOptions) {
        this.individualOrder = orderOptions;
    }
}
