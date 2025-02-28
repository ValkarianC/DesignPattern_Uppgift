package org.example.Model.Garments;

public enum GarmentSize {
    Small(1),
    Medium(2),
    Large(3);

    public final int INDEX;


    GarmentSize(int index) {
        this.INDEX = index;
    }
}
