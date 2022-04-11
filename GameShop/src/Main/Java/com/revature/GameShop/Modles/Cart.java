package com.revature.GameShop.Modles;

public class Cart {

    private int id;
    private int product_id;
    private int totalPrice;
    private int  shippingAddress_id;
    private int users_id;


    public Cart() {
    }

    public Cart(int id, int product_id, int shippingAddress_id, int users_id) {
        this.id = id;
        this.product_id = product_id;
        //this.totalPrice = totalPrice;
        this.shippingAddress_id = shippingAddress_id;
        this.users_id = users_id;
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
}