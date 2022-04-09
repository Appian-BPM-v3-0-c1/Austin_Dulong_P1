package com.revature.GameShop.Modles;

public class Game {

    private int game_id;
    private int product_id;

    public Game() {
    }

    public Game(int game_id, int product_id) {
        this.game_id = game_id;
        this.product_id = product_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
