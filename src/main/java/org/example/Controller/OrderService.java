package org.example.Controller;

import org.example.Model.Customer;
import org.example.Model.Garments.Garment;
import org.example.Model.Garments.GarmentColour;
import org.example.Model.Garments.GarmentMaterial;
import org.example.Model.Garments.GarmentSize;
import org.example.Model.Garments.Skirt.Skirt;
import org.example.Model.Garments.Skirt.SkirtPattern;
import org.example.Model.Garments.Skirt.SkirtWaistline;
import org.example.Model.Garments.TShirt.TShirt;
import org.example.Model.Garments.TShirt.TShirtNeck;
import org.example.Model.Garments.TShirt.TShirtSleeves;
import org.example.Model.Garments.Trousers.TrouserFit;
import org.example.Model.Garments.Trousers.TrouserLength;
import org.example.Model.Garments.Trousers.Trousers;
import org.example.Model.Order;
import org.example.View.GarmentMenu;
import org.example.View.OptionMenus.GarmentOptionMenu;

import java.util.UUID;

public class OrderService {
    private static OrderService instance;
    private Order order;
    GarmentOptionMenu optionMenu = new GarmentOptionMenu();


    private OrderService() {
    }

    public static OrderService getInstance(){
        if (instance == null){
            instance = new OrderService();
        }
        return instance;
    }

    public Order createNewOrder(Customer customer){
        order = new Order();
        order.setId(createOrderId());
        order.setName(createOrderName());
        order.setOrderingCustomer(customer);
        return order;
    }

    public void orderTrousers(Customer customer){
        Trousers trousers = new Trousers();
        TrouserBuilder builder = new TrouserBuilder();

        builder.setSize(GarmentSize.valueOf(optionMenu.execute(0)));
        builder.setMaterial(GarmentMaterial.valueOf(optionMenu.execute(1)));
        builder.setColour(GarmentColour.valueOf(optionMenu.execute(2)));
        builder.setFit(TrouserFit.valueOf(optionMenu.execute(3)));
        builder.setLength(TrouserLength.valueOf(optionMenu.execute(4)));
        trousers = builder.build();
        order.getGarments().add(trousers);
        GarmentMenu.getInstance().createGarmentMenu(this.order);
    }
    public void orderTShirt(Customer customer){
        TShirt tshirt = new TShirt();
        TShirtBuilder builder = new TShirtBuilder();

        builder.setSize(GarmentSize.valueOf(optionMenu.execute(0)));
        builder.setMaterial(GarmentMaterial.valueOf(optionMenu.execute(1)));
        builder.setColour(GarmentColour.valueOf(optionMenu.execute(2)));
        builder.setSleeves(TShirtSleeves.valueOf(optionMenu.execute(5)));
        builder.setNeck(TShirtNeck.valueOf(optionMenu.execute(6)));

        tshirt = builder.build();
        order.getGarments().add(tshirt);
        GarmentMenu.getInstance().createGarmentMenu(this.order);
    }
    public void orderSkirt(Customer customer){
        Skirt skirt = new Skirt();
        SkirtBuilder builder = new SkirtBuilder();

        builder.setSize(GarmentSize.valueOf(optionMenu.execute(0)));
        builder.setMaterial(GarmentMaterial.valueOf(optionMenu.execute(1)));
        builder.setColour(GarmentColour.valueOf(optionMenu.execute(2)));
        builder.setWaistline(SkirtWaistline.valueOf(optionMenu.execute(7)));
        builder.setPattern(SkirtPattern.valueOf(optionMenu.execute(8)));

        skirt = builder.build();
        order.getGarments().add(skirt);
        GarmentMenu.getInstance().createGarmentMenu(this.order);
    }


    public String createOrderId(){
        int uuid = UUID.randomUUID().hashCode();
        if (uuid < 0){
            uuid *= -1;
        }
        return ("O-" + uuid);
    }

    public String createOrderName(){
        return "Order No: " + order.getId();
    }
}
