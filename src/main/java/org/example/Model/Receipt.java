package org.example.Model;

import org.example.Model.Garments.Garment;
import org.example.Model.Garments.Skirt.Skirt;
import org.example.Model.Garments.TShirt.TShirt;
import org.example.Model.Garments.Trousers.Trousers;

import java.util.UUID;

public class Receipt extends BusinessObject{
    private Order order;

    public Receipt() {
    }

    public Receipt(String id, String name, Order order) {
        super(id, name);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        generateReceiptInfo();
    }

    public void generateReceiptInfo(){
        String uuid = String.valueOf(UUID.randomUUID().hashCode());
        setId("R-"+uuid);
        setName("Receipt for " + this.order.getId());
    }
    public void printReceipt(){
        System.out.println("Receipt ID: "+getId());
        System.out.println(getName() + "\n");
        System.out.println("Order Contents:\n");
        double total = 0;
        for (Garment garment: this.order.getGarments()){
            System.out.println("Item: " + garment.getName() + ", Price: "+ garment.getPrice());
            if (garment instanceof Trousers trousers){
                System.out.println("Fit: " + trousers.getFit()+", Length: "+trousers.getLength());
            }
            if (garment instanceof TShirt tShirt){
                System.out.println("Sleeves: " + tShirt.getSleeves()+", Neckline: "+tShirt.getNeck());
            }
            if (garment instanceof Skirt skirt){
                System.out.println("Waistline: " + skirt.getWaistline()+", Pattern: "+skirt.getPattern());
            }
            System.out.println("\n");
            total += garment.getPrice();
        }
        System.out.println("\nTotal Price: "+ String.format("%.2f",total));
    }
}
