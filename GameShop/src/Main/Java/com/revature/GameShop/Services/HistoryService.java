package com.revature.GameShop.Services;

import com.revature.GameShop.DAOs.HistoryDAO;

public class HistoryService {

    private final HistoryDAO historyDAO;


    public HistoryService(HistoryDAO historyDAO) {
        this.historyDAO = historyDAO;
    }

    public HistoryDAO getHistoryDAO() {
        return historyDAO;
    }
}
