package org.example.Model.Garments.Trousers;

public enum TrouserFit {
    Straight(1),
    Flared(2);

    public final int INDEX;

    private TrouserFit(int index){
        this.INDEX = index;
    }
}
