package com.revature.GameShop.UI;

import com.revature.GameShop.DAOs.CrudDAO;
import com.revature.GameShop.DAOs.ProductsDAO;
import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Modles.Products;
import com.revature.GameShop.Services.GameShopServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class GameShopMenu {
    private final GameShopServices gameShopServices;
    CrudDAO<Products> productsCrudDAO = new ProductsDAO();
    Scanner scan = new Scanner(System.in);


    public GameShopMenu(GameShopServices gameShopServices) {
        this.gameShopServices = gameShopServices;
    }

    //@Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);


        while (!exit) {
            System.out.println("\nWelcome to the game shop menu!");
            System.out.println("[1] List all game shops");
            System.out.println("[2] Search game shop");
            System.out.println("[3] Create game shop");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllGameShops();
                    break;
                case '2':
                    break;
                case '3':
                    createGameShop();
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

    private void createGameShop() {
        char input = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        GameShop gameShop= new GameShop();

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
    private void listGameShops(){
        char input= ' ';

        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        GameShop gameShop= new GameShop();
        ArrayList<String> shops = new ArrayList<>();
    }

    private void viewAllGameShops(){
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<GameShop> gameShopList = gameShopServices.getCrudDAO().findAll();

        /* loop through gameshop list and print out the gameshop */
        System.out.println();
        for (int i = 0; i < gameShopList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + gameShopList.get(i).getName());
        }

        /* loop to ask user to enter a gameshop */
        while (true) {
            System.out.print("\nSelect a gameshop to view products: ");

            /* get the user gameshop selection */
            input = scan.nextInt() - 1;


            if (input > gameShopList.size()) {
                System.out.println("\nInvalid input");
            } else {

                List<Products> prodList = productsCrudDAO.findAllById(gameShopList.get(input).getId());

                /* printout the selected gameshop */
                //System.out.println(gameShopList.get(input));


                for (Products prod : prodList) {
                    System.out.println(prodList);
                }

                new ProductsMenu(user, gameshop, productservice, cartService).start();

                break;
            }
        }
    }

    public void viewProducts() {
        int input = 0;

        List<Products> products = productservice.getProductsDAO().findAll();

        while (true) {
            System.out.println();
            for (int i = 0; i < products.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + products.get(i).getName() + products.get(i).getPrice() + products.get(i).getInstock()
                        + "\n" + products.get(i).getDescription() + products.get(i).getManufacturer());
            }
            System.out.println("\nPick a product to add to your cart: ");
            input = scan.nextInt() - 1;
            String name = scan.nextLine();
            product.setName(name);
            scan.nextLine();

            if (input < products.size()) {
                System.out.println("\nAdding " + products.get(input).getName() + " to cart!");

                while (true) {
                    System.out.println("\nEnter quantity: ");
                    int quantity = scan.nextInt();
                    scan.nextLine();
                    product.setQuantity(quantity);
                    break;
                }

                System.out.println("\nPlease confirm decision(y/n)");
                String msg = scan.nextLine();

                System.out.println("\nEnter: ");
                if (scan.next().charAt(0) == 'y') {
                    addToCart();
                    //cartService.getCartDAO().save(cart);
                    System.out.println("Added to cart!");
                    goToCart();
                    break;
                }
            } else {
                System.out.println("\nInvalid input!");
            }
        }
    }
}
