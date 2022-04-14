package com.revature.GameShop.Modles;

public class History {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int products_id;
    private int users_id;
    private String datetime;

    public History() {

    }

    public History(int id, String name, int price, int quantity, int products_id, int users_id, String datetime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.products_id = products_id;
        this.users_id = users_id;
        this.datetime=datetime;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProducts_id() {
        return products_id;
    }

    public void setProducts_id(int products_id) {
        this.products_id = products_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", products_id=" + products_id +
                ", users_id=" + users_id +
                ", datetime=" + datetime +
                '}';
    }
}
