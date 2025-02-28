package org.example.Model;

import java.util.ArrayList;

public class Customer extends BusinessObject{
    private String email;
    private Address address;

    public Customer() {
    }

    public Customer(String id, String name, String email, Address address) {
        super(id, name);
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
