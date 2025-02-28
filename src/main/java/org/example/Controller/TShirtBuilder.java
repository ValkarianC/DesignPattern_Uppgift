package org.example.Controller;

import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;
import org.example.Model.Garments.TShirt.TShirt;
import org.example.Model.Garments.TShirt.TShirtNeck;
import org.example.Model.Garments.TShirt.TShirtSleeves;

public class TShirtBuilder implements GarmentBuilder{
    private TShirt tShirt = new TShirt();
    @Override
    public TShirtBuilder setSize(GarmentSize size) {
        if (size == null) {
            throw new BuildException("T-Shirt Size", size);
        }
        tShirt.setSize(size);
        return this;
    }

    @Override
    public TShirtBuilder setMaterial(GarmentMaterial material) {
        if (material == null){
            throw new BuildException("T-Shirt Material", material);
        }
        tShirt.setMaterial(material);
        return this;
    }

    @Override
    public TShirtBuilder setColour(GarmentColour colour) {
        if (colour == null){
            throw new BuildException("T-Shirt Colour", colour);
        }
        tShirt.setColour(colour);
        return this;
    }

    public TShirtBuilder setSleeves(TShirtSleeves sleeves) {
        if (sleeves == null){
            throw new BuildException("T-Shirt Sleeves", sleeves);
        }
        tShirt.setSleeves(sleeves);
        return this;
    }

    public TShirtBuilder setNeck(TShirtNeck neck) {
        if (neck == null) {
            throw new BuildException("T-Shirt Neck", neck);
        }
        tShirt.setNeck(neck);
        return this;
    }

    private String createID(){
        String id = "G-2";
        id += tShirt.getSize().INDEX;
        id += tShirt.getMaterial().INDEX;
        id += tShirt.getColour().INDEX;
        id += tShirt.getSleeves().INDEX;
        id += tShirt.getNeck().INDEX;
        return id;
    }

    @Override
    public TShirt build() {
        if (tShirt.getSize() == null || tShirt.getMaterial() == null || tShirt.getColour() == null || tShirt.getSleeves() == null || tShirt.getNeck() == null){
            throw new BuildException("Skirt creation", tShirt);
        }
        tShirt.setName(tShirt.getSize() + " " + tShirt.getColour() + " " + tShirt.getMaterial() + " T-Shirt");
        tShirt.setId(createID());
        return tShirt;
    }
}
