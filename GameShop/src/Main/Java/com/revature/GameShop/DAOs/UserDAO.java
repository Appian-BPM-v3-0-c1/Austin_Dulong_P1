package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.Address;
import com.revature.GameShop.connection.DatabaseConnection;
import com.revature.GameShop.Modles.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User> {
    Connection con = DatabaseConnection.getCon();


    @Override
    public int save(User obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (firstname, lastname, username, password, street, city, state, zipcode, country, adminis) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getFirstName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getPassword());
            //ps.setInt(5, obj.getCart_id());
            ps.setString(5, obj.getStreet());
            ps.setString(6, obj.getCity());
            ps.setString(7, obj.getState());
            ps.setString(8, obj.getZipcode());
            ps.setString(9, obj.getCountry());
           ps.setBoolean(10, obj.getAdminis());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
    public int save(Address obj){
        int n = 0;
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO shippingaddress (address, city, state, zipcode, country) VALUES (?, ?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return n;

    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(User updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<String> findAllUsernames() {
        List<String> username_list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                username_list.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return username_list;
    }

    public int getUserId(String username) {
        int id = 0;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM users where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    public boolean getAdmin(boolean adminis){
        boolean id = false;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (adminis) FROM users where adminis = ?");
            ps.setBoolean(1, adminis);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getBoolean("adminis");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;

    }

    public User findByUsername(String username){

        User user = new User();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setStreet(rs.getString("street"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                user.setZipcode(rs.getString("zipcode"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAdminis(rs.getBoolean("adminis"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }
}


//private void existingUser() {
//        User user = new User();
//        while (true) {
//            System.out.print("\nUsername: ");
//            user.setUsername(scan.next());
//
//            System.out.print("\nPassword: ");
//            user.setPassword((scan.next()));
//
//            if (userService.isValidLogin(user)) {
//                user = userService.getUserDAO().findByUsername(user.getUsername());
//                new MainMenu(new Cart(),new ItemService(new ItemDAO()),user).start();
//                break;
//            } else {
//                System.out.println("\nInvalid login");
//            }
//        }
//    }