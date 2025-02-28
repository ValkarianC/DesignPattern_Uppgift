package org.example;

import org.example.Controller.SkirtBuilder;
import org.example.Controller.TShirtBuilder;
import org.example.Controller.TrouserBuilder;
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

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Trousers trousers;
        Skirt skirt;
        TShirt tShirt;
        TrouserBuilder builder = new TrouserBuilder();
        SkirtBuilder skirtBuilder = new SkirtBuilder();
        TShirtBuilder tShirtBuilder = new TShirtBuilder();

        trousers = builder.setColour(GarmentColour.Red)
                .setSize(GarmentSize.Large)
                .setMaterial(GarmentMaterial.Wool)
                .setLength(TrouserLength.Long)
                .setFit(TrouserFit.Straight)
                .build();

        skirt = skirtBuilder.setSize(GarmentSize.Small)
                .setMaterial(GarmentMaterial.Cotton)
                .setColour(GarmentColour.Blue)
                .setWaistline(SkirtWaistline.High_Waist)
                .setPattern(SkirtPattern.Pleated)
                .build();

        tShirt = tShirtBuilder.setSize(GarmentSize.Medium)
                .setSleeves(TShirtSleeves.Long)
                .setNeck(TShirtNeck.Turtleneck)
                .setColour(GarmentColour.Yellow)
                .setMaterial(GarmentMaterial.Polyester)
                .build();

        System.out.println(trousers.toString());
        System.out.println(skirt.toString());
        System.out.println(tShirt.toString());
    }
}