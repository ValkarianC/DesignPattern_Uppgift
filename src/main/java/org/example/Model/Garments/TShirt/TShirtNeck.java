package org.example.Model.Garments.TShirt;

public enum TShirtNeck {
    Polo(1),
    Turtleneck(2);

    public final int INDEX;


    private TShirtNeck(int index) {
        this.INDEX = index;
    }
}
