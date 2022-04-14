package com.revature.GameShop.UI;

import com.revature.GameShop.DAOs.*;
import com.revature.GameShop.Modles.Cart;
import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Modles.History;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Services.*;

import java.util.Scanner;

public class MainMenu implements IMenu {
    private User user;
    private Cart cart;
    private History history;

    public MainMenu(User user, Cart cart, History history) {
        this.user = user;
        this.cart = cart;
        this.history = history;
    }

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        boolean admin = user.getAdminis();

        while (!exit) {
            if (admin == true) {
                System.out.println("\nWelcome back, admin!");
                System.out.println("[1] View all game shops");
                System.out.println("[2] View Order History");
                System.out.println("[x] Exit");

                System.out.print("\nEnter: ");
                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        new GameShopMenu(new GameShopServices(new GameShopDAO()), user, new GameShop(), new ProductsService(new ProductsDAO()), new CartServices(new CartDAO()), cart, history, new HistoryService(new HistoryDAO())).start();
                        break;
                    case '2':
                        new HistoryMenu(user, new HistoryService(new HistoryDAO()), new ProductsService(new ProductsDAO())).start();
                        break;
                    case 'x':
                        exit = true;
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            } else{
                System.out.println("\nWelcome to the game shop system!");
                System.out.println("[1] View all game shops");
                System.out.println("[2] View Order History");
                System.out.println("[x] Exit");

                System.out.print("\nEnter: ");
                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        new GameShopMenu(new GameShopServices(new GameShopDAO()), user, new GameShop(), new ProductsService(new ProductsDAO()), new CartServices(new CartDAO()), cart, history, new HistoryService(new HistoryDAO())).start();
                        break;
                    case '2':
                        new HistoryMenu(user, new HistoryService(new HistoryDAO()), new ProductsService(new ProductsDAO())).start();
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
}