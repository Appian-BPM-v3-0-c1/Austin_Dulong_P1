package com.revature.GameShop.Services;


import com.revature.GameShop.Modles.History;

import java.util.Comparator;

public class HistoryComparator implements Comparator<History> {

    @Override
    public int compare(History o1, History o2) {
        return o1.getDatetime().compareTo(o2.getDatetime());
    }

}
