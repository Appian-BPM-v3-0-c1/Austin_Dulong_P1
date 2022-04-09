package com.revature.GameShop.UI;

import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Modles.Reviews;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Services.ReviewService;

import java.util.List;
import java.util.Scanner;

public class ReviewMenu implements IMenu {
    private final User user;
    private final ReviewService reviewservice;

    public ReviewMenu(User user, ReviewService reviewservice) {
        this.user = user;
        this.reviewservice = reviewservice;
    }

    Reviews review = new Reviews();
    Scanner scan = new Scanner(System.in);

    @Override
    public void start(){
        char input = ' ';

        exit: {
            while(true){
                System.out.println("\nWelcome to review menu, " + user.getUsername() +"!");
                System.out.println("[1] Leave a review");
                System.out.println("[x] Exit");

                input = scan.next().charAt(0);
                scan.nextLine();

                switch(input){
                    case '1':
                        createReview();
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
    private void createReview(){
        int input = 0;

        List<GameShop> gameShops = reviewservice.getGameshopDAO().findAll();

        while(true){
            System.out.println();
            for (int i = 0; i < gameShops.size(); i++){
                System.out.println("[" + (i + 1) + "]" + gameShops.get(i).getName());
            }

            System.out.println("\nPick a gameshop to review: ");
            input = scan.nextInt() - 1;
            scan.nextLine();

            if (input < gameShops.size()){
                System.out.println("\nCreating review for " + gameShops.get(input). getName() + "!");

                while(true){
                    System.out.println("\nEnter in rating: ");
                    String rating = scan.nextLine();

                    if (reviewservice.isValidRating(rating)){
                        review.setRating(rating);
                        break;
                    } else{
                        System.out.println("\nInvalid rating!");
                    }
                }
                System.out.println("\nEnter in review: ");
                String msg = scan.nextLine();
                review.setMessage(msg);
                review.setUsername(user.getUsername());
                review.setGameShopId(gameShops.get(input).getId());
                review.setUserId(user.getId());

                System.out.println("\nPlease confirm your review (y/n");
                System.out.println(review);

                System.out.println("\nEnter: ");
                if (scan.next().charAt(0) == 'y'){
                    reviewservice.getReviewDAO().save(review);
                    System.out.println("\nReview created successfully!");
                    break;
                }
            } else {
                System.out.println("\nInvalid input!");
            }
        }
    }
}
