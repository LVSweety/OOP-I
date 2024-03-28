package service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import main.Main;
import model.BorrowingItemsProcedure;
import model.Librarian;
import model.item.AbstractItem;
import model.item.EBook;
import model.item.Genre;
import model.item.Magazine;

public class MainService {

    public static void run() throws Exception {
        Librarian worker1 = new Librarian("Emilly", "Gold", "123456-12345", true);

        createNewEBook("Long home", 5, 0, Genre.FANTASY );
        createNewEBook("Long home I", 5, 0, Genre.FANTASY );
        createNewEBook("Long home II", 5, 0, Genre.FANTASY );
        createNewEBook("Long home III", 5, 0, Genre.FANTASY );
        Main.allItems.add(new Magazine());
        Main.allItems.add(new Magazine("Next world", 20, 15, "Oliver Wrong"));
        System.out.println("----------------------------------------------------------------");
        for (EBook e : getAllEBooks()){
            System.out.println(e);
        }

        updateEBookByID(0, "An test", 10);
        updateEBookByID(2, "An test I", 10);
        updateEBookByID(3, "An test II", 10);
        System.out.println("----------------------------------------------------------------");
        for (EBook e : getAllEBooks()){
            System.out.println(e);
        }

        Main.allBorrowings.add(new BorrowingItemsProcedure(worker1, LocalDateTime.now().plusDays(2)));
        Main.allBorrowings.add(new BorrowingItemsProcedure(worker1, LocalDateTime.now().plusDays(1)));
        Main.allBorrowings.add(new BorrowingItemsProcedure(worker1, LocalDateTime.now().plusDays(1)));
        Main.allBorrowings.get(0).addItemInBorrowingItemsListByItemCode("0_EBook_Longhome");
        Main.allBorrowings.get(1).addItemInBorrowingItemsListByItemCode("0_EBook_Longhome");
        Main.allBorrowings.get(2).addItemInBorrowingItemsListByItemCode("0_EBook_Longhome");
        System.out.println("----------------------------------------------------------------");
        for (EBook e : getAllEBooks()){
            System.out.println(e);
        }
        System.out.println("----------------------------------------------------------------");
        Main.allBorrowings.get(0).showAllEBooks();
        System.out.println("----------------------------------------------------------------");
        // for (AbstractItem e : Main.allItems){
        //     System.out.println(e);
        // }

    }

    public static EBook getEBookById(int ID) throws Exception {
        if (ID >= 0) {
            for (AbstractItem e : Main.allItems) {
                if (e.getId() == ID) {
                    return (EBook) e;
                }
            }
        }
        throw new IllegalArgumentException("[ERROR]: item not found");
    }

    public static EBook getEBookByItemCode(String itemCode) throws Exception {
        if (itemCode != null) {
            for (AbstractItem e : Main.allItems) {
                if (e.getItemCode().matches(itemCode)) {
                    return (EBook) e;
                }
            }
        }
        throw new IllegalArgumentException("[ERROR]: item not found");
    }

    public static void createNewEBook(String title, int howManyCopies, int combinedMinutes, Genre genre) throws Exception {
        for (AbstractItem e : Main.allItems){
            if ((e.getItemCode().matches(e.getId() + "_EBook_" + title.replace(" ", "")))) {
                throw new IllegalArgumentException("[ERROR]: book exists");
            }
        }
        Main.allItems.add(new EBook(title, howManyCopies, combinedMinutes, genre));
    }

    public static ArrayList<EBook> getAllEBooks() throws Exception {
        ArrayList<EBook> books = new ArrayList<EBook>();
        for (AbstractItem e : Main.allItems) {
            if (e instanceof EBook){
                books.add((EBook)e);
            }
        }
        return books;
    }

    public static void deleteEBookByID(int ID) throws Exception {
        Main.allItems.remove(getEBookById(ID));
    }

    public static void updateEBookByID(int ID, String title, int howManyCopies) throws Exception {
        getEBookById(ID).setTitle(title);
        getEBookById(ID).setHowManyCopies(howManyCopies);
    }
    
    public static ArrayList<AbstractItem> showAllLoanItemsByLibrarianPersonCode(String personCode) throws Exception {
        if (personCode == null){
            throw new IllegalArgumentException("[ERROR]: illegal argument");
        }
        ArrayList<AbstractItem> list = new ArrayList<AbstractItem>();

        for (BorrowingItemsProcedure e : Main.allBorrowings) {
            if (e.getLibrarian().getPersonCode().matches(personCode)) {
                list.addAll(e.getLoanItems());
            }
        }
        return list;
    }

    public static int calculateHowManyItemsLoanByAdminLibrarians(){
        int sum = 0;
        for (BorrowingItemsProcedure e : Main.allBorrowings) {
            if (e.getLibrarian().getIsAdminLibrarian()) {
                sum++;
            }
        }
        return sum;
    }

    public static ArrayList<AbstractItem> showAllLateBorrowingItems() {
        ArrayList<AbstractItem> list = new ArrayList<AbstractItem>();
        for (BorrowingItemsProcedure e : Main.allBorrowings) {
            if (e.getReturningDateTime().compareTo(e.getBorrowingDateTime()) < 0) {
                list.addAll(e.getLoanItems());
            }
        }
        return list;
    }
}
