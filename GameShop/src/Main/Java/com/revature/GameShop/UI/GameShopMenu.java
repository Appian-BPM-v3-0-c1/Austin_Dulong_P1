package com.revature.GameShop.UI;

import com.revature.GameShop.DAOs.CrudDAO;
import com.revature.GameShop.DAOs.ProductsDAO;
import com.revature.GameShop.Modles.*;
import com.revature.GameShop.Services.CartServices;
import com.revature.GameShop.Services.GameShopServices;
import com.revature.GameShop.Services.HistoryService;
import com.revature.GameShop.Services.ProductsService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameShopMenu implements IMenu {
    private final GameShopServices gameShopServices;
    private final User user;
    private final GameShop gameshop;
    private final ProductsService productservice;
    private final CartServices cartService;
    private final Cart cart;
    private final HistoryService historyService;
    CrudDAO<Products> productsCrudDAO = new ProductsDAO();
    Scanner scan = new Scanner(System.in);
    int productX;


    public GameShopMenu(GameShopServices gameShopServices, User user, GameShop gameshop, ProductsService productservice, CartServices cartService, Cart cart, History history, HistoryService historyService) {
        this.gameShopServices = gameShopServices;
        this.user = user;
        this.gameshop = gameshop;
        this.productservice = productservice;
        this.cartService = cartService;
        this.cart = cart;
        // this.history = history;
        this.historyService = historyService;


        Products product = new Products();
        Scanner scan = new Scanner(System.in);
        boolean admin = user.getAdminis();
    }

    //@Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        System.out.println(user.getId());

        while (!exit) {
            System.out.println("\nWelcome to the game shop menu!");
            System.out.println("[1] List all game shops");
            System.out.println("[2] Go to cart");
            if (user.getAdminis() == true) {
                System.out.println("[3] Restock Shops");
            }
            System.out.println("[x] Exit");


            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllGameShops();
                    break;
                case '2':
                    goToCart();
                    break;
                case '3':
                    if (user.getAdminis() == true) {
                        restockStock();
                    }
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }
    }


    private void createGameShop() {
        char input = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        GameShop gameShop = new GameShop();

        while (!exit) {
            System.out.println("\nCreating game shop...");
            System.out.print("Enter in game shop id: ");
            gameShop.setId(scan.nextInt());

            System.out.print("\nEnter in game shop name: ");
            gameShop.setName(scan.next().toLowerCase());

            System.out.print("\nEnter in game shop city: ");
            gameShop.setCity(scan.next().toLowerCase());

            System.out.print("\nEnter in game shop state: ");
            gameShop.setState(scan.next().toLowerCase());

            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)\n");
                System.out.println(gameShop);

                input = scan.next().charAt(0);
                switch (input) {
                    case 'y':
                        System.out.println("\nGame shop created successfully!");
                        exit = true;
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void listGameShops() {
        char input = ' ';

        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        GameShop gameShop = new GameShop();
        ArrayList<String> shops = new ArrayList<>();
    }

    private void viewAllGameShops() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<GameShop> gameShopList = gameShopServices.getCrudDAO().findAll();

        /* loop through gameshop list and print out the gameshop */
        System.out.println();
        for (int i = 0; i < gameShopList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + gameShopList.get(i).getName());
        }


        while (true) {
            System.out.print("\nSelect a gameshop to view products: ");


            input = scan.nextInt() - 1;


            if (input > gameShopList.size()) {
                System.out.println("\nInvalid input");
            } else {

                List<Products> prodList = productsCrudDAO.findAllById(gameShopList.get(input).getId());

                /* printout the selected gameshop */


                for (Products prod : prodList) {

                }

                viewProducts();

                break;
            }
        }
    }

    public void viewProducts() {
        int input = 0;

        List<Products> products = productservice.getProductsDAO().findAll();
        Products product = new Products();

        while (true) {
            System.out.println();
            for (int i = 0; i < products.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + products.get(i).getName() + " Price: $" + products.get(i).getPrice() + " Number of Available Copies: " + products.get(i).getQuantity() +' ' + products.get(i).getInstock() + ' '
                        + "\nDescription: " + products.get(i).getDescription() + products.get(i).getManufacturer());
                System.out.println();

            }
            System.out.println("\nPick a product to add to your cart by in-putting the number in []: ");
            input = scan.nextInt() - 1;
            scan.nextLine();
            productX = input;


            if (input < products.size()) {
                System.out.println("\nAdding " + products.get(input).getName() + " to cart!");
                product = products.get(input);

                while (true) {
                    int qty = product.getQuantity();
                    System.out.println("\nEnter quantity (MAX "+ product.getQuantity() + ") ");
                    int quantity = scan.nextInt();
                    scan.nextLine();
                    if (quantity>qty){
                        System.out.println("Invalid Input");

                    } else {


                        productservice.getProductsDAO().takeFromQuantity(qty - quantity, product.getId());



                        //ADDED TO CART
                        //System.out.println(product.getQuantity());
                        //WHAT WE WANT TO ADD TO CART
                        //System.out.println(quantity);
                        break;
                    }
                }
                System.out.println("\nPlease confirm decision(y/n)");
                System.out.println(product);

                if (scan.next().charAt(0) == 'y') {
                    addToCart(product, cart);

                    System.out.println("Added to cart!");

                    break;
                }
            } else {
                System.out.println("\nInvalid input!");
            }
        }
    }



    public void addToCart(Products product, Cart cart) {
        int input = 0;


        Products selectedProduct = product;


        cart.setProduct_id(selectedProduct.getId());
        cart.setName(selectedProduct.getName());
        cart.setQuantity(selectedProduct.getQuantity());


        cart.setUsers_id(user.getId());


        cartService.getCartDAO().save(cart);
    }

    public void goToCart() {
        int input = 0;

        /* cart of the user by id */
        List<Cart> carts = cartService.getCartDAO().findCartById((user.getId()));

        for (Cart c : carts) {
            System.out.println(productservice.getProductsDAO().findById(c.getProduct_id()));
        }


        System.out.println("Would you like to check out? (y/n)");
        if (scan.next().charAt(0) == 'y') {

            //saves to orderhistory
            System.out.println("Congratulations on your purchase!");
            for (int i = 0; i < carts.size(); i++) {

                History history = new History();
                history.setName(carts.get(i).getName());
                System.out.println(carts.get(i).getName());
                history.setProducts_id(carts.get(i).getProduct_id());
                System.out.println(carts.get(i).getProduct_id());
                history.setQuantity(carts.get(i).getQuantity());
                history.setUsers_id(carts.get(i).getUsers_id());

                history.setUsers_id(user.getId());

                historyService.getHistoryDAO().save(history);
                System.out.println(history);
            }

            cartService.getCartDAO().emptyById(user.getId());
            System.out.println("Cart has been emptied");
        } else {

        }
    }

    public void restockStock() {
        int input = 0;

        List<Products> products = productservice.getProductsDAO().findAll();
        Products product = new Products();

        while (true) {
            System.out.println();
            for (int i = 0; i < products.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + products.get(i).getName() + " Price: $" + products.get(i).getPrice() + " Number of Available Copies: " + products.get(i).getQuantity() +' ' + products.get(i).getInstock() + ' '
                        + "\nDescription: " + products.get(i).getDescription() + products.get(i).getManufacturer());
                System.out.println();

            }
            System.out.println("\nPick a product to restock: ");
            input = scan.nextInt() - 1;
            scan.nextLine();
            productX = input;


            if (input <= products.size()) {
                product = products.get(input);

                while (true) {
                    System.out.println("Input amount to restock with:");
                    int qty = product.getQuantity();
                    int quantity = scan.nextInt();
                    scan.nextLine();
                    if (quantity>qty){
                        System.out.println("Invalid Input");

                    } else {



                        productservice.getProductsDAO().takeFromQuantity(qty + quantity, product.getId());



                        //ADDED TO CART
                        //System.out.println(product.getQuantity());
                        //WHAT WE WANT TO ADD TO CART
                        //System.out.println(quantity);
                        break;
                    }
                }


                    System.out.println("Restocked");

                    break;
                }
            }
        }
    }




