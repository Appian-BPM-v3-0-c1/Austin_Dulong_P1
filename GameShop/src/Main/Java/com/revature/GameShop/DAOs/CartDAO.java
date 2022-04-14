package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.Cart;
import com.revature.GameShop.Modles.Reviews;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Modles.Products;
import com.revature.GameShop.Services.ProductsService;
import com.revature.GameShop.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements CrudDAO<Cart> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Cart obj) {

        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO carts (product_id, user_id, quantity, name) VALUES (?, ?, ?, ?)");
            //ps.setInt(1, obj.getTotalPrice());
//            ps.setInt(2, obj.getCart_id());
            ps.setInt(1, obj.getProduct_id());
            ps.setInt(2, obj.getUsers_id());
            //input NAME and  QUANTITY
            ps.setInt(3, obj.getQuantity());
            ps.setString(4, obj.getName());
            //ps.setInt(3, obj.getShippingAddress_id());


            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Cart findById(String id) {
        return null;
    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Cart updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<Cart> findByCartID(int id) {
        List<Cart> cartList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cart WHERE cart_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();

                cart.setId(rs.getInt("id"));
                //cart.setTotalPrice(rs.getInt("totalprice"));
                // cart.setCart_id(rs.getInt("cart_id"));
                cart.setProduct_id(rs.getInt("product_id"));
                cart.setShippingAddress_id(rs.getInt("shippingaddress_id"));
                cart.setUsers_id(rs.getInt("users_id"));

                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartList;
    }

    public List<Cart> findCartById(int user_id) {
        List<Cart> carts = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carts WHERE user_id = ?");
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();

                //cart.setid(rs.getInt("id"));
                //cart.setTotalPrice(rs.getInt("totalprice"));
                cart.setProduct_id(rs.getInt("product_id"));
                //cart.setShippingAddress_id(rs.getInt("shippingaddress_id"));
                cart.setUsers_id(rs.getInt("user_id"));
                cart.setName(rs.getString("name"));
                cart.setQuantity(rs.getInt("quantity"));

                carts.add(cart);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carts;
    }

    public boolean emptyById(int user_id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM carts WHERE user_id = ?");
            ps.setInt(1, user_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }
}
