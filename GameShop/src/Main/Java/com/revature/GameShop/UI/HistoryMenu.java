package com.revature.GameShop.UI;

import com.revature.GameShop.Modles.Cart;
import com.revature.GameShop.Modles.GameShop;
import com.revature.GameShop.Modles.History;
import com.revature.GameShop.Modles.User;
import com.revature.GameShop.Services.HistoryComparator;
import com.revature.GameShop.Services.HistoryService;
import com.revature.GameShop.Services.ProductsService;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class HistoryMenu implements IMenu{

    private final User user;
    private final HistoryService historyService;
    private final ProductsService productsService;


    Scanner scan = new Scanner(System.in);

    public HistoryMenu(User user,HistoryService historyService, ProductsService productsService) {
        this.user = user;
        this.historyService = historyService;
        this.productsService = productsService;
    }

    @Override
    public void start() {
        char input = ' ';

        exit: {
            while(true){
                System.out.println("\nWelcome to your order history, " + user.getUsername() +"!");
                System.out.println("[1] View order history!");
                System.out.println("[2] View order history in date order!");
                System.out.println("[x] Exit");

                input = scan.next().charAt(0);
                scan.nextLine();

                switch(input){
                    case '1':
                        viewOrderHistory();
                        break;
                    case '2':
                        sortByDate();
                        break;
                    case 'x':
                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }
private void viewOrderHistory(){
        int input = 0;

        List<History> history = historyService.getHistoryDAO().findByHistoryId(user.getId());



    //for (History h: history) {
    //    System.out.println(historyService.getHistoryDAO().findById(h.getProducts_id()));
    //}


        for(int i = 0; i < history.size(); i++){
            System.out.println("[" + (i+1) + "]" + history.get(i).getName() + "\nQuantity: " + history.get(i).getQuantity() + "\nDate/Time: " + history.get(i).getDatetime());


    }
    }

    private void sortByDate(){
        int input = 0;

        List<History> history = historyService.getHistoryDAO().findByHistoryId(user.getId());


        Collections.sort(history, new HistoryComparator());

        for (History historyz: history) {
            System.out.println(historyz);
        }
        //for(int i = 0; i < history.size(); i++){
            //System.out.println("[" + (i+1) + "]" + history.get(i).getName() + "\nQuantity: " + history.get(i).getQuantity() + "\nDate/Time: " + history.get(i).getDatetime());


        }

    }
//}
