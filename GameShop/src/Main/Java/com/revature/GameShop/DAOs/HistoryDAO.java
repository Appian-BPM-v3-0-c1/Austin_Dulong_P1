package com.revature.GameShop.DAOs;

import com.revature.GameShop.Modles.History;
import com.revature.GameShop.Modles.Products;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.connection.DatabaseConnection;
import org.postgresql.core.SetupQueryRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class HistoryDAO implements CrudDAO<History> {
    Connection con = DatabaseConnection.getCon();

    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
    String dateTime = myDateObj.format(myFormatObj);


    @Override
    public int save(History obj) {

        int n = 0;

        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO pastorders (name, price, quantity, product_id, users_id, datetime) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1,obj.getName());
            ps.setInt(2, obj.getPrice());
            ps.setInt(3, obj.getQuantity());
            ps.setInt(4, obj.getProducts_id());
            ps.setInt(5, obj.getUsers_id());
            ps.setString(6, dateTime);
            n = ps.executeUpdate();
        }catch (SQLException e) {

        }
        return n;
    }

    @Override
    public List<History> findAll() {
        List<History> historyList = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pastorders");
            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                History history = new History();

                history.setId(rs.getInt("id"));
                history.setName(rs.getString("name"));
                history.setPrice(rs.getInt("price"));
                history.setQuantity(rs.getInt("quantity"));
                history.setProducts_id(rs.getInt("product_id"));
                history.setUsers_id(rs.getInt("users_id"));
                history.setDatetime(rs.getString("datetime"));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

        return historyList;
    }

    @Override
    public History findById(String id) {
        return null;
    }

    @Override
    public History findById(int id) {
        History history = new History();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pastorders WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();



            while (rs.next()){

                history.setId(rs.getInt("id"));
                history.setName(rs.getString("name"));
                history.setQuantity(rs.getInt("quantity"));
                history.setUsers_id(rs.getInt("users_id"));
                history.setProducts_id(rs.getInt("product_id"));
                history.setDatetime(rs.getString("datetime"));

            }
        } catch (SQLException e) { e.printStackTrace();}

        return history;
    }

    @Override
    public List<History> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(History updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public int findAllByIds(){
        int id = 0;

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pastorders WHERE id = ?");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                id = rs.getInt("product_id");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return id;

    }

    public List<History> findByHistoryId(int id){
        List<History> historyList = new ArrayList<>();


        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pastorders WHERE users_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

           while (rs.next()){
               History history = new History();

               history.setId(rs.getInt("id"));
               history.setName(rs.getString("name"));
               history.setQuantity(rs.getInt("quantity"));
               history.setUsers_id(rs.getInt("users_id"));
               history.setProducts_id(rs.getInt("product_id"));
               history.setDatetime(rs.getString("datetime"));

               historyList.add(history);

           }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return historyList;
    }

}
