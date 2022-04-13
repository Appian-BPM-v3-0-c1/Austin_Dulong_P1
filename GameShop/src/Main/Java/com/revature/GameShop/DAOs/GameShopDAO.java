package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Modles.Reviews;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GameShopDAO implements CrudDAO<GameShop> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(GameShop obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO gameshops (name, city, state) VALUES (?, ?, ?)");
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getCity());
            ps.setString(3, obj.getState());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<GameShop> findAll() {
        List<GameShop> restList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gameshops");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GameShop gameshop = new GameShop();

                gameshop.setId(rs.getInt("id"));
                gameshop.setName(rs.getString("name"));
                gameshop.setCity(rs.getString("city"));
                gameshop.setState(rs.getString("state"));

                restList.add(gameshop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return restList;
    }



    @Override
    public GameShop findById(String id) {
        return null;
    }

    @Override
    public GameShop findById(int id) {
        return null;
    }

    @Override
    public List<GameShop> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(GameShop updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

}