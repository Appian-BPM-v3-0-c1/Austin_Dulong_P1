package com.revature.GameShop.Modles;

import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Services.GameShopServices;

import java.util.List;

public class Products {
    private int id;
    private String name;
    private String instock;
    private String price;
    private int gameshop_id;
    private String description;
    private String manufacturer;
    private int quantity;


    public Products() {
    }

    public Products(int id, String name, String instock, String price, int gameshop_id, String description, String manufacturer, int quantity) {
        this.id = id;
        this.name = name;
        this.instock = instock;
        this.price = price;
        this.gameshop_id = gameshop_id;
        this.description = description;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstock() {
        return instock;
    }

    public void setInstock(String instock) {
        this.instock = instock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getGameshop_id() {
        return gameshop_id;
    }

    public void setGameshop_id(int gameshop_id) {
        this.gameshop_id = gameshop_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instock='" + instock + '\'' +
                ", price='" + price + '\'' +
                ", gameshop_id=" + gameshop_id +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
