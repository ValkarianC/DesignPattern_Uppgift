package org.example.Controller;

import org.example.Model.Garments.Garment;
import org.example.Model.Order;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OrderObserver {
    private Order order;
    private boolean itemOrdered;
    private boolean itemCreated;
    private boolean orderComplete;
    private String passedStep;
    private PropertyChangeSupport propertyChangeSupport;

    public OrderObserver() {
    }

    public OrderObserver(Order order) {
        this.order = order;
        this.itemOrdered = false;
        this.itemCreated = false;
        this.orderComplete = false;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isItemOrdered() {
        return itemOrdered;
    }

    public void setItemOrdered(boolean itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    public boolean isItemCreated() {
        return itemCreated;
    }

    public void setItemCreated(boolean itemCreated) {
        this.itemCreated = itemCreated;
    }

    public boolean isOrderComplete() {
        return orderComplete;
    }

    public void setOrderComplete(boolean orderComplete) {
        this.orderComplete = orderComplete;
    }

    public String getPassedStep() {
        return passedStep;
    }

    public void setPassedStep(String passedStep) {
        this.passedStep = passedStep;
    }

    public void itemOrdered(String item, boolean isOrdered){
        setItemOrdered(isOrdered);
        if (this.itemOrdered){
            this.propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(item,"Ordered", false, this.itemOrdered));
        }
    }

    public void itemCreated(Garment item, boolean isCreated){
        setItemCreated(isCreated);
        if (this.itemCreated){
            this.propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(item, "Created", false, this.itemCreated));
        }
    }

    public void orderCompleted(Order order, boolean orderComplete){
        setOrder(order);
        setOrderComplete(orderComplete);
        if (this.orderComplete){
            this.propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(order, "Complete", false, this.orderComplete));
        }
    }

    public void problemWithOrder(String location){
        this.propertyChangeSupport.firePropertyChange("Problem", this.passedStep, location);
    }
}
