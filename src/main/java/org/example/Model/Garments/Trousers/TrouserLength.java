package org.example.Model.Garments.Trousers;

public enum TrouserLength {
    Regular(1),
    Long(2);

    public final int INDEX;

    private TrouserLength(int index){
        this.INDEX = index;
    }
}
