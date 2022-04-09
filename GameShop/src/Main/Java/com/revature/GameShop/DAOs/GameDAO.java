package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.User;
import com.revature.GameShop.connection.DatabaseConnection;
import com.revature.GameShop.Modles.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements CrudDAO<Game> {
    Connection con = DatabaseConnection.getCon();


    @Override
    public int save(Game obj) {
        return 0;
    }

    @Override
    public List<Game> findAll() {
        return null;
    }

    @Override
    public Game findById(String id) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<Game> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Game updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
