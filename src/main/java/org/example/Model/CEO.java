package org.example.Model;

import org.example.Model.Garments.Garment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO extends BusinessObject implements PropertyChangeListener {

    public CEO() {
    }

    public CEO(String id, String name) {
        super(id, name);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("-CEO Console-");
        if (evt.getPropertyName().equalsIgnoreCase("Ordered") && (evt.getNewValue().equals(true))){
            System.out.println("Item in Production: " + evt.getSource());
        }
        if (evt.getPropertyName().equalsIgnoreCase("Created") && (evt.getNewValue().equals(true))){
            Garment item = (Garment) evt.getSource();
            System.out.println("Item Created: " + ((Garment) evt.getSource()).getName());
        }
        if (evt.getPropertyName().equalsIgnoreCase("Complete") && (evt.getNewValue().equals(true))){
            Order order = (Order) evt.getSource();
            System.out.println("Order Complete: " + order.getId());
        }
        if (evt.getPropertyName().equalsIgnoreCase("Problem")){
            System.out.println("A customer encountered a problem while ordering from the page:\n" +
                    "Problem occured between "+evt.getOldValue() + " and "+ evt.getNewValue());
        }
    }
}
