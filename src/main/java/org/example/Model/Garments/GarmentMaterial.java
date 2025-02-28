package org.example.Model.Garments;

public enum GarmentMaterial {
    Cotton(1),
    Wool(2),
    Polyester(3);

    public final int INDEX;

    GarmentMaterial(int index) {
        this.INDEX = index;
    }
}
