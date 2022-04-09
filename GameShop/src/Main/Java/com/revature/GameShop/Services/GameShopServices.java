package com.revature.GameShop.Services;

import com.revature.GameShop.DAOs.CrudDAO;
import com.revature.GameShop.DAOs.GameShopDAO;
import com.revature.GameShop.DAOs.ReviewDAO;
import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Modles.Reviews;

public class GameShopServices {
    private final GameShopDAO crudDAO;

    public GameShopServices(GameShopDAO crudDAO) {
        this.crudDAO = crudDAO;
    }

    public GameShopDAO getCrudDAO() {
        return crudDAO;
    }
}
