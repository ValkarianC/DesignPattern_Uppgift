package org.example.Controller;

import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;
import org.example.Model.Garments.Skirt.Skirt;
import org.example.Model.Garments.Skirt.SkirtPattern;
import org.example.Model.Garments.Skirt.SkirtWaistline;

public class SkirtBuilder implements GarmentBuilder{
    private Skirt skirt = new Skirt();

    @Override
    public SkirtBuilder setSize(GarmentSize size) {
        if (size == null){
            throw new BuildException("Skirt Size", size);
        }
        skirt.setSize(size);
        return this;
    }

    @Override
    public SkirtBuilder setMaterial(GarmentMaterial material) {
        if (material == null){
            throw new BuildException("Skirt Material", material);
        }
        skirt.setMaterial(material);
        return this;
    }

    @Override
    public SkirtBuilder setColour(GarmentColour colour) {
        if (colour == null){
            throw new BuildException("Skirt Colour", colour);
        }
        skirt.setColour(colour);
        return this;
    }

    public SkirtBuilder setWaistline(SkirtWaistline waistline){
        if (waistline == null){
            throw new BuildException("Skirt Waistline", waistline);
        }
        skirt.setWaistline(waistline);
        return this;
    }

    public SkirtBuilder setPattern(SkirtPattern pattern){
        if (pattern == null){
            throw new BuildException("Skirt Pattern", pattern);
        }
        skirt.setPattern(pattern);
        return this;
    }

    private String createID(){
        String id = "G-3";
        id += skirt.getSize().INDEX;
        id += skirt.getMaterial().INDEX;
        id += skirt.getColour().INDEX;
        id += skirt.getWaistline().INDEX;
        id += skirt.getPattern().INDEX;
        return id;
    }



    @Override
    public Skirt build() {
        if (skirt.getSize() == null || skirt.getMaterial() == null || skirt.getColour() == null || skirt.getWaistline() == null || skirt.getPattern() == null){
            throw new BuildException("Skirt creation", skirt);
        }
        skirt.setName(skirt.getSize() + " " + skirt.getColour() + " " + skirt.getMaterial() + " Skirt");
        skirt.setId(createID());
        return skirt;
    }
}
