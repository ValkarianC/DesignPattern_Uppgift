package org.example.Model.Garments.Trousers;

import org.example.Model.Garments.Garment;
import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;

public class Trousers extends Garment {
    private TrouserFit fit;
    private TrouserLength length;

    public Trousers() {
        this.setPrice(79.99);
    }

    public Trousers(String id, String name, double price, GarmentSize size, GarmentMaterial material, GarmentColour colour, TrouserFit fit, TrouserLength length) {
        super(id, name, price, size, material, colour);
        this.fit = fit;
        this.length = length;
    }

    public TrouserFit getFit() {
        return fit;
    }

    public void setFit(TrouserFit fit) {
        this.fit = fit;
    }

    public TrouserLength getLength() {
        return length;
    }

    public void setLength(TrouserLength length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Trousers{" +
                "id=" + getId() +
                ", name="+ getName() +
                ", price="+ getPrice() +
                ", size="+ getSize() +
                ", material="+ getMaterial() +
                ", colour="+ getColour() +
                ", fit=" + fit +
                ", length=" + length +
                '}';
    }
}
