package org.example.Controller;

import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;
import org.example.Model.Garments.Trousers.TrouserFit;
import org.example.Model.Garments.Trousers.TrouserLength;
import org.example.Model.Garments.Trousers.Trousers;

public class TrouserBuilder implements GarmentBuilder{
    private Trousers trousers = new Trousers();

    @Override
    public TrouserBuilder setSize(GarmentSize size) {
        if (size == null){
            throw new BuildException("Trouser Size", size);
        }
        trousers.setSize(size);
        return this;
    }

    @Override
    public TrouserBuilder setMaterial(GarmentMaterial material) {
        if (material == null){
            throw new BuildException("Trouser Material", material);
        }
        trousers.setMaterial(material);
        return this;
    }

    @Override
    public TrouserBuilder setColour(GarmentColour colour) {
        if (colour == null){
            throw new BuildException("Trouser Colour", colour);
        }
        trousers.setColour(colour);
        return this;
    }

    public TrouserBuilder setFit(TrouserFit fit){
        if (fit == null){
            throw new BuildException("Trouser Fit", fit);
        }
        trousers.setFit(fit);
        return this;
    }

    public TrouserBuilder setLength(TrouserLength length){
        if (length == null){
            throw new BuildException("Trouser Length", length);
        }
        trousers.setLength(length);
        return this;
    }

    @Override
    public Trousers build() {
        if (trousers.getSize() == null || trousers.getMaterial() == null || trousers.getColour() == null || trousers.getFit() == null || trousers.getLength() == null){
            throw new BuildException("Trouser creation", trousers);
        }
        trousers.setName(trousers.getSize() + " " + trousers.getColour() + " " + trousers.getMaterial() + " Trousers");
        return trousers;
    }
}
