package com.revature.GameShop.Services;

import com.revature.GameShop.DAOs.GameShopDAO;
import com.revature.GameShop.DAOs.ProductsDAO;

public class ProductsService {
    private final ProductsDAO productsDAO;
//    private final GameShopDAO gameshopDAO;

    public ProductsService(ProductsDAO productsDAO/*, GameShopDAO gameshopDAO*/) {
        this.productsDAO = productsDAO;
//        this.gameshopDAO = gameshopDAO;
    }

    public ProductsDAO getProductsDAO() {
        return productsDAO;
    }

//    public GameShopDAO getGameshopDAO() {
//        return gameshopDAO;
//    }
    public boolean isValidQuantity(String quantity) {
            return quantity.matches("^[0-99]");
    }
}
