package com.revature.GameShop.Modles;

public class Reviews {
    private int id;
    private String rating;
    private String message;
    private int gameShopId;
    private int userId;
    private String username;

    public Reviews() {
    }

    public Reviews(int id, String rating, String message, int gameShopId, int userId, String username) {
        this.id = id;
        this.rating = rating;
        this.message = message;
        this.gameShopId = gameShopId;
        this.userId = userId;
        this.username = username;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getGameShopId() {
        return gameShopId;
    }

    public void setGameShopId(int gameShopId) {
        this.gameShopId = gameShopId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", rating=" + rating +
                ", message='" + message + '\'' +
                ", gameShopId=" + gameShopId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
