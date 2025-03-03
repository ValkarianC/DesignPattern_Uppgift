package org.example.Model;

import org.example.Model.Garments.Garment;

import java.util.ArrayList;

public class Order extends BusinessObject {
    private ArrayList<Garment> garments = new ArrayList<>();
    private Customer orderingCustomer = new Customer();

    public Order() {
    }

    public Order(String id, String name, ArrayList<Garment> garments, Customer orderingCustomer) {
        super(id, name);
        this.garments = garments;
        this.orderingCustomer = orderingCustomer;
    }

    public ArrayList<Garment> getGarments() {
        return garments;
    }

    public void setGarments(ArrayList<Garment> garments) {
        this.garments = garments;
    }

    public Customer getOrderingCustomer() {
        return orderingCustomer;
    }

    public void setOrderingCustomer(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }
}
