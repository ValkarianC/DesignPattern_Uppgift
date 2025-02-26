package org.example.Model;

import java.util.ArrayList;

public class Customer extends BusinessObject{
    private String email;
    private ArrayList<String> address;

    public Customer() {
    }

    public Customer(int id, String name, String email, ArrayList<String> address) {
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

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }
}
