package org.example;

import org.example.Controller.TrouserBuilder;
import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;
import org.example.Model.Garments.Trousers.TrouserFit;
import org.example.Model.Garments.Trousers.TrouserLength;
import org.example.Model.Garments.Trousers.Trousers;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Trousers trousers = new Trousers();
        TrouserBuilder builder = new TrouserBuilder();

        trousers = (Trousers) builder.setColour(GarmentColour.Red)
                .setSize(GarmentSize.Large)
                .setMaterial(GarmentMaterial.Wool)
                .setLength(TrouserLength.Long)
                .setFit(TrouserFit.Straight)
                .build();

        System.out.println(trousers.getFit());
        System.out.println(trousers.toString());
    }
}