package org.example;

import org.example.Controller.SkirtBuilder;
import org.example.Controller.TShirtBuilder;
import org.example.Controller.TrouserBuilder;
import org.example.Model.Address;
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
import org.example.View.OptionMenus.GarmentOptionMenu;
import org.example.View.WelcomeMenu;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Home","Road","Town","County","Country","Postcode");
        WelcomeMenu welcomeMenu = WelcomeMenu.getInstance();
        welcomeMenu.setCurrentCustomer(new Customer("C1","Ben Portsmouth", "b@p.com", address));
        welcomeMenu.createWelcomeMenu();

//        GarmentOptionMenu menu = new GarmentOptionMenu();
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