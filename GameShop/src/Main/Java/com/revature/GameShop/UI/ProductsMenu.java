package com.revature.GameShop.UI;

import com.revature.GameShop.Modles.Products;
import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Services.ProductsService;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Services.CartServices;
import com.revature.GameShop.Modles.Cart;

import java.util.List;
import java.util.Scanner;

public class ProductsMenu implements IMenu {
    private final User user;
    private final GameShop gameshop;
    private final ProductsService productservice;
    private final CartServices cartService;

    public ProductsMenu(User user, GameShop gameshop, ProductsService productservice, CartServices cartService) {
        this.user = user;
        this.gameshop = gameshop;
        this.productservice = productservice;
        this.cartService = cartService;
    }





    Products product = new Products();
    Scanner scan = new Scanner(System.in);



    @Override
    public void start() {
        char input = ' ';

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to " + gameshop.getName() + ", " + user.getUsername() + "!");
                System.out.println("[1] View items in stock");
                System.out.println("[x] Exit");

                input = scan.next().charAt(0);
                scan.nextLine();

                switch (input) {
                    case '1':
                        viewProducts();
                        break;
                    case '2':
                        viewCart();
                        break;
                    case '3':
//                        viewOrderHistory();
                        break;
                    case 'x':
                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
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

    public void viewCart(){

            List<Cart> carts = cartService.getCartDAO().findCartById(user.getId());

            for (Cart c : carts) {
                System.out.println(productservice.getProductsDAO().findById(c.getId()));
            }

            System.out.print("\nWould you like to checkout? (y/n) ");
            if (scan.next().charAt(0) == 'y') {

                if (carts.isEmpty()) {
                    System.out.println("\nThere is nothing to checkout!");
                } else {
                    System.out.println("blahblahblahblah");
                }
            }
        }


    public void addToCart(){

                //fucking add it to the cart, it's becoming hard to think of this stuff, AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH


    }

    public void goToCart(){

    }
}
