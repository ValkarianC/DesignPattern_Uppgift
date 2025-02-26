package org.example.Controller;

import org.example.Model.Garments.Garment;
import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;

public interface GarmentBuilder {

    GarmentBuilder setSize(GarmentSize size);

    GarmentBuilder setMaterial(GarmentMaterial material);

    GarmentBuilder setColour(GarmentColour colour);

    Garment build();
}
