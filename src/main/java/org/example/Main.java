package org.example;

import org.example.Controller.OrderService;
import org.example.Model.Address;
import org.example.Model.CEO;
import org.example.Model.Customer;
import org.example.Model.Garments.Trousers.Trousers;
import org.example.Model.Order;
import org.example.View.WelcomeMenu;

public class Main {
    public static void main(String[] args) {

        Address address = new Address("Home","Road","Town","County","Country","Postcode");
        WelcomeMenu welcomeMenu = WelcomeMenu.getInstance();
        welcomeMenu.setCurrentCustomer(new Customer("C1","Ben Portsmouth", "b@p.com", address));
        welcomeMenu.createWelcomeMenu();

//        OrderService.getInstance().createNewOrder(welcomeMenu.getCurrentCustomer());
//        OrderService.getInstance().createTrousersOrder();
//        System.out.println(OrderService.getInstance().getTotalOrder().get(1).get("Price"));

//        GarmentOptionMenus menu = new GarmentOptionMenus();
//
//        Trousers trousers;
//        TrouserBuilder builder = new TrouserBuilder();
//        TShirt tShirt;
//        TShirtBuilder shirtBuilder = new TShirtBuilder();
//        Skirt skirt;
//        SkirtBuilder skirtBuilder = new SkirtBuilder();
//
//
//        trousers = builder.setSize(GarmentSize.valueOf(menu.execute(0)))
//                .setMaterial(GarmentMaterial.valueOf(menu.execute(1)))
//                .setColour(GarmentColour.valueOf(menu.execute(2)))
//                .setFit(TrouserFit.valueOf(menu.execute(3)))
//                .setLength(TrouserLength.valueOf(menu.execute(4)))
//                .build();
//
//        tShirt = shirtBuilder.setSize(GarmentSize.valueOf(menu.execute(0)))
//                        .setMaterial(GarmentMaterial.valueOf(menu.execute(1)))
//                                .setColour(GarmentColour.valueOf(menu.execute(2)))
//                                        .setSleeves(TShirtSleeves.valueOf(menu.execute(5)))
//                                                .setNeck(TShirtNeck.valueOf(menu.execute(6)))
//                                                        .build();
//
//        skirt = skirtBuilder.setSize(GarmentSize.valueOf(menu.execute(0)))
//                        .setMaterial(GarmentMaterial.valueOf(menu.execute(1)))
//                                .setColour(GarmentColour.valueOf(menu.execute(2)))
//                                        .setWaistline(SkirtWaistline.valueOf(menu.execute(7)))
//                                                .setPattern(SkirtPattern.valueOf(menu.execute(8)))
//                                                        .build();
//
//        System.out.println(trousers.toString());
//        System.out.println(tShirt.toString());
//        System.out.println(skirt.toString());

    }
}