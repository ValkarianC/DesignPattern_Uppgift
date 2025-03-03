package org.example.Model.Garments;

import org.example.Model.BusinessObject;

public abstract class Garment extends BusinessObject {
    private double price;
    private GarmentSize size;
    private GarmentMaterial material;
    private GarmentColour colour;

    public Garment() {
    }

    public Garment(String id, String name, double price, GarmentSize size, GarmentMaterial material, GarmentColour colour) {
        super(id, name);
        this.price = price;
        this.size = size;
        this.material = material;
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GarmentSize getSize() {
        return size;
    }

    public void setSize(GarmentSize size) {
        this.size = size;
    }

    public GarmentMaterial getMaterial() {
        return material;
    }

    public void setMaterial(GarmentMaterial material) {
        this.material = material;
    }

    public GarmentColour getColour() {
        return colour;
    }

    public void setColour(GarmentColour colour) {
        this.colour = colour;
    }
    public String orderPrintout(){
        return "Name: " + this.getName() + ", ID: "+ this.getId() +
                "\nPrice: " +  this.price;
    }
}
