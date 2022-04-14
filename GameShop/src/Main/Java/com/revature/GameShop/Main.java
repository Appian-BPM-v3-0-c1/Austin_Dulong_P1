package com.revature.GameShop;

import com.revature.GameShop.UI.MainMenu;
import com.revature.GameShop.connection.DatabaseConnection;
import com.revature.GameShop.DAOs.UserDAO;
import com.revature.GameShop.Services.UserService;
import com.revature.GameShop.UI.loginMenu;
import java.util.Collections;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        new loginMenu(new UserService(new UserDAO())).start();

    }
}
