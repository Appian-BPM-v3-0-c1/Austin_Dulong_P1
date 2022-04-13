package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.Reviews;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements CrudDAO<Reviews> {
    Connection con = DatabaseConnection.getCon();


    @Override
    public int save(Reviews obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO reviews (rating, message, username, gameshop_id, user_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getRating());
            ps.setString(2, obj.getMessage());
            ps.setString(3, obj.getUsername());
            ps.setInt(4, obj.getGameShopId());
            ps.setInt(5, obj.getUserId());

            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Reviews> findAll() {
        return null;
    }

    @Override
    public Reviews findById(String id) {
        return null;
    }

    @Override
    public Reviews findById(int id) {
        return null;
    }

    @Override
    public List<Reviews> findAllById(int id) {
        List<Reviews> revList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reviews WHERE gameshop_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reviews review = new Reviews();

                review.setId(rs.getInt("id"));
                review.setRating(rs.getString("rating"));
                review.setMessage(rs.getString("message"));
                review.setUsername(rs.getString("username"));
                review.setGameShopId(rs.getInt("gameshop_id"));
                review.setUserId(rs.getInt("user_id"));


                revList.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return revList;
    }

    @Override
    public boolean update(Reviews updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
