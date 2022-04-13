package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.User;
import com.revature.GameShop.connection.DatabaseConnection;
import com.revature.GameShop.Modles.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO implements CrudDAO<Products> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Products obj) {

        int n = 0;

        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO products (name, instock, price, gameshop_id, description, manufacturer, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getInstock());
            ps.setString(3, obj.getPrice());
            ps.setString(4, obj.getDescription());
            ps.setString(5, obj.getManufacturer());
            ps.setInt(6, obj.getQuantity());
            ps.setInt(7, obj. getGameshop_id());
            //NOTE! THIS GAMESHOP ID IS LOOKING DIFFERENT FROM THE ONE IN REVIEW DAO! BE WARY!!!!

            n = ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Products> findAll() {
        List<Products> products = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Products product = new Products();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setInstock(rs.getString("instock"));
                product.setPrice(rs.getString("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setGameshop_id(rs.getInt("gameshop_id"));

                products.add(product);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return products;

    }

    @Override
    public Products findById(String id) {
        return null;

    }

    @Override
    public Products findById(int id) {
        Products products = new Products();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();



            while (rs.next()){

                products.setId(rs.getInt("id"));
                products.setName(rs.getString("name"));
                products.setInstock(rs.getString("instock"));
                products.setPrice(rs.getString("price"));
                products.setDescription(rs.getString("description"));
                products.setManufacturer(rs.getString("manufacturer"));
                products.setGameshop_id(rs.getInt("gameshop_id"));

            }
        } catch (SQLException e) { e.printStackTrace();}

        return products;
    }

    @Override
    public List<Products> findAllById(int id) {
        List<Products> prodList = new ArrayList<>();
        Products product = new Products();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE gameshop_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setInstock(rs.getString("instock"));
                product.setPrice(rs.getString("price"));
                product.setDescription(rs.getString("description"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setGameshop_id(rs.getInt("gameshop_id"));

                prodList.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return prodList;
    }

    @Override
    public boolean update(Products updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public Products findProductById(int id){
        Products product = new Products();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setInstock(rs.getString("instock"));
                product.setPrice(rs.getString("price"));
                product.setDescription(rs.getString("description"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setGameshop_id(rs.getInt("gameshop_id"));

            }
        } catch (SQLException e){

        }

        return product;
    }
}


