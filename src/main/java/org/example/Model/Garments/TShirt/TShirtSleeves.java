package org.example.Model.Garments.TShirt;

public enum TShirtSleeves {
    Short(1),
    Long(2);

    public final int INDEX;

    private TShirtSleeves(int index) {
        this.INDEX = index;
    }
}
