package com.revature.GameShop.UI;

import com.revature.GameShop.Modles.Address;
import com.revature.GameShop.Modles.Cart;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Services.UserService;
import com.revature.GameShop.Modles.History;

import java.util.Scanner;

public class loginMenu implements IMenu {
    private UserService userService;

    public loginMenu(UserService userService) {
        this.userService = userService;
    }

    Scanner scan = new Scanner(System.in);
    User user = new User();
    Cart cart = new Cart();
    History history = new History();
    String username;
    //Address shippingaddress = new Address();

    @Override
    public void start() {
        char input = ' ';

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to login menu");
                System.out.println("[1] log in");
                System.out.println("[2] Create new account");
                System.out.println("[x] Exit");

                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        login();
                        break;
                    case '2':
                        createAccount();
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

    private void createAccount() {
        String username = "";
        String password1 = "";
        String password2 = "";
        String address = "";
        String city = "";
        String state = "";
        String zipcode = "";
        String country = "";
        String firstname = "";
        String lastname = "" ;

        System.out.println("\nCreating account...");

        while (true) {
            while (true) {
                System.out.print("\nEnter in username: ");
                username = scan.next();

                if (!userService.isDupUsername(username)) {
                    if (userService.isValidUsername(username)) {
                        user.setUsername(username);
                        break;
                    } else {
                        System.out.println("\nInvalid username :(");
                    }

                } else {
                    System.out.println("\nDuplicate username :(");
                }
            }

            while (true) {
                System.out.print("\nEnter in password: ");
                password1 = scan.next();

                System.out.print("\nEnter in password again: ");
                password2 = scan.next();

                if (password1.equals(password2)) {
                    if (userService.isValidPassword(password1)) {

                        user.setPassword(password1);
                        break;
                    } else {
                        System.out.println("\nInvalid password!");
                    }
                } else {
                    System.out.println("Password does not match!");
                }
            }

            System.out.println("Please add first name!");
            firstname = scan.next();
            user.setFirstName(firstname);

            System.out.println("Please add last name!");
            lastname = scan.next();
            user.setLastName(lastname);

            System.out.println("Please add billing and shipping street (use - between words)!");
            address = scan.next();

            user.setStreet(address);

            System.out.println("Please enter billing and shipping state!");
            state = scan.next();

            user.setState(state);

            System.out.println("Please add billing and shipping city!");
            city = scan.next();

            user.setCity(city);


            System.out.println("Please enter billing and shipping zipcode!");
            zipcode = scan.next();

            user.setZipcode(zipcode);


            System.out.println("Please enter billing and shipping country!");
            country = scan.next();
            user.setCountry(country);



            System.out.println("\nPlease confirm credentials (y/n)");
            System.out.print("Username: " + username);
            System.out.print("\nPassword: " + password1);
            System.out.print("\nAddress:" + address);
            System.out.print("\nState: " + state);
            System.out.print("\nCity:" + city);
            System.out.print("\nZipcode: " + zipcode);
            System.out.print("\nCountry: " + country);

            System.out.print("\nEnter: ");


            if (scan.next().charAt(0) == 'y') {
                userService.getUserDAO().save(user);

                System.out.println("Account created succesfully!");
                login();
                break;


            }
        }
    }


    private void login () {
        User user = new User();
        while (true) {
            System.out.print("\nUsername: ");
            user.setUsername(scan.next());

            System.out.print("\nPassword: ");
            user.setPassword((scan.next()));

            if (userService.isValidLogin(user)) {
                user = userService.getUserDAO().findByUsername(user.getUsername());




                new MainMenu(user, cart, history).start();
                break;
            } else {
                System.out.println("\nInvalid login");
            }
        }
    }
}


//           while(true) {
//                System.out.println("Please add billing and shipping address!");
//                address = scan.next();
//            }
//            while (true) {
//                System.out.println("Please enter billing and shipping state!");
//                state = scan.next();
//            }
//            while (true) {
//                System.out.println("Please add billing and shipping city!");
//                city = scan.next();
//            }
//            while (true) {
//                System.out.println("Please enter billing and shipping zipcode!");
//                zipcode = scan.next();
//            }
//            while(true) {
//                System.out.println("Please enter billing and shipping country!");
//                country = scan.next();
//            }

