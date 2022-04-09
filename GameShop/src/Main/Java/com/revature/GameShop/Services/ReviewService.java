package com.revature.GameShop.Services;

import com.revature.GameShop.DAOs.GameShopDAO;
import com.revature.GameShop.DAOs.ReviewDAO;

public class ReviewService {
    private final ReviewDAO reviewDAO;
    private final GameShopDAO gameshopDAO;

    public ReviewService(ReviewDAO reviewDAO, GameShopDAO gameshopDAO){
        this.reviewDAO=reviewDAO;
        this.gameshopDAO=gameshopDAO;
    }

    public ReviewDAO getReviewDAO() {
        return reviewDAO;
    }

    public GameShopDAO getGameshopDAO() {
        return gameshopDAO;
    }

    public boolean isValidRating(String rating){
        return rating.matches("^[0-5]");
    }
}
