package com.revature.GameShop.UI;

import com.revature.GameShop.DAOs.CartDAO;
import com.revature.GameShop.DAOs.GameShopDAO;
import com.revature.GameShop.DAOs.ProductsDAO;
import com.revature.GameShop.DAOs.ReviewDAO;
import com.revature.GameShop.Modles.Cart;
import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Services.CartServices;
import com.revature.GameShop.Services.GameShopServices;
import com.revature.GameShop.Services.ProductsService;
import com.revature.GameShop.Services.ReviewService;

import java.util.Scanner;

public class MainMenu implements IMenu {
    private User user;
    private Cart cart;

    public MainMenu(User user, Cart cart) {
        this.user = user;
        this.cart = cart;
    }

   @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);


        while (!exit) {
            System.out.println("\nWelcome to the game shop system!");
            System.out.println("[1] View all game shops");
            System.out.println("[2] Leave a review");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    new GameShopMenu(new GameShopServices(new GameShopDAO()), user, new GameShop(), new ProductsService(new ProductsDAO()), new CartServices(new CartDAO()), cart).start();
                    break;
                case '2':
                    new ReviewMenu(user, new ReviewService(new ReviewDAO(), new GameShopDAO())).start();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }
    }
}