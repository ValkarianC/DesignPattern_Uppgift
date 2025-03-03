package org.example.Model.Garments.Skirt;

import org.example.Model.Garments.Garment;
import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;

public class Skirt extends Garment {
    private SkirtWaistline waistline;
    private SkirtPattern pattern;

    public Skirt() {
        this.setPrice(49.99);
    }

    public Skirt(String id, String name, double price, GarmentSize size, GarmentMaterial material, GarmentColour colour, SkirtWaistline waistline, SkirtPattern pattern) {
        super(id, name, price, size, material, colour);
        this.waistline = waistline;
        this.pattern = pattern;
    }

    public SkirtWaistline getWaistline() {
        return waistline;
    }

    public void setWaistline(SkirtWaistline waistline) {
        this.waistline = waistline;
    }

    public SkirtPattern getPattern() {
        return pattern;
    }

    public void setPattern(SkirtPattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Skirt{" +
                "id=" + getId() +
                ", name="+ getName() +
                ", price="+ getPrice() +
                ", size="+ getSize() +
                ", material="+ getMaterial() +
                ", colour="+ getColour() +
                ", waistline=" + waistline +
                ", pattern=" + pattern +
                '}';
    }
    @Override
    public String orderPrintout(){
        return "Name: " + this.getName() + ", ID: "+ this.getId() +
                "\nWaistline: " + this.waistline + ", Pattern: " + this.pattern +
                "\nPrice: " +  this.getPrice() + "\n";
    }
}
