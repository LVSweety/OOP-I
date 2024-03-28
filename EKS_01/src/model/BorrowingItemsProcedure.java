package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import main.Main;
import model.item.AbstractItem;
import model.item.EBook;
import model.item.Magazine;

public class BorrowingItemsProcedure {
    private Librarian librarian;
    private ArrayList<AbstractItem> loanItems = new ArrayList<AbstractItem>();
    private LocalDateTime borrowingDateTime;
    private LocalDateTime returningDateTime;

    public BorrowingItemsProcedure() throws Exception{
        this.borrowingDateTime = LocalDateTime.now();
    }

    public BorrowingItemsProcedure(Librarian librarian, LocalDateTime returningDateTime) throws Exception {
        this.borrowingDateTime = LocalDateTime.now();
        setLibrarian(librarian);
        setReturningDateTime(returningDateTime);
    }

    public void setLibrarian(Librarian librarian) throws Exception {
        if (librarian != null && librarian instanceof Librarian) {
            this.librarian = librarian;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: illegal argument");
    }

    public void setReturningDateTime(LocalDateTime returningDateTime) throws Exception {
        if (returningDateTime.compareTo(this.borrowingDateTime) > 0){
            this.returningDateTime = returningDateTime;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: illegal argument");
    }

    public Librarian getLibrarian() {
        return librarian;
    }
    public ArrayList<AbstractItem> getLoanItems() {
        return loanItems;
    }
    public LocalDateTime getBorrowingDateTime() {
        return borrowingDateTime;
    }
    public LocalDateTime getReturningDateTime() {
        return returningDateTime;
    }

    public void addItemInBorrowingItemsListByItemCode(String itemCode) throws Exception {
        if (itemCode == null) {
            throw new IllegalArgumentException("[ERROR]: illegal argument");
        }
        
        for (AbstractItem e : Main.allItems){
            if (e.getItemCode().matches(itemCode)) {
                if (e.getHowManyCopies() - 1 >= 0){
                    e.setHowManyCopies(e.getHowManyCopies() -1);
                    loanItems.add(e); 
                    return;
                }
                throw new IllegalArgumentException("[ERROR]: no inventory");
            }
        }
        throw new IllegalArgumentException("[ERROR]: element not found");
    }

    public void showAllEBooks() {
        for (AbstractItem e : loanItems){
            if (e instanceof EBook) {
                System.out.println(e);
            }
        }
    }

    public void showAllMagazines() {
        for (AbstractItem e : loanItems){
            if (e instanceof Magazine) {
                System.out.println(e);
            }
        }
    }

    @Override
    public String toString() {
        return "[ " + this.librarian + "," + this.borrowingDateTime + "," + this.returningDateTime +" ]";
    }
}
