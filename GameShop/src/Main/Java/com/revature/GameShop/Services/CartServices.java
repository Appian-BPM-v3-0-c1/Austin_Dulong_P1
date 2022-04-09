package com.revature.GameShop.Services;

import com.revature.GameShop.DAOs.CartDAO;

public class CartServices {

    private final CartDAO cartDAO;

    public CartServices(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public CartDAO getCartDAO() {
        return cartDAO;
    }


}
