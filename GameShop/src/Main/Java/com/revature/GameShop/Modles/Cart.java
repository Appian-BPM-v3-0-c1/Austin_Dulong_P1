package com.revature.GameShop.Modles;

public class Cart {

    private int id;
    private int product_id;
    private int totalPrice;
    private int  shippingAddress_id;
    private int users_id;
    private String name;
    private int quantity;


    public Cart() {
    }

    public Cart(int id, int product_id, int shippingAddress_id, int users_id, String name, int quantity) {
        this.id = id;
        this.product_id = product_id;
        //this.totalPrice = totalPrice;
        this.shippingAddress_id = shippingAddress_id;
        this.users_id = users_id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getShippingAddress_id() {
        return shippingAddress_id;
    }

    public void setShippingAddress_id(int shippingAddress_id) {
        this.shippingAddress_id = shippingAddress_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", totalPrice=" + totalPrice +
                ", shippingAddress_id=" + shippingAddress_id +
                ", users_id=" + users_id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}