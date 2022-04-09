package com.revature.GameShop.UI;

import com.revature.GameShop.Modles.Products;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Modles.Cart;
import com.revature.GameShop.Services.CartServices;

import java.util.List;
import java.util.Scanner;

public class CartMenu implements IMenu {
    private final User user;
    private final Cart cart;
    private final CartServices cartServices;

    public CartMenu(User user, Cart cart, CartServices cartServices) {
        this.user = user;
        this.cart = cart;
        this.cartServices = cartServices;
    }



    @Override
    public void start() {

    }
}


