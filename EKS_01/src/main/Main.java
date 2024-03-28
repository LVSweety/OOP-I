package main;

import java.util.ArrayList;

import model.BorrowingItemsProcedure;
import model.item.AbstractItem;
import service.MainService;

public class Main {
    public static ArrayList<AbstractItem> allItems = new ArrayList<AbstractItem>();
    public static ArrayList<BorrowingItemsProcedure> allBorrowings = new ArrayList<BorrowingItemsProcedure>();
    public static void main(String[] args) {
        try {
            MainService.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
