package org.example.View;

public class GarmentMenu {
    private static GarmentMenu instance;

    private GarmentMenu(){

    }

    public static GarmentMenu getInstance(){
        if (instance == null){
            instance = new GarmentMenu();
        }
        return instance;
    }
}
