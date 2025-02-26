package org.example.Model.Garments.TShirt;

import org.example.Model.Garments.Garment;
import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;

public class TShirt extends Garment {
    private TShirtSleeves sleeves;
    private TShirtNeck neck;

    public TShirt() {
    }

    public TShirt(int id, String name, double price, GarmentSize size, GarmentMaterial material, GarmentColour colour, TShirtSleeves sleeves, TShirtNeck neck) {
        super(id, name, price, size, material, colour);
        this.sleeves = sleeves;
        this.neck = neck;
    }

    public TShirtSleeves getSleeves() {
        return sleeves;
    }

    public void setSleeves(TShirtSleeves sleeves) {
        this.sleeves = sleeves;
    }

    public TShirtNeck getNeck() {
        return neck;
    }

    public void setNeck(TShirtNeck neck) {
        this.neck = neck;
    }
}
