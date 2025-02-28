package org.example.Model.Garments;

public enum GarmentColour {
    Red(1),
    Yellow(2),
    Blue(3);

    public final int INDEX;

    private GarmentColour(int index) {
        this.INDEX = index;
    }
}
